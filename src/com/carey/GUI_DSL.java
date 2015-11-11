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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import javax.swing.UnsupportedLookAndFeelException;

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
    public static void main(String[] args) throws FileNotFoundException, IOException, SyntaxError, ParseException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */

        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }

        Reader reader = new StringReader(
                "Window \"Calculator\" (200, 200) Layout Flow:\n"
                + "  Textfield 20;\n"
//                + "  Panel Layout Grid(2,1):\n"
//                + "  Panel Layout Flow:\n"
//                + "    Group\n"
//                + "      Radio \"One\";\n"
//                + "      Radio \"Two\";\n"
//                + "      Radio \"Three\";\n"
//                + "    End;\n"
//                + "  End;\n"
                + "  Panel Layout Grid(4, 3, 5, 5):\n"
                + "    Button \"7\";\n"
                + "    Button \"8\";\n"
                + "    Button \"9\";\n"
                + "    Button \"4\";\n"
                + "    Button \"5\";\n"
                + "    Button \"6\";\n"
                + "    Button \"1\";\n"
                + "    Button \"2\";\n"
                + "    Button \"3\";\n"
                + "    Label \"\";\n"
                + "    Button \"0\";\n"
                + "  End;\n"
//                + "  End;\n"
                + "End.");
        RecursiveDescentParser parser = new RecursiveDescentParser();
        parser.parse(reader);
    }

}
