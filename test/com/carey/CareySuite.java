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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author ReginaldCarey
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.carey.EmitterTest.class, com.carey.ParseExceptionTest.class, com.carey.MainTest.class, com.carey.TypeTest.class, com.carey.LexicalScannerTest.class, com.carey.SyntaxErrorTest.class, com.carey.TokenTest.class, com.carey.RecursiveDescentParserTest.class})
public class CareySuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}
