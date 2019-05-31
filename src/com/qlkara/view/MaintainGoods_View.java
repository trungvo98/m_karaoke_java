package com.qlkara.view;

import com.qlkara.controller.MaintainGoods_CTL;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class MaintainGoods_View extends javax.swing.JPanel {

    public MaintainGoods_View() {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        MaintainGoods_CTL ctrl = new MaintainGoods_CTL(jpnView1, jpnView2, jtfSearch1, jtfSearch2, jbtnAdd, jbtnExport, jbtnAddEqui, jbtnExportEqui);
        ctrl.setDataToTableSanPham(1);
        ctrl.setDataToTableTrangThietBi();
        ctrl.setEvent();
        ctrl.setEventRadionButton(jrdAll, jrdWater, jrdBread);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jpnView1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jrdAll2 = new javax.swing.JRadioButton();
        jrdConhang = new javax.swing.JRadioButton();
        jrdHethang = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jrdAll = new javax.swing.JRadioButton();
        jrdWater = new javax.swing.JRadioButton();
        jrdBread = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jtfSearch1 = new javax.swing.JTextField();
        jbtnAdd = new javax.swing.JButton();
        jbtnExport = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jpnView2 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jrdAll1 = new javax.swing.JRadioButton();
        jrdReceipt1 = new javax.swing.JRadioButton();
        jrdPayment1 = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jtfSearch2 = new javax.swing.JTextField();
        jbtnAddEqui = new javax.swing.JButton();
        jbtnExportEqui = new javax.swing.JButton();

        jTabbedPane1.setForeground(java.awt.Color.blue);
        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jpnView1Layout = new javax.swing.GroupLayout(jpnView1);
        jpnView1.setLayout(jpnView1Layout);
        jpnView1Layout.setHorizontalGroup(
            jpnView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpnView1Layout.setVerticalGroup(
            jpnView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(java.awt.Color.blue);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlkara/image/aa.png"))); // NOI18N
        jLabel4.setText("LỌC THEO TỒN KHO ");

        buttonGroup2.add(jrdAll2);
        jrdAll2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrdAll2.setSelected(true);
        jrdAll2.setText("Tất cả ");

        buttonGroup2.add(jrdConhang);
        jrdConhang.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrdConhang.setText("Còn hàng ");

        buttonGroup2.add(jrdHethang);
        jrdHethang.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrdHethang.setText("Hết hàng ");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(java.awt.Color.blue);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlkara/image/aa.png"))); // NOI18N
        jLabel5.setText("TÌM KIẾM");

        buttonGroup1.add(jrdAll);
        jrdAll.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrdAll.setSelected(true);
        jrdAll.setText("Tất cả ");
        jrdAll.setToolTipText("");

        buttonGroup1.add(jrdWater);
        jrdWater.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrdWater.setText("Nước uống");

        buttonGroup1.add(jrdBread);
        jrdBread.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrdBread.setText("Thức ăn");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(java.awt.Color.blue);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlkara/image/aa.png"))); // NOI18N
        jLabel6.setText("LỌC THEO NHÓM");

        jtfSearch1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfSearch1.setForeground(new java.awt.Color(51, 51, 51));
        jtfSearch1.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jrdAll2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jrdConhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jrdHethang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfSearch1)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jrdAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jrdWater, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jrdBread, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrdAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrdWater, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrdBread, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrdAll2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrdConhang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrdHethang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(204, Short.MAX_VALUE))
        );

        jbtnAdd.setBackground(new java.awt.Color(255, 255, 255));
        jbtnAdd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbtnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlkara/image/plus.png"))); // NOI18N
        jbtnAdd.setText("Thêm mới sản phẩm ");
        jbtnAdd.setBorder(null);

        jbtnExport.setBackground(new java.awt.Color(255, 255, 255));
        jbtnExport.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbtnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlkara/image/excel.png"))); // NOI18N
        jbtnExport.setText("Xuất ra file ");
        jbtnExport.setBorder(null);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 470, Short.MAX_VALUE)
                        .addComponent(jbtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpnView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản lý danh mục sản phẩm ", jPanel7);

        javax.swing.GroupLayout jpnView2Layout = new javax.swing.GroupLayout(jpnView2);
        jpnView2.setLayout(jpnView2Layout);
        jpnView2Layout.setHorizontalGroup(
            jpnView2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 785, Short.MAX_VALUE)
        );
        jpnView2Layout.setVerticalGroup(
            jpnView2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(java.awt.Color.blue);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlkara/image/aa.png"))); // NOI18N
        jLabel8.setText("TÌM KIẾM");

        buttonGroup3.add(jrdAll1);
        jrdAll1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrdAll1.setSelected(true);
        jrdAll1.setText("Tất cả ");
        jrdAll1.setToolTipText("");

        buttonGroup3.add(jrdReceipt1);
        jrdReceipt1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrdReceipt1.setText("Còn hàng ");

        buttonGroup3.add(jrdPayment1);
        jrdPayment1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jrdPayment1.setText("Hết hàng ");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(java.awt.Color.blue);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlkara/image/aa.png"))); // NOI18N
        jLabel9.setText("LỌC THEO NHÓM");

        jtfSearch2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfSearch2.setForeground(new java.awt.Color(51, 51, 51));
        jtfSearch2.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jtfSearch2)
                    .addComponent(jrdAll1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jrdReceipt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jrdPayment1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrdAll1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrdReceipt1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrdPayment1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
        );

        jbtnAddEqui.setBackground(new java.awt.Color(255, 255, 255));
        jbtnAddEqui.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbtnAddEqui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlkara/image/plus.png"))); // NOI18N
        jbtnAddEqui.setText("Thêm mới thiết bị");
        jbtnAddEqui.setBorder(null);

        jbtnExportEqui.setBackground(new java.awt.Color(255, 255, 255));
        jbtnExportEqui.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbtnExportEqui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/qlkara/image/excel.png"))); // NOI18N
        jbtnExportEqui.setText("Xuất ra file ");
        jbtnExportEqui.setBorder(null);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnView2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnAddEqui, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnExportEqui, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnAddEqui, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnExportEqui, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnView2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản lý trang thiết bị", jPanel11);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtnAdd;
    private javax.swing.JButton jbtnAddEqui;
    private javax.swing.JButton jbtnExport;
    private javax.swing.JButton jbtnExportEqui;
    private javax.swing.JPanel jpnView1;
    private javax.swing.JPanel jpnView2;
    private javax.swing.JRadioButton jrdAll;
    private javax.swing.JRadioButton jrdAll1;
    private javax.swing.JRadioButton jrdAll2;
    private javax.swing.JRadioButton jrdBread;
    private javax.swing.JRadioButton jrdConhang;
    private javax.swing.JRadioButton jrdHethang;
    private javax.swing.JRadioButton jrdPayment1;
    private javax.swing.JRadioButton jrdReceipt1;
    private javax.swing.JRadioButton jrdWater;
    private javax.swing.JTextField jtfSearch1;
    private javax.swing.JTextField jtfSearch2;
    // End of variables declaration//GEN-END:variables
}
