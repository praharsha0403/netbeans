package org.openide.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaskListenerMockTest {

    static class MockTaskListener implements TaskListener {
        int callCount = 0;
        Task lastCalledWith = null;

        @Override
        public void taskFinished(Task task) {
            callCount++;
            lastCalledWith = task;
        }
    }

    // Test 1: verifies notifyFinished() calls taskFinished() exactly once
    // with the correct Task argument
    @Test
    public void testNotifyFinishedCallsTaskListener() {
        Task task = new Task(() -> {});
        MockTaskListener listener = new MockTaskListener();

        task.addTaskListener(listener);
        task.notifyFinished();

        assertEquals("taskFinished() should be called exactly once", 1, listener.callCount);
        assertSame("taskFinished() should be called with the correct task", task, listener.lastCalledWith);
    }

    // Test 2: verifies the listener is NOT called before notifyFinished()
    @Test
    public void testListenerNotCalledBeforeNotifyFinished() {
        Task task = new Task(() -> {});
        MockTaskListener listener = new MockTaskListener();

        task.addTaskListener(listener);

        assertEquals("taskFinished() should not be called before notifyFinished()", 0, listener.callCount);
    }

    // Test 3: verifies the listener is called each time notifyFinished() is called
    @Test
    public void testListenerCallCountMatchesNotifyFinishedCalls() {
        Task task = new Task(() -> {});
        MockTaskListener listener = new MockTaskListener();

        task.addTaskListener(listener);
        task.notifyFinished();
        task.notifyFinished();

        assertEquals("taskFinished() should be called once per notifyFinished() call", 2, listener.callCount);
    }
}
