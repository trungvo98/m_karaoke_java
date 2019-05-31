package com.qlkara.controller;

import com.qlkara.bean.Category_Bean;
import com.qlkara.view.Dashboard_View;
import com.qlkara.view.MaintainEmployee_View;
import com.qlkara.view.MaintainExpense_View;
import com.qlkara.view.MaintainGoods_View;
import com.qlkara.view.MaintainInventory_View;
import com.qlkara.view.Statistic_View;
import com.qlkara.view.MaintainSchedule_View;
import com.qlkara.view.MaintainSingingRoom_View;
import com.qlkara.view.Report_View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;
public class ChuyenManHinh_CTL {

    private JPanel root;
    private String kindSelected = "";
    private ArrayList<Category_Bean> listItem = null;

    public ChuyenManHinh_CTL(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnCategory, JLabel jlbCategory) {
        kindSelected = "Dashboard";
        jpnCategory.setBackground(new Color(96, 100, 191));
        jlbCategory.setBackground(new Color(96, 100, 191));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new Dashboard_View());
        root.validate();
        root.repaint();

    }

    public void setEvent(ArrayList<Category_Bean> listItem) {
        this.listItem = listItem;
        for (Category_Bean item : listItem) {
            item.getJpn().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));

        }

    }
    public void setDashboard(JPanel jpn, JLabel jlb) {

    }
    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "Dashboard":
                    node = new Dashboard_View();
                    break;
                case "MaintainRoom":
                    node = new MaintainSingingRoom_View();
                    break;
                case "MaintainEmployee":
                    node = new MaintainEmployee_View();
                    break;
                case "MaintainSchedule":
                    node = new MaintainSchedule_View();
                    break;
                case "MaintainInventory":
                    node = new MaintainInventory_View();
                    break;
                case "MaintainExpense":
                    node = new MaintainExpense_View();
                    break;
                case "MaintainGoods":
                    node = new MaintainGoods_View();
                    break;
                case "Statistic":
                    node = new Statistic_View();
                    break;
                case "Report":
                    node = new Report_View();
                    break;
                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);

        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(30, 144, 255));
                jlbItem.setBackground(new Color(30, 144, 255));
            }
        }

    }

    private void setChangeBackground(String kind) {
        for (Category_Bean item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(96, 100, 191));
                item.getJlb().setBackground(new Color(96, 100, 191));
            } else {
                item.getJpn().setBackground(new Color(30, 144, 255));
                item.getJlb().setBackground(new Color(30, 144, 255));
            }
        }

    }

}
