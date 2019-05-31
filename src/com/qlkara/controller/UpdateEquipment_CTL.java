package com.qlkara.controller;

import com.qlkara.model.TrangThietBi;
import com.qlkara.service.ITrangThietBiService;
import com.qlkara.service.TrangThietBiService;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateEquipment_CTL {

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

    public UpdateEquipment_CTL(JButton jbtnSave, JButton jbtnCancel, JTextField jtfID, JTextField jtfTentb, JTextField jtfGiamua, JTextField jtfNuocsx, JTextField jtfslt, JLabel jlbMess, JFrame jfrEqui) {
        this.jbtnSave = jbtnSave;
        this.jbtnCancel = jbtnCancel;
        this.jtfID = jtfID;
        this.jtfTentb = jtfTentb;
        this.jtfGiamua = jtfGiamua;
        this.jtfNuocsx = jtfNuocsx;
        this.jtfslt = jtfslt;
        this.jlbMess = jlbMess;
        this.jfrEqui = jfrEqui;
        ttbService = new ITrangThietBiService();
    }

    public void setData(TrangThietBi ttb) {
        jtfID.setText(ttb.getMatb());
        jtfTentb.setText(ttb.getTentb());
        jtfGiamua.setText(Integer.toString(ttb.getGiamua()));
        jtfNuocsx.setText(ttb.getNuocsx());
        jtfslt.setText(Integer.toString(ttb.getSoluongton()));
    }

    public void setEvent() {
        jbtnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TrangThietBi ttb = new TrangThietBi();
                ttb.setMatb(jtfID.getText());
                ttb.setTentb(jtfTentb.getText());
                ttb.setGiamua(Integer.parseInt(jtfGiamua.getText()));
                ttb.setNuocsx(jtfNuocsx.getText());
                ttb.setTentb(jtfTentb.getText());
                ttb.setSoluongton(Integer.parseInt(jtfslt.getText()));
                Date date = new Date(System.currentTimeMillis());
                ttb.setNgayUpdate(date);
                int result = JOptionPane.showConfirmDialog(null, "Bạn muốn cập nhật dữ liệu không ?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    if (ttbService.update(ttb) != -1) {
                        JOptionPane.showMessageDialog(null, "Cập nhật trang thiết bị thành công!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cập nhật thất bại!");
                    }
                }
            }
        });
        jbtnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e
            ) {
                jfrEqui.setVisible(false);
            }

        }
        );

    }

}
