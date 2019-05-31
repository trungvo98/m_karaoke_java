package com.qlkara.controller;

import com.qlkara.model.SanPham;
import com.qlkara.model.TrangThietBi;
import com.qlkara.service.ISanPhamService;
import com.qlkara.utilities.ClassTableModel;
import com.sun.xml.internal.ws.api.server.Adapter;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import com.qlkara.service.SanPhamService;

/**
 *
 * @author trung98
 */
public class MaintainInventory_CTL {

    private JPanel jpnView;
    private JTextField jtfSearch;
    private JButton jbtnShowAll;
    private JButton jbtnExport;
    private SanPhamService spService = null;
    private TableRowSorter<TableModel> sorter;
    private String[] listColumn = {"STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng tồn", "Ngày cập nhật"};
    private DefaultTableModel dtm = null;
    JTable table = null;

    public MaintainInventory_CTL(JPanel jpnView, JTextField jtfSearch, JButton jbtnShowAll, JButton jbtnExport) {
        this.jpnView = jpnView;
        this.jtfSearch = jtfSearch;
        this.jbtnShowAll = jbtnShowAll;
        this.jbtnExport = jbtnExport;
        spService = new ISanPhamService();

    }

    public void setDataToTable() {
        ArrayList<SanPham> list = spService.getAll();
        dtm = new ClassTableModel().setTableHangHoa(list, listColumn);
        table = new JTable(dtm);
        sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);

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
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
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
        for (int i = 0; i < listColumn.length; i++) {
            if (i == 0) {
                table.getColumnModel().getColumn(i).setPreferredWidth(50);
            } else if (i == 2 || i == 4) {
                table.getColumnModel().getColumn(i).setPreferredWidth(200);
            } else {
                table.getColumnModel().getColumn(i).setPreferredWidth(100);
            }
        }
    }

    public void setEvent() {
        jbtnShowAll.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setDataToTable();
            }

        });

    }

}
