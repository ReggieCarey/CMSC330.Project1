/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        currentToken = new Token(Type.BEGINOFINPUT, null, lineNumber, offset);
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
        advance();
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
        Matcher whiteSpaceMatcher;

        if (current != null) {
            // create a whitespace matcher over the current line.
            whiteSpaceMatcher = whiteSpace.matcher(current);

            // If we got a matcher for a token and we have a prefix match
            if (whiteSpaceMatcher != null && whiteSpaceMatcher.lookingAt()) {

                // Offset to the next token is computed
                offset += whiteSpaceMatcher.group().length();

                // Remove what we just matched from the front of the string
                current = current.substring(whiteSpaceMatcher.group().length());
            }

            if (current.length() == 0) {
                current = null;
            }
        }

        // Consume whitespace including blank lines
        while (current == null) {

            // read a line from the file
            current = reader.readLine();

            // If it's null then we've reached the end of the file
            if (current == null) {
                currentToken = new Token(Type.ENDOFINPUT, null, lineNumber, offset);
                return currentToken;
            }

            // We have some data to parse. Reset our positional parameters
            lineNumber++;
            offset = 0;

            // create a whitespace matcher over the current line.
            whiteSpaceMatcher = whiteSpace.matcher(current);

            // If we got a matcher for a token and we have a prefix match
            if (whiteSpaceMatcher != null && whiteSpaceMatcher.lookingAt()) {

                // Offset to the next token is computed
                offset += whiteSpaceMatcher.group().length();

                // Remove what we just matched from the front of the string
                current = current.substring(whiteSpaceMatcher.group().length());
            }

            if (current.length() == 0) {
                current = null;
            }
        }

System.out.println("Current input line ["+current+"]");
        // An horrifically inefficient token matching loop
        for (Type type : Type.values()) {

            System.out.println("Is it a "+type);
            // Get a matcher for a token
            Matcher typeMatcher = type.getMatcher(current);

            // If we got a matcher for a token and we have a prefix match
            if (typeMatcher != null && typeMatcher.lookingAt()) {

                // The current token is what we found
                currentToken = new Token(type, typeMatcher.group(typeMatcher.groupCount()), lineNumber, offset + typeMatcher.start(typeMatcher.groupCount()));

                // Offset to the next token is computed
                offset += typeMatcher.group().length();

                // Remove what we just matched from the front of the string
                current = current.substring(typeMatcher.group().length());
System.out.println("It is a Token : "+currentToken);
                return currentToken;
            }
        }

        throw new SyntaxError(String.format("Invalid token at [%d:%d]\n", lineNumber, offset));
    }

}
