/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
