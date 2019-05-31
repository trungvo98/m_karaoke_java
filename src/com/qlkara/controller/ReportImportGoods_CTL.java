
package com.qlkara.controller;

import com.qlkara.model.PhieuNhapHang;
import com.qlkara.service.PhieuNhapHangService;
import com.qlkara.utilities.ClassTableModel;
import com.qlkara.view.ReportImportGoods;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author trung98
 */
public class ReportImportGoods_CTL {
    private JLabel jlbNgaytao;
    private JLabel jlbSodonhang;
    private JLabel jlbTongtien;
    private JLabel jlbChietkhau;
    private String[] listColumn = {"STT","Mã đơn hàng","Ngày nhập","Tên đối tác","Trị giá"};
    private JTable table;
    private TableRowSorter sorter;
    private JPanel jpnView;
    DefaultTableModel model =null;
    PhieuNhapHangService clvService =null;

    public ReportImportGoods_CTL(JLabel jlbNgaytao, JLabel jlbSodonhang, JLabel jlbTongtien, JLabel jlbChietkhau, JPanel jpnView) {
        this.jlbNgaytao = jlbNgaytao;
        this.jlbSodonhang = jlbSodonhang;
        this.jlbTongtien = jlbTongtien;
        this.jlbChietkhau = jlbChietkhau;
   
        this.jpnView = jpnView;
    }

    
    

    public void setDataToTable() {
        ArrayList<PhieuNhapHang> list = clvService.getAll();
        model = new ClassTableModel().setTablePhieuNhapHang(list, listColumn);
        table = new JTable(model);
        sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);

        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        // Độ rộng các cột 
       /* table.getColumnModel().getColumn(0).setMaxWidth(50);
        table.getColumnModel().getColumn(0).setMinWidth(50);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setMaxWidth(50);
        table.getColumnModel().getColumn(1).setMinWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setMaxWidth(80);
        table.getColumnModel().getColumn(4).setMinWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getColumnModel().getColumn(7).setMaxWidth(200);
        table.getColumnModel().getColumn(7).setMinWidth(200);
        table.getColumnModel().getColumn(7).setPreferredWidth(200);
        // Độ rộng các cột*/
      /*  table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    PhieuNhapHang pnh = new PhieuNhapHang();
                    pnh.setMapnh(model.getValueAt(selectedRowIndex,1).toString());
                    pnh.setNgaynhap((Date) model.getValueAt(selectedRowIndex, 2));
                    pnh.setMancc( (int)model.getValueAt(selectedRowIndex, 3));
                    pnh.setSotien((int) model.getValueAt(selectedRowIndex, 4));
                  
                    //clv.setGionghibd((Time) model.getValueAt(selectedRowIndex,6));
                    //clv.setGionghikt((Time) model.getValueAt(selectedRowIndex,7));
                    ReportImportGoods jfrRIG = new ReportImportGoods();
                    jfrSchedule.setTitle("Thông tin nhân viên");
                    jfrSchedule.setResizable(false);
                    jfrSchedule.setLocationRelativeTo(null);
                    jfrSchedule.setVisible(true);
                }
            }
        });*/
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }
}
