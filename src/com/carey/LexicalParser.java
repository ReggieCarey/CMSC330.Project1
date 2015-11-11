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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ReginaldCarey
 */
public class LexicalParser {

    private final BufferedReader reader;
    private int lineNumber = 0;
    private String current = null;
    private int offset = 0;
    private final Pattern whiteSpace = Pattern.compile("[ \t]*");
    private Token currentToken;

    /**
     *
     * @param stream
     * @throws IOException
     */
    public LexicalParser(Reader stream) throws IOException {
        reader = new BufferedReader(stream);
        currentToken = new Token(Type.BEGINOFINPUT, null, 0, 0);
    }

    /**
     *
     * @param type
     * @return
     * @throws ParseException
     */
    public Token match(Type type) throws ParseException {
        if (currentToken.getType() != type) {
            throw new ParseException(String.format("Unexpected token %s at [%d:%d]\n",
                    currentToken.getContent(),
                    currentToken.getLineNumber(),
                    currentToken.getOffset()));
        }
        return currentToken;
    }

    /**
     *
     * @param type
     * @return
     * @throws ParseException
     * @throws IOException
     * @throws SyntaxError
     */
    public Token matchAndAdvance(Type type) throws ParseException, IOException, SyntaxError {
        if (currentToken.getType() != type) {
            throw new ParseException(String.format("Unexpected token %s at [%d:%d]\n",
                    currentToken.getContent(),
                    currentToken.getLineNumber(),
                    currentToken.getOffset()));
        }
        Token prevToken = currentToken;
        advance();
        return prevToken;
    }

    /**
     *
     * @param type
     * @return
     * @throws ParseException
     */
    public boolean doesMatch(Type type) throws ParseException {
        return currentToken.getType() == type;
    }

    /**
     *
     * @param types
     * @return
     * @throws ParseException
     */
    public boolean doesMatchAny(Type... types) throws ParseException {
        boolean answer = false;
        for (Type type : types) {
            answer = answer | (currentToken.getType() == type);
        }
        return answer;
    }

    /**
     *
     * @param type
     * @return
     * @throws ParseException
     * @throws IOException
     * @throws SyntaxError
     */
    public boolean doesMatchThenAdvance(Type type) throws ParseException, IOException, SyntaxError {
        boolean match = currentToken.getType() == type;
        if (match) {
            advance();
        }
        return match;
    }

    /**
     *
     * @return
     */
    public Token getCurrentToken() {
        return currentToken;
    }

    private Token advance() throws IOException, SyntaxError {

        // While current is null we consume lines of data and white space
        while (true) {
            if (current == null) {
                current = reader.readLine();
                if (current != null) {
                    lineNumber++;
                    offset = 0;
                } else {
                    currentToken = new Token(Type.ENDOFINPUT, null, lineNumber, offset);
                    return currentToken;
                }
            }
            // Look for white space and consume it
            Matcher m = whiteSpace.matcher(current);
            if (m.lookingAt()) {
                offset += m.group().length();
                current = current.substring(m.group().length());
            }

            if (current.length() == 0) {
                current = null;
            } else {
                break;
            }
        }

        // Find the next legal token
        for (Type tokenType : Type.values()) {
            Matcher tokenMatcher = tokenType.getMatcher(current);
            if (tokenMatcher == null) {
                continue;
            }

            if (tokenMatcher.lookingAt()) {
                String foundStr = tokenMatcher.group(tokenMatcher.groupCount());
                currentToken = new Token(tokenType, foundStr, lineNumber, offset);
                offset += tokenMatcher.group().length();
                current = current.substring(tokenMatcher.group().length());
                if (current.length() == 0) {
                    current = null;
                }
                return currentToken;
            }
        }

        throw new SyntaxError(String.format("Invalid token at [%d:%d]\n", lineNumber, offset));
    }
}
