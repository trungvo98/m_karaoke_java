package com.qlkara.controller;

import com.qlkara.model.CaLamViec;
import com.qlkara.service.CaLamViecService;
import com.qlkara.service.ICaLamViecService;
import com.qlkara.utilities.ClassTableModel;
import com.qlkara.view.Schedule;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author trung98  
 */
public class MaintainSchedule_CTL {

    private JButton jbtnAdd;
    private JButton jbtnPhanca1;
    private JButton jbtnPhanca2;
    private String[] listColumn = {"STT","Tên ca","Ký hiệu","Giờ bắt đầu","Giờ kết thúc","Số công","Giờ nghỉ lao"};
    private JTable table;
    private TableRowSorter sorter;
    private JPanel jpnView;
    DefaultTableModel model =null;
    CaLamViecService clvService =null;

    public MaintainSchedule_CTL(JButton jbtnAdd, JButton jbtnPhanca1, JButton jbtnPhanca2,JPanel jpnView) {
        this.jbtnAdd = jbtnAdd;
        this.jbtnPhanca1 = jbtnPhanca1;
        this.jbtnPhanca2 = jbtnPhanca2;
        this.jpnView = jpnView;
        clvService = new ICaLamViecService();
    }
    

    public void setDataToTable() {
        ArrayList<CaLamViec> list = clvService.getAll();
        model = new ClassTableModel().setTableCaLamViec(list, listColumn);
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
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    CaLamViec clv = new CaLamViec();
                    clv.setTenca(model.getValueAt(selectedRowIndex,1).toString());
                    clv.setMaca((int) model.getValueAt(selectedRowIndex, 2));
                    clv.setGiobatdau((Time) model.getValueAt(selectedRowIndex, 3));
                    clv.setGioketthuc((Time) model.getValueAt(selectedRowIndex, 4));
                    clv.setSocong((int) model.getValueAt(selectedRowIndex, 5));
                    //clv.setGionghibd((Time) model.getValueAt(selectedRowIndex,6));
                    //clv.setGionghikt((Time) model.getValueAt(selectedRowIndex,7));
                    Schedule jfrSchedule = new Schedule(clv);
                    jfrSchedule.setTitle("Thông tin nhân viên");
                    jfrSchedule.setResizable(false);
                    jfrSchedule.setLocationRelativeTo(null);
                    jfrSchedule.setVisible(true);
                }
            }
        });
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
