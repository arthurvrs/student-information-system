package sis.util;

import junit.framework.TestCase;

public class ParityCheckerTest extends TestCase {

    public void testSingleByte() {
        ParityChecker checker = new ParityChecker();
        byte source1 = 10;
        byte source2 = 13;
        byte source3 = 2;

        byte[] data = new byte[] {source1, source2, source3};

        byte checksum = 5;

        assertEquals(checksum, checker.checksum(data));

        data[1] = 14;
        assertFalse(checksum == checker.checksum(data));
    }

}