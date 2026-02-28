package org.openide.util;

public class ImmediateTask extends Task {

    public ImmediateTask(Runnable run) {
        super(run);
    }

    public synchronized boolean waitFinishedWithTimeout(long timeoutMs) {
        if (isFinished()) {
            return true;
        }
        long deadline = System.currentTimeMillis() + timeoutMs;
        while (!isFinished()) {
            long remaining = deadline - System.currentTimeMillis();
            if (remaining <= 0) {
                return false;
            }
            try {
                wait(remaining);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        return true;
    }
}
