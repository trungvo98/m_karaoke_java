package com.qlkara.controller;

import com.qlkara.bean.DoanhThu_Bean;
import com.qlkara.service.IThongKeService;
import com.qlkara.service.ThongKeService;
import com.qlkara.view.SelectDate;
import com.toedter.calendar.JDateChooser;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class Dashboard_CTL {

    private JLabel jlbDonhang;
    private JLabel jlbTienmat;
    private JLabel jlbDoanhthu;
    private JLabel jlbPhongsudung;
    private JLabel jlbGhino;
    private JLabel jlbTinnhan;
    private JPanel jpnDoanhthu;
    private ThongKeService tkService = null;
    private JComboBox jcbSelect;
    private JDateChooser jdcTungay;
    private JDateChooser jdcDenngay;
    private JButton jbtnSave;
    private JButton jbtnExit;

    public Dashboard_CTL(JPanel jpnDoanhthu, JLabel jlbDh, JLabel jlbTm, JLabel jlbDt, JLabel jlbPsd, JLabel jlbGn, JLabel jlbTn, JComboBox jcb) {
        this.jcbSelect = jcb;
        this.jpnDoanhthu = jpnDoanhthu;
        this.jlbDonhang = jlbDh;
        this.jlbTienmat = jlbTm;
        this.jlbDoanhthu = jlbDt;
        this.jlbPhongsudung = jlbPsd;
        this.jlbGhino = jlbGn;
        this.jlbTinnhan = jlbTn;
        tkService = new IThongKeService();
    }

    public void setData() {
        Date d1 = new Date(System.currentTimeMillis());
        Calendar c = Calendar.getInstance();
        c.setTime(d1);
        c.add(Calendar.DATE, - 7);
        Date d2 = covertDateToDateSql(c.getTime());
        setDataToDoanhThu(jpnDoanhthu, d1, d2);
    }

    public void setDataToDoanhThu(JPanel jpnChart, Date d1, Date d2) {

        ArrayList<DoanhThu_Bean> list = tkService.list_bySelect(d2, d1);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (list != null) {
            for (DoanhThu_Bean item : list) {
                dataset.addValue(item.getDoanhthu(), "Tp Hồ Chí Minh", item.getNgay() + "/" + item.getThang());
            }
        }
        JFreeChart barChart = ChartFactory.createBarChart("DOANH THU CỦA QUÁN KARAOKE", "", "Số tiên(VNĐ)", dataset);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnChart.getWidth(), 123));
        jpnChart.removeAll();
        jpnChart.setLayout(new CardLayout());
        jpnChart.add(chartPanel);
        jpnChart.validate();
        jpnChart.repaint();
    }

    public void setDataToDoanhThuthisMonth(JPanel jpnChart) {

        ArrayList<DoanhThu_Bean> list = tkService.list_bythisMonth();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (list != null) {
            for (DoanhThu_Bean item : list) {
                dataset.addValue(item.getDoanhthu(), "Tp Hồ Chí Minh", item.getNgay() + "/" + item.getThang());
            }
        }
        JFreeChart barChart = ChartFactory.createBarChart("DOANH THU CỦA QUÁN KARAOKE", "", "Số tiên(VNĐ)", dataset);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnChart.getWidth(), 123));
        jpnChart.removeAll();
        jpnChart.setLayout(new CardLayout());
        jpnChart.add(chartPanel);
        jpnChart.validate();
        jpnChart.repaint();
    }

    public void setEvent() {
        jcbSelect.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (jcbSelect.getSelectedIndex() == 0) {
                    Date d1 = new Date(System.currentTimeMillis());
                    Calendar c = Calendar.getInstance();
                    c.setTime(d1);
                    c.add(Calendar.DATE, - 7);
                    Date d2 = covertDateToDateSql(c.getTime());
                    setDataToDoanhThu(jpnDoanhthu, d1, d2);
                } else if (jcbSelect.getSelectedIndex() == 1) {
                    setDataToDoanhThuthisMonth(jpnDoanhthu);

                } else if (jcbSelect.getSelectedIndex() == 2) {
                    Date d1 = new Date(System.currentTimeMillis());
                    Calendar c = Calendar.getInstance();
                    c.setTime(d1);
                    c.add(Calendar.DATE, - 1);
                    Date d2 = covertDateToDateSql(c.getTime());
                    setDataToDoanhThu(jpnDoanhthu, d2, d2);
                } else if (jcbSelect.getSelectedIndex() == 3) {
                    Date d1 = new Date(System.currentTimeMillis());
                    setDataToDoanhThu(jpnDoanhthu, d1, d1);

                } else if (jcbSelect.getSelectedIndex() == 4) {
                    SelectDate jfrDate = new SelectDate(jdcTungay, jdcDenngay, jbtnSave, jbtnExit);
                    jfrDate.setTitle("Lựa chọn khác");
                    jfrDate.setVisible(true);
                    jfrDate.setLocationRelativeTo(null);

                    jbtnSave.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            Date d1 = covertDateToDateSql(jdcTungay.getDate());
                            Date d2 = covertDateToDateSql(jdcDenngay.getDate());
                            setDataToDoanhThu(jpnDoanhthu, d1, d2);
                        }
                    });

                }
            }
        });

    }

    public java.sql.Date covertDateToDateSql(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }

}
