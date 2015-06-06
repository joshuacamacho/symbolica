package Terminal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color.*;
import java.awt.event.*;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.text.BadLocationException;

import Terminal.*;

/**
 *
 * @author Alec
 */
public class Terminal_UI extends javax.swing.JFrame {

    Terminal terminal;
    Terminal_State state;
    
    /**
     * Creates new form Terminal_UI
     */
    public Terminal_UI() {
        initComponents();
        terminal = new Terminal();
        state = new Terminal_State();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Symbolica Terminal");
        setBackground(new java.awt.Color(0, 0, 0));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.getViewport().setBackground(new java.awt.Color(0,0,0));

        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setText("-------------------------Symbolica Terminal------------------------\n~~> ");
        jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextArea1MouseClicked(evt);
            }
        });
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextArea1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyReleased
        int key = evt.getKeyCode();
        if(key == KeyEvent.VK_ENTER){
            String text;
            text = jTextArea1.getText();
            text = text.substring(state.get_cursor_position(), text.length()-1);
            change_screen(text);
            terminal.history.add(text);
            jTextArea1.setText(jTextArea1.getText() + "~~> ");
            state.set_cursor_position(state.get_cursor_position() + text.length() + 5);
            terminal.set_history_index(0);
            
        }
        if(key == KeyEvent.VK_UP){
            String modify = terminal.get_history_item(terminal.get_history_index());
            if(!modify.equals("$")){
                int index = jTextArea1.getText().length()-1;
                while(jTextArea1.getText().charAt(index) != '>'){
                    index--;
                }
                String reset = jTextArea1.getText().substring(0,index+2);
                jTextArea1.setText(reset);
                jTextArea1.setText(jTextArea1.getText() + modify);
                terminal.set_history_index(terminal.get_history_index() + 1);
            }
            else{
                jTextArea1.setText(jTextArea1.getText());
            }
            
        }
        if(key == KeyEvent.VK_DOWN){
            
            if(terminal.get_history_index() != 1 && terminal.get_history_index() != 0 && !terminal.history.isEmpty()){
                int index = jTextArea1.getText().length()-1;
                while(jTextArea1.getText().charAt(index) != '>'){
                    index--;
                }
                jTextArea1.setText(jTextArea1.getText().substring(0,index+2));
                terminal.set_history_index(terminal.get_history_index() - 1);
                jTextArea1.setText(jTextArea1.getText() + 
                           terminal.get_history_item(terminal.get_history_index()-1));
            }
            else{
                jTextArea1.setText(jTextArea1.getText());
            }
                        
        }
        if(key == KeyEvent.VK_LEFT){
            if(jTextArea1.getText().charAt(jTextArea1.getCaretPosition()-1) == '>'){
                jTextArea1.setText(jTextArea1.getText());
            }   
        }
        if(key == KeyEvent.VK_BACK_SPACE){
            if(jTextArea1.getText().charAt(jTextArea1.getCaretPosition()-1) == '>'){
                jTextArea1.setText(jTextArea1.getText() + " ");
            } 
        }
        
    }//GEN-LAST:event_jTextArea1KeyReleased

    private void jTextArea1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MouseClicked
        jTextArea1.setText(jTextArea1.getText());
    }//GEN-LAST:event_jTextArea1MouseClicked
    
    
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
            java.util.logging.Logger.getLogger(Terminal_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Terminal_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Terminal_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Terminal_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Terminal_UI().setVisible(true);
            }
        });
    }

    public void change_screen(String text){
        
        String change = terminal.input(text);
        if(change != null && !change.equals("clear")){
            jTextArea1.setText(jTextArea1.getText() + change  + "\n");
            state.set_cursor_position(state.get_cursor_position() + change.length()+1);
        }
        if(change != null && change.equals("clear")){
            jTextArea1.setText("-------------------------Symbolica Terminal------------------------\n");
            state.set_cursor_position(62);
        }
        if(terminal.end_session()){
            System.exit(0);
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}