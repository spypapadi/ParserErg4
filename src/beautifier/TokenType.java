package beautifier;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author spypa
 */
public enum TokenType {
    
    
    whitespaceTK("[ \t\f\r]+"),
        newlineTK("\n"),

        integerTK("\\d+"),

        programTK("program"),
        ifTK("if"),
        elseTK("else"),       
        whileTK("while"),       
        printTK("print"),
        variableTK("[a-zA-Z]\\w*"),

        assignTK(":="),     

        plusTK("\\+"),
        minusTK("\\-"),
        multTK("\\*"),
        divTK("\\/"),
        equalTK("="),
        smallerTK("<"),
        largerTK(">"),
        smallerEqualTK("<="),
        largerEqualTK(">="),
        notEqualTK("<>"),
      
        leftpTK("\\("),
        rightpTK("\\)"),
        leftbTK("\\{"),
        rightbTK("\\}"),

        semicolTK(";"),
        eofTK("\\Z"),
        unknownTK("."),
        ;

        public final String pattern;

        private TokenType(String pattern) 
        {
            this.pattern = pattern;
        }    

    public String getPattern() 
    {
        return pattern;
    }            
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

