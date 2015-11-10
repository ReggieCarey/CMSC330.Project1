/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carey;

import static com.carey.Type.BEGINOFINPUT;
import static com.carey.Type.BUTTON;
import static com.carey.Type.COLON;
import static com.carey.Type.COMMA;
import static com.carey.Type.END;
import static com.carey.Type.ENDOFINPUT;
import static com.carey.Type.FLOW;
import static com.carey.Type.GRID;
import static com.carey.Type.GROUP;
import static com.carey.Type.LABEL;
import static com.carey.Type.LAYOUT;
import static com.carey.Type.LPAREN;
import static com.carey.Type.NUMBER;
import static com.carey.Type.PANEL;
import static com.carey.Type.PERIOD;
import static com.carey.Type.RADIO;
import static com.carey.Type.RPAREN;
import static com.carey.Type.SEMICOLON;
import static com.carey.Type.STRING;
import static com.carey.Type.TEXTFIELD;
import static com.carey.Type.WINDOW;
import java.io.IOException;
import java.io.Reader;

/*******************************************************************************
 * NAME: Recursive Descent Parser - Project 1
 * COURSE: CMSC 330 - 7980
 * SECTION: 2158
 * SEMESTER: FALL 2015
 * EMPLID: 0316442
 *******************************************************************************
 * This class implements a Recursive Descent Parser.  It parses the grammar
 * as specified in the Project 1 homework assignment.  This grammar is intended
 * to represent a domain specific language designed to generate graphical user
 * interfaces.
 *
 * This code will act like an interpreter in that it will directly generate the
 * GUI using Java SWING API's instead of generating the Java Source Code to
 * produce the GUI.
 *
 * Implementation details:  This class utilizes two helper classes, LexicalParser
 * and Emitter.  LexicalParser has the job to present a stream tokens. It
 * also provides helper routines to evaluate the current token.
 *
 * @author ReginaldCarey
 */
public class RecursiveDescentParser {

    private LexicalParser lex;
    private Emitter emitter;

    /**
     * Parse a GUI DSL producing a GUI.  This method will parse the contents
     * of a Reader and generate a GUI based on the content.
     *
     * @param stream - a basic reader.
     * @throws IOException - on problems reading the reader
     * @throws SyntaxError - on any token parsing error
     * @throws ParseException - on any structural parsing error
     */
    public void parse(Reader stream) throws IOException, SyntaxError, ParseException {
        lex = new LexicalParser(stream);
        emitter = new Emitter();
        gui();
    }

    /**
     * Recursive Descent Parser for gui. Parses gui as per the grammar:
     *
     * gui ::=
     *      Window STRING '(' NUMBER ',' NUMBER ')' layout widgets End '.'
     *
     * @throws IOException
     * @throws SyntaxError
     * @throws ParseException
     */
    private void gui() throws IOException, SyntaxError, ParseException {
        lex.matchAndAdvance(BEGINOFINPUT);
        lex.matchAndAdvance(WINDOW);
        String windowName = lex.matchAndAdvance(STRING).getContent();
        lex.matchAndAdvance(LPAREN);
        int width = Integer.parseInt(lex.matchAndAdvance(NUMBER).getContent());
        lex.matchAndAdvance(COMMA);
        int height = Integer.parseInt(lex.matchAndAdvance(NUMBER).getContent());
        lex.matchAndAdvance(RPAREN);
        layout();
        widgets();
        lex.matchAndAdvance(END);
        lex.matchAndAdvance(PERIOD);
        lex.match(ENDOFINPUT);
        emitter.emit(new Object[]{WINDOW,windowName,width,height});
    }

    /**
     * Recursive Descent Parser for layout. Parses layout as per the grammar:
     *
     * layout ::=
     *      Layout layout_type ':'
     *
     * @throws IOException
     * @throws SyntaxError
     * @throws ParseException
     */
    private void layout() throws IOException, SyntaxError, ParseException {
        lex.matchAndAdvance(LAYOUT);
        layout_type();
        lex.matchAndAdvance(COLON);
        emitter.emit(new Object[]{LAYOUT});
    }

    /**
     * Recursive Descent Parser for layout_type. Parses layout_type as per the grammar:
     *
     * layout_type ::=
     *      Flow |
     *      Grid '(' NUMBER ',' NUMBER [',' NUMBER ',' NUMBER] ')'
     *
     * @throws IOException
     * @throws SyntaxError
     * @throws ParseException
     */
    private void layout_type() throws IOException, SyntaxError, ParseException {
            System.out.println("Doing Layout Type");
        if (lex.doesMatchThenAdvance(FLOW)) {
            emitter.emit(new Object[]{FLOW});
        } else if (lex.doesMatchThenAdvance(GRID)) {
            int rows, cols, hspace = 0, vspace = 0;
            System.out.println("P1");
            lex.matchAndAdvance(LPAREN);
            System.out.println("P2");
            rows = Integer.parseInt(lex.matchAndAdvance(NUMBER).getContent());
            System.out.println("P3");
            lex.matchAndAdvance(COMMA);
            cols = Integer.parseInt(lex.matchAndAdvance(NUMBER).getContent());
            if (lex.doesMatchThenAdvance(COMMA)) {
                hspace = Integer.parseInt(lex.matchAndAdvance(NUMBER).getContent());
                lex.matchAndAdvance(COMMA);
                vspace = Integer.parseInt(lex.matchAndAdvance(NUMBER).getContent());
            }
            lex.matchAndAdvance(RPAREN);
            emitter.emit(new Object[]{GRID,rows,cols,hspace,vspace});
//        } else {
//            throw new ParseException(String.format("Expected one of [Flow, Grid] at [%d:%d]", lex.getCurrentToken().getLineNumber(), lex.getCurrentToken().getOffset()));
        }
    }

    /**
     * Recursive Descent Parser for widgets. Parses widgets as per the grammar:
     *
     * widgets ::=
     *      widget widgets |
     *      widget
     *
     * NOTE: We take advantage of tail recursion optimization and convert to a loop.
     *
     * @throws IOException
     * @throws SyntaxError
     * @throws ParseException
     */
    private void widgets() throws IOException, SyntaxError, ParseException {
        widget();
        while (lex.doesMatchAny(BUTTON,GROUP,LABEL,PANEL,TEXTFIELD)) {
            widget();
        }
    }

    /**
     * Recursive Descent Parser for widget. Parses widget as per the grammar:
     *
     * widget ::=
     *      Button STRING ';' |
     *      Group radio_buttons End ';' |
     *      Label STRING ';' |
     *      Panel layout widgets End ';' |
     *      Textfield NUMBER ';'
     *
     * @throws IOException
     * @throws SyntaxError
     * @throws ParseException
     */
    private void widget() throws IOException, SyntaxError, ParseException {
        if (lex.doesMatchThenAdvance(BUTTON)) {
            String buttonText = lex.matchAndAdvance(STRING).getContent();
            lex.matchAndAdvance(SEMICOLON);
            emitter.emit(new Object[]{BUTTON,buttonText});
        } else if (lex.doesMatchThenAdvance(GROUP)) {
            radio_buttons();
            lex.matchAndAdvance(END);
            lex.matchAndAdvance(SEMICOLON);
            emitter.emit(new Object[]{GROUP});
        } else if (lex.doesMatchThenAdvance(LABEL)) {
            String labelText = lex.matchAndAdvance(STRING).getContent();
            lex.matchAndAdvance(SEMICOLON);
            emitter.emit(new Object[]{LABEL,labelText});
        } else if (lex.doesMatchThenAdvance(PANEL)) {
            layout();
            widgets();
            lex.matchAndAdvance(END);
            lex.matchAndAdvance(SEMICOLON);
            emitter.emit(new Object[]{PANEL});
        } else if (lex.doesMatchThenAdvance(TEXTFIELD)) {
            int width = Integer.parseInt(lex.matchAndAdvance(NUMBER).getContent());
            lex.matchAndAdvance(SEMICOLON);
            emitter.emit(new Object[]{TEXTFIELD, width});
        } else {
            throw new ParseException(String.format("Expected one of [Button, Group, Label, Panel, Textfield] at [%d:%d]", lex.getCurrentToken().getLineNumber(), lex.getCurrentToken().getOffset()));
        }
    }

    /**
     * Recursive Descent Parser for radio_buttons. Parses radio_buttons as per the grammar:
     *
     * radio_buttons ::=
     *      radio_button radio_buttons |
     *      radio_button
     *
     * NOTE: We take advantage of tail recursion optimization and convert to a loop.
     *
     * @throws IOException
     * @throws SyntaxError
     * @throws ParseException
     */
    private void radio_buttons() throws IOException, SyntaxError, ParseException {
        radio_button();
        while (lex.doesMatch(RADIO)) {
            radio_button();
        }
    }

    /**
     * Recursive Descent Parser for radio_button. Parses radio_button as per the grammar:
     *
     * radio_button ::=
     *      Radio STRING ';'
     *
     * @throws IOException
     * @throws SyntaxError
     * @throws ParseException
     */
    private void radio_button() throws IOException, SyntaxError, ParseException {
        lex.matchAndAdvance(RADIO);
        String name = lex.matchAndAdvance(STRING).getContent();
        lex.matchAndAdvance(SEMICOLON);
        emitter.emit(new Object[]{RADIO,name});
    }

}
