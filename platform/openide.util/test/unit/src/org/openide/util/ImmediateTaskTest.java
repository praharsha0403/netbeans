package org.openide.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmediateTaskTest {

    @Test
    public void testTimeoutReturnsFalseWhenTaskNeverFinishes() {
        ImmediateTask task = new ImmediateTask(() -> {});
        boolean finished = task.waitFinishedWithTimeout(100);
        assertFalse("Task that never finishes should return false after timeout",
                finished);
    }

    @Test
    public void testReturnsTrueWhenTaskFinishesBeforeTimeout() {
        ImmediateTask task = new ImmediateTask(() -> {});
        task.notifyFinished();
        boolean finished = task.waitFinishedWithTimeout(1000);
        assertTrue("Already-finished task should return true", finished);
    }

    @Test
    public void testAlreadyFinishedTaskReturnsImmediately() {
        ImmediateTask task = new ImmediateTask(() -> {});
        task.notifyFinished();
        long start = System.currentTimeMillis();
        boolean result = task.waitFinishedWithTimeout(5000);
        long elapsed = System.currentTimeMillis() - start;
        assertTrue(result);
        assertTrue("Should not wait 5 seconds", elapsed < 500);
    }
}
