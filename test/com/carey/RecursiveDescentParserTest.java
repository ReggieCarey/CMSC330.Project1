/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carey;

import java.io.Reader;
import java.io.StringReader;
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
     * @throws java.lang.Exception
     */
    @Test
    public void testParse() throws Exception {
        Reader stream = new StringReader(
                "Window \"Calculator\" (200, 200) Layout Flow:\n"
                + "  Textfield 20;\n"
                + "  Panel Layout Grid(4, 3, 5, 5):\n"
                + "    Button \"7\";\n"
                + "    Button \"8\";\n"
                + "    Button \"9\";\n"
                + "    Button \"4\";\n"
                + "    Button \"5\";\n"
                + "    Button \"6\";\n"
                + "    Button \"1\";\n"
                + "    Button \"2\";\n"
                + "    Button \"3\";\n"
                + "    Label \"\";\n"
                + "    Button \"0\";\n"
                + "  End;\n"
                + "End.");
        RecursiveDescentParser instance = new RecursiveDescentParser();
        instance.parse(stream);
    }

}
