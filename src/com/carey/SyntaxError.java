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
 *
 * @author ReginaldCarey
 */
public class SyntaxError extends Exception {

    /**
     *
     */
    public SyntaxError() {
    }

    /**
     *
     * @param message
     */
    public SyntaxError(String message) {
        super(message);
    }

}
