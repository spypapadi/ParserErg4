package beautifier;

//   @author spypa
public class Parser {

    Token token;
    Lex lex;
    Boolean error = false;

    public Parser(String buffer) {
        lex = new Lex(buffer);
        if (lex.getError()) {
            error = true;
        } else {
            token = lex.nextToken();
            program();
            if (!token.getType().name().equals("eofTK")) {
                error();
            }
        }
    }

    private void error() {
        if (!error) {
            System.out.format("Syntax error in line %d\n", token.getLine());
        }
        error = true;
    }

    public Boolean getError() {
        return error;
    }

    private void program() {
        if (token.getType().name().equals("programTK")) {
            FormTools.produceToken(token.getData());
            FormTools.produceSpace();
            token = lex.nextToken();
            if (token.getType().name().equals("variableTK")) {
                FormTools.produceToken(token.getData());
                FormTools.produceNewLine();
                FormTools.addTab();
                FormTools.produceTabs();
                token = lex.nextToken();
                statements();
                FormTools.produceNewLine();
            } else {
                error();
            }
        } else {
            error();
        }
    }

    //   Ακολουθούμε το παράδειγμα για την < expression > που δίνεται στην εκφώνηση όπου λόγω 
    //   του αστέρι Klenee, μπορεί η κλήση μιας μεθόδου ( στην συγκεκριμένη περίπτωση της statetement() )
    //   να γίνει από καμία έως όσες φορές χρειαστεί , με την προυπόθεση ότο ο διαχωρισμός μεταξύ τους 
    //   θα γίνεται με semicol .
    private void statements() {

        //  Καλώ τη μεθοδο statetement
        statement();

        // Με την προυπόθεση ύπαρξης διαχωριστικού συμβόλου " ; "
        while (token.type.name().equals("semicolTK")) {
            // Παίρνω το data του λεκτικού
            FormTools.produceToken(token.getData());
            // Κάνω αλλαγή γραμμής
            FormTools.produceNewLine();
            // Τυπώνω τα tabs
            FormTools.produceTabs();
            // Καλώ το επόμενο λεκτικό 
            token = lex.nextToken();
            //  Καλώ τη μεθοδο statetement
            statement();

        }

    }

    private void statement() {
        if (token.type.name().equals("ifTK")) {
            if_stat();
        } else if (token.type.name().equals("whileTK")) {
            while_stat();
        } else if (token.type.name().equals("printTK")) {
            print_stat();
        } else if (token.type.name().equals("variableTK")) {
            assign_stat();
        } else {
            error();
        }
    }

    // <print_stat> 	::= 	print ( <expression> )
    private void print_stat() {

        // Αν το λεκτικό είναι το " print " 
        if (token.getType().name().equals("printTK")) {
            // Παίρνω το data του λεκτικού   
            FormTools.produceToken(token.getData());           
            // Καλώ το επόμενο λεκτικό    
            token = lex.nextToken();

            // Αν το λεκτικό είναι το " αριστερή παρένθεση "      
            if (token.getType().name().equals("leftpTK")) {
                // Παίρνω το data του λεκτικού   
                FormTools.produceToken(token.getData());
                // Καλώ το επόμενο λεκτικό    
                token = lex.nextToken();

                // Καλώ την μέθοδο expression  
                expression();
                // Αν το λεκτικό είναι το " δεξιά παρένθεση "   
                if (token.getType().name().equals("rightpTK")) {
                    // Παίρνω το data του λεκτικού  
                    FormTools.produceToken(token.getData());
                    // Καλώ το επόμενο λεκτικό     
                    token = lex.nextToken();

                } else {
                    error();
                }

            }
        }
    }

    //   <assign_stat>	::= 	ID := <expression>
    private void assign_stat() {

        if (token.type.name().equals("variableTK")) {
            // Παίρνω το data του λεκτικού
            FormTools.produceToken(token.getData());
            // Αφήνω ένα κενό 
            FormTools.produceSpace();
            // Καλώ το επόμενο λεκτικό            
            token = lex.nextToken();

            if (token.type.name().equals("assignTK")) {
                // Παίρνω το data του λεκτικού
                FormTools.produceToken(token.getData());
                // Αφήνω ένα κενό 
                FormTools.produceSpace();
                // Καλώ το επόμενο λεκτικό        
                token = lex.nextToken();
                // Καλώ τη μεθοδο expression
                expression();
            } else {
                error();
            }
        }

    }

//   <while_stat>	 ::=	  while ( <expression> <rel_op> <expression> )
//                                { <statements> }
    private void while_stat() {

        // Αν το λεκτικό είναι το " while " 
        if (token.getType().name().equals("whileTK")) {
            // Παίρνω το data του λεκτικού
            FormTools.produceToken(token.getData());
            // Αφήνω ένα κενό 
            FormTools.produceSpace();
            // Καλώ το επόμενο λεκτικό 
            token = lex.nextToken();

            // Αν το λεκτικό είναι το " αριστερή παρένθεση "     
            if (token.getType().name().equals("leftpTK")) {
                // Παίρνω το data του λεκτικού
                FormTools.produceToken(token.getData());
                // Καλώ το επόμενο λεκτικό 
                token = lex.nextToken();
                // Καλώ τις παρακάτω μεθόδους
                expression();
                relOperator();
                expression();

                // Αν το λεκτικό είναι το " δεξιά  παρένθεση "     
                if (token.getType().name().equals("rightpTK")) {
                    // Παίρνω το data του λεκτικού
                    FormTools.produceToken(token.getData());
                    // Κάνω αλλαγή γραμμής
                    FormTools.produceNewLine();
                    //  Τυπώνω τα tabs
                    FormTools.produceTabs();
                    // Καλώ το επόμενο λεκτικό 
                    token = lex.nextToken();

                    // Αν το λεκτικό είναι το " αριστερό άγκιστρο "     
                    if (token.getType().name().equals("leftbTK")) {
                        // Παίρνω το data του λεκτικού
                        FormTools.produceToken(token.getData());
                        // Κάνω αλλαγή γραμμής
                        FormTools.produceNewLine();
                        // Προσθέτω tabs
                        FormTools.addTab();
                        // Τυπώνω τα tabs
                        FormTools.produceTabs();
                        // Καλώ το επόμενο λεκτικό 
                        token = lex.nextToken();
                        // Καλώ την μέθοδο " statements "
                        statements();

                        // Κάνω αλλαγή γραμμής
                        FormTools.produceNewLine();
                        // Προσθέτω tabs
                        FormTools.deTab();
                        // Τυπώνω τα tabs
                        FormTools.produceTabs();
                        // Καλώ το επόμενο λεκτικό 
                        token = lex.nextToken();

                        // Αν το λεκτικό είναι το " δεξί άγκιστρο "     
                        if (token.getType().name().equals("rightbTK")) {
                            // Παίρνω το data του λεκτικού
                            FormTools.produceToken(token.getData());
                            // Κάνω αλλαγή γραμμής
                            FormTools.produceNewLine();
                            // Αφαιρώ tabs
                            FormTools.deTab();
                            // Τυπώνω τα tabs
                            FormTools.produceTabs();

                        } else {
                            error();
                        }

                    } else {
                        error();
                    }

                } else {
                    error();
                }

            } else {
                error();
            }

        } else {
            error();
        }

    }
//
// 
//    <if_stat> 	::= 	if ( <expression> <rel_op> <expression> )
//                               { <statements> }
//                               <else_part>

    private void if_stat() {

        // Αν το λεκτικό είναι το " if " 
        if (token.getType().name().equals("ifTK")) {
            // Παίρνω το data του λεκτικού
            FormTools.produceToken(token.getData());
            // Αφήνω ένα κενό
            FormTools.produceSpace();
            // Καλώ το επόμενο λεκτικό 
            token = lex.nextToken();

            // Αν το λεκτικό είναι η αριστερή παρένθεση
            if (token.getType().name().equals("leftpTK")) {
                // Παίρνω το data του λεκτικού
                FormTools.produceToken(token.getData());

                // Καλώ το επόμενο λεκτικό 
                token = lex.nextToken();
                expression();
                relOperator();
                expression();

                // Αν το λεκτικό είναι η δεξιά  παρένθεση
                if (token.getType().name().equals("rightpTK")) {
                    // Παίρνω το data του λεκτικού
                    FormTools.produceToken(token.getData());
                    // Κάνω αλλαγή γραμμής
                    FormTools.produceNewLine();
                    // Τυπώνω τα tabs
                    FormTools.produceTabs();
                    // Καλώ το επόμενο λεκτικό 
                    token = lex.nextToken();

                    // Αν το λεκτικό είναι το αριστερό άγκιστρο
                    if (token.getType().name().equals("leftbTK")) {
                        // Παίρνω το data του λεκτικού
                        FormTools.produceToken(token.getData());
                        // Κάνω αλλαγή γραμμής
                        FormTools.produceNewLine();
                        // Προσθέτω tabs
                        FormTools.addTab();
                        // Τυπώνω τα tabs
                        FormTools.produceTabs();
                        // Καλώ το επόμενο λεκτικό 
                        token = lex.nextToken();

                        // Καλώ τη μέθοδο statements
                        statements();

                        // Κάνω αλλαγή γραμμής
                        FormTools.produceNewLine();
                        // Αφαιρώ  tabs για να υπάρξει κάθετη στοίχιση του αριστερού και δεξιού bracket
                        FormTools.deTab();
                        // Τυπώνω τα tabs
                        FormTools.produceTabs();
                        // Καλώ το επόμενο λεκτικό 

                        // Αν το λεκτικό είναι το δεξί άγκιστρο
                        if (token.getType().name().equals("rightbTK")) {
                            // Παίρνω το data του λεκτικού
                            FormTools.produceToken(token.getData());
                            //Καλώ το επόμενο λεκτικό 
                            token = lex.nextToken();

                            //Καλώ τη μέθοδο else_part
                            else_part();

                            // Σε κάθε άλλη περίπτωση καλώ την μέθοδο error
                        } else {
                            error();

                        }
                    }

                }
            }
        }
    }

//   <else_part> 	: := 	  else { <statements> } 
//                        | 	  ε
    private void else_part() {

        //  Αν το λεκτικό είναι το  " else "
        if (token.getType().name().equals("elseTK")) {

            //  Κάνω αλλαγή γραμμής
            FormTools.produceNewLine();
            //  Τυπώνω τα tabs για στοίχιση του " else " κάτω από το αριστερό άγκιστρο 
            FormTools.produceTabs();

            //Παίρνω το data του λεκτικού
            FormTools.produceToken(token.getData());
            //  Κάνω αλλαγή γραμμής
            FormTools.produceNewLine();
            // Τυπώνω τα tabs για στοίχιση του " else " κάτω από το αριστερό άγκιστρο 
            FormTools.produceTabs();

            //  Καλώ το επόμενο λεκτικό 
            token = lex.nextToken();
            //  Αν το λεκτικό είναι το αριστερό άγκιστρο
            if (token.getType().name().equals("leftbTK")) {
                //  Παίρνω το data του λεκτικού
                FormTools.produceToken(token.getData());
                //  Κάνω αλλαγή γραμμής
                FormTools.produceNewLine();
                //  Προσθέτω tabs
                FormTools.addTab();
                //   Τυπώνω τα tabs
                FormTools.produceTabs();

                //  Καλώ το επόμενο λεκτικό 
                token = lex.nextToken();
                //   Καλώ την μέθοδο " statements "
                statements();

                //   Αν το λεκτικό είναι το δεξί άγκιστρο
                if (token.getType().name().equals("rightbTK")) {
                    //   Παίρνω το data του λεκτικού
                    FormTools.produceToken(token.getData());

                    //  Καλώ το επόμενο λεκτικό 
                    token = lex.nextToken();
                    // Καλώ τη μέθοδο " print_stat() "
                    print_stat();

                }

            }

        }

    }

    private void expression() {
        optional_sign();
        term();
        while (token.type.name().equals("plusTK") || token.type.name().equals("minusTK")) {
            add_oper();
            term();
        }
    }

    private void term() {
        factor();
        while (token.type.name().equals("multTK") || token.type.name().equals("divTK")) {
            mult_oper();
            factor();
        }
    }

    private void factor() {
        if (token.type.name().equals("integerTK")) {
            FormTools.produceToken(token.getData());
            token = lex.nextToken();
        } else if (token.type.name().equals("variableTK")) {
            FormTools.produceToken(token.getData());
            token = lex.nextToken();
        } else if (token.type.name().equals("leftpTK")) {
            FormTools.produceToken(token.getData());
            token = lex.nextToken();
            expression();
            if (token.type.name().equals("rightpTK")) {
                FormTools.produceToken(token.getData());
                token = lex.nextToken();
            } else {
                error();
            }
        } else {
            error();
        }
    }

    private void relOperator() {
        if (token.type.name().equals("equalTK")) {
            FormTools.produceToken(token.getData());
            token = lex.nextToken();
        } else if (token.type.name().equals("smallerTK")) {
            FormTools.produceToken(token.getData());
            token = lex.nextToken();
        } else if (token.type.name().equals("largerTK")) {
            FormTools.produceToken(token.getData());
            token = lex.nextToken();
        } else if (token.type.name().equals("smallerEqualTK")) {
            FormTools.produceToken(token.getData());
            token = lex.nextToken();
        } else if (token.type.name().equals("largerEqualTK")) {
            FormTools.produceToken(token.getData());
            token = lex.nextToken();
        } else if (token.type.name().equals("notEqualTK")) {
            FormTools.produceToken(token.getData());
            token = lex.nextToken();
        } else {
            error();
        }
    }

    private void add_oper() {
        if (token.type.name().equals("plusTK")) {
            FormTools.produceToken(token.getData());
            token = lex.nextToken();
        } else if (token.type.name().equals("minusTK")) {
            FormTools.produceToken(token.getData());
            token = lex.nextToken();
        } else {
            error();
        }
    }

    private void mult_oper() {
        if (token.type.name().equals("multTK")) {
            FormTools.produceToken(token.getData());
            token = lex.nextToken();
        } else if (token.type.name().equals("divTK")) {
            FormTools.produceToken(token.getData());
            token = lex.nextToken();
        } else {
            error();
        }
    }

    private void optional_sign() {
        if (token.type.name().equals("plusTK") || token.type.name().equals("minusTK")) {
            add_oper();
        }
    }

}
