package org.netbeans.modules.apisupport.project;

import org.junit.Test;
import static org.junit.Assert.*;

public class PartitionExampleTest {

    // Simple helper method to demonstrate partition testing
    private boolean isValidName(String name) {
        if (name == null) return false;
        if (name.isEmpty()) return false;
        if (name.length() > 20) return false;
        return name.matches("[A-Za-z0-9_]+");
    }

    @Test
    public void validName_partition() {
        assertTrue(isValidName("Main_01"));
    }

    @Test
    public void emptyName_partition() {
        assertFalse(isValidName(""));
    }

    @Test
    public void nullName_partition() {
        assertFalse(isValidName(null));
    }

    @Test
    public void illegalCharacters_partition() {
        assertFalse(isValidName("bad@name"));
    }

    @Test
    public void tooLong_partition() {
        assertFalse(isValidName("this_name_is_way_too_long"));
    }
}

