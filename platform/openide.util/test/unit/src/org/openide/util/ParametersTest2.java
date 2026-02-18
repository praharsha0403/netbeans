package org.openide.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class ParametersTest2 {

    @Test
    public void testNotNullValid() {
        String result = Parameters.notNull("myParam", "hello");
        assertEquals("hello", result);
    }

    @Test(expected = NullPointerException.class)
    public void testNotNullThrowsOnNull() {
        Parameters.notNull("myParam", null);
    }

    @Test
    public void testNotWhitespaceValid() {
        String result = Parameters.notWhitespace("myParam", "hello");
        assertEquals("hello", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotWhitespaceThrowsOnBlank() {
        Parameters.notWhitespace("myParam", "   ");
    }

    @Test(expected = NullPointerException.class)
    public void testNotWhitespaceThrowsOnNull() {
        Parameters.notWhitespace("myParam", null);
    }

    @Test
    public void testJavaIdentifierValid() {
        String result = Parameters.javaIdentifier("myParam", "validName");
        assertEquals("validName", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testJavaIdentifierInvalid() {
        Parameters.javaIdentifier("myParam", "123invalid");
    }

    @Test
    public void testJavaIdentifierUnderscore() {
        String result = Parameters.javaIdentifier("myParam", "_valid");
        assertEquals("_valid", result);
    }
}
