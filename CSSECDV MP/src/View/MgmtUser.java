/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static Controller.Main.getSHA;
import static Controller.Main.toHexString;
import Controller.SQLite;
import Model.User;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author beepxD
 */
public class MgmtUser extends javax.swing.JPanel {

    public SQLite sqlite;
    public DefaultTableModel tableModel;
    
    private User active;
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.SSS"); 
    
    private ArrayList<User> users;
    
    public MgmtUser(SQLite sqlite) {
        initComponents();
        this.sqlite = sqlite;
        tableModel = (DefaultTableModel)table.getModel();
        table.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
        
//        UNCOMMENT TO DISABLE BUTTONS
//        editBtn.setVisible(false);
//        deleteBtn.setVisible(false);
//        lockBtn.setVisible(false);
//        chgpassBtn.setVisible(false);
    }
    
    public void init(){
        //      CLEAR TABLE
        for(int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--){
            tableModel.removeRow(0);
        }
        
//      LOAD CONTENTS
        ArrayList<User> users = sqlite.getUsers();
        for(int nCtr = 0; nCtr < users.size(); nCtr++){
            tableModel.addRow(new Object[]{
                users.get(nCtr).getUsername(), 
                users.get(nCtr).getPassword(), 
                users.get(nCtr).getRole(), 
                users.get(nCtr).getLocked()});
        }
    }

    public void designer(JTextField component, String text){
        component.setSize(70, 600);
        component.setFont(new java.awt.Font("Tahoma", 0, 18));
        component.setBackground(new java.awt.Color(240, 240, 240));
        component.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        component.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), text, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12)));
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
        table = new javax.swing.JTable();
        editRoleBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        lockBtn = new javax.swing.JButton();
        chgpassBtn = new javax.swing.JButton();

        table.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Username", "Password", "Role", "Locked"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(24);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(160);
            table.getColumnModel().getColumn(1).setPreferredWidth(400);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        editRoleBtn.setBackground(new java.awt.Color(255, 255, 255));
        editRoleBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editRoleBtn.setText("EDIT ROLE");
        editRoleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRoleBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(255, 255, 255));
        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        lockBtn.setBackground(new java.awt.Color(255, 255, 255));
        lockBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lockBtn.setText("LOCK/UNLOCK");
        lockBtn.setToolTipText("");
        lockBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lockBtnActionPerformed(evt);
            }
        });

        chgpassBtn.setBackground(new java.awt.Color(255, 255, 255));
        chgpassBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chgpassBtn.setText("CHANGE PASS");
        chgpassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chgpassBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editRoleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(lockBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(chgpassBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chgpassBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editRoleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lockBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editRoleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRoleBtnActionPerformed
        if(table.getSelectedRow() >= 0){
            int currentRole = Integer.parseInt(tableModel.getValueAt(table.getSelectedRow(), 2).toString());
            
            // Check if chosen user role is admin
            if(currentRole == 5) {
                    String error_admin = "Error: Cannot change admin role";
                    System.out.println(error_admin);
                    JOptionPane.showMessageDialog(null, error_admin, "Popup Message", JOptionPane.PLAIN_MESSAGE);
            }
            
            else {
                String[] options = {"1-DISABLED", "2-CLIENT", "3-STAFF", "4-MANAGER", "5-ADMIN"};
                JComboBox optionList = new JComboBox(options);

                optionList.setSelectedIndex((int) tableModel.getValueAt(table.getSelectedRow(), 2) - 1);

                String result = (String) JOptionPane.showInputDialog(null, "USER: " + tableModel.getValueAt(table.getSelectedRow(), 0),
                        "EDIT USER ROLE", JOptionPane.QUESTION_MESSAGE, null, options, options[(int) tableModel.getValueAt(table.getSelectedRow(), 2) - 1]);

                if (result != null) {
                    System.out.println(tableModel.getValueAt(table.getSelectedRow(), 0));
                    System.out.println(result.charAt(0));
                    int r = Character.getNumericValue(result.charAt(0));
                    sqlite.updateRole(r, String.valueOf(tableModel.getValueAt(table.getSelectedRow(), 0)));
                    this.init();
                }
            }
        }
    }//GEN-LAST:event_editRoleBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if(table.getSelectedRow() >= 0){
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + tableModel.getValueAt(table.getSelectedRow(), 0) + "?", "DELETE USER", JOptionPane.YES_NO_OPTION);
            
            if (result == JOptionPane.YES_OPTION) {
                System.out.println(tableModel.getValueAt(table.getSelectedRow(), 0));
                sqlite.removeUser(tableModel.getValueAt(table.getSelectedRow(), 0).toString());
                LocalDateTime now = LocalDateTime.now();
                sqlite.addLogs("NOTICE", this.active.getUsername(), "Edited product details", dtf.format(now));
                this.init();
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void lockBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lockBtnActionPerformed
        if(table.getSelectedRow() >= 0){
            int state = 1;
            String s = "lock";
            if("1".equals(tableModel.getValueAt(table.getSelectedRow(), 3) + "")){
                state = 0;
                s = "unclock";
            }
            
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to " + s + " " + tableModel.getValueAt(table.getSelectedRow(), 0) + "?", "DELETE USER", JOptionPane.YES_NO_OPTION);
            
            if (result == JOptionPane.YES_OPTION) {
                System.out.println(tableModel.getValueAt(table.getSelectedRow(), 0));
                sqlite.updateLocked(state, String.valueOf(tableModel.getValueAt(table.getSelectedRow(), 0)));
                
                // If user is unlocked (and was disabled) change back role to default. (Must manually be changed back to original role by the admin, if role is not the default role)
                if(state == 0) { 
                    sqlite.updateRole(2, String.valueOf(tableModel.getValueAt(table.getSelectedRow(), 0)));
                }
                // If locked, change user role to disabled
                else {
                    sqlite.updateRole(1, String.valueOf(tableModel.getValueAt(table.getSelectedRow(), 0)));
                }
                
                this.init();
            }
        }
    }//GEN-LAST:event_lockBtnActionPerformed

    private void chgpassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chgpassBtnActionPerformed
        if(table.getSelectedRow() >= 0){
            JTextField password = new JPasswordField();
            JTextField confpass = new JPasswordField();
            designer(password, "PASSWORD");
            designer(confpass, "CONFIRM PASSWORD");
            
            Object[] message = {
                "Enter New Password:", password, confpass
            };

            int result = JOptionPane.showConfirmDialog(null, message, "CHANGE PASSWORD", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
            
            if (result == JOptionPane.OK_OPTION) {
                
                if(password.getText().equals(confpass.getText())) {
                    System.out.println(password.getText());
                    System.out.println(confpass.getText());
                    System.out.println(tableModel.getValueAt(table.getSelectedRow(), 0));
                    String new_password;
                    try {
                        new_password = toHexString(getSHA(password.getText()));
                        sqlite.updatePassword(new_password, String.valueOf(tableModel.getValueAt(table.getSelectedRow(), 0)));
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(MgmtUser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.init();
                }
                
                else {
                    String message_error = "Error: Password does not match.";
                    JOptionPane.showMessageDialog(null, message_error, "Popup Message", JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_chgpassBtnActionPerformed

    public void setActiveUser(User user)
    {
        this.active = user;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chgpassBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editRoleBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lockBtn;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
