/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlkara.utilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Chart {

    public JFreeChart createBarChart(String title, String axisLabelHoz, String axisLabelVet, CategoryDataset dataset) {
        JFreeChart barChart = ChartFactory.createBarChart(title, axisLabelHoz, axisLabelVet, dataset);
        return barChart;

    }
   

}
