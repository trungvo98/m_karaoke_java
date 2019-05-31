package com.qlkara.controller;

import com.qlkara.view.Employee;
import com.qlkara.model.NhanVien;
import com.qlkara.service.INhanVienService;
import com.qlkara.service.NhanVienService;
import com.qlkara.utilities.ClassTableModel;
import com.qlkara.view.UpdateEmployee;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author trung98
 */
public class MaintainEmployee_CTL {

    private JPanel jpnView;
    private JButton jbtnAdd;
    private JButton jbtnUpdate;
    private JButton jbtnDelete;
    private JButton jbtnShowAll;
    private JTextField jtfSearch;
    private NhanVienService nvService = null;
    DefaultTableModel model = null;
    JTable jtb = null;

    private String[] listColumn = {"STT", "MãNV", "Họ tên", "Ngày sinh", "Giới tính", "Ngày vào làm", "SĐT", "Địa chỉ", "Tình trạng"};
    private TableRowSorter<TableModel> sorter = null;
    private NhanVien nv = null;

    public MaintainEmployee_CTL(JPanel jpnView, JButton jbtnAdd, JButton jbtnUpdate, JTextField jtfSearch, JButton jbtnDelete, JButton jbtnShowAll) {
        this.jpnView = jpnView;
        this.jbtnAdd = jbtnAdd;
        this.jbtnUpdate = jbtnUpdate;
        this.jtfSearch = jtfSearch;
        this.nvService = new INhanVienService();
        this.jbtnDelete = jbtnDelete;
        this.jbtnShowAll = jbtnShowAll;
    }

    public void addOrUpdate() {
        model = (DefaultTableModel) jtb.getModel();
        int selectedRowIndex = jtb.getSelectedRow();
        selectedRowIndex = jtb.convertRowIndexToModel(selectedRowIndex);

        NhanVien nv = new NhanVien();
        nv.setManv(model.getValueAt(selectedRowIndex, 1).toString());
        nv.setTennv((String) model.getValueAt(selectedRowIndex, 2));
        nv.setNgsinh((Date) model.getValueAt(selectedRowIndex, 3));
        nv.setGioitinh(model.getValueAt(selectedRowIndex, 4).toString().equalsIgnoreCase("Nam"));
        nv.setNgvl((Date) model.getValueAt(selectedRowIndex, 5));
        nv.setSdt((String) model.getValueAt(selectedRowIndex, 6));
        nv.setDiachi((String) model.getValueAt(selectedRowIndex, 7));
        nv.setTrangthai(model.getValueAt(selectedRowIndex, 8).toString().equalsIgnoreCase("Đang làm"));
        Employee jfrNhanVien = new Employee(nv);
        jfrNhanVien.setTitle("Sửa thông tin nhân viên");
        jfrNhanVien.setResizable(false);
        jfrNhanVien.setLocationRelativeTo(null);
        jfrNhanVien.setVisible(true);

    }

    public void updateEmployee() {
        model = (DefaultTableModel) jtb.getModel();

        if (jtb.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên bạn muốn cập nhật !");
        } else {
            int selectedRowIndex = jtb.getSelectedRow();

            selectedRowIndex = jtb.convertRowIndexToModel(selectedRowIndex);

            NhanVien nv = new NhanVien();
            nv.setManv(model.getValueAt(selectedRowIndex, 1).toString());
            nv.setTennv((String) model.getValueAt(selectedRowIndex, 2));
            nv.setNgsinh((Date) model.getValueAt(selectedRowIndex, 3));
            nv.setGioitinh(model.getValueAt(selectedRowIndex, 4).toString().equalsIgnoreCase("Nam"));
            nv.setNgvl((Date) model.getValueAt(selectedRowIndex, 5));
            nv.setSdt((String) model.getValueAt(selectedRowIndex, 6));
            nv.setDiachi((String) model.getValueAt(selectedRowIndex, 7));
            nv.setTrangthai(model.getValueAt(selectedRowIndex, 8).toString().equalsIgnoreCase("Đang làm"));
            UpdateEmployee updateEmployee = new UpdateEmployee(nv);
            updateEmployee.setTitle("Sửa thông tin nhân viên");
            updateEmployee.setResizable(false);
            updateEmployee.setLocationRelativeTo(null);
            updateEmployee.setVisible(true);
        }
    }

    public void setDataToTable() {
        ArrayList<NhanVien> list = nvService.getList();
        model = new ClassTableModel().setTableNhanVien(list, listColumn);
        jtb = new JTable(model);
        sorter = new TableRowSorter<>(jtb.getModel());
        jtb.setRowSorter(sorter);

        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        jtb.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        jtb.getTableHeader().setPreferredSize(new Dimension(100, 50));
        // Độ rộng các cột 

        for (int i = 0; i < listColumn.length; i++) {
            if (i == 0) {
                jtb.getColumnModel().getColumn(i).setPreferredWidth(40);
            } else if (i == 2) {
                jtb.getColumnModel().getColumn(i).setPreferredWidth(150);
            } else if (i == 4) {
                jtb.getColumnModel().getColumn(i).setPreferredWidth(70);
            } else if (i == 7) {
                jtb.getColumnModel().getColumn(i).setPreferredWidth(170);
            } else {
                jtb.getColumnModel().getColumn(i).setPreferredWidth(100);
            }
        }
        /*jtb.getColumnModel().getColumn(0).setMaxWidth(50);
        jtb.getColumnModel().getColumn(0).setMinWidth(50);
        jtb.getColumnModel().getColumn(0).setPreferredWidth(50);
        jtb.getColumnModel().getColumn(1).setMaxWidth(50);
        jtb.getColumnModel().getColumn(1).setMinWidth(50);
        jtb.getColumnModel().getColumn(1).setPreferredWidth(50);
        jtb.getColumnModel().getColumn(4).setMaxWidth(80);
        jtb.getColumnModel().getColumn(4).setMinWidth(80);
        jtb.getColumnModel().getColumn(4).setPreferredWidth(80);
        jtb.getColumnModel().getColumn(7).setMaxWidth(200);
        jtb.getColumnModel().getColumn(7).setMinWidth(200);
        jtb.getColumnModel().getColumn(7).setPreferredWidth(200);*/
        // Độ rộng các cột
        jtb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && jtb.getSelectedRow() != -1) {
                    updateEmployee();
                }
            }
        });
        jtb.setRowHeight(45);
        jtb.validate();
        jtb.repaint();
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(jtb);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }

    public void setEvent() {
        jbtnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Employee jfrmEmp = new Employee(new NhanVien());
                jfrmEmp.setVisible(true);
                jfrmEmp.setTitle("Thêm mới nhân viên");
                jfrmEmp.setLocationRelativeTo(null);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
        jbtnUpdate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                updateEmployee();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        jbtnDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel model = (DefaultTableModel) jtb.getModel();
                if (jtb.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên bạn muốn xóa !");
                } else {
                    int selectedRowIndex = jtb.getSelectedRow();
                    selectedRowIndex = jtb.convertRowIndexToModel(selectedRowIndex);
                    String manv = (model.getValueAt(selectedRowIndex, 1).toString());
                    int check = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa nhân viên này ?", "Thông báo", JOptionPane.YES_NO_OPTION);
                    if (check == JOptionPane.YES_OPTION) {
                        boolean result = nvService.delete(manv);
                        if (result) {
                            JOptionPane.showMessageDialog(null, "Xóa nhân viên thành công!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Xóa nhân viên thất bại!");
                        }
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        jbtnShowAll.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setDataToTable();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

}
