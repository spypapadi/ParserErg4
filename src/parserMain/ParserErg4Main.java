/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parserMain;

import beautifier.FormTools;
import beautifier.Parser;

/**
 *
 * @author spypa
 */
public class ParserErg4Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
          Parser parseFile = new Parser("program X\n"
                + "a := -2;\n"
                + "b := 1;\n"
                + "if (a=5)\n"
                + "{\n"
                + "a := 6\n"
                + "}\n"
                + "else\n"
                + "{\n"
                + "if (b>1)\n"
                + "{\n"
                + "a := 1+a\n"
                + "};\n"
                + "while (a<10)\n"
                + "{\n"
                + "a := a*1;\n"
                + "b := b/1\n"
                + "}\n"
                + "};\n"
                + "print(a)");
        
        System.out.format("%s",FormTools.getProduced());
        
        
      
        
        
        
        
    }
    
}
