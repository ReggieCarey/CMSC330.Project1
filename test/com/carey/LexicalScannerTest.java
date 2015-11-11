/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carey;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ReginaldCarey
 */
public class LexicalScannerTest {

    public LexicalScannerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCurrentToken method, of class LexicalScanner.
     */
    @Test
    public void testGetCurrentToken() {
        System.out.println("getCurrentToken");
        LexicalScanner instance = null;
        Token expResult = null;
        Token result = instance.getCurrentToken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of advance method, of class LexicalScanner.
     */
    @Test
    public void testAdvance() throws Exception {
        System.out.println("advance");
        LexicalScanner instance = null;
        instance.advance();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
