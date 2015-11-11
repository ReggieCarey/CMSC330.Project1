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

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.util.regex.Pattern.LITERAL;

/**
 *
 * @author ReginaldCarey
 */
public enum Type {

    /**
     * Synthetic type used to mark the beginning of the token stream.
     */
    BEGINOFINPUT,

    /**
     * Synthetic type used to mark the end of a Window.
     */
    ENDWINDOW,

    /**
     * Synthetic type used to mark the end of a Panel.
     */
    ENDPANEL,

    /**
     * Synthetic type used to mark the end of a Group.
     */
    ENDGROUP,

    /**
     * Synthetic type used to mark the ending of the token stream.
     */
    ENDOFINPUT,

    /**
     * Window is a keyword.
     */
    WINDOW("Window", LITERAL),

    /**
     * A String. We only consider the contents between the quotes.
     */
    STRING("\"([^\"]*)\""),

    /**
     * L-parenthesis is used to start a list of related tokens.
     */
    LPAREN("\\("),

    /**
     * R-parenthesis is used to end a list of related tokens.
     */
    RPAREN("\\)"),

    /**
     * A Number. Numbers consist of 1-9 followed by zero or more 0-9.
     */
    NUMBER("[1-9][0-9]*"),

    /**
     * End is a keyword.
     */
    END("End", LITERAL),

    /**
     * Period is the last character token in a file.
     */
    PERIOD(".", LITERAL),

    /**
     * Layout is a keyword.
     */
    LAYOUT("Layout", LITERAL),

    /**
     * Colon is used to terminate a layout definition.
     */
    COLON(":", LITERAL),

    /**
     * Flow is a keyword.
     */
    FLOW("Flow", LITERAL),

    /**
     * Grid is a keyword.
     */
    GRID("Grid", LITERAL),

    /**
     * Comma is a separator in a list of tokens.
     */
    COMMA(",", LITERAL),

    /**
     * Button is a keyword.
     */
    BUTTON("Button", LITERAL),

    /**
     * Semi-colon is used to terminate widget definitions including radio buttons.
     */
    SEMICOLON(";", LITERAL),

    /**
     * Group is a keyword.
     */
    GROUP("Group", LITERAL),

    /**
     * Label is a keyword.
     */
    LABEL("Label", LITERAL),

    /**
     * Panel is a keyword.
     */
    PANEL("Panel", LITERAL),

    /**
     * Textfield is a keyword.
     */
    TEXTFIELD("Textfield", LITERAL),

    /**
     * Radio is a keyword.
     */
    RADIO("Radio", LITERAL);

    private final Pattern pattern;

    private Type() {
        pattern = null;
    }

    private Type(String str) {
        pattern = Pattern.compile(str);
    }

    private Type(String str, int flags) {
        pattern = Pattern.compile(str, flags);
    }

    /**
     *
     * @param charSequence
     * @return
     */
    public Matcher getMatcher(CharSequence charSequence) {
        return pattern != null ? pattern.matcher(charSequence) : null;
    }
}
