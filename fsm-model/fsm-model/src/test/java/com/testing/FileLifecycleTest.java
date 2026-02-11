package com.testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FileLifecycleTest {

    @Test
    void testOpenFromClosed() {
        FileLifecycle file = new FileLifecycle();
        file.open();
        assertEquals(FileLifecycle.State.OPEN, file.getState());
    }

    @Test
    void testEditAfterOpen() {
        FileLifecycle file = new FileLifecycle();
        file.open();
        file.edit();
        assertEquals(FileLifecycle.State.MODIFIED, file.getState());
    }

    @Test
    void testSaveAfterModify() {
        FileLifecycle file = new FileLifecycle();
        file.open();
        file.edit();
        file.save();
        assertEquals(FileLifecycle.State.SAVED, file.getState());
    }

    @Test
    void testCloseAfterSave() {
        FileLifecycle file = new FileLifecycle();
        file.open();
        file.edit();
        file.save();
        file.close();
        assertEquals(FileLifecycle.State.CLOSED, file.getState());
    }

    @Test
    void testInvalidSaveFromClosed() {
        FileLifecycle file = new FileLifecycle();
        file.save();
        assertEquals(FileLifecycle.State.ERROR, file.getState());
    }

    @Test
    void testInvalidEditFromClosed() {
        FileLifecycle file = new FileLifecycle();
        file.edit();
        assertEquals(FileLifecycle.State.ERROR, file.getState());
    }
}

