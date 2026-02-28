package org.openide.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class StubTaskTest {

    @Test
    public void testStubTaskInitialStateIsNotFinished() {
        StubTask task = new StubTask();
        assertFalse("Stub task should start in NOT_FINISHED state",
                task.isFinished());
    }

    @Test
    public void testStubTaskTransitionsToFinishedAfterRun() {
        StubTask task = new StubTask();
        task.run();
        assertTrue("Stub task should be FINISHED after run()",
                task.isFinished());
    }

    @Test
    public void testStubRunWasInvoked() {
        StubTask task = new StubTask();
        assertFalse(task.wasRunCalled());
        task.run();
        assertTrue("run() should have been called on the stub",
                task.wasRunCalled());
    }
}
