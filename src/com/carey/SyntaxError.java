/*
 * *****************************************************************************
 * NAME: Reginald B Carey
 * EMPLID: 0316442
 * PROJECT: Recursive Descent Parser - Project 1
 * COURSE: CMSC 330 - 7980
 * SECTION: 2158
 * SEMESTER: FALL 2015
 * *****************************************************************************
 */
package com.carey;

/**
 * Syntax Error is used to identify lexical parsing problems. When ever there is
 * a problem identifying a token, this exception is raised.
 *
 * @author ReginaldCarey
 */
public class SyntaxError extends Exception {

    public SyntaxError(String message) {
        super(message);
    }

}
