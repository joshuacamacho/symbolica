/*
 * Name: Alec Farfan, Jiwon Yoo, Luis Pena, Wenbo Yang
 * Date: 03/20/15
 * Purpose: Chess LoginUI Class
 */



// Import libraries
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class LoginUI extends javax.swing.JFrame {

    // Member variables
    private static boolean onePlayer;
    private Pattern r,r2;
    private Matcher m,m2;
    
    /**
     * Creates new form LoginUI
     */
    public LoginUI() {
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

        registerDialog = new javax.swing.JDialog();
        registerUsernameLabel = new javax.swing.JLabel();
        registerUnameTextField = new javax.swing.JTextField();
        registerPWField = new javax.swing.JPasswordField();
        registerConfirmPWField = new javax.swing.JPasswordField();
        registerPWLabel = new javax.swing.JLabel();
        registerConfirmPWLabel = new javax.swing.JLabel();
        registerButton2 = new javax.swing.JButton();
        registerCancelButton = new javax.swing.JButton();
        registerCheckIDButton = new javax.swing.JButton();
        selectPlayerLabel = new javax.swing.JLabel();
        choice1 = new java.awt.Choice();
        startGameButton = new javax.swing.JButton();
        userNameLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        pwLabel = new javax.swing.JLabel();
        userPasswordField = new javax.swing.JPasswordField();
        loginGuestButtton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        returnLabel = new javax.swing.JLabel();
        player1ID = new javax.swing.JLabel();
        p1UserName = new javax.swing.JTextField();
        p2UserName = new javax.swing.JTextField();
        player2ID = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();

        registerDialog.setTitle("Chess - Registor new user");

        registerUsernameLabel.setText("User Name:");

        registerUnameTextField.setForeground(new java.awt.Color(203, 203, 203));
        registerUnameTextField.setText("enter username");
        registerUnameTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerUnameTextFieldMouseClicked(evt);
            }
        });

        registerPWField.setText("root");

        registerConfirmPWField.setText("toor");

        registerPWLabel.setText("Password:");

        registerConfirmPWLabel.setText("Confirm Password:");

        registerButton2.setText("Register");
        registerButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButton2ActionPerformed(evt);
            }
        });

        registerCancelButton.setText("Cancel");
        registerCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerCancelButtonActionPerformed(evt);
            }
        });

        registerCheckIDButton.setText("Check");

        javax.swing.GroupLayout registerDialogLayout = new javax.swing.GroupLayout(registerDialog.getContentPane());
        registerDialog.getContentPane().setLayout(registerDialogLayout);
        registerDialogLayout.setHorizontalGroup(
            registerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerDialogLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(registerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registerUsernameLabel)
                    .addComponent(registerPWLabel)
                    .addComponent(registerConfirmPWLabel)
                    .addComponent(registerButton2))
                .addGap(138, 138, 138)
                .addGroup(registerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(registerPWField)
                        .addComponent(registerUnameTextField)
                        .addComponent(registerConfirmPWField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(registerCancelButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(34, 34, 34)
                .addComponent(registerCheckIDButton)
                .addContainerGap())
        );
        registerDialogLayout.setVerticalGroup(
            registerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerDialogLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(registerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerUsernameLabel)
                    .addComponent(registerUnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerCheckIDButton))
                .addGap(18, 18, 18)
                .addGroup(registerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerPWField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerPWLabel))
                .addGap(18, 18, 18)
                .addGroup(registerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerConfirmPWField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerConfirmPWLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(registerDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerButton2)
                    .addComponent(registerCancelButton))
                .addGap(29, 29, 29))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chess - Login");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });

        selectPlayerLabel.setText("Select Player to Login:");

        choice1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        choice1.setName(""); // NOI18N

        startGameButton.setText("Start Game");
        startGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameButtonActionPerformed(evt);
            }
        });

        userNameLabel.setText("User Name:");

        usernameTextField.setForeground(new java.awt.Color(209, 209, 209));
        usernameTextField.setText("user name");
        usernameTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameTextFieldMouseClicked(evt);
            }
        });

        pwLabel.setText("Password:");

        userPasswordField.setText("root");

        loginGuestButtton.setText("Login as Guest");
        loginGuestButtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginGuestButttonActionPerformed(evt);
            }
        });

        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        returnLabel.setText("Return");
        returnLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnLabelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                returnLabelMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                returnLabelMouseEntered(evt);
            }
        });

        player1ID.setText("Player 1:");

        p1UserName.setEnabled(false);

        p2UserName.setEnabled(false);

        player2ID.setText("Player 2:");

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(returnLabel)
                .addGap(61, 61, 61)
                .addComponent(startGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(player1ID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(p1UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(player2ID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(p2UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(userNameLabel)
                                    .addGap(118, 118, 118)
                                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(selectPlayerLabel)
                                    .addGap(45, 45, 45)
                                    .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(loginGuestButtton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(pwLabel)
                                    .addGap(126, 126, 126)
                                    .addComponent(userPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectPlayerLabel)
                    .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(userNameLabel))
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(pwLabel))
                    .addComponent(userPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginButton)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginGuestButtton)
                    .addComponent(registerButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player1ID)
                    .addComponent(p1UserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player2ID)
                    .addComponent(p2UserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returnLabel))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnLabelMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        //System.exit(0);
        Matrix_Calculator_UI mainMenu = new Matrix_Calculator_UI();
        mainMenu.setVisible(true);
    }//GEN-LAST:event_returnLabelMouseClicked

    private void returnLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnLabelMouseEntered
        // TODO add your handling code here:
        returnLabel.setText("RETURN");
        returnLabel.setForeground(Color.MAGENTA);
    }//GEN-LAST:event_returnLabelMouseEntered

    private void returnLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnLabelMouseExited
        // TODO add your handling code here:
        returnLabel.setText("Return");
        returnLabel.setForeground(Color.BLACK);
    }//GEN-LAST:event_returnLabelMouseExited

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        // TODO add your handling code here:
        registerDialog.setLocationRelativeTo(null);
        registerDialog.setSize(600,250);
        registerDialog.setVisible(true);
        if( registerDialog.isEnabled() );
            reset();
    }//GEN-LAST:event_registerButtonActionPerformed

    private void registerCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerCancelButtonActionPerformed
        // TODO add your handling code here:
        registerDialog.setVisible(false);
    }//GEN-LAST:event_registerCancelButtonActionPerformed

    private void registerButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButton2ActionPerformed
      // String to be scanned to find the pattern.
      String username = registerUnameTextField.getText();
      String pw = "",
              pwConfirm = "";
      
      // getPassword() returns char[]
      char[] ch = registerPWField.getPassword(),
              ch2 = registerConfirmPWField.getPassword();
      
      // append each char in char[] to string
      for(int i = 0; i < ch.length; ++i) 
           pw += ("" + ch[i]);
      
       for(int i = 0; i < ch2.length; ++i) 
           pwConfirm += ("" + ch2[i]);
      
       // patterns
      String pattern = "^[a-zA-Z0-9]{3,35}$"; // username
      String pattern2 = "^[a-zA-Z0-9!@#$%^&*]{8,35}$"; // password

      // Create a Pattern object
      r = Pattern.compile(pattern);
      r2 = Pattern.compile(pattern2);
      // Now create matcher object.
      m = r.matcher(username);
      m2 = r2.matcher(pw);
      
      if(m.find() && m2.find() && (pw.equals(pwConfirm))){
          System.out.println("true");
          JOptionPane.showMessageDialog(null, "New user registered.");
          registerDialog.setVisible(false);
      } else {
          System.out.println("false"); 
          //if username field is empty
          if(registerUnameTextField.getText().equals("enter username") ||
                  registerUnameTextField.getText().length() == 0) {
              JOptionPane.showMessageDialog(null, "Enter username!");
          }
          // if pw and pwConfirm is not matched
          else if(!pw.equals(pwConfirm)) {
              JOptionPane.showMessageDialog(null, "Password not matched!");
          }
          // if username or pw failed passing regex test
          else {
              JOptionPane.showMessageDialog(null, "Username: 3-35 characters.\n"
                      + "Password: 8-35 characters.");
          }     
      }
    }//GEN-LAST:event_registerButton2ActionPerformed

    private void loginGuestButttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginGuestButttonActionPerformed
        if(choice1.getSelectedItem().equals("Player 1")) {
            p1UserName.setText(("Guset 1"));
        } else {
            p2UserName.setText("Guest 2");
        }
    }//GEN-LAST:event_loginGuestButttonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // perform regex test on username and pw
        String username = usernameTextField.getText();
        String pw = "";

        // getPassword() returns char[]
        char[] ch = userPasswordField.getPassword();
        
        // append each char in char[] to string
        for(int i = 0; i < ch.length; ++i) 
           pw += ("" + ch[i]);

        // patterns
        String pattern = "^[a-zA-Z0-9]{3,35}$"; // username
        String pattern2 = "^[a-zA-Z0-9!@#$%^&*]{8,35}$"; // password

        // Create a Pattern object
        r = Pattern.compile(pattern);
        r2 = Pattern.compile(pattern2);
        
        // Now create matcher object.  
        m = r.matcher(username);
        m2 = r2.matcher(pw);
        
        // if username and pw failed to pass regex test
        // show error (chekc database later on)
         if(m.find() && m2.find()) {
              if(choice1.getSelectedItem().equals("Player 1"))
                  p1UserName.setText((usernameTextField.getText()));
              else if(choice1.getSelectedItem().equals("Player 2"))
                  p2UserName.setText(usernameTextField.getText());
         } else {
             JOptionPane.showMessageDialog(null,
                     "Incorrect username or password.");
         }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void usernameTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameTextFieldMouseClicked
        usernameTextField.setText("");
        usernameTextField.setForeground(Color.BLACK);
    }//GEN-LAST:event_usernameTextFieldMouseClicked

    private void registerUnameTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerUnameTextFieldMouseClicked
        registerUnameTextField.setText("");
        registerUnameTextField.setForeground(Color.BLACK);
    }//GEN-LAST:event_registerUnameTextFieldMouseClicked

    private void startGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startGameButtonActionPerformed
        if(p1UserName.getText().length() == 0 || 
                p2UserName.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Login please..");
        } else {
            Matrix_Calculator_UI screen = new Matrix_Calculator_UI();
            screen.setVisible(true);
        }
    }//GEN-LAST:event_startGameButtonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if(onePlayer == true) {
             choice1.add("Player 1");
             p2UserName.setText("Computer");
        }
        else{
             choice1.add("Player 1");
             choice1.add("Player 2");
             
        }
    }//GEN-LAST:event_formWindowActivated

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        choice1.removeAll();
    }//GEN-LAST:event_formWindowDeactivated

    // reset register field
    private void reset() {
        registerUnameTextField.setText("enter username");
        registerUnameTextField.setForeground(new Color(203,203,203));
        registerPWField.setText("root");
        registerConfirmPWField.setText("toor");
    }
    
    // check if 1P or 2P login
    public static void isOnePlayer(boolean b) {
        onePlayer = b;
    }
    
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
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choice1;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton loginGuestButtton;
    private javax.swing.JTextField p1UserName;
    private javax.swing.JTextField p2UserName;
    private javax.swing.JLabel player1ID;
    private javax.swing.JLabel player2ID;
    private javax.swing.JLabel pwLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JButton registerButton2;
    private javax.swing.JButton registerCancelButton;
    private javax.swing.JButton registerCheckIDButton;
    private javax.swing.JPasswordField registerConfirmPWField;
    private javax.swing.JLabel registerConfirmPWLabel;
    private javax.swing.JDialog registerDialog;
    private javax.swing.JPasswordField registerPWField;
    private javax.swing.JLabel registerPWLabel;
    private javax.swing.JTextField registerUnameTextField;
    private javax.swing.JLabel registerUsernameLabel;
    private javax.swing.JLabel returnLabel;
    private javax.swing.JLabel selectPlayerLabel;
    private javax.swing.JButton startGameButton;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JPasswordField userPasswordField;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
