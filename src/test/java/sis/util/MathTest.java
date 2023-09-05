package sis.util;

import junit.framework.TestCase;

public class MathTest extends TestCase {

    static final double TOLERANCE = 0.05;

    public void testHypotenuse() {
        assertEquals(5.0, Math.hypotenuse(3.0, 4.0), TOLERANCE);
    }

}