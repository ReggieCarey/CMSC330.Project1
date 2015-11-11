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
public class TokenTest {

    public TokenTest() {
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
     * Test of getContent method, of class Token.
     */
    @Test
    public void testGetContent() {
        System.out.println("getContent");
        Token instance = null;
        String expResult = "";
        String result = instance.getContent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Token.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Token instance = null;
        Type expResult = null;
        Type result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLineNumber method, of class Token.
     */
    @Test
    public void testGetLineNumber() {
        System.out.println("getLineNumber");
        Token instance = null;
        int expResult = 0;
        int result = instance.getLineNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOffset method, of class Token.
     */
    @Test
    public void testGetOffset() {
        System.out.println("getOffset");
        Token instance = null;
        int expResult = 0;
        int result = instance.getOffset();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
