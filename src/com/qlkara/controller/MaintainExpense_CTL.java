package com.qlkara.controller;

import com.qlkara.model.PhieuChi;
import com.qlkara.model.PhieuThu;
import com.qlkara.service.IPhieuChiService;
import com.qlkara.service.IPhieuThuService;
import com.qlkara.service.PhieuChiService;
import com.qlkara.service.PhieuThuService;
import com.qlkara.utilities.ClassTableModel;
import com.qlkara.view.PaymentVoucher;
import com.qlkara.view.ReceiptVoucher;
import com.toedter.calendar.JDateChooser;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class MaintainExpense_CTL {

    private JTextField jtfSearchByID;
    private JButton jbtnPhieuthu;
    private JButton jbtnPhieuchi;
    private JPanel jpnView;
    private JLabel jlbTongthu;
    private JLabel jlbTongchi;
    private JLabel jlbTonquy;
    private JRadioButton jrdTatca;
    private JRadioButton jrdThu;
    private JRadioButton jrdChi;
    private JRadioButton jrdAllTime;
    private JRadioButton jrdToday;
    private JRadioButton jrd7dayago;
    private JRadioButton jrdMonth;
    private JRadioButton jrdKhac;
    private JTable table;
    private JDateChooser jdcStart;
    private JDateChooser jdcEnd;
    private JButton jbtnXem;

    private String[] listColumns = {"STT", "Mã phiếu", "Người nộp/nhận", "Loại phiếu", "Lý do", "Ngày giao dịch", "Giá trị"};
    private PhieuThuService ptService = null;
    private PhieuChiService pcService = null;
    private TableRowSorter<TableModel> sorter = null;
    private DefaultTableModel dtm = null;

    public MaintainExpense_CTL(JButton jbtnXem, JDateChooser jdcStart, JDateChooser jdcEnd, JRadioButton jrdTong, JRadioButton jrdThu, JRadioButton jrdChi, JRadioButton jrdAllTime, JRadioButton jrdToday, JRadioButton jrd7, JRadioButton jrdMonth, JRadioButton jrdKhac, JLabel jlbThu, JLabel jlbChi, JLabel jlbquy, JTextField jtfSearchByID, JButton jbtnPhieuthu, JButton jbtnPhieuchi, JPanel jpnView) {
        this.jbtnXem = jbtnXem;
        this.jdcStart = jdcStart;
        this.jdcEnd = jdcEnd;
        this.jrdAllTime = jrdAllTime;
        this.jrdToday = jrdToday;
        this.jrd7dayago = jrd7;
        this.jrdMonth = jrdMonth;
        this.jrdKhac = jrdKhac;
        this.jrdTatca = jrdTong;
        this.jrdThu = jrdThu;
        this.jrdChi = jrdChi;
        this.jlbTongthu = jlbThu;
        this.jlbTongchi = jlbChi;
        this.jlbTonquy = jlbquy;
        this.jtfSearchByID = jtfSearchByID;
        this.jbtnPhieuthu = jbtnPhieuthu;
        this.jbtnPhieuchi = jbtnPhieuchi;
        this.jpnView = jpnView;
        ptService = new IPhieuThuService();
        pcService = new IPhieuChiService();

    }

    public void setDataToLabel() {

        jlbTongchi.setText(getTongchi() + "");
        jlbTongthu.setText(getTongthu() + "");
        jlbTonquy.setText(getTongthu() + "");
        String str = pcService.getMaphieuTop1();
        String str2 = ptService.getMaphieuTop1();
    }

    public void setDataToTable(int id) {
        ArrayList<PhieuThu> listThu = ptService.getAll();
        ArrayList<PhieuChi> listChi = pcService.getAll();
        dtm = new ClassTableModel().setTableThuChi(listThu, listChi, listColumns, id);
        jtfSearchByID.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearchByID.getText();
                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearchByID.getText();
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

        table = new JTable(dtm);
        sorter = new TableRowSorter<>(dtm);
        table.setRowSorter(sorter);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(45);
        table.validate();
        table.repaint();
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        for (int i = 0; i < listColumns.length; i++) {
            if (i == 0) {
                table.getColumnModel().getColumn(i).setPreferredWidth(40);
            } else if (i == 2) {
                table.getColumnModel().getColumn(i).setPreferredWidth(150);
            } else if (i == 4) {
                table.getColumnModel().getColumn(i).setPreferredWidth(150);
            } else if (i == 7) {
                table.getColumnModel().getColumn(i).setPreferredWidth(170);
            } else {
                table.getColumnModel().getColumn(i).setPreferredWidth(100);
            }
        }

        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();

    }

    public int getTongthu() {
        return ptService.getTongthu();
    }

    public int getTongchi() {
        return pcService.getTongchi();
    }

    public void setEvent() {
        jrdTatca.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                setDataToTable(1);
                jlbTongchi.setText(getTongchi() + "");
                jlbTongthu.setText(getTongthu() + "");
            }
        });
        jrdThu.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                setDataToTable(2);
                jlbTongthu.setText(getTongthu() + "");
                jlbTongchi.setText(0 + "");
            }
        });
        jrdChi.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                setDataToTable(3);
                jlbTongchi.setText(getTongchi() + "");
                jlbTongthu.setText(0 + "");
            }
        });

        jbtnPhieuthu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReceiptVoucher jfrReceiptVoucher = new ReceiptVoucher();
                jfrReceiptVoucher.setVisible(true);
                jfrReceiptVoucher.setLocationRelativeTo(null);
                jfrReceiptVoucher.setDefaultCloseOperation(2);
                jfrReceiptVoucher.setTitle("Thêm phiếu thu");

            }
        });
        jbtnPhieuchi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PaymentVoucher jfrPaymentVoucher = new PaymentVoucher();
                jfrPaymentVoucher.setVisible(true);
                jfrPaymentVoucher.setLocationRelativeTo(null);
                jfrPaymentVoucher.setDefaultCloseOperation(2);
                jfrPaymentVoucher.setTitle("Thêm phiếu chi");
            }

        });

        jtfSearchByID.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jtfSearchByID.setText("");

            }

        });

        jrdAllTime.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                setDataToTable(1);
                hide();
            }
        });
        jrdToday.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Date date = new Date(System.currentTimeMillis());
                System.out.println(date);
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, - 6);
                date = covertDateToDateSql(c.getTime());

                //System.out.println(date);
                Date d1 = (Date) dtm.getValueAt(0, 5);
                Date d2 = (Date) dtm.getValueAt(dtm.getRowCount() - 2, 5);

                // System.out.println(d1);
                // System.out.println(d2);
                RowFilter<TableModel, Integer> low = RowFilter.dateFilter(RowFilter.ComparisonType.BEFORE, date, 5);
                //RowFilter<TableModel, Integer> high = RowFilter.dateFilter(RowFilter.ComparisonType.BEFORE, d2, 5);
                //RowFilter<TableModel,Integer> today1 = RowFilter.dateFilter(ComparisonType.EQUAL, low,5);

                List<RowFilter<TableModel, Integer>> filters = Arrays.asList(low);
                final RowFilter<TableModel, Integer> filter = RowFilter.andFilter(filters);
                if (sorter.getRowFilter() != null) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(filter);
                }
                hide();

            }
        });
        jrd7dayago.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Date date = new Date(System.currentTimeMillis());
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, -7);
                date = covertDateToDateSql(c.getTime());
                RowFilter<TableModel, Integer> sevendayago = RowFilter.dateFilter(RowFilter.ComparisonType.AFTER, date);
                List<RowFilter<TableModel, Integer>> filters = Arrays.asList(sevendayago);
                RowFilter<TableModel, Integer> filter = RowFilter.andFilter(filters);
                if (sorter.getRowFilter() != null) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(filter);

                }
                java.util.Date d1 = (java.util.Date) dtm.getValueAt(0, 5);
                java.util.Date d2 = (java.util.Date) dtm.getValueAt(dtm.getRowCount() - 2, 5);
                //System.out.println(d1);
                // System.out.println(d2);
                java.util.Date today = new java.util.Date();
                hide();
            }
        });

        jrdMonth.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                long millis = System.currentTimeMillis();
                java.sql.Date date = new java.sql.Date(millis);
                //System.out.println(date);
                date.getMonth();
                java.util.Date d1 = (java.util.Date) dtm.getValueAt(0, 5);
                java.util.Date d2 = (java.util.Date) dtm.getValueAt(4, 5);
                RowFilter<TableModel, Integer> today = RowFilter.dateFilter(RowFilter.ComparisonType.BEFORE, date, 5);
                RowFilter<TableModel, Integer> high = RowFilter.dateFilter(RowFilter.ComparisonType.AFTER, date, 5);
                List<RowFilter<TableModel, Integer>> filters = Arrays.asList(today, high);
                final RowFilter<TableModel, Integer> filter = RowFilter.andFilter(filters);
                if (sorter.getRowFilter() != null) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(filter);
                }
                hide();

            }
        });
        jrdKhac.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                display();
            }
        });
        if (!jrdKhac.isSelected()) {
            hide();
        }
        jbtnXem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                java.util.Date d1 = jdcStart.getDate();
                java.util.Date d2 = jdcEnd.getDate();
                //RowFilter<TableModel, Integer> equal = RowFilter.dateFilter(ComparisonType.EQUAL, d1);
                RowFilter<TableModel, Integer> low = RowFilter.dateFilter(ComparisonType.AFTER, d1);
                RowFilter<TableModel, Integer> high = RowFilter.dateFilter(ComparisonType.BEFORE, d2);
                List<RowFilter<TableModel, Integer>> filters = Arrays.asList(low, high);
                RowFilter<TableModel, Integer> filter = RowFilter.andFilter(filters);
                if (sorter.getRowFilter() != null) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(filter);
                }
            }
        });

    }

    public void hide() {
        jdcStart.setVisible(false);
        jdcEnd.setVisible(false);
        jbtnXem.setVisible(false);
    }

    public void display() {
        jdcStart.setVisible(true);
        jdcEnd.setVisible(true);
        jbtnXem.setVisible(true);
    }

    public void filter(Date startDate, Date endDate) {
        List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(2);
        filters.add(RowFilter.dateFilter(ComparisonType.AFTER, startDate));
        filters.add(RowFilter.dateFilter(ComparisonType.BEFORE, endDate));
        RowFilter<Object, Object> rf = RowFilter.andFilter(filters);
        sorter.setRowFilter(rf);
    }

    /*public java.util.Date CovertStringToDate(String dd) {
        try {
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dd);
        } catch (ParseException ex) {
            Logger.getLogger(MaintainExpense_CTL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;

    }*/
    public java.sql.Date covertDateToDateSql(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }
}
