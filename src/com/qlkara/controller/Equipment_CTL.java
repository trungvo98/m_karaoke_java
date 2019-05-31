package com.qlkara.controller;

import com.qlkara.model.TrangThietBi;
import com.qlkara.service.ITrangThietBiService;
import com.qlkara.service.TrangThietBiService;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.Random;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Equipment_CTL {

    private JButton jbtnSave;
    private JButton jbtnCancel;
    private JTextField jtfID;
    private JTextField jtfTentb;
    private JTextField jtfGiamua;
    private JTextField jtfNuocsx;
    private JTextField jtfslt;
    private JLabel jlbMess;
    private TrangThietBiService ttbService = null;
    private JFrame jfrEqui;
    private Vector vector = null;

    public Equipment_CTL(JFrame jfrEqui, JButton jbtnSave, JButton jbtnCancel, JTextField jtfID, JTextField jtfTentb, JTextField jtfGiamua, JTextField jtfNuocsx, JTextField jtfslt, JLabel jlbMess) {
        this.jfrEqui = jfrEqui;
        this.jbtnSave = jbtnSave;
        this.jbtnCancel = jbtnCancel;
        this.jtfID = jtfID;
        this.jtfTentb = jtfTentb;
        this.jtfGiamua = jtfGiamua;
        this.jtfNuocsx = jtfNuocsx;
        this.jtfslt = jtfslt;
        this.jlbMess = jlbMess;
        ttbService = new ITrangThietBiService();
    }

    public void setView() {
        jtfTentb.requestFocus();

    }

    public void setEvent() {
        jbtnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtfTentb.getText().length() == 0 || jtfGiamua.getText().length() == 0 || jtfNuocsx.getText().length() == 0) {
                    jlbMess.setForeground(Color.red);
                } else {
                    TrangThietBi ttb = new TrangThietBi();
                    vector = ttbService.getID();
                    Random rd = new Random();
                    String mattb = "TTB" + (+1000 + rd.nextInt(9000));
                    while (vector.contains(mattb)) {
                        mattb = "TTB" + (+1000 + rd.nextInt(9000));
                    }
                    ttb.setMatb(mattb);
                    ttb.setTentb(jtfTentb.getText());
                    ttb.setGiamua(Integer.parseInt(jtfGiamua.getText()));
                    ttb.setNuocsx(jtfNuocsx.getText());
                    ttb.setSoluongton(Integer.parseInt(jtfslt.getText()));
                    Date date = new Date(System.currentTimeMillis());
                    ttb.setNgayAdd(date);
                    ttb.setNgayUpdate(date);
                    boolean result = ttbService.add(ttb);
                    if (result) {
                        JOptionPane.showMessageDialog(null, "Thêm thiết bị thành công!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Thêm thất bại.Có lỗi xảy ra!");
                    }
                }
            }

        });
        jbtnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jfrEqui.setVisible(false);
            }
        });
    }

}
