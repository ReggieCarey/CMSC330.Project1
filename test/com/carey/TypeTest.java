/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carey;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ReginaldCarey
 */
public class TypeTest {

    public TypeTest() {
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
     * Test of values method, of class Type.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Type[] expResult = {Type.WINDOW,Type.END,Type.LPAREN};
        Type[] result = Type.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class Type.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "WINDOW";
        Type expResult = Type.WINDOW;
        Type result = Type.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPattern method, of class Type.
     */
    @Test
    public void testGetPattern() {
        System.out.println("getPattern");
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
