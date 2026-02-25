package org.openide.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class ParametersTest2 {

    @Test
    public void testNotNullValid() {
        Parameters.notNull("myParam", "hello");
    }

    @Test(expected = NullPointerException.class)
    public void testNotNullThrowsOnNull() {
        Parameters.notNull("myParam", null);
    }

    @Test
    public void testNotWhitespaceValid() {
        Parameters.notWhitespace("myParam", "hello");
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
        Parameters.javaIdentifier("myParam", "validName");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testJavaIdentifierInvalid() {
        Parameters.javaIdentifier("myParam", "123invalid");
    }

    @Test
    public void testJavaIdentifierUnderscore() {
        Parameters.javaIdentifier("myParam", "_valid");
    }

}
