package com.qlkara.controller;

import com.qlkara.bean.DoanhThuOfSanPham_Bean;
import com.qlkara.bean.DoanhThu_Bean;
import com.qlkara.bean.SanPhamBanChay_Bean;
import com.qlkara.service.IThongKeService;
import com.qlkara.service.ThongKeService;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author trung98
 */
public class Statistic_CTL {

    private ThongKeService tkService;

    public Statistic_CTL() {
        tkService = new IThongKeService();
    }

    public void setDataToJPanel_WaterTop(JPanel jpnChart) {
        ArrayList<SanPhamBanChay_Bean> list1 = tkService.getList("DM001");
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (list1 != null) {
            for (SanPhamBanChay_Bean item : list1) {
                dataset.addValue(item.getSoluong(), "Nước giải khát", item.getTensp());
            }
        }
        JFreeChart barChart = ChartFactory.createBarChart("NƯỚC GIẢI KHÁT BÁN CHẠY", "", "Số lượng(lon)", dataset);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnChart.getWidth(), 123));
        jpnChart.removeAll();
        jpnChart.setLayout(new CardLayout());
        jpnChart.add(chartPanel);
        jpnChart.validate();
        jpnChart.repaint();
    }

    public void setDataToJPanel_BreadTop(JPanel jpnChart) {
        ArrayList<SanPhamBanChay_Bean> list2 = tkService.getList("DM002");
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (list2 != null) {
            for (SanPhamBanChay_Bean item : list2) {
                dataset.addValue(item.getSoluong(), "Bánh", item.getTensp());
            }
        }
        JFreeChart barChart = ChartFactory.createBarChart("BÁNH BÁN CHẠY", "", "Số lượng(cái)", dataset);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnChart.getWidth(), 123));
        jpnChart.removeAll();
        jpnChart.setLayout(new CardLayout());
        jpnChart.add(chartPanel);
        jpnChart.validate();
        jpnChart.repaint();
    }

    public void setDataToJPanel_LoiNhuan1(JPanel jpnView3) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(2.0, "Doanh thu", "2015");
        dataset.addValue(3.6, "Doanh thu", "2016");
        dataset.addValue(4.6, "Doanh thu", "2017");
        dataset.addValue(4.2, "Doanh thu", "2018");
        dataset.addValue(5.6, "Doanh thu", "2019");
        dataset.addValue(6.9, "Doanh thu", "2020");

        dataset.addValue(2.1, "Lợi nhuận", "2015");
        dataset.addValue(4.1, "Lợi nhuận", "2016");
        dataset.addValue(3.5, "Lợi nhuận", "2017");
        dataset.addValue(5.6, "Lợi nhuận", "2018");
        dataset.addValue(4.5, "Lợi nhuận", "2019");
        dataset.addValue(6.9, "Lợi nhuận", "2020");
        JFreeChart chart = ChartFactory.createLineChart("Biểu đồ lợi nhuận theo tốc độ tăng trưởng".toUpperCase(), "Năm", "Số (%)tăng trưởng", dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(jpnView3.getWidth(), 123));
        jpnView3.removeAll();
        jpnView3.setLayout(new CardLayout());
        jpnView3.add(chartPanel);
        jpnView3.validate();
        jpnView3.repaint();

    }

    public void setDataToJPanel_LoiNhuan2(JPanel jpnView3) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<DoanhThu_Bean> list = tkService.list_byYear();
        for (DoanhThu_Bean item : list) {
            /*int doanhthu = item.getDoanhthu();
            String str = Integer.toString(doanhthu);

            String str2 = str.substring(0, str.length() - 3); 
            int result = Integer.parseInt(str2);*/
            dataset.addValue(item.getDoanhthu(), "Doanh thu", Integer.toString(item.getNam()));
        }
        dataset.addValue(200000, "Lợi nhuận", "2015");
        dataset.addValue(600000, "Lợi nhuận", "2016");
        dataset.addValue(400000, "Lợi nhuận", "2017");
        dataset.addValue(500000, "Lợi nhuận", "2018");
        dataset.addValue(1100000, "Lợi nhuận", "2019");
        dataset.addValue(1300000, "Lợi nhuận", "2020");
        JFreeChart chart = ChartFactory.createBarChart("Biểu đồ lợi nhuận theo số tiền".toUpperCase(), "", "Số tiền(VNĐ)", dataset, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(jpnView3.getWidth(), 123));
        jpnView3.removeAll();
        jpnView3.setLayout(new CardLayout());
        jpnView3.add(chartPanel);
        jpnView3.validate();
        jpnView3.repaint();

    }

    public void setDataToDoanhThu(JPanel jpnChart) {
        ArrayList<DoanhThu_Bean> list = tkService.list_byYear();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (list != null) {
            for (DoanhThu_Bean item : list) {
                dataset.addValue(item.getDoanhthu(), "Tp Hồ Chí Minh", item.getNam() + "");
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

    public void setDataToDoanhThuByMonth(JPanel jpnChart, int year) {
        ArrayList<DoanhThu_Bean> list = tkService.list_byMonthYear(year);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (list != null) {
            for (DoanhThu_Bean item : list) {
                dataset.addValue(item.getDoanhthu(), "Tp Hồ Chí Minh", item.getThang() + "/"+year);
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

}
