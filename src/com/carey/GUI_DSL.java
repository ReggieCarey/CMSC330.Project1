/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carey;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author ReginaldCarey
 */
public class GUI_DSL {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws com.carey.SyntaxError
     * @throws com.carey.ParseException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, SyntaxError, ParseException {
        File file = new File(args[0]);
        Reader reader = new FileReader(file);
        RecursiveDescentParser parser = new RecursiveDescentParser();
        parser.parse(reader);
    }

}
