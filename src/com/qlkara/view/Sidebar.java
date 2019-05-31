package com.qlkara.view;

import com.qlkara.bean.Category_Bean;
import com.qlkara.controller.ChuyenManHinh_CTL;
import java.util.ArrayList;

/**
 *
 * @author trung98
 */
public class Sidebar extends javax.swing.JFrame {

    public Sidebar() {
        initComponents();
        ChuyenManHinh_CTL ctl = new ChuyenManHinh_CTL(jpnView);
        ctl.setView(jpnDashboard, jlbDashboard);
        ArrayList<Category_Bean> list = new ArrayList<>();
        list.add(new Category_Bean("Dashboard", jpnDashboard, jlbDashboard));
        list.add(new Category_Bean("MaintainRoom", jpnMaintain_SingingRom, jlbMaintain_SingingRoom));
        list.add(new Category_Bean("MaintainEmployee", jpnMaintain_Employee, jlbMaintain_Employee));
        list.add(new Category_Bean("MaintainSchedule", jpnMaintain_Schedule, jlbMaintain_Schedule));
        list.add(new Category_Bean("MaintainInventory", jpnMaintain_Inventory, jlbMaintain_Inventory));
        list.add(new Category_Bean("MaintainExpense", jpnExpense, jlbExpense));
        list.add(new Category_Bean("MaintainGoods", jpnMaintainGoods, jlbMaintainGoods));
        list.add(new Category_Bean("Statistic", jpnStatistic, jlbStatistic));
        list.add(new Category_Bean("Report", jpnReport, jlbReport));

        ctl.setEvent(list);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpnDashboard = new javax.swing.JPanel();
        jlbDashboard = new javax.swing.JLabel();
        jpnMaintain_SingingRom = new javax.swing.JPanel();
        jlbMaintain_SingingRoom = new javax.swing.JLabel();
        jpnMaintain_Employee = new javax.swing.JPanel();
        jlbMaintain_Employee = new javax.swing.JLabel();
        jpnMaintain_Inventory = new javax.swing.JPanel();
        jlbMaintain_Inventory = new javax.swing.JLabel();
        jpnMaintain_Schedule = new javax.swing.JPanel();
        jlbMaintain_Schedule = new javax.swing.JLabel();
        jpnStatistic = new javax.swing.JPanel();
        jlbStatistic = new javax.swing.JLabel();
        jpnReport = new javax.swing.JPanel();
        jlbReport = new javax.swing.JLabel();
        jpnExpense = new javax.swing.JPanel();
        jlbExpense = new javax.swing.JLabel();
        jpnMaintainGoods = new javax.swing.JPanel();
        jlbMaintainGoods = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phần mềm quản lý quán Karaoke Nice");

        jpnMenu.setBackground(new java.awt.Color(102, 102, 102));

        jPanel4.setBackground(java.awt.Color.red);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlkara/image/karaoke.png"))); // NOI18N
        jLabel1.setText("QUẢN LÝ KARAOKE NICE");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnDashboard.setBackground(new java.awt.Color(30, 144, 255));

        jlbDashboard.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbDashboard.setForeground(new java.awt.Color(255, 255, 255));
        jlbDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlkara/image/baseline_important_devices_white_24dp.png"))); // NOI18N
        jlbDashboard.setText("MÀN HÌNH CHÍNH ");

        javax.swing.GroupLayout jpnDashboardLayout = new javax.swing.GroupLayout(jpnDashboard);
        jpnDashboard.setLayout(jpnDashboardLayout);
        jpnDashboardLayout.setHorizontalGroup(
            jpnDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnDashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnDashboardLayout.setVerticalGroup(
            jpnDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbDashboard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        jpnMaintain_SingingRom.setBackground(new java.awt.Color(30, 144, 255));

        jlbMaintain_SingingRoom.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbMaintain_SingingRoom.setForeground(new java.awt.Color(255, 255, 255));
        jlbMaintain_SingingRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlkara/image/baseline_perm_camera_mic_white_24dp.png"))); // NOI18N
        jlbMaintain_SingingRoom.setText("QUẢN LÝ PHÒNG HÁT ");

        javax.swing.GroupLayout jpnMaintain_SingingRomLayout = new javax.swing.GroupLayout(jpnMaintain_SingingRom);
        jpnMaintain_SingingRom.setLayout(jpnMaintain_SingingRomLayout);
        jpnMaintain_SingingRomLayout.setHorizontalGroup(
            jpnMaintain_SingingRomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMaintain_SingingRomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbMaintain_SingingRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnMaintain_SingingRomLayout.setVerticalGroup(
            jpnMaintain_SingingRomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbMaintain_SingingRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        jpnMaintain_Employee.setBackground(new java.awt.Color(30, 144, 255));

        jlbMaintain_Employee.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbMaintain_Employee.setForeground(new java.awt.Color(255, 255, 255));
        jlbMaintain_Employee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlkara/image/baseline_supervisor_account_white_24dp.png"))); // NOI18N
        jlbMaintain_Employee.setText("QUẢN LÝ NHÂN VIÊN");

        javax.swing.GroupLayout jpnMaintain_EmployeeLayout = new javax.swing.GroupLayout(jpnMaintain_Employee);
        jpnMaintain_Employee.setLayout(jpnMaintain_EmployeeLayout);
        jpnMaintain_EmployeeLayout.setHorizontalGroup(
            jpnMaintain_EmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMaintain_EmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbMaintain_Employee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnMaintain_EmployeeLayout.setVerticalGroup(
            jpnMaintain_EmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbMaintain_Employee, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        jpnMaintain_Inventory.setBackground(new java.awt.Color(30, 144, 255));

        jlbMaintain_Inventory.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbMaintain_Inventory.setForeground(new java.awt.Color(255, 255, 255));
        jlbMaintain_Inventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlkara/image/baseline_store_mall_directory_white_24dp.png"))); // NOI18N
        jlbMaintain_Inventory.setText("QUẢN LÝ HÀNG TỒN KHO");

        javax.swing.GroupLayout jpnMaintain_InventoryLayout = new javax.swing.GroupLayout(jpnMaintain_Inventory);
        jpnMaintain_Inventory.setLayout(jpnMaintain_InventoryLayout);
        jpnMaintain_InventoryLayout.setHorizontalGroup(
            jpnMaintain_InventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMaintain_InventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbMaintain_Inventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnMaintain_InventoryLayout.setVerticalGroup(
            jpnMaintain_InventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbMaintain_Inventory, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        jpnMaintain_Schedule.setBackground(new java.awt.Color(30, 144, 255));

        jlbMaintain_Schedule.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbMaintain_Schedule.setForeground(new java.awt.Color(255, 255, 255));
        jlbMaintain_Schedule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlkara/image/baseline_watch_later_white_24dp.png"))); // NOI18N
        jlbMaintain_Schedule.setText("QUẢN LÝ LỊCH LÀM VIỆC");

        javax.swing.GroupLayout jpnMaintain_ScheduleLayout = new javax.swing.GroupLayout(jpnMaintain_Schedule);
        jpnMaintain_Schedule.setLayout(jpnMaintain_ScheduleLayout);
        jpnMaintain_ScheduleLayout.setHorizontalGroup(
            jpnMaintain_ScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMaintain_ScheduleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbMaintain_Schedule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnMaintain_ScheduleLayout.setVerticalGroup(
            jpnMaintain_ScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbMaintain_Schedule, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        jpnStatistic.setBackground(new java.awt.Color(30, 144, 255));

        jlbStatistic.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbStatistic.setForeground(new java.awt.Color(255, 255, 255));
        jlbStatistic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlkara/image/baseline_assessment_white_24dp.png"))); // NOI18N
        jlbStatistic.setText("THỐNG KÊ DỮ LIỆU");

        javax.swing.GroupLayout jpnStatisticLayout = new javax.swing.GroupLayout(jpnStatistic);
        jpnStatistic.setLayout(jpnStatisticLayout);
        jpnStatisticLayout.setHorizontalGroup(
            jpnStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnStatisticLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbStatistic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnStatisticLayout.setVerticalGroup(
            jpnStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbStatistic, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        jpnReport.setBackground(new java.awt.Color(30, 144, 255));

        jlbReport.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbReport.setForeground(new java.awt.Color(255, 255, 255));
        jlbReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlkara/image/baseline_pie_chart_white_24dp.png"))); // NOI18N
        jlbReport.setText("BÁO CÁO");

        javax.swing.GroupLayout jpnReportLayout = new javax.swing.GroupLayout(jpnReport);
        jpnReport.setLayout(jpnReportLayout);
        jpnReportLayout.setHorizontalGroup(
            jpnReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnReportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnReportLayout.setVerticalGroup(
            jpnReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbReport, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        jpnExpense.setBackground(new java.awt.Color(30, 144, 255));

        jlbExpense.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbExpense.setForeground(new java.awt.Color(255, 255, 255));
        jlbExpense.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlkara/image/baseline_swap_horizontal_circle_white_24dp.png"))); // NOI18N
        jlbExpense.setText("QUẢN LÝ THU VÀ CHI");

        javax.swing.GroupLayout jpnExpenseLayout = new javax.swing.GroupLayout(jpnExpense);
        jpnExpense.setLayout(jpnExpenseLayout);
        jpnExpenseLayout.setHorizontalGroup(
            jpnExpenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnExpenseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbExpense, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnExpenseLayout.setVerticalGroup(
            jpnExpenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbExpense, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        jpnMaintainGoods.setBackground(new java.awt.Color(30, 144, 255));

        jlbMaintainGoods.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbMaintainGoods.setForeground(new java.awt.Color(255, 255, 255));
        jlbMaintainGoods.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlkara/image/baseline_subtitles_white_24dp.png"))); // NOI18N
        jlbMaintainGoods.setText("QUẢN LÝ HÀNG HÓA");

        javax.swing.GroupLayout jpnMaintainGoodsLayout = new javax.swing.GroupLayout(jpnMaintainGoods);
        jpnMaintainGoods.setLayout(jpnMaintainGoodsLayout);
        jpnMaintainGoodsLayout.setHorizontalGroup(
            jpnMaintainGoodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMaintainGoodsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbMaintainGoods, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnMaintainGoodsLayout.setVerticalGroup(
            jpnMaintainGoodsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbMaintainGoods, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnMaintain_Inventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnMaintain_Employee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnMaintain_SingingRom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnMaintain_Schedule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnStatistic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnExpense, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnMaintainGoods, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnMaintain_SingingRom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnMaintain_Employee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnMaintain_Schedule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnMaintain_Inventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnExpense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnMaintainGoods, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnStatistic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 876, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sidebar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sidebar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sidebar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sidebar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sidebar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jlbDashboard;
    private javax.swing.JLabel jlbExpense;
    private javax.swing.JLabel jlbMaintainGoods;
    private javax.swing.JLabel jlbMaintain_Employee;
    private javax.swing.JLabel jlbMaintain_Inventory;
    private javax.swing.JLabel jlbMaintain_Schedule;
    private javax.swing.JLabel jlbMaintain_SingingRoom;
    private javax.swing.JLabel jlbReport;
    private javax.swing.JLabel jlbStatistic;
    private javax.swing.JPanel jpnDashboard;
    private javax.swing.JPanel jpnExpense;
    private javax.swing.JPanel jpnMaintainGoods;
    private javax.swing.JPanel jpnMaintain_Employee;
    private javax.swing.JPanel jpnMaintain_Inventory;
    private javax.swing.JPanel jpnMaintain_Schedule;
    private javax.swing.JPanel jpnMaintain_SingingRom;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnReport;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnStatistic;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
