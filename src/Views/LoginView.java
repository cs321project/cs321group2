/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Session;
import Utils.Constants;
import Utils.Log;
import Utils.StringUtil;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author Group 2
 */
public class LoginView extends javax.swing.JFrame {

    private final Session session = Session.getInstance();

    /**
     * Creates new form InitView
     */
    public LoginView() {
        initComponents();

        this.newUserLabel.setVisible(false);
        this.returningUserLabel.setVisible(false);
        this.startGameButton.setVisible(false);
        this.usernameComboBox.setVisible(false);
        this.usernameEntry.setVisible(false);
        this.gameSetupView.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        loginPanel = new javax.swing.JInternalFrame();
        newUserButton = new javax.swing.JButton();
        returningUserButton = new javax.swing.JButton();
        usernameEntry = new javax.swing.JTextField();
        newUserLabel = new javax.swing.JLabel();
        returningUserLabel = new javax.swing.JLabel();
        usernameComboBox = new javax.swing.JComboBox<>();
        aboutButton = new javax.swing.JButton();
        startGameButton = new javax.swing.JButton();
        gameSetupView = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        newGameRadioButton = new javax.swing.JRadioButton();
        lastSessionRadioButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        currentPlayerEntry = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        levelEntry = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        diffEntry = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        invEntry = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        highestLevelEntry = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(550, 550));

        titleLabel.setFont(new java.awt.Font("Sitka Subheading", 1, 18)); // NOI18N
        titleLabel.setText("Best Dungeon Crawler");

        loginPanel.setVisible(true);

        newUserButton.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        newUserButton.setText("New User ");
        newUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newUserButtonActionPerformed(evt);
            }
        });

        returningUserButton.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        returningUserButton.setText("Returning User");
        returningUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returningUserButtonActionPerformed(evt);
            }
        });

        usernameEntry.setFont(new java.awt.Font("Sitka Subheading", 0, 14)); // NOI18N

        newUserLabel.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        newUserLabel.setText("Username:");

        returningUserLabel.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        returningUserLabel.setText("Username:");

        usernameComboBox.setFont(new java.awt.Font("Sitka Subheading", 0, 14)); // NOI18N

        aboutButton.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        aboutButton.setText("About");

        startGameButton.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        startGameButton.setText("Setup Game");
        startGameButton.setActionCommand("startGame");
        startGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel.getContentPane());
        loginPanel.getContentPane().setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addComponent(returningUserLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                        .addComponent(newUserLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameEntry))
                    .addComponent(newUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aboutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(returningUserButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
                .addContainerGap())
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newUserButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(returningUserButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newUserLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(returningUserLabel)
                    .addComponent(usernameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(startGameButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aboutButton)
                .addContainerGap())
        );

        gameSetupView.setVisible(true);

        jLabel1.setFont(new java.awt.Font("Sitka Subheading", 1, 18)); // NOI18N
        jLabel1.setText("Game Setup");

        jLabel2.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel2.setText("Choose Game:");

        newGameRadioButton.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        newGameRadioButton.setText("New Game");
        newGameRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameRadioButtonActionPerformed(evt);
            }
        });

        lastSessionRadioButton.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        lastSessionRadioButton.setText("Continue Last Session");
        lastSessionRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastSessionRadioButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel3.setText("Current Player:");

        currentPlayerEntry.setFont(new java.awt.Font("Sitka Subheading", 0, 14)); // NOI18N
        currentPlayerEntry.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel4.setText("Current Level/Map:");

        levelEntry.setFont(new java.awt.Font("Sitka Subheading", 0, 14)); // NOI18N
        levelEntry.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel5.setText("Level of Difficulty");

        diffEntry.setFont(new java.awt.Font("Sitka Subheading", 0, 14)); // NOI18N
        diffEntry.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel6.setText("Current Inventory:");

        invEntry.setFont(new java.awt.Font("Sitka Subheading", 0, 14)); // NOI18N
        invEntry.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel7.setText("Highest Level Acheived:");

        highestLevelEntry.setFont(new java.awt.Font("Sitka Subheading", 0, 14)); // NOI18N
        highestLevelEntry.setEnabled(false);

        jButton1.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jButton1.setText("Start Game");

        javax.swing.GroupLayout gameSetupViewLayout = new javax.swing.GroupLayout(gameSetupView.getContentPane());
        gameSetupView.getContentPane().setLayout(gameSetupViewLayout);
        gameSetupViewLayout.setHorizontalGroup(
            gameSetupViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameSetupViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gameSetupViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gameSetupViewLayout.createSequentialGroup()
                        .addGroup(gameSetupViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(gameSetupViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(highestLevelEntry)
                            .addComponent(invEntry)
                            .addComponent(diffEntry)
                            .addComponent(levelEntry)))
                    .addGroup(gameSetupViewLayout.createSequentialGroup()
                        .addGroup(gameSetupViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(75, 75, 75)
                        .addGroup(gameSetupViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gameSetupViewLayout.createSequentialGroup()
                                .addComponent(newGameRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addComponent(lastSessionRadioButton)
                                .addGap(10, 10, 10))
                            .addComponent(currentPlayerEntry)))
                    .addGroup(gameSetupViewLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        gameSetupViewLayout.setVerticalGroup(
            gameSetupViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameSetupViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gameSetupViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(newGameRadioButton)
                    .addComponent(lastSessionRadioButton))
                .addGap(25, 25, 25)
                .addGroup(gameSetupViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(currentPlayerEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(gameSetupViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(levelEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(gameSetupViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(diffEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(gameSetupViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(invEntry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(gameSetupViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(highestLevelEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jLabel5.getAccessibleContext().setAccessibleName("Level of Difficulty:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(gameSetupView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(titleLabel)
                    .addComponent(jSeparator1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gameSetupView)
                    .addComponent(loginPanel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newUserButtonActionPerformed
        session.isNewUser = true;
        this.newUserLabel.setVisible(true);
        this.usernameEntry.setVisible(true);
        this.returningUserLabel.setVisible(false);
        this.usernameComboBox.setVisible(false);
        this.startGameButton.setVisible(true);
    }//GEN-LAST:event_newUserButtonActionPerformed

    private void returningUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returningUserButtonActionPerformed
        session.isNewUser = false;
        this.newUserLabel.setVisible(false);
        this.usernameEntry.setVisible(false);
        this.returningUserLabel.setVisible(true);
        this.usernameComboBox.setVisible(true);
        this.startGameButton.setVisible(true);
    }//GEN-LAST:event_returningUserButtonActionPerformed

    private void startGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startGameButtonActionPerformed
        try {
            String username = Constants.EMPTY_STRING;

            if (session.isNewUser) {
                username = this.usernameEntry.getText().trim();

                if (username == null ? Constants.EMPTY_STRING == null : username.equals(Constants.EMPTY_STRING)) {
                    JOptionPane.showMessageDialog(this, "Invalid Username");
                }
            } else {

            }

            boolean init = session.initGame(username);
            this.currentPlayerEntry.setText(this.session.currentPlayer.getUsername());
            this.levelEntry.setText(Integer.toString(this.session.currentMap.getLevel()));
            this.diffEntry.setText(this.session.currentMap.getLevelOfDificulty());
            this.invEntry.setText(StringUtil.join(this.session.currentPlayer.getInventoryIDs()));
            this.highestLevelEntry.setText(Integer.toString(this.session.currentPlayer.getHighestLevel()));
            this.loginPanel.setVisible(false);
            this.gameSetupView.setVisible(true);

            if (session.isNewUser) {
                this.newGameRadioButton.setSelected(true);
                this.lastSessionRadioButton.setEnabled(false);
                this.newGameRadioButton.setEnabled(false);
            } else {
                this.lastSessionRadioButton.setSelected(true);
            }
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_startGameButtonActionPerformed

    private void newGameRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameRadioButtonActionPerformed
        if (!session.isNewUser) {
            this.lastSessionRadioButton.setSelected(!this.newGameRadioButton.isSelected());
        }
    }//GEN-LAST:event_newGameRadioButtonActionPerformed

    private void lastSessionRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastSessionRadioButtonActionPerformed
        if (!session.isNewUser) {
            this.newGameRadioButton.setSelected(!this.lastSessionRadioButton.isSelected());
        }
    }//GEN-LAST:event_lastSessionRadioButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        Log.verbose("Initializing Application");

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JTextField currentPlayerEntry;
    private javax.swing.JTextField diffEntry;
    private javax.swing.JInternalFrame gameSetupView;
    private javax.swing.JTextField highestLevelEntry;
    private javax.swing.JTextField invEntry;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton lastSessionRadioButton;
    private javax.swing.JTextField levelEntry;
    private javax.swing.JInternalFrame loginPanel;
    private javax.swing.JRadioButton newGameRadioButton;
    private javax.swing.JButton newUserButton;
    private javax.swing.JLabel newUserLabel;
    private javax.swing.JButton returningUserButton;
    private javax.swing.JLabel returningUserLabel;
    private javax.swing.JButton startGameButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JComboBox<String> usernameComboBox;
    private javax.swing.JTextField usernameEntry;
    // End of variables declaration//GEN-END:variables
}
