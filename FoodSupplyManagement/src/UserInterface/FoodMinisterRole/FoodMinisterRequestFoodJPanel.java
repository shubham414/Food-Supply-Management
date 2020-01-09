/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.FoodMinisterRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Food.Food;
import Business.Food.Food.FoodType;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FoodRequest;
import Business.WorkQueue.WorkRequest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 
 */
public class FoodMinisterRequestFoodJPanel extends javax.swing.JPanel {

    /**
     * Creates new form FoodMinisterRequestFoodJPanel
     */
    private JPanel container;
    private Organization organization;
    private Enterprise enterprise;
    private UserAccount ua;
    private EcoSystem system;
    private ArrayList<String> countOfType;
    private HashMap<String, Integer> hm= new HashMap<>();
   
    public FoodMinisterRequestFoodJPanel(JPanel container, UserAccount ua, Organization organization, Enterprise enterprise,EcoSystem system) {
        initComponents();
        this.container=container;
        this.enterprise=enterprise;
        this.ua=ua;
        this.organization=organization;
        this.system=system;
        foodDetails.hide();
        populateRequestTable();
       
    }

    public void populateRequestTable() {

        boolean flag;
        countOfType= new ArrayList<>();
        DefaultTableModel dtm = (DefaultTableModel) tblfoodministerfoodReq.getModel();
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
              
                dtm.addRow(row);
                flag = true;
            }

        }
        populateCount();
        if (flag == false) {
            btnViewDet.setEnabled(false);
           
        } else {
            btnViewDet.setEnabled(true);
         
        }

    }

    public void populateCount() {
        for (FoodType t : Food.FoodType.values()) {
            int occurencies = Collections.frequency(countOfType, t.getValue());
           if (t == Food.FoodType.Cereals) {
                hm.put("Anesthetic", occurencies);
            }
            if (t == Food.FoodType.Fruits) {
                hm.put("Dental", occurencies);
            }
            if (t == Food.FoodType.Vegetables) {
                hm.put("Dressings", occurencies);
            }
            if (t == Food.FoodType.Beans) {
                hm.put("Emergency", occurencies);
            }
           
            if (t == Food.FoodType.MeatandPoultry) {
                hm.put("Ophthalmic", occurencies);
            }
            if (t == Food.FoodType.Seafood) {
                hm.put("Orthopedic", occurencies);
            }

        }
        String highestValue = getMapKeyWithHighestValue(hm);
       
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
        int selectedrow = tblfoodministerfoodReq.getSelectedRow();
        if (selectedrow >= 0) {
            foodDetails.show();
            FoodRequest foodreq = (FoodRequest) tblfoodministerfoodReq.getValueAt(selectedrow, 3);
            lblFoodName.setText(foodreq.getFood().getName());
            lblCode.setText(foodreq.getFood().getCode());
            lblQty.setText(String.valueOf(foodreq.getRequestQuantity()));
          
            lblPurchaseDate.setText(foodreq.getDateOfPurchaseInString());
          
        } else {
            JOptionPane.showMessageDialog(null, "Please select Food from Table ", "Warning", JOptionPane.WARNING_MESSAGE);
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
        lblFoodMinister = new javax.swing.JLabel();
        lblMyRequests = new javax.swing.JLabel();
        foodDetails = new javax.swing.JInternalFrame();
        jLabel20 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblQty = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();
        lblFoodName = new javax.swing.JLabel();
        lblPurchaseDate = new javax.swing.JLabel();
        btnRequest = new javax.swing.JButton();
        btnViewDet = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblfoodministerfoodReq = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 204, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei", 1, 24)); // NOI18N
        jLabel6.setText("Activity:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, -1, -1));

        lblFoodMinister.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        lblFoodMinister.setText("Food Minister");
        add(lblFoodMinister, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, 170, 30));

        lblMyRequests.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        lblMyRequests.setText("My Requests");
        add(lblMyRequests, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 120, 90, -1));

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

        jLabel20.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel20.setText("Food Order Details");
        foodDetails.getContentPane().add(jLabel20);
        jLabel20.setBounds(10, 0, 160, 30);

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel7.setText("Food :");
        foodDetails.getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 60, 60, 30);

        jLabel14.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel14.setText("Date of purchase :");
        foodDetails.getContentPane().add(jLabel14);
        jLabel14.setBounds(240, 60, 130, 30);

        lblQty.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        lblQty.setText("*qty");
        foodDetails.getContentPane().add(lblQty);
        lblQty.setBounds(110, 120, 60, 20);

        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel11.setText("Quantity :");
        foodDetails.getContentPane().add(jLabel11);
        jLabel11.setBounds(20, 120, 80, 30);

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel8.setText("Code :");
        foodDetails.getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 90, 70, 30);

        lblCode.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        lblCode.setText("*MCode");
        foodDetails.getContentPane().add(lblCode);
        lblCode.setBounds(110, 90, 80, 20);

        lblFoodName.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        lblFoodName.setText("*Food");
        foodDetails.getContentPane().add(lblFoodName);
        lblFoodName.setBounds(110, 60, 70, 20);

        lblPurchaseDate.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        lblPurchaseDate.setText("*purchase Date");
        foodDetails.getContentPane().add(lblPurchaseDate);
        lblPurchaseDate.setBounds(400, 60, 110, 20);

        add(foodDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 480, 550, 220));

        btnRequest.setBackground(new java.awt.Color(102, 102, 102));
        btnRequest.setForeground(new java.awt.Color(255, 255, 255));
        btnRequest.setText("Request new Food");
        btnRequest.setMaximumSize(new java.awt.Dimension(200, 200));
        btnRequest.setMinimumSize(new java.awt.Dimension(200, 200));
        btnRequest.setOpaque(false);
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });
        add(btnRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 360, 180, 50));

        btnViewDet.setBackground(new java.awt.Color(102, 102, 102));
        btnViewDet.setForeground(new java.awt.Color(255, 255, 255));
        btnViewDet.setText("View Details");
        btnViewDet.setMaximumSize(new java.awt.Dimension(200, 200));
        btnViewDet.setMinimumSize(new java.awt.Dimension(200, 200));
        btnViewDet.setOpaque(false);
        btnViewDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetActionPerformed(evt);
            }
        });
        add(btnViewDet, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 180, 50));

        tblfoodministerfoodReq.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        tblfoodministerfoodReq.setForeground(new java.awt.Color(102, 0, 102));
        tblfoodministerfoodReq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "RequestId", "Food", "Code", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblfoodministerfoodReq);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 1170, 190));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        // TODO add your handling code here:
//        RequestForFoodJPanel addcartjp = new RequestForFoodJPanel(container,ua,organization,enterprise,system);
//        container.add("Doctor Buy A Food JPanel", addcartjp);
//        CardLayout layout = (CardLayout) container.getLayout();
//        layout.next(container);
    }//GEN-LAST:event_btnRequestActionPerformed

    
    
    private void btnViewDetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetActionPerformed
        // TODO add your handling code here:
        populateLabel();
    }//GEN-LAST:event_btnViewDetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRequest;
    private javax.swing.JButton btnViewDet;
    private javax.swing.JInternalFrame foodDetails;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblFoodMinister;
    private javax.swing.JLabel lblFoodName;
    private javax.swing.JLabel lblMyRequests;
    private javax.swing.JLabel lblPurchaseDate;
    private javax.swing.JLabel lblQty;
    private javax.swing.JTable tblfoodministerfoodReq;
    // End of variables declaration//GEN-END:variables
}
