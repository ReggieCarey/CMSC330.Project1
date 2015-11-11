/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carey;

import java.io.File;
import java.io.Reader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ReginaldCarey
 */
public class RecursiveDescentParserTest {

    public RecursiveDescentParserTest() {
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
     * Test of parse method, of class RecursiveDescentParser.
     */
    @Test
    public void testParse_Reader() throws Exception {
        System.out.println("parse");
        Reader stream = null;
        RecursiveDescentParser instance = new RecursiveDescentParser();
        instance.parse(stream);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parse method, of class RecursiveDescentParser.
     */
    @Test
    public void testParse_String() throws Exception {
        System.out.println("parse");
        String content = "";
        RecursiveDescentParser instance = new RecursiveDescentParser();
        instance.parse(content);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parse method, of class RecursiveDescentParser.
     */
    @Test
    public void testParse_File() throws Exception {
        System.out.println("parse");
        File file = null;
        RecursiveDescentParser instance = new RecursiveDescentParser();
        instance.parse(file);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
