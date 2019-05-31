package com.qlkara.controller;

import com.qlkara.dao.DanhMucDAO;
import com.qlkara.dao.DonViTinhDAO;
import com.qlkara.model.SanPham;
import com.qlkara.service.ISanPhamService;
import com.qlkara.service.SanPhamService;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateProduct_CTL {

    private JButton jbtnSave;
    private JButton jbtnCancel;
    private JTextField jtfID;
    private JTextField jtfTensp;
    private JTextField jtfGiaban;
    private JTextField jtfGiavon;
    private JComboBox jcbDvt;
    private JComboBox jcbLoaisp;
    private JTextField jtfslt;
    private DefaultComboBoxModel dcbmDm;
    private DefaultComboBoxModel dcbmDvt;
    private DonViTinhDAO dvtDAO = null;
    private DanhMucDAO dmDAO = null;
    private JFrame jfrPro;
    private SanPhamService spSerice = null;
    private JLabel jlbMess;

    public UpdateProduct_CTL(JButton jbtnSave, JButton jbtnCancel, JTextField jtfID, JTextField jtfTensp, JTextField jtfGiaban, JTextField jtfGiavon, JComboBox jcbDvt, JComboBox jcbLoaisp, JTextField jtfslt, JFrame jfrPro, JLabel jlbMess) {
        this.jbtnSave = jbtnSave;
        this.jbtnCancel = jbtnCancel;
        this.jtfID = jtfID;
        this.jtfTensp = jtfTensp;
        this.jtfGiaban = jtfGiaban;
        this.jtfGiavon = jtfGiavon;
        this.jcbDvt = jcbDvt;
        this.jcbLoaisp = jcbLoaisp;
        this.jtfslt = jtfslt;

        this.jfrPro = jfrPro;
        this.jlbMess = jlbMess;
        spSerice=new ISanPhamService();
    }

    public void setData(SanPham sp) {
        jtfID.setText(sp.getMasp());
        jtfTensp.setText(sp.getTensp());
        jtfGiaban.setText(Integer.toString(sp.getGiaban()));
        jtfGiavon.setText(Integer.toString(sp.getGiavon()));
        /* if (sp.getMadvt().equalsIgnoreCase("DVT001")) {
            jcbDvt.setSelectedItem("lon");
        } else if (sp.getMadvt().equalsIgnoreCase("DVT002")) {
            jcbDvt.setSelectedIndex(1);
        }

        if (sp.getMadm().equalsIgnoreCase("DM001")) {
            jcbLoaisp.setSelectedIndex(0);
        } else if (sp.getMadvt().equalsIgnoreCase("DM002")) {
            jcbLoaisp.setSelectedIndex(1);
        }*/
        jtfslt.setText(Integer.toString(sp.getSoluongton()));
    }

    public void setEvent() {
        jbtnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SanPham sp = new SanPham();
                sp.setMasp(jtfID.getText());
                sp.setTensp(jtfTensp.getText());
                sp.setGiavon(Integer.parseInt(jtfGiavon.getText()));
                sp.setGiaban(Integer.parseInt(jtfGiaban.getText()));
                sp.setSoluongton(Integer.parseInt(jtfslt.getText()));
                 Date date = new Date(System.currentTimeMillis());
                sp.setNgayUpdate(date);
                int result = JOptionPane.showConfirmDialog(null, "Bạn muốn cập nhật dữ liệu không", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    System.out.println(spSerice.update(sp));
                    if (spSerice.update(sp) != -1) {
                        JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
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
                jfrPro.setVisible(false);
            }

        }
        );

    }

}
