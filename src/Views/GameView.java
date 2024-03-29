/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Session;
import Models.Settings;
import Utils.Constants;
import Utils.DateTimeUtil;
import Utils.FileUtil;
import Utils.Log;
import Utils.StringUtil;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Group 2
 */
public class GameView extends javax.swing.JFrame {

    private final Session session = Session.getInstance();

    /**
     * Creates new form InitView
     */
    public GameView() {
        initComponents();

        String[] savedUsers;

        savedUsers = FileUtil
                .getSubdirectories(
                        Session.getInstance().getGameDirectory());

        for (String user : savedUsers) {
            this.usernameComboBox.addItem(user);
        }

        this.newUserLabel.setVisible(false);
        this.returningUserLabel.setVisible(false);
        this.startGameButton.setVisible(false);
        this.usernameComboBox.setVisible(false);
        this.usernameEntry.setVisible(false);
        this.gameSetupView.setVisible(false);
        this.mapView.setVisible(false);
        this.inGameMenuView.setVisible(false);

        //Main Frame
        super.getContentPane().setBackground(Color.BLACK);
        this.titleLabel.setForeground(Color.LIGHT_GRAY);

        //Login view
        this.loginPanel.getContentPane().setBackground(Color.BLACK);
        this.newUserLabel.setForeground(Color.LIGHT_GRAY);
        this.returningUserLabel.setForeground(Color.LIGHT_GRAY);

        this.gameSetupView.getContentPane().setBackground(Color.BLACK);
        this.jLabel1.setForeground(Color.LIGHT_GRAY);
        this.jLabel2.setForeground(Color.LIGHT_GRAY);
        this.jLabel3.setForeground(Color.LIGHT_GRAY);
        this.jLabel4.setForeground(Color.LIGHT_GRAY);
        this.jLabel5.setForeground(Color.LIGHT_GRAY);
        this.jLabel6.setForeground(Color.LIGHT_GRAY);
        this.jLabel7.setForeground(Color.LIGHT_GRAY);
        this.newGameRadioButton.setForeground(Color.LIGHT_GRAY);
        this.lastSessionRadioButton.setForeground(Color.LIGHT_GRAY);

        this.mapView.getContentPane().setBackground(Color.BLACK);
        this.jLabel8.setForeground(Color.LIGHT_GRAY);
        this.jLabel10.setForeground(Color.LIGHT_GRAY);
        this.jLabel12.setForeground(Color.LIGHT_GRAY);
        this.attackLabel.setForeground(Color.LIGHT_GRAY);
        this.healthLabel.setForeground(Color.LIGHT_GRAY);
        this.defenseLabel.setForeground(Color.LIGHT_GRAY);

        this.inGameMenuView.getContentPane().setBackground(Color.BLACK);
        this.jLabel9.setForeground(Color.LIGHT_GRAY);
        this.jLabel11.setForeground(Color.LIGHT_GRAY);
        this.jLabel13.setForeground(Color.LIGHT_GRAY);
        this.jLabel14.setForeground(Color.LIGHT_GRAY);
        this.jLabel15.setForeground(Color.LIGHT_GRAY);
        this.jLabel16.setForeground(Color.LIGHT_GRAY);

        this.aboutView.setVisible(false);
        this.aboutView.getContentPane().setBackground(Color.BLACK);
        this.buildDate.setText(DateTimeUtil.getLocalDateTimeAsString());
        this.buildDate.setForeground(Color.LIGHT_GRAY);
        this.jLabel17.setForeground(Color.LIGHT_GRAY);
        this.jLabel21.setForeground(Color.LIGHT_GRAY);
        this.jLabel22.setForeground(Color.LIGHT_GRAY);
        this.jLabel24.setForeground(Color.LIGHT_GRAY);
        this.jLabel25.setForeground(Color.LIGHT_GRAY);
        this.jLabel26.setForeground(Color.LIGHT_GRAY);
        this.jLabel27.setForeground(Color.LIGHT_GRAY);
        this.jLabel28.setForeground(Color.LIGHT_GRAY);
        this.jLabel29.setForeground(Color.LIGHT_GRAY);
        this.jLabel30.setForeground(Color.LIGHT_GRAY);
        this.jLabel31.setForeground(Color.LIGHT_GRAY);
        this.jLabel32.setForeground(Color.LIGHT_GRAY);
    }

    /**
     * Message before quitting the game
     */
    private void quitWarningPopUp() {
        int response = JOptionPane.showConfirmDialog(this, "You are about to quit with out saving. Is this OK?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    /**
     * Updates all players statistics on the menus
     */
    public void UpdatePlayerStats() {
        this.currentPlayerEntry.setText(this.session.currentPlayer.getUsername());
        this.levelEntry.setText(Integer.toString(this.session.currentLevel));
        this.diffEntry.setText(this.session.currentMap.getLevelOfDificulty());
        this.invEntry.setText(StringUtil.join(this.session.currentPlayer.getInventoryDisplayNames()));
        this.highestLevelEntry.setText(Integer.toString(this.session.currentPlayer.getHighestLevel()));
        this.attackLabel.setText(Integer.toString(session.currentPlayer.getAttack()));
        this.defenseLabel.setText(Integer.toString(session.currentPlayer.getDefense()));
        this.healthLabel.setText(Integer.toString(session.currentPlayer.getHealth()));
        this.inGameUsernameField.setText(this.session.currentPlayer.getUsername());
        this.inGameCurrentMap.setText(Integer.toString(this.session.currentMap.getLevel()));
        this.inGameCurrentLevel.setText(Integer.toString(this.session.currentLevel));
        this.inGameCurrentInventory.setText(StringUtil.join(this.session.currentPlayer.getInventoryDisplayNames()));
        this.inGameLivesLeft.setText(Integer.toString(this.session.currentPlayer.getLives()));
        this.inGameHealthLevel.setValue(this.session.currentPlayer.getHealth());
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
        jLabel18 = new javax.swing.JLabel();
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
        jLabel19 = new javax.swing.JLabel();
        mapView = new javax.swing.JInternalFrame();
        jLabel8 = new javax.swing.JLabel();
        attackLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        defenseLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        healthLabel = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        gamePanel = new javax.swing.JLabel();
        inGameMenuView = new javax.swing.JInternalFrame();
        saveGameButton = new javax.swing.JButton();
        resumeButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        inGameUsernameField = new javax.swing.JTextField();
        inGameHealthLevel = new javax.swing.JProgressBar();
        inGameCurrentMap = new javax.swing.JTextField();
        inGameLivesLeft = new javax.swing.JTextField();
        inGameCurrentInventory = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        inGameCurrentLevel = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        aboutView = new javax.swing.JInternalFrame();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        buildDate = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        titleLabel.setFont(new java.awt.Font("Sitka Subheading", 1, 18)); // NOI18N
        titleLabel.setText("Best Dungeon Crawler");

        loginPanel.setBorder(null);
        loginPanel.setPreferredSize(new java.awt.Dimension(500, 500));
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
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        startGameButton.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        startGameButton.setText("Setup Game");
        startGameButton.setActionCommand("startGame");
        startGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameButtonActionPerformed(evt);
            }
        });

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LoginBackground.png"))); // NOI18N
        jLabel18.setText("jLabel18");

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel.getContentPane());
        loginPanel.getContentPane().setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(newUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(returningUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(returningUserLabel)
                            .addComponent(newUserLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameEntry)
                            .addComponent(usernameComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(startGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aboutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returningUserLabel))
                .addGap(18, 18, 18)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 245, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startGameButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aboutButton)
                .addContainerGap())
        );

        gameSetupView.setBorder(null);
        gameSetupView.setPreferredSize(new java.awt.Dimension(500, 500));
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
        currentPlayerEntry.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        currentPlayerEntry.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel4.setText("Current Level:");

        levelEntry.setFont(new java.awt.Font("Sitka Subheading", 0, 14)); // NOI18N
        levelEntry.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        levelEntry.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel5.setText("Level of Difficulty");

        diffEntry.setFont(new java.awt.Font("Sitka Subheading", 0, 14)); // NOI18N
        diffEntry.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        diffEntry.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel6.setText("Current Inventory:");

        invEntry.setFont(new java.awt.Font("Sitka Subheading", 0, 14)); // NOI18N
        invEntry.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        invEntry.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel7.setText("Highest Level Acheived:");

        highestLevelEntry.setFont(new java.awt.Font("Sitka Subheading", 0, 14)); // NOI18N
        highestLevelEntry.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        highestLevelEntry.setEnabled(false);

        jButton1.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jButton1.setText("Start Game");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LoginBackground.png"))); // NOI18N

        javax.swing.GroupLayout gameSetupViewLayout = new javax.swing.GroupLayout(gameSetupView.getContentPane());
        gameSetupView.getContentPane().setLayout(gameSetupViewLayout);
        gameSetupViewLayout.setHorizontalGroup(
            gameSetupViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameSetupViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gameSetupViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameSetupViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(gameSetupViewLayout.createSequentialGroup()
                            .addGroup(gameSetupViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4))
                            .addGap(18, 18, 18)
                            .addGroup(gameSetupViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(invEntry, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                                .addComponent(levelEntry, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(diffEntry, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(highestLevelEntry)))
                        .addComponent(jLabel1)
                        .addGroup(gameSetupViewLayout.createSequentialGroup()
                            .addGroup(gameSetupViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addGap(75, 75, 75)
                            .addGroup(gameSetupViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(gameSetupViewLayout.createSequentialGroup()
                                    .addComponent(newGameRadioButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(lastSessionRadioButton))
                                .addComponent(currentPlayerEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(17, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(343, 343, 343))
        );

        jLabel5.getAccessibleContext().setAccessibleName("Level of Difficulty:");

        mapView.setBorder(null);
        mapView.setPreferredSize(new java.awt.Dimension(500, 500));
        mapView.setVisible(true);

        jLabel8.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel8.setText("Attack: ");

        attackLabel.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        attackLabel.setText("0");

        jLabel10.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel10.setText("Defense: ");

        defenseLabel.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        defenseLabel.setText("0");

        jLabel12.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel12.setText("Health: ");

        healthLabel.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        healthLabel.setText("0");

        jButton2.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jButton2.setText("Menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        gamePanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MapBackground.png"))); // NOI18N

        javax.swing.GroupLayout mapViewLayout = new javax.swing.GroupLayout(mapView.getContentPane());
        mapView.getContentPane().setLayout(mapViewLayout);
        mapViewLayout.setHorizontalGroup(
            mapViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mapViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mapViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mapViewLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(attackLabel)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(defenseLabel)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(healthLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mapViewLayout.setVerticalGroup(
            mapViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mapViewLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(mapViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(attackLabel)
                    .addComponent(jLabel10)
                    .addComponent(defenseLabel)
                    .addComponent(jLabel12)
                    .addComponent(healthLabel)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 455, Short.MAX_VALUE)
                .addContainerGap())
        );

        inGameMenuView.setBorder(null);
        inGameMenuView.setVisible(true);

        saveGameButton.setFont(new java.awt.Font("Sitka Subheading", 1, 18)); // NOI18N
        saveGameButton.setText("Save Game");
        saveGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveGameButtonActionPerformed(evt);
            }
        });

        resumeButton.setFont(new java.awt.Font("Sitka Subheading", 1, 18)); // NOI18N
        resumeButton.setText("Resume");
        resumeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumeButtonActionPerformed(evt);
            }
        });

        quitButton.setFont(new java.awt.Font("Sitka Subheading", 1, 18)); // NOI18N
        quitButton.setText("Quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel9.setText("Username: ");

        jLabel11.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel11.setText("Current Map: ");

        jLabel13.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel13.setText("Lives Left: ");

        jLabel14.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel14.setText("Current Inventory: ");

        jLabel15.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel15.setText("Current Health Level:");

        inGameUsernameField.setEditable(false);
        inGameUsernameField.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N

        inGameHealthLevel.setPreferredSize(new java.awt.Dimension(146, 20));

        inGameCurrentMap.setEditable(false);
        inGameCurrentMap.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N

        inGameLivesLeft.setEditable(false);
        inGameLivesLeft.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N

        inGameCurrentInventory.setEditable(false);
        inGameCurrentInventory.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LoginBackground.png"))); // NOI18N

        inGameCurrentLevel.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        inGameCurrentLevel.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        inGameCurrentLevel.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel16.setText("Current Level:");

        javax.swing.GroupLayout inGameMenuViewLayout = new javax.swing.GroupLayout(inGameMenuView.getContentPane());
        inGameMenuView.getContentPane().setLayout(inGameMenuViewLayout);
        inGameMenuViewLayout.setHorizontalGroup(
            inGameMenuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inGameMenuViewLayout.createSequentialGroup()
                .addGroup(inGameMenuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(inGameMenuViewLayout.createSequentialGroup()
                        .addComponent(quitButton)
                        .addGap(18, 18, 18)
                        .addComponent(resumeButton)
                        .addGap(18, 18, 18)
                        .addComponent(saveGameButton))
                    .addGroup(inGameMenuViewLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(inGameMenuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 564, Short.MAX_VALUE)
                            .addGroup(inGameMenuViewLayout.createSequentialGroup()
                                .addGroup(inGameMenuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(inGameMenuViewLayout.createSequentialGroup()
                                        .addGroup(inGameMenuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel9))
                                        .addGap(65, 65, 65))
                                    .addGroup(inGameMenuViewLayout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, inGameMenuViewLayout.createSequentialGroup()
                                        .addGroup(inGameMenuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(inGameMenuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inGameHealthLevel, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                                    .addComponent(inGameCurrentInventory)
                                    .addComponent(inGameLivesLeft)
                                    .addComponent(inGameCurrentMap)
                                    .addComponent(inGameUsernameField)
                                    .addComponent(inGameCurrentLevel))))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        inGameMenuViewLayout.setVerticalGroup(
            inGameMenuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inGameMenuViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inGameMenuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(inGameUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inGameMenuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(inGameCurrentMap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inGameMenuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inGameCurrentLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inGameMenuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inGameLivesLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inGameMenuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(inGameCurrentInventory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inGameMenuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inGameHealthLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(inGameMenuViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveGameButton)
                    .addComponent(resumeButton)
                    .addComponent(quitButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        aboutView.setBorder(null);
        aboutView.setVisible(true);

        jLabel17.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel17.setText("Application:");

        jLabel21.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel21.setText("Best Dungeon Crawler");

        jLabel22.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel22.setText("Build Date: ");

        jLabel23.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N

        buildDate.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel24.setText("Developers: ");

        jLabel25.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel25.setText("Branch Hill, Matthew Buechler, Andrew Kent");

        jLabel26.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel26.setText("Controls: ");

        jLabel27.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel27.setText("W - Forward");

        jLabel28.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel28.setText("A - Left");

        jLabel29.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel29.setText("S - Backward");

        jLabel30.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel30.setText("D - Right");

        jLabel31.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel31.setText("B - Battle Enemy");

        jLabel32.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jLabel32.setText("Note: Click map to give focus before moving the player");

        jButton3.setFont(new java.awt.Font("Sitka Subheading", 1, 14)); // NOI18N
        jButton3.setText("Back");
        jButton3.setActionCommand("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout aboutViewLayout = new javax.swing.GroupLayout(aboutView.getContentPane());
        aboutView.getContentPane().setLayout(aboutViewLayout);
        aboutViewLayout.setHorizontalGroup(
            aboutViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aboutViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aboutViewLayout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(aboutViewLayout.createSequentialGroup()
                        .addGroup(aboutViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(aboutViewLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel21))
                            .addGroup(aboutViewLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(buildDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23))
                            .addGroup(aboutViewLayout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel25))
                            .addGroup(aboutViewLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(aboutViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel32)))
                            .addComponent(jLabel26))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        aboutViewLayout.setVerticalGroup(
            aboutViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aboutViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(aboutViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(buildDate))
                .addGap(18, 18, 18)
                .addGroup(aboutViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addGap(34, 34, 34)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addComponent(jLabel31)
                .addGap(18, 18, 18)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        jLabel32.getAccessibleContext().setAccessibleName("Note: Click map to give focus before moving the player");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aboutView)
                        .addContainerGap())
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleLabel)
                    .addComponent(inGameMenuView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(loginPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                        .addComponent(gameSetupView, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                        .addComponent(mapView, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gameSetupView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mapView, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(inGameMenuView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(aboutView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
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
                    return;
                }
            } else {
                try {
                    username = this.usernameComboBox.getSelectedItem().toString();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Invalid Username");
                    return;
                }
            }

            Log.debug(username);

            boolean init = session.initGame(username);
            this.currentPlayerEntry.setText(this.session.currentPlayer.getUsername());
            this.levelEntry.setText(Integer.toString(this.session.currentMap.getLevel()));
            this.diffEntry.setText(this.session.currentMap.getLevelOfDificulty());
            this.invEntry.setText(StringUtil.join(this.session.currentPlayer.getInventoryDisplayNames()));
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.gameSetupView.setVisible(false);
        this.mapView.setVisible(true);

        this.attackLabel.setText(Integer.toString(session.currentPlayer.getAttack()));
        this.defenseLabel.setText(Integer.toString(session.currentPlayer.getDefense()));
        this.healthLabel.setText(Integer.toString(session.currentPlayer.getHealth()));

        this.gamePanel.add(new MapView(this));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.inGameUsernameField.setText(this.session.currentPlayer.getUsername());
        this.inGameCurrentMap.setText(Integer.toString(this.session.currentMap.getLevel()));
        this.inGameCurrentInventory.setText(StringUtil.join(this.session.currentPlayer.getInventoryDisplayNames()));
        this.inGameCurrentLevel.setText(Integer.toString(this.session.currentLevel));
        this.inGameLivesLeft.setText(Integer.toString(this.session.currentPlayer.getLives()));
        this.inGameHealthLevel.setValue(this.session.currentPlayer.getHealth());

        this.mapView.setVisible(false);
        this.inGameMenuView.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void saveGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveGameButtonActionPerformed

        try {
            Settings.addOrUpdateSetting(this.session);
            JOptionPane.showMessageDialog(this, "Game saved successfully!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                    this, StringUtil.concat("Failed to save game: ", ex.getMessage()));
            Log.exception(ex);
        }
    }//GEN-LAST:event_saveGameButtonActionPerformed

    private void resumeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumeButtonActionPerformed
        this.inGameMenuView.setVisible(false);
        this.mapView.setVisible(true);
    }//GEN-LAST:event_resumeButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        int response = JOptionPane.showConfirmDialog(
                this, "Would you like to save the game before quitting?");

        switch (response) {
            case 0: {
                try {
                    Settings.addOrUpdateSetting(this.session);
                    JOptionPane.showMessageDialog(this, "Game saved successfully!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(
                            this, StringUtil.concat("Failed to save game: ", ex.getMessage()));
                    Log.exception(ex);
                }

                this.inGameMenuView.setVisible(false);
                this.loginPanel.setVisible(true);
                this.session.resetSession();
            }
            case 1: {
                this.inGameMenuView.setVisible(false);
                this.loginPanel.setVisible(true);
                this.session.resetSession();
            }
        }
    }//GEN-LAST:event_quitButtonActionPerformed

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        this.loginPanel.setVisible(false);
        this.aboutView.setVisible(true);
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.aboutView.setVisible(false);
        this.loginPanel.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     *
     * @param userName
     * @param level
     */
    public static void DisplayWinningMessage(String userName, int level) {

        if (level > 3) {
            return;
        }

        JOptionPane.showMessageDialog(
                null, StringUtil.concat("Congratulations ",
                        userName, "! You beat the level! "
                        + "You will advance to level ", Integer.toString(level)));
    }

    /**
     *
     * @param userName
     */
    public static void DisplayGameOver(String userName) {
        JOptionPane.showMessageDialog(
                null, StringUtil.concat("Congratulations ",
                        userName, "! You beat the game!"));
    }

    /**
     *
     */
    public static void DisplayNoKeyMessage() {
        JOptionPane.showMessageDialog(
                null, "You can't unlock the door until you find the key");
    }

    /**
     *
     */
    public static void DisplayHasKeyMessage() {
        JOptionPane.showMessageDialog(
                null, "You have gained access to the key!");
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

        Log.verbose("Initializing Application");

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameView().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JInternalFrame aboutView;
    private javax.swing.JLabel attackLabel;
    private javax.swing.JLabel buildDate;
    private javax.swing.JTextField currentPlayerEntry;
    private javax.swing.JLabel defenseLabel;
    private javax.swing.JTextField diffEntry;
    private javax.swing.JLabel gamePanel;
    private javax.swing.JInternalFrame gameSetupView;
    private javax.swing.JLabel healthLabel;
    private javax.swing.JTextField highestLevelEntry;
    private javax.swing.JTextField inGameCurrentInventory;
    private javax.swing.JTextField inGameCurrentLevel;
    private javax.swing.JTextField inGameCurrentMap;
    private javax.swing.JProgressBar inGameHealthLevel;
    private javax.swing.JTextField inGameLivesLeft;
    private javax.swing.JInternalFrame inGameMenuView;
    private javax.swing.JTextField inGameUsernameField;
    private javax.swing.JTextField invEntry;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton lastSessionRadioButton;
    private javax.swing.JTextField levelEntry;
    private javax.swing.JInternalFrame loginPanel;
    private javax.swing.JInternalFrame mapView;
    private javax.swing.JRadioButton newGameRadioButton;
    private javax.swing.JButton newUserButton;
    private javax.swing.JLabel newUserLabel;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton resumeButton;
    private javax.swing.JButton returningUserButton;
    private javax.swing.JLabel returningUserLabel;
    private javax.swing.JButton saveGameButton;
    private javax.swing.JButton startGameButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JComboBox<String> usernameComboBox;
    private javax.swing.JTextField usernameEntry;
    // End of variables declaration//GEN-END:variables
}
