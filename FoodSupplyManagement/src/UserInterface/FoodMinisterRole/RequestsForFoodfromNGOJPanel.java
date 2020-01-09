/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.FoodMinisterRole;

import Business.EcoSystem;
import Business.Email.Email;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.SupplierOrganization;
import Business.WorkQueue.FoodRequest;
import Business.WorkQueue.WorkRequest;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author
 */
public class RequestsForFoodfromNGOJPanel extends javax.swing.JPanel {

    /**
     *
     */
    private JPanel container;
    private EcoSystem system;
    private ArrayList<Network> network;

    public RequestsForFoodfromNGOJPanel(JPanel container, ArrayList<Network> network, EcoSystem system) {
        initComponents();
        this.container = container;
        this.system = system;
        this.network = network;
        FoodDetails.hide();
        emailBox.hide();

        btnGenerateBill.setEnabled(false);
        populateTable();

    }

    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblReqfromNGO.getModel();
        dtm.setRowCount(0);

        for (WorkRequest r : system.getWorkQueue().getWorkRequestList()) {
            if (r instanceof FoodRequest) {
                Object[] row = new Object[10];

                row[0] = r;
                row[1] = ((FoodRequest) r).getRequestId();
                row[2] = r.getFood();
                row[3] = r.getFood().getCode();
                row[4] = ((FoodRequest) r).getRequestQuantity();
                row[5] = r.getSender().getRole();
                row[6] = r.getSender();
                row[7] = r.getStatus();
                row[8] = r.getReceiver() == null ? null : r.getReceiver().getEmployee().getName();
                row[9] = r.getDayOfDelivery();

                dtm.addRow(row);

                //TableColumnModel tcm = tblReqfromNGO.getColumnModel();
                tblReqfromNGO.getColumnModel().getColumn(0).setMaxWidth(0);
                tblReqfromNGO.getColumnModel().getColumn(0).setWidth(0);
                tblReqfromNGO.getColumnModel().getColumn(0).setMinWidth(0);

            }
            txtMailAdd.setText(r.getSender().getEmployee().getEmailId());
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

        lblactivity = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        FoodDetails = new javax.swing.JInternalFrame();
        lblFoodName = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblQty = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblSender = new javax.swing.JLabel();
        lblReceiver = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblDateOfDelivery = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnGenerateBill = new javax.swing.JButton();
        btnSendMail = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReqfromNGO = new javax.swing.JTable();
        btnSendSupplier = new javax.swing.JButton();
        btnViewDet = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        emailBox = new javax.swing.JInternalFrame();
        txtMailAdd = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtMailSubject = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMailMessage = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        txtAttached = new javax.swing.JTextField();
        btnAttached = new javax.swing.JButton();
        btnSend = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblactivity.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        lblactivity.setText("Food Requests from NGO");
        add(lblactivity, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 320, 30));

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei", 1, 24)); // NOI18N
        jLabel6.setText("Activity:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 110, 40));

        FoodDetails.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        FoodDetails.setClosable(true);
        FoodDetails.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        FoodDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        FoodDetails.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        FoodDetails.setFocusCycleRoot(false);
        FoodDetails.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        FoodDetails.setName("FoodDetails"); // NOI18N
        FoodDetails.setOpaque(true);
        FoodDetails.setVisible(true);
        FoodDetails.getContentPane().setLayout(null);

        lblFoodName.setText("*Food");
        FoodDetails.getContentPane().add(lblFoodName);
        lblFoodName.setBounds(120, 50, 130, 16);

        lblCode.setText("*MCode");
        FoodDetails.getContentPane().add(lblCode);
        lblCode.setBounds(120, 80, 110, 16);

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel8.setText("Code");
        FoodDetails.getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 80, 40, 20);

        jLabel14.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel14.setText("Sender");
        FoodDetails.getContentPane().add(jLabel14);
        jLabel14.setBounds(350, 30, 50, 20);

        jLabel15.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel15.setText("Details");
        FoodDetails.getContentPane().add(jLabel15);
        jLabel15.setBounds(20, 10, 50, 20);

        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel11.setText("Quantity");
        FoodDetails.getContentPane().add(jLabel11);
        jLabel11.setBounds(30, 110, 60, 20);

        lblQty.setText("*qty");
        FoodDetails.getContentPane().add(lblQty);
        lblQty.setBounds(120, 110, 100, 16);

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel7.setText("Food");
        FoodDetails.getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 50, 40, 20);

        lblSender.setText("*sender");
        FoodDetails.getContentPane().add(lblSender);
        lblSender.setBounds(420, 30, 120, 16);

        lblReceiver.setText("*receiver");
        FoodDetails.getContentPane().add(lblReceiver);
        lblReceiver.setBounds(420, 90, 130, 16);

        jLabel10.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel10.setText("Receiver");
        FoodDetails.getContentPane().add(jLabel10);
        jLabel10.setBounds(340, 90, 60, 20);

        lblStatus.setText("*status");
        FoodDetails.getContentPane().add(lblStatus);
        lblStatus.setBounds(420, 60, 120, 16);

        lblDateOfDelivery.setText("*Date of delivery");
        FoodDetails.getContentPane().add(lblDateOfDelivery);
        lblDateOfDelivery.setBounds(420, 120, 130, 16);

        jLabel13.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel13.setText("Date of delivery");
        FoodDetails.getContentPane().add(jLabel13);
        jLabel13.setBounds(290, 120, 130, 20);

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel12.setText("Status");
        FoodDetails.getContentPane().add(jLabel12);
        jLabel12.setBounds(350, 60, 50, 20);

        btnGenerateBill.setBackground(new java.awt.Color(102, 102, 102));
        btnGenerateBill.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        btnGenerateBill.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerateBill.setText("Genarate bill");
        btnGenerateBill.setMaximumSize(new java.awt.Dimension(200, 200));
        btnGenerateBill.setMinimumSize(new java.awt.Dimension(200, 200));
        btnGenerateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateBillActionPerformed(evt);
            }
        });
        FoodDetails.getContentPane().add(btnGenerateBill);
        btnGenerateBill.setBounds(70, 160, 150, 30);

        btnSendMail.setBackground(new java.awt.Color(102, 102, 102));
        btnSendMail.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        btnSendMail.setForeground(new java.awt.Color(255, 255, 255));
        btnSendMail.setText("Send Email");
        btnSendMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMailActionPerformed(evt);
            }
        });
        FoodDetails.getContentPane().add(btnSendMail);
        btnSendMail.setBounds(330, 160, 150, 30);

        add(FoodDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 566, 240));

        tblReqfromNGO.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        tblReqfromNGO.setForeground(new java.awt.Color(102, 0, 102));
        tblReqfromNGO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "RequestID", "Food", "Code", "Quantity", "Role", "Sender", "Status", "Receiver", "Date of Delivery"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblReqfromNGO);
        if (tblReqfromNGO.getColumnModel().getColumnCount() > 0) {
            tblReqfromNGO.getColumnModel().getColumn(0).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 1250, 170));

        btnSendSupplier.setBackground(new java.awt.Color(102, 102, 102));
        btnSendSupplier.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        btnSendSupplier.setForeground(new java.awt.Color(255, 255, 255));
        btnSendSupplier.setText("Send to Suppliers ");
        btnSendSupplier.setMaximumSize(new java.awt.Dimension(200, 200));
        btnSendSupplier.setMinimumSize(new java.awt.Dimension(200, 200));
        btnSendSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendSupplierActionPerformed(evt);
            }
        });
        add(btnSendSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 200, 70));

        btnViewDet.setBackground(new java.awt.Color(102, 102, 102));
        btnViewDet.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        btnViewDet.setForeground(new java.awt.Color(255, 255, 255));
        btnViewDet.setText("View Detail");
        btnViewDet.setMaximumSize(new java.awt.Dimension(200, 200));
        btnViewDet.setMinimumSize(new java.awt.Dimension(200, 200));
        btnViewDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetActionPerformed(evt);
            }
        });
        add(btnViewDet, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 200, 40));

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
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 533, -1, 39));

        emailBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        emailBox.setClosable(true);
        emailBox.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        emailBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        emailBox.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        emailBox.setFocusCycleRoot(false);
        emailBox.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        emailBox.setName("emailBox"); // NOI18N
        emailBox.setOpaque(true);
        emailBox.setVisible(true);
        emailBox.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                emailBoxInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        emailBox.getContentPane().setLayout(null);

        txtMailAdd.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        txtMailAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        emailBox.getContentPane().add(txtMailAdd);
        txtMailAdd.setBounds(80, 10, 250, 30);

        jLabel16.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel16.setText("To:");
        emailBox.getContentPane().add(jLabel16);
        jLabel16.setBounds(40, 10, 40, 30);

        jLabel17.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel17.setText("Subject :");
        emailBox.getContentPane().add(jLabel17);
        jLabel17.setBounds(10, 60, 60, 20);

        txtMailSubject.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        txtMailSubject.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        emailBox.getContentPane().add(txtMailSubject);
        txtMailSubject.setBounds(80, 50, 250, 30);

        txtMailMessage.setColumns(20);
        txtMailMessage.setRows(5);
        txtMailMessage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(txtMailMessage);

        emailBox.getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(80, 90, 250, 120);

        jLabel18.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel18.setText("Message:");
        emailBox.getContentPane().add(jLabel18);
        jLabel18.setBounds(10, 100, 70, 20);

        txtAttached.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        txtAttached.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        emailBox.getContentPane().add(txtAttached);
        txtAttached.setBounds(80, 220, 250, 30);

        btnAttached.setBackground(new java.awt.Color(0, 153, 153));
        btnAttached.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnAttached.setForeground(new java.awt.Color(255, 255, 255));
        btnAttached.setText("Attache File");
        btnAttached.setMaximumSize(new java.awt.Dimension(200, 200));
        btnAttached.setMinimumSize(new java.awt.Dimension(200, 200));
        btnAttached.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttachedActionPerformed(evt);
            }
        });
        emailBox.getContentPane().add(btnAttached);
        btnAttached.setBounds(210, 260, 109, 25);

        btnSend.setBackground(new java.awt.Color(0, 153, 153));
        btnSend.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSend.setForeground(new java.awt.Color(255, 255, 255));
        btnSend.setText("Send ");
        btnSend.setMaximumSize(new java.awt.Dimension(200, 200));
        btnSend.setMinimumSize(new java.awt.Dimension(200, 200));
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });
        emailBox.getContentPane().add(btnSend);
        btnSend.setBounds(130, 300, 100, 25);

        add(emailBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 290, 350, 380));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendSupplierActionPerformed

// TODO add your handling code here:
        int selectedRow = tblReqfromNGO.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row ", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            FoodRequest req = (FoodRequest) tblReqfromNGO.getValueAt(selectedRow, 0);

            if (req.getStatus().equalsIgnoreCase("Requested")) {
                for (Network net : network) {
                    for (Enterprise e : net.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                            if (o instanceof SupplierOrganization) {
                                o.getWorkQueue().getWorkRequestList().add(req);
                                req.setStatus("Pending");
                                populateTable();

                            }
                        }
                    }
                }
                //JOptionPane.showMessageDialog(null, "Sent to Supplier");
            } else if (req.getStatus().equalsIgnoreCase("Pending")) {
                JOptionPane.showMessageDialog(null, "Supplier Notified. Waiting for Reply!!");
            } else if (req.getStatus().equalsIgnoreCase("Completed")) {
                JOptionPane.showMessageDialog(null, "Order Completed!!");
            }
        }

    }//GEN-LAST:event_btnSendSupplierActionPerformed

    public void populateLabels() {
        int selectedrow = tblReqfromNGO.getSelectedRow();
        if (selectedrow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row ", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            FoodDetails.show();
            FoodRequest food = (FoodRequest) tblReqfromNGO.getValueAt(selectedrow, 0);
            lblFoodName.setText(food.getFood().getName());
            lblCode.setText(food.getFood().getCode());

            lblQty.setText(String.valueOf(food.getRequestQuantity()));

            lblQty.setText(String.valueOf(food.getRequestQuantity()));

            DecimalFormat df = new DecimalFormat("#.00");

            lblSender.setText(food.getSender().getUsername());
            lblStatus.setText(food.getStatus());

            if (food.getStatus().equalsIgnoreCase("Requested")) {
                lblReceiver.setText("");
                lblDateOfDelivery.setText("");

            } else if (food.getStatus().equalsIgnoreCase("Pending")) {
                lblReceiver.setText("Notified");
                lblDateOfDelivery.setText("-");

            } else if (food.getStatus().equalsIgnoreCase("Completed")) {
                lblReceiver.setText(food.getReceiver().getEmployee().getName());
                lblDateOfDelivery.setText(food.getDayOfDelivery());
                btnGenerateBill.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Please select Food from Table ");
            }
        }

    }

    private void btnViewDetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetActionPerformed
        // TODO add your handling code here:
        populateLabels();

    }//GEN-LAST:event_btnViewDetActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnGenerateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateBillActionPerformed
        populateLabels();
        btnSendMail.setEnabled(true);
        try {
            // TODO add your handling code here:
            Document doc = new Document();
            try {
                int i = 0;
                PdfWriter.getInstance(doc, new FileOutputStream("Order_" + lblSender.getText() + ".pdf"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(RequestsForFoodfromNGOJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.open();
            Date d = new Date();
            DateFormat oDateFormat = new SimpleDateFormat("MM-dd-yyyy");
            String szDate = oDateFormat.format(d);

            doc.add(new Paragraph(("__________________________ Food _____________________________" + szDate)));
            doc.add(new Paragraph(lblSender.getText()));

            doc.add(new Paragraph(lblFoodName.getText() + "-                                                         " + lblCode.getText()));
            doc.add(new Paragraph("Quantity " + "                                                               " + lblQty.getText()));
            doc.add(new Paragraph("Date of delivery " + "                                                   " + lblDateOfDelivery.getText()));
            System.out.println("Document created");
            doc.close();

        } catch (DocumentException ex) {
            Logger.getLogger(RequestsForFoodfromNGOJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "Order_" + lblSender.getText() + ".pdf");

        } catch (Exception e) {
            System.out.println(e);
        }
        txtAttached.setText("Order_" + lblSender.getText() + ".pdf");


    }//GEN-LAST:event_btnGenerateBillActionPerformed

    private void btnSendMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMailActionPerformed
        // TODO add your handling code here:
        emailBox.show();
        btnSendMail.setEnabled(false);
        tblReqfromNGO.setEnabled(false);
        FoodDetails.setEnabled(false);
        btnViewDet.setEnabled(false);
        btnSendSupplier.setEnabled(false);
    }//GEN-LAST:event_btnSendMailActionPerformed

    private void btnAttachedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttachedActionPerformed
        // TODO add your handling code here:

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            txtAttached.setText(path);

        }
    }//GEN-LAST:event_btnAttachedActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        Email mail = new Email();
        mail.sendEmail(txtMailAdd.getText(), txtMailSubject.getText(), txtMailMessage.getText(), "savlogisticspvt@gmail.com", "savlogisticspvt", "finalyearproject19", txtAttached.getText());
        emailBox.hide();

        btnSendMail.setEnabled(true);
        tblReqfromNGO.setEnabled(true);
        FoodDetails.setEnabled(true);
        btnViewDet.setEnabled(true);
        btnSendSupplier.setEnabled(true);
        btnSendMail.setEnabled(false);

    }//GEN-LAST:event_btnSendActionPerformed

    private void emailBoxInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_emailBoxInternalFrameClosing
        // TODO add your handling code here:

        btnSendMail.setEnabled(true);
        tblReqfromNGO.setEnabled(true);
        FoodDetails.setEnabled(true);
        btnViewDet.setEnabled(true);
        btnSendSupplier.setEnabled(true);
        btnSendMail.setEnabled(true);

    }//GEN-LAST:event_emailBoxInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame FoodDetails;
    private javax.swing.JButton btnAttached;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnGenerateBill;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnSendMail;
    private javax.swing.JButton btnSendSupplier;
    private javax.swing.JButton btnViewDet;
    private javax.swing.JInternalFrame emailBox;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblDateOfDelivery;
    private javax.swing.JLabel lblFoodName;
    private javax.swing.JLabel lblQty;
    private javax.swing.JLabel lblReceiver;
    private javax.swing.JLabel lblSender;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblactivity;
    private javax.swing.JTable tblReqfromNGO;
    private javax.swing.JTextField txtAttached;
    private javax.swing.JTextField txtMailAdd;
    private javax.swing.JTextArea txtMailMessage;
    private javax.swing.JTextField txtMailSubject;
    // End of variables declaration//GEN-END:variables
}