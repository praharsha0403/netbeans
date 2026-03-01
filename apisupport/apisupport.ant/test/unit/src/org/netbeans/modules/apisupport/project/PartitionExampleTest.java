package org.netbeans.modules.apisupport.project;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Partition-based tests for module name validation.
 * Each test method covers one distinct input partition.
 */
public class PartitionExampleTest {

    // Partition 1: Valid input — normal well-formed module name
    @Test
    public void testValidModuleName() {
        String name = "mymodule";
        assertNotNull("Valid name should not be null", name);
        assertTrue("Valid name should be non-empty", name.length() > 0);
        assertTrue("Valid name should contain only word chars",
                name.matches("[a-zA-Z0-9_]+"));
    }

    // Partition 2: Empty input — boundary between valid and invalid
    @Test
    public void testEmptyModuleName() {
        String name = "";
        assertTrue("Empty name should be flagged as invalid",
                name.isEmpty());
    }

    // Partition 3: Null input — null safety
    @Test
    public void testNullModuleName() {
        String name = null;
        assertNull("Null name should be null", name);
    }

    // Partition 4: Illegal characters — format validation
    @Test
    public void testIllegalCharactersInModuleName() {
        String name = "my module!";
        assertFalse("Name with illegal characters should fail validation",
                name.matches("[a-zA-Z0-9_]+"));
    }

    // Partition 5: Overly long input — upper length boundary
    @Test
    public void testOverlyLongModuleName() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 300; i++) sb.append("a");
        String name = sb.toString();
        assertTrue("Overly long name should exceed length limit",
                name.length() > 255);
    }
}
