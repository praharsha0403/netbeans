package org.openide.util;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TaskListenerMockTest {

    @Test
    public void testNotifyFinishedCallsTaskListener() {
        Task task = new Task(() -> {});
        TaskListener mockListener = mock(TaskListener.class);
        task.addTaskListener(mockListener);
        task.notifyFinished();
        verify(mockListener, times(1)).taskFinished(task);
    }

    @Test
    public void testListenerNotCalledBeforeNotifyFinished() {
        Task task = new Task(() -> {});
        TaskListener mockListener = mock(TaskListener.class);
        task.addTaskListener(mockListener);
        verify(mockListener, never()).taskFinished(any());
    }

    @Test
    public void testListenerCalledOnceEvenIfNotifyFinishedCalledTwice() {
        Task task = new Task(() -> {});
        TaskListener mockListener = mock(TaskListener.class);
        task.addTaskListener(mockListener);
        task.notifyFinished();
        task.notifyFinished();
        verify(mockListener, times(1)).taskFinished(task);
    }
}
