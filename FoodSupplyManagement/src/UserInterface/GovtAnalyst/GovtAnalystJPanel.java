/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.GovtAnalyst;

import Business.EcoSystem;
import Business.Food.Food;
import Business.Network.Network;
import Business.WorkQueue.FoodRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author
 */
public class GovtAnalystJPanel extends javax.swing.JPanel {

    /**
     * Creates new form GovtAnalystJPanel
     */
    private JPanel container;
    private EcoSystem system;
    private ArrayList<Network> network;
    private Map< String, Integer> ngoRequestedQuantity;
    private ArrayList<String> countOfType;

    private HashMap<String, Integer> hm = new HashMap<>();

    public GovtAnalystJPanel(JPanel userProcessContainer, ArrayList<Network> networkList, EcoSystem business) {
        initComponents();

        this.container = userProcessContainer;
        this.system = business;
        this.network = networkList;

        jScrollPane1.hide();

        populateTable();
        populateCount();
    }

    public void populateTable() {
        ngoRequestedQuantity = new HashMap<>();
        countOfType = new ArrayList<>();

        DefaultTableModel dtm = (DefaultTableModel) tblReqfromNGO.getModel();
        dtm.setRowCount(0);

        for (WorkRequest r : system.getWorkQueue().getWorkRequestList()) {
            if (r instanceof FoodRequest) {
                Object[] row = new Object[10];
                countOfType.add(r.getFood().getType());

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
                tblReqfromNGO.getColumnModel().getColumn(0).setMaxWidth(0);
                tblReqfromNGO.getColumnModel().getColumn(0).setWidth(0);
                tblReqfromNGO.getColumnModel().getColumn(0).setMinWidth(0);

                int likes = 0;
                if (ngoRequestedQuantity.containsKey(r.getFood().getName())) {
                    likes = ngoRequestedQuantity.get(r.getFood().getName());
                }
                likes += ((FoodRequest) r).getRequestQuantity();
                ngoRequestedQuantity.put(r.getFood().getName(), likes);

                Set<Map.Entry<String, Integer>> entrySet = ngoRequestedQuantity.entrySet();
                ArrayList<Map.Entry<String, Integer>> listOfEntry = new ArrayList<Map.Entry<String, Integer>>(entrySet);

                //System.out.println("ArrayList of Key-Values :"); 
                DefaultTableModel dtm2 = (DefaultTableModel) requestsJTable.getModel();
                dtm2.setRowCount(0);
                for (Map.Entry<String, Integer> entry : listOfEntry) {
                    Object roww[] = new Object[2];
                    roww[0] = entry.getKey();
                    roww[1] = entry.getValue();
                    dtm2.addRow(roww);
                    // System.out.println(entry.getKey()+" : "+entry.getValue()); 
                }
            }
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

        System.out.println(hm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReqfromNGO = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        requestsJTable = new javax.swing.JTable();
        btnFQ = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblCustomername1 = new javax.swing.JLabel();
        jPanelanalysis1 = new javax.swing.JPanel();
        jPanelanalysis2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 204, 102));
        setPreferredSize(new java.awt.Dimension(0, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 204, 102));

        tblReqfromNGO.setForeground(new java.awt.Color(102, 0, 102));
        tblReqfromNGO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "RequestId", "RequestID", "Food", "Code", "Quantity", "Role", "Sender", "Status", "Receiver", "DAte of Delivery"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblReqfromNGO);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 1087, 20));

        jScrollPane2.setBackground(new java.awt.Color(255, 204, 102));

        requestsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food", "Requested Quantity till date"
            }
        ));
        jScrollPane2.setViewportView(requestsJTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 27, -1, 140));

        btnFQ.setText("Show Food Quantity Analysis Chart");
        btnFQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFQActionPerformed(evt);
            }
        });
        jPanel1.add(btnFQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jButton1.setText(" Show Food Type Analysis Chart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 230, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 756, -1));

        jLabel6.setFont(new java.awt.Font("Microsoft JhengHei", 1, 24)); // NOI18N
        jLabel6.setText("Activity:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        lblCustomername1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        lblCustomername1.setText("Analysis");
        add(lblCustomername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 110, 30));

        jPanelanalysis1.setBackground(new java.awt.Color(255, 204, 102));

        javax.swing.GroupLayout jPanelanalysis1Layout = new javax.swing.GroupLayout(jPanelanalysis1);
        jPanelanalysis1.setLayout(jPanelanalysis1Layout);
        jPanelanalysis1Layout.setHorizontalGroup(
            jPanelanalysis1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
        jPanelanalysis1Layout.setVerticalGroup(
            jPanelanalysis1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        add(jPanelanalysis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(996, 230, 530, 460));

        jPanelanalysis2.setBackground(new java.awt.Color(255, 204, 102));

        javax.swing.GroupLayout jPanelanalysis2Layout = new javax.swing.GroupLayout(jPanelanalysis2);
        jPanelanalysis2.setLayout(jPanelanalysis2Layout);
        jPanelanalysis2Layout.setHorizontalGroup(
            jPanelanalysis2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );
        jPanelanalysis2Layout.setVerticalGroup(
            jPanelanalysis2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        add(jPanelanalysis2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 450));
    }// </editor-fold>//GEN-END:initComponents

    private void btnFQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFQActionPerformed
        // TODO add your handling code here:
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
        Set<Map.Entry<String, Integer>> entrySet = ngoRequestedQuantity.entrySet();
        ArrayList<Map.Entry<String, Integer>> listOfEntry = new ArrayList<Map.Entry<String, Integer>>(entrySet);
        for (Map.Entry<String, Integer> entry : listOfEntry) {

            dcd.setValue(entry.getValue(), "RequestedQuantity", entry.getKey());

        }

        JFreeChart jchart = ChartFactory.createBarChart3D("Food Record", "Food Type", "Quantity Requested", dcd, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = jchart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);

        ChartPanel chartFrm = new ChartPanel(jchart, true);
        jPanelanalysis2.add(chartFrm);
        //chartFrm.setVisible(true);
        chartFrm.setSize(500, 400);

    }//GEN-LAST:event_btnFQActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
        Set<Map.Entry<String, Integer>> entrySet = hm.entrySet();
        ArrayList<Map.Entry<String, Integer>> listOfEntry = new ArrayList<Map.Entry<String, Integer>>(entrySet);
        for (Map.Entry<String, Integer> entry : listOfEntry) {

            dcd.setValue(entry.getValue(), "Number of times Requested", entry.getKey());

        }

        JFreeChart jchart = ChartFactory.createBarChart3D("Food Type Record", "Food Type", "Number of types this food Requested", dcd, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = jchart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);

        ChartPanel chartFrm = new ChartPanel(jchart, true);
        jPanelanalysis1.add(chartFrm);
        chartFrm.setVisible(true);
        chartFrm.setSize(500, 400);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFQ;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelanalysis1;
    private javax.swing.JPanel jPanelanalysis2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCustomername1;
    private javax.swing.JTable requestsJTable;
    private javax.swing.JTable tblReqfromNGO;
    // End of variables declaration//GEN-END:variables
}
