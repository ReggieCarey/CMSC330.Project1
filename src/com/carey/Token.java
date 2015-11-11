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
public class Token {

    private final Type type;
    private final String content;
    private final int lineNumber;
    private final int offset;

    /**
     *
     * @param type
     * @param content
     * @param lineNumber
     * @param offset
     */
    public Token(Type type, String content, int lineNumber, int offset) {
        this.type = type;
        this.content = content;
        this.lineNumber = lineNumber;
        this.offset = offset;
    }

    /**
     *
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     *
     * @return
     */
    public Type getType() {
        return type;
    }

    /**
     *
     * @return
     */
    public int getLineNumber() {
        return lineNumber;
    }

    /**
     *
     * @return
     */
    public int getOffset() {
        return offset;
    }

    public String toString() {
        return String.format("type: %s, content: %s, line: %d, offset: %d",type,content,lineNumber,offset);
    }
}
