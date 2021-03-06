/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.NGOAdmin;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author
 */
public class NGOManageUserAccountJPanel extends javax.swing.JPanel {

    private JPanel container;
    private Enterprise enterprise;

    public NGOManageUserAccountJPanel(JPanel container, Enterprise enterprise) {
        initComponents();
        this.enterprise = enterprise;
        this.container = container;

        popOrganizationComboBox();
        popData();
    }

    public void popOrganizationComboBox() {
        jcbOrg.removeAllItems();

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            jcbOrg.addItem(organization);
        }
    }

    public void populateEmployeeComboBox(Organization organization) {
        jcbOrgEmp.removeAllItems();

        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
            jcbOrgEmp.addItem(employee);
        }
    }

    private void populateRoleComboBox(Organization o) {
        jcbRole.removeAllItems();
        for (Role role : o.getSupportedRole()) {
            jcbRole.addItem(role);
        }
    }

    public void popData() {

        DefaultTableModel model = (DefaultTableModel) tblNetwork.getModel();

        model.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                Object row[] = new Object[2];
                row[0] = ua;
                row[1] = ua.getRole();
                ((DefaultTableModel) tblNetwork.getModel()).addRow(row);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcbRole = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblCustomername1 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNetwork = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        btnCreateNetwork = new javax.swing.JButton();
        jcbOrg = new javax.swing.JComboBox();
        btnBack = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jcbOrgEmp = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jcbRole.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jcbRole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jcbRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 430, 208, 29));

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei", 1, 24)); // NOI18N
        jLabel6.setText("Activity:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 110, 120, -1));

        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel11.setText("Role");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 430, 60, -1));

        lblCustomername1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        lblCustomername1.setText("User Account");
        add(lblCustomername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 110, 170, -1));

        txtPassword.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 510, 207, 27));

        tblNetwork.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        tblNetwork.setForeground(new java.awt.Color(102, 0, 102));
        tblNetwork.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "User Name", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblNetwork);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, 520, 130));

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel12.setText("Password");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 510, 80, -1));

        btnCreateNetwork.setBackground(new java.awt.Color(102, 102, 102));
        btnCreateNetwork.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        btnCreateNetwork.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateNetwork.setText("Create User Account");
        btnCreateNetwork.setMaximumSize(new java.awt.Dimension(200, 200));
        btnCreateNetwork.setMinimumSize(new java.awt.Dimension(200, 200));
        btnCreateNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNetworkActionPerformed(evt);
            }
        });
        add(btnCreateNetwork, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 580, 223, 39));

        jcbOrg.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jcbOrg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbOrgActionPerformed(evt);
            }
        });
        add(jcbOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 350, 208, 29));

        btnBack.setBackground(new java.awt.Color(102, 102, 102));
        btnBack.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("<<");
        btnBack.setMaximumSize(new java.awt.Dimension(200, 200));
        btnBack.setMinimumSize(new java.awt.Dimension(200, 200));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 580, -1, 39));

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel8.setText("Organization");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 360, 100, -1));

        txtUserName.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        txtUserName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserNameKeyPressed(evt);
            }
        });
        add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 470, 207, 27));

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel9.setText("UserName");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 470, 80, -1));

        jcbOrgEmp.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jcbOrgEmp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jcbOrgEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 390, 208, 29));

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel10.setText("Employee");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 390, 80, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNetworkActionPerformed
        // TODO add your handling code here:
        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        if (!((userName.equals("") || (password.equals(""))))) {
            if (EcoSystem.checkIfUsernameIsUnique(userName)) {
                Organization organization = (Organization) jcbOrg.getSelectedItem();
                Employee employee = (Employee) jcbOrgEmp.getSelectedItem();
                Role role = (Role) jcbRole.getSelectedItem();

                organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role);

                popData();
            } else {
                JOptionPane.showMessageDialog(null, "Please enter unique username", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter value", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCreateNetworkActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtUserNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameKeyPressed

    private void jcbOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbOrgActionPerformed
        // TODO add your handling code here:
        Organization org = (Organization) jcbOrg.getSelectedItem();
        if (org != null) {
            populateEmployeeComboBox(org);
            populateRoleComboBox(org);
        }

    }//GEN-LAST:event_jcbOrgActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateNetwork;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcbOrg;
    private javax.swing.JComboBox jcbOrgEmp;
    private javax.swing.JComboBox jcbRole;
    private javax.swing.JLabel lblCustomername1;
    private javax.swing.JTable tblNetwork;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
