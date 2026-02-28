package org.openide.util;

public class StubTask extends Task {

    private boolean runCalled = false;

    public StubTask() {
        super(() -> {});
    }

    @Override
    public void run() {
        runCalled = true;
        notifyFinished();
    }

    public boolean wasRunCalled() {
        return runCalled;
    }
}
