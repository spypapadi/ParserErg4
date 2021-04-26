package parserMain;

import beautifier.FormTools;
import beautifier.Parser;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author spypa
 */
public class Gui_erg4 extends javax.swing.JFrame {

    /**
     * Creates new form Gui_erg4
     */
    public Gui_erg4() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Μορφοποίητης");

        jButton1.setText("ΑΝΟΙΓΜΑ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ΜΟΡΦΟΠΟΙΗΣΗ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("ΑΠΟΘΗΚΕΥΣΗ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1099, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(602, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        // Δημιουργώ ένα αντικείμενο με όνομα test  τύπου71   "  Parser   "
        Parser test = new Parser(jTextArea1.getText());
        // Κάνω έλεγχο για λάθη στα tokens
        if (!test.getError()) {
            // Με χρήση της μεθόδου " FormTools.getProduced() " της κλάσης parser και τησ μεθόδου " toString "
            // δινω εντολή για εμφάνιση του μορφοποιημένου κειμένου            
            jTextArea1.setText(FormTools.getProduced().toString());
            // Δίνω εντολή για εμφάνιση του παρακάτω μηνύματος στο πεδίο του αντικειμένου " jTextField1 "  
            jTextField1.setText("Text parsing was successful");
        } else {
            // Αν η μορφοποίηση δεν είναι επιτυχής δίνω εντολή για εμφάνιση του παρακάτω μηνύματος 
            // στο πεδίο του αντικειμένου " jTextField1 " 
            jTextField1.setText("Text parsing failed");
        }
        // jTextField1.setText(" Text parsing was successful");


    }//GEN-LAST:event_jButton2ActionPerformed

    @SuppressWarnings("empty-statement")
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // Δημιουργώ έναν επιλογέα αρχείων που τον ονομάζω "   fc  "
        JFileChooser fc = new JFileChooser();
        // Δηλώνω μεταβλητή τύπου File που την ονομάζω chosenFile
        File chosenFile;
        // Σε μια μεταβλητή που την ονομάζω " result "  περνάω την έναρξη επικοινωνίας του επιλεγμένου αρχείου
        // με το κουμπί επιλογής "ΑΝΟΙΓΜΑ"                                 
        int result = fc.showOpenDialog(this);
        
        // Όταν η έναρξη επικοινωνίας εγκριθεί
        if (result == JFileChooser.APPROVE_OPTION) {

            //  System.out.println("Cancel or the close-dialog icon was clicked");
            try {
            // Επιλέγεται το αρχείο
                chosenFile = fc.getSelectedFile();
            // Δημιουργείται στιγμιότυπο αντικειμένου κλάσης FileReader όπου καταχωρείται το επιλεγμένο αρχείο  
                FileReader myReader = new FileReader(chosenFile);
            // Εμφανίζεται το περιεχόμενο στην περιοχή του jTextArea1    
                jTextArea1.read(myReader, fc);
            } catch (IOException ioe) {
           // Σε περίπτωση εξαίρεσης πετάει το παρακάτω μήνυμα
                System.out.println("Exception occured");

            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add 

        // Δημιουργώ έναν επιλογέα αρχείων που τον ονομάζω "   fc  "
        JFileChooser fc = new JFileChooser();
       
        // Κάνω να εμφανίζει το αποτέλεσμα σε μια μεταβλητή που την ονομάζω " result "                                   
        int result = fc.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
        // System.out.println("Cancel or the close-dialog icon was clicked");

            try {
                File chosenFile = fc.getSelectedFile();
                FileWriter myWriter = new FileWriter(chosenFile);
                jTextArea1.write(myWriter);
            } catch (IOException ioe) {

                System.out.println("Exception occured");
            }
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui_erg4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_erg4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_erg4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_erg4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui_erg4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
