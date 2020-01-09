/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SystemAdmin;

import Business.EcoSystem;
import Business.Network.Network;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author
 */
public class NetworkJPanel extends javax.swing.JPanel {

    /**
     * Creates new form NetworkJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem system;

    public NetworkJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;

        populateNetworkTable();
    }

    private void populateNetworkTable() {
        DefaultTableModel model = (DefaultTableModel) tblNetwork.getModel();
        model.setRowCount(0);

        for (Network network : system.getNetworkList()) {
            Object[] row = new Object[2];
            row[0] = network.getId();
            row[1] = network.getName();
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblNetwork = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtNetwork = new javax.swing.JTextField();
        btnCreateNetwork = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblCustomername1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 102));
        setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblNetwork.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        tblNetwork.setForeground(new java.awt.Color(102, 0, 102));
        tblNetwork.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Network Id", "Network"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblNetwork);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 520, 140));

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel5.setText("Network");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 370, 70, -1));

        txtNetwork.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        txtNetwork.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNetwork.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNetworkKeyPressed(evt);
            }
        });
        add(txtNetwork, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 370, 244, 30));

        btnCreateNetwork.setBackground(new java.awt.Color(102, 102, 102));
        btnCreateNetwork.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        btnCreateNetwork.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateNetwork.setText("Create Network");
        btnCreateNetwork.setMaximumSize(new java.awt.Dimension(200, 200));
        btnCreateNetwork.setMinimumSize(new java.awt.Dimension(200, 200));
        btnCreateNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNetworkActionPerformed(evt);
            }
        });
        add(btnCreateNetwork, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 460, 223, 40));

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei", 1, 24)); // NOI18N
        jLabel6.setText("Activity:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, 120, 30));

        lblCustomername1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        lblCustomername1.setText("Network");
        add(lblCustomername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 110, 30));

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
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 460, -1, 39));
    }// </editor-fold>//GEN-END:initComponents


    private void btnCreateNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNetworkActionPerformed
        // TODO add your handling code here:
        String name = txtNetwork.getText();
        if (!name.equals("")) {
            Network network = system.createAndAddNetwork();
            network.setName(name);

            populateNetworkTable();
        } else {
            JOptionPane.showMessageDialog(null, "Enter value", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnCreateNetworkActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkAreaJPanel swjp = (SystemAdminWorkAreaJPanel) component;
        swjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtNetworkKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNetworkKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if ((key >= evt.VK_0 && key <= evt.VK_9) || (key >= evt.VK_NUMPAD0 && key <= evt.VK_NUMPAD9)) {
            txtNetwork.setEditable(false);
            txtNetwork.setBackground(Color.red);
        } else {
            txtNetwork.setEditable(true);
            txtNetwork.setBackground(Color.WHITE);
        }


    }//GEN-LAST:event_txtNetworkKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateNetwork;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCustomername1;
    private javax.swing.JTable tblNetwork;
    private javax.swing.JTextField txtNetwork;
    // End of variables declaration//GEN-END:variables
}
