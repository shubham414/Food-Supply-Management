/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.NGOVolunteer;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Food.Food;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FoodRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.CommonLoginPage.CallQualityCheckerJPanel;
import UserInterface.CommonLoginPage.RequestForFoodJPanel;

import java.awt.CardLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author
 */
public class NGOVolunteerJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    private JPanel container;
    private Organization organization;
    private Enterprise enterprise;
    private UserAccount ua;
    private EcoSystem system;
    private ArrayList<String> countOfType;
    private HashMap<String, Integer> hm = new HashMap<>();
    private Map< String, Integer> ngoAvailQuant;

    public NGOVolunteerJPanel(JPanel container, UserAccount ua, Organization organization, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.container = container;
        this.enterprise = enterprise;
        this.ua = ua;
        this.organization = organization;
        this.system = system;
        foodDetails.hide();
        populateRequestTable();
        jPanel2.setVisible(false);
    }

    public void populateRequestTable() {
        ngoAvailQuant = new HashMap<>();
        boolean flag;
        countOfType = new ArrayList<>();
        DefaultTableModel dtm = (DefaultTableModel) tblVolunteerFoodReq.getModel();
        dtm.setRowCount(0);

        DecimalFormat df = new DecimalFormat("#.00");
        flag = false;
        for (WorkRequest req : ua.getWorkQueue().getWorkRequestList()) {
            if (req instanceof FoodRequest) {

                Object row[] = new Object[10];

                countOfType.add(req.getFood().getType());
                row[0] = ((FoodRequest) req).getRequestId();
                row[1] = req.getFood().getName();
                row[2] = req.getFood().getCode();
                row[3] = ((FoodRequest) req);
                row[4] = req.getStatus();
                dtm.addRow(row);
                flag = true;

                int quantity = 0;
                if (ngoAvailQuant.containsKey(req.getFood().getName())) {
                    quantity = ngoAvailQuant.get(req.getFood().getName());
                }
                quantity += ((FoodRequest) req).getRequestQuantity();
                ngoAvailQuant.put(req.getFood().getName(), quantity);
            }
        }
        populateCount();
        Set<Map.Entry<String, Integer>> entrySet = ngoAvailQuant.entrySet();
        ArrayList<Map.Entry<String, Integer>> listOfEntry = new ArrayList<Map.Entry<String, Integer>>(entrySet);

        System.out.println("ArrayList of Key-Values :");
        DefaultTableModel dtm2 = (DefaultTableModel) tblNGOInventory.getModel();
        dtm2.setRowCount(0);
        for (Map.Entry<String, Integer> entry : listOfEntry) {
            Object row[] = new Object[2];
            row[0] = entry.getKey();
            row[1] = entry.getValue();
            dtm2.addRow(row);
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        if (flag == false) {
            btnViewDet.setEnabled(false);

        } else {
            btnViewDet.setEnabled(true);

        }

    }

    public void populateCount() {
        for (Food.FoodType t : Food.FoodType.values()) {
            int occurencies = Collections.frequency(countOfType, t.getValue());
            if (t == Food.FoodType.Cereals) {
                hm.put("Cereals", occurencies);
            }
            if (t == Food.FoodType.Fruits) {
                hm.put("Fruits", occurencies);
            }
            if (t == Food.FoodType.Vegetables) {
                hm.put("Vegetables", occurencies);
            }
            if (t == Food.FoodType.Beans) {
                hm.put("Beans", occurencies);
            }

            if (t == Food.FoodType.MeatandPoultry) {
                hm.put("Meat and Poultry", occurencies);
            }
            if (t == Food.FoodType.Seafood) {
                hm.put("Seafood", occurencies);
            }

        }
        String highestValue = getMapKeyWithHighestValue(hm);

        System.out.println(hm);
    }

    public String getMapKeyWithHighestValue(HashMap<String, Integer> map) {
        String keyWithHighestVal = "";

        // getting the maximum value in the Hashmap
        int maxValueInMap = (Collections.max(map.values()));

        //iterate through the map to get the key that corresponds to the maximum value in the Hashmap
        for (Map.Entry<String, Integer> entry : map.entrySet()) {  // Iterate through hashmap
            if (entry.getValue() == maxValueInMap) {

                keyWithHighestVal = entry.getKey();     // this is the key which has the max value
            }

        }
        return keyWithHighestVal;
    }

    public void populateLabel() {
        DecimalFormat df = new DecimalFormat("#.00");
        int selectedrow = tblVolunteerFoodReq.getSelectedRow();
        if (selectedrow >= 0) {
            foodDetails.show();
            FoodRequest foodreq = (FoodRequest) tblVolunteerFoodReq.getValueAt(selectedrow, 3);
            lblFoodName.setText(foodreq.getFood().getName());
            lblCode.setText(foodreq.getFood().getCode());
            lblQty.setText(String.valueOf(foodreq.getRequestQuantity()));

            lblRequestDate.setText(foodreq.getDateOfPurchaseInString());

        } else {
            JOptionPane.showMessageDialog(null, "Please select food from Table ", "Warning", JOptionPane.WARNING_MESSAGE);
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

        jLabel6 = new javax.swing.JLabel();
        lblVolunteer = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVolunteerFoodReq = new javax.swing.JTable();
        btnViewDet = new javax.swing.JButton();
        foodDetails = new javax.swing.JInternalFrame();
        jLabel20 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblQty = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();
        lblFoodName = new javax.swing.JLabel();
        lblRequestDate = new javax.swing.JLabel();
        btnRequestFood = new javax.swing.JButton();
        btnNotifyQualityChecker = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNGOInventory = new javax.swing.JTable();
        btnDistribute = new javax.swing.JButton();
        btnShowInventory = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 102));
        setLayout(null);

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei", 1, 24)); // NOI18N
        jLabel6.setText("Activity:");
        add(jLabel6);
        jLabel6.setBounds(820, 80, 120, 33);

        lblVolunteer.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        lblVolunteer.setText("Volunteer");
        add(lblVolunteer);
        lblVolunteer.setBounds(950, 80, 130, 30);

        lbl.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        lbl.setText("My Food Requests");
        add(lbl);
        lbl.setBounds(370, 140, 160, 20);

        tblVolunteerFoodReq.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        tblVolunteerFoodReq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "RequestId", "Food", "Code", "Quantity", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVolunteerFoodReq);

        add(jScrollPane1);
        jScrollPane1.setBounds(370, 170, 1170, 190);

        btnViewDet.setBackground(new java.awt.Color(102, 102, 102));
        btnViewDet.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        btnViewDet.setForeground(new java.awt.Color(255, 255, 255));
        btnViewDet.setText("View Details");
        btnViewDet.setMaximumSize(new java.awt.Dimension(200, 200));
        btnViewDet.setMinimumSize(new java.awt.Dimension(200, 200));
        btnViewDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetActionPerformed(evt);
            }
        });
        add(btnViewDet);
        btnViewDet.setBounds(370, 370, 180, 50);

        foodDetails.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        foodDetails.setClosable(true);
        foodDetails.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        foodDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        foodDetails.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        foodDetails.setFocusCycleRoot(false);
        foodDetails.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        foodDetails.setName("foodDetails"); // NOI18N
        foodDetails.setOpaque(true);
        foodDetails.setVisible(true);
        foodDetails.getContentPane().setLayout(null);

        jLabel20.setFont(new java.awt.Font("Microsoft JhengHei", 0, 18)); // NOI18N
        jLabel20.setText("Food Request Details");
        foodDetails.getContentPane().add(jLabel20);
        jLabel20.setBounds(180, 10, 200, 25);

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel7.setText("Food");
        foodDetails.getContentPane().add(jLabel7);
        jLabel7.setBounds(70, 70, 70, 20);

        jLabel14.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel14.setText("Date of request");
        foodDetails.getContentPane().add(jLabel14);
        jLabel14.setBounds(290, 70, 110, 20);

        lblQty.setText("*qty");
        foodDetails.getContentPane().add(lblQty);
        lblQty.setBounds(150, 130, 80, 16);

        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel11.setText("Quantity");
        foodDetails.getContentPane().add(jLabel11);
        jLabel11.setBounds(70, 130, 90, 20);

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel8.setText("Code");
        foodDetails.getContentPane().add(jLabel8);
        jLabel8.setBounds(70, 100, 70, 20);

        lblCode.setText("*MCode");
        foodDetails.getContentPane().add(lblCode);
        lblCode.setBounds(150, 100, 110, 16);

        lblFoodName.setText("*Food");
        foodDetails.getContentPane().add(lblFoodName);
        lblFoodName.setBounds(150, 70, 130, 16);

        lblRequestDate.setText("*purchase Date");
        foodDetails.getContentPane().add(lblRequestDate);
        lblRequestDate.setBounds(400, 70, 140, 16);

        add(foodDetails);
        foodDetails.setBounds(750, 410, 550, 220);

        btnRequestFood.setBackground(new java.awt.Color(102, 102, 102));
        btnRequestFood.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        btnRequestFood.setForeground(new java.awt.Color(255, 255, 255));
        btnRequestFood.setText("Request for Food");
        btnRequestFood.setMaximumSize(new java.awt.Dimension(200, 200));
        btnRequestFood.setMinimumSize(new java.awt.Dimension(200, 200));
        btnRequestFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestFoodActionPerformed(evt);
            }
        });
        add(btnRequestFood);
        btnRequestFood.setBounds(1330, 440, 230, 50);

        btnNotifyQualityChecker.setBackground(new java.awt.Color(102, 102, 102));
        btnNotifyQualityChecker.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        btnNotifyQualityChecker.setForeground(new java.awt.Color(255, 255, 255));
        btnNotifyQualityChecker.setText("Request for Quality Check");
        btnNotifyQualityChecker.setMaximumSize(new java.awt.Dimension(200, 200));
        btnNotifyQualityChecker.setMinimumSize(new java.awt.Dimension(200, 200));
        btnNotifyQualityChecker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotifyQualityCheckerActionPerformed(evt);
            }
        });
        add(btnNotifyQualityChecker);
        btnNotifyQualityChecker.setBounds(1330, 510, 230, 50);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblNGOInventory.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        tblNGOInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food", "Quantity"
            }
        ));
        jScrollPane2.setViewportView(tblNGOInventory);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, 90));

        btnDistribute.setBackground(new java.awt.Color(102, 102, 102));
        btnDistribute.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        btnDistribute.setForeground(new java.awt.Color(255, 255, 255));
        btnDistribute.setText("Distribute");
        btnDistribute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDistributeActionPerformed(evt);
            }
        });
        jPanel2.add(btnDistribute, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 120, -1));

        add(jPanel2);
        jPanel2.setBounds(370, 430, 350, 160);

        btnShowInventory.setBackground(new java.awt.Color(102, 102, 102));
        btnShowInventory.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        btnShowInventory.setForeground(new java.awt.Color(255, 255, 255));
        btnShowInventory.setText("Show Inventory");
        btnShowInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowInventoryActionPerformed(evt);
            }
        });
        add(btnShowInventory);
        btnShowInventory.setBounds(370, 620, 230, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewDetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetActionPerformed
        // TODO add your handling code here:
        populateLabel();
    }//GEN-LAST:event_btnViewDetActionPerformed

    private void btnRequestFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestFoodActionPerformed
        // TODO add your handling code here:

        RequestForFoodJPanel addcartjp = new RequestForFoodJPanel(container, ua, organization, enterprise, system, ngoAvailQuant);
        container.add("Order a Food JPanel", addcartjp);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);

    }//GEN-LAST:event_btnRequestFoodActionPerformed

    private void btnDistributeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDistributeActionPerformed
        // TODO add your handling code here:

        int selectedrow = tblNGOInventory.getSelectedRow();
        if (selectedrow >= 0) {
            String enter = JOptionPane.showInputDialog("Enter quantity");
            int enteredquant = Integer.parseInt(enter);
            String s = tblNGOInventory.getValueAt(selectedrow, 0).toString();
            System.out.println(s);
            int n = ngoAvailQuant.get(s);
            System.out.println(n);
            if (n > enteredquant) {
                int remainingquant = n - enteredquant;
                System.out.println(remainingquant);
                for (String sr : ngoAvailQuant.keySet()) {
                    if (sr.contains(s)) {
                        ngoAvailQuant.put(s, remainingquant);
                    }
                }
                Set<Map.Entry<String, Integer>> entrySet = ngoAvailQuant.entrySet();
                ArrayList<Map.Entry<String, Integer>> listOfEntry = new ArrayList<Map.Entry<String, Integer>>(entrySet);

                tblNGOInventory.removeAll();
                DefaultTableModel dtm2 = (DefaultTableModel) tblNGOInventory.getModel();
                dtm2.setRowCount(0);
                for (Map.Entry<String, Integer> entry : listOfEntry) {
                    Object row[] = new Object[2];
                    row[0] = entry.getKey();
                    row[1] = entry.getValue();
                    dtm2.addRow(row);

                }

            } else {
                JOptionPane.showMessageDialog(null, "You don't have that much quantity of this food item available in your inventory ", "Warning", JOptionPane.WARNING_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select food item you want to distribute from Table ", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDistributeActionPerformed

    private void btnNotifyQualityCheckerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotifyQualityCheckerActionPerformed
        // TODO add your handling code here:

        int selectedrow = tblVolunteerFoodReq.getSelectedRow();
        if (selectedrow >= 0) {
            populateLabel();
            FoodRequest FoodReq = (FoodRequest) tblVolunteerFoodReq.getValueAt(selectedrow, 3);
            if (FoodReq.getStatus().equals("Completed")) {
                CallQualityCheckerJPanel callqualcheckerjp = new CallQualityCheckerJPanel(container, FoodReq, ua, organization, enterprise, system);
                container.add(" Call Quality Checker JPanel", callqualcheckerjp);
                CardLayout layout = (CardLayout) container.getLayout();
                layout.next(container);
            } else {
                JOptionPane.showMessageDialog(null, "FoodRequest not processed yet !Cannot call a quality checker", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select Food from Table ", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnNotifyQualityCheckerActionPerformed

    private void btnShowInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowInventoryActionPerformed
        // TODO add your handling code here:

        jPanel2.setVisible(true);

    }//GEN-LAST:event_btnShowInventoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDistribute;
    private javax.swing.JButton btnNotifyQualityChecker;
    private javax.swing.JButton btnRequestFood;
    private javax.swing.JButton btnShowInventory;
    private javax.swing.JButton btnViewDet;
    private javax.swing.JInternalFrame foodDetails;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblFoodName;
    private javax.swing.JLabel lblQty;
    private javax.swing.JLabel lblRequestDate;
    private javax.swing.JLabel lblVolunteer;
    private javax.swing.JTable tblNGOInventory;
    private javax.swing.JTable tblVolunteerFoodReq;
    // End of variables declaration//GEN-END:variables
}
