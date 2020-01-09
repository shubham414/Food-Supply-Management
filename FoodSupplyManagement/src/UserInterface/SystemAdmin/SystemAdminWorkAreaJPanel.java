/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SystemAdmin;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author 
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    public SystemAdminWorkAreaJPanel(JPanel userProcessContainer, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business= business; 
        populateTree();
    }

    
     public void populateTree() {
        DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
        ArrayList<Network> networkList = business.getNetworkList();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> organizationList;

        Network network;
        Enterprise enterprise;
        Organization organization;

        DefaultMutableTreeNode networks = new DefaultMutableTreeNode("Network");
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        root.removeAllChildren();
        root.insert(networks, 0);

        DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;

        for (int i = 0; i < networkList.size(); i++) {
            network = networkList.get(i);
            networkNode = new DefaultMutableTreeNode(network.getName());
            networks.insert(networkNode, i);

            enterpriseList = network.getEnterpriseDirectory().getEnterpriseList();
            for (int j = 0; j < enterpriseList.size(); j++) {
                enterprise = enterpriseList.get(j);
                enterpriseNode = new DefaultMutableTreeNode(enterprise.getName());
                networkNode.insert(enterpriseNode, j);

                organizationList = enterprise.getOrganizationDirectory().getOrganizationList();
                for (int k = 0; k < organizationList.size(); k++) {
                    organization = organizationList.get(k);
                    organizationNode = new DefaultMutableTreeNode(organization.getName());
                    enterpriseNode.insert(organizationNode, k);

                }
            }
        }
        model.reload();

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        btnMngEnterpriseAdmin = new javax.swing.JButton();
        btnMngEnterprise = new javax.swing.JButton();
        btnMngNetwork = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblCustomername2 = new javax.swing.JLabel();
        selectedNodeLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(100);

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMngEnterpriseAdmin.setBackground(new java.awt.Color(102, 102, 102));
        btnMngEnterpriseAdmin.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        btnMngEnterpriseAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnMngEnterpriseAdmin.setText("Manage Enterprise Admin");
        btnMngEnterpriseAdmin.setMaximumSize(new java.awt.Dimension(200, 200));
        btnMngEnterpriseAdmin.setMinimumSize(new java.awt.Dimension(200, 200));
        btnMngEnterpriseAdmin.setOpaque(false);
        btnMngEnterpriseAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMngEnterpriseAdminActionPerformed(evt);
            }
        });
        jPanel1.add(btnMngEnterpriseAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, 244, 50));

        btnMngEnterprise.setBackground(new java.awt.Color(102, 102, 102));
        btnMngEnterprise.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        btnMngEnterprise.setForeground(new java.awt.Color(255, 255, 255));
        btnMngEnterprise.setText("Manage Enterprise");
        btnMngEnterprise.setMaximumSize(new java.awt.Dimension(200, 200));
        btnMngEnterprise.setMinimumSize(new java.awt.Dimension(200, 200));
        btnMngEnterprise.setOpaque(false);
        btnMngEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMngEnterpriseActionPerformed(evt);
            }
        });
        jPanel1.add(btnMngEnterprise, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 410, 244, 50));

        btnMngNetwork.setBackground(new java.awt.Color(102, 102, 102));
        btnMngNetwork.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        btnMngNetwork.setForeground(new java.awt.Color(255, 255, 255));
        btnMngNetwork.setText("Manage Network");
        btnMngNetwork.setMaximumSize(new java.awt.Dimension(200, 200));
        btnMngNetwork.setMinimumSize(new java.awt.Dimension(200, 200));
        btnMngNetwork.setOpaque(false);
        btnMngNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMngNetworkActionPerformed(evt);
            }
        });
        jPanel1.add(btnMngNetwork, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 340, 244, 50));

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        jLabel7.setText("Selected Node :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 180, -1));

        lblCustomername2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        lblCustomername2.setText("System Admin");
        jPanel1.add(lblCustomername2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, 190, -1));

        selectedNodeLabel.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        selectedNodeLabel.setText("*Selected Node");
        jPanel1.add(selectedNodeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, 190, -1));

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei", 1, 24)); // NOI18N
        jLabel6.setText("Activity:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 110, 30));

        jSplitPane1.setRightComponent(jPanel1);

        jTree.setBackground(new java.awt.Color(255, 204, 102));
        jTree.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("System");
        jTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeValue(evt);
            }
        });
        jScrollPane1.setViewportView(jTree);

        jSplitPane1.setLeftComponent(jScrollPane1);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMngEnterpriseAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMngEnterpriseAdminActionPerformed
        // TODO add your handling code here:
        EnterpriseAdminJPanel enterpriseAdminJPanel = new EnterpriseAdminJPanel(userProcessContainer,business);
        userProcessContainer.add("Enterprise Admin JPanel", enterpriseAdminJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnMngEnterpriseAdminActionPerformed

    private void btnMngEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMngEnterpriseActionPerformed
        // TODO add your handling code here:
        ManageEnterpriseJPanel manageEnterpriseJPanel = new ManageEnterpriseJPanel(userProcessContainer,business);
        userProcessContainer.add("Manage Enterprise JPanel", manageEnterpriseJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnMngEnterpriseActionPerformed

    private void btnMngNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMngNetworkActionPerformed
        // TODO add your handling code here:
        NetworkJPanel networkJPanel = new NetworkJPanel(userProcessContainer,business);
        userProcessContainer.add("network JPanel", networkJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnMngNetworkActionPerformed

    private void treeValue(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeValue
        // TODO add your handling code here:
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();
        if (selectedNode != null) {
            selectedNodeLabel.setText(selectedNode.toString());
        }

    }//GEN-LAST:event_treeValue

    private void jTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {                                   
        // TODO add your handling code here:
    }                                  


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMngEnterprise;
    private javax.swing.JButton btnMngEnterpriseAdmin;
    private javax.swing.JButton btnMngNetwork;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTree jTree;
    private javax.swing.JLabel lblCustomername2;
    private javax.swing.JLabel selectedNodeLabel;
    // End of variables declaration//GEN-END:variables
}