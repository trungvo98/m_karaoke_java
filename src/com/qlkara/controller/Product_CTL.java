package com.qlkara.controller;

import com.qlkara.dao.DanhMucDAO;
import com.qlkara.dao.DonViTinhDAO;
import com.qlkara.dao.IDanhMucDAO;
import com.qlkara.dao.IDonViTinhDAO;
import com.qlkara.model.DanhMuc;
import com.qlkara.model.DonViTinh;
import com.qlkara.model.NhanVien;
import com.qlkara.model.SanPham;
import com.qlkara.service.ISanPhamService;
import com.qlkara.service.SanPhamService;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author trung98
 */
public class Product_CTL {

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
    Vector vector = null;

    public Product_CTL(JLabel jlbMess, JButton jbtnSave, JButton jbtnCancel, JTextField jtfID, JTextField jtfTensp, JTextField jtfGiaban, JTextField jtfGiavon, JComboBox jcbDvt, JComboBox jcbLoaisp, JTextField jtfslt, JFrame jfrPro) {
        this.jlbMess = jlbMess;
        this.jbtnSave = jbtnSave;
        this.jbtnCancel = jbtnCancel;
        this.jtfID = jtfID;
        this.jtfTensp = jtfTensp;
        this.jtfGiaban = jtfGiaban;
        this.jtfGiavon = jtfGiavon;
        this.jcbDvt = jcbDvt;
        this.jcbLoaisp = jcbLoaisp;
        this.jtfslt = jtfslt;
        dcbmDm = new DefaultComboBoxModel();
        dcbmDvt = new DefaultComboBoxModel();
        this.jfrPro = jfrPro;
        spSerice = new ISanPhamService();
    }

    public void setDataToJFrame(SanPham sp) {
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

    public void setData() {
        dvtDAO = new IDonViTinhDAO();
        dmDAO = new IDanhMucDAO();
        ArrayList<DonViTinh> listDVT = dvtDAO.getAll();
        ArrayList<DanhMuc> listDM = dmDAO.getAll();
        for (DanhMuc dm : listDM) {
            dcbmDm.addElement(dm.getTendm());
        }
        jcbLoaisp.setModel(dcbmDm);
        for (DonViTinh dvt : listDVT) {
            dcbmDvt.addElement(dvt.getTendvt());
        }
        jcbDvt.setModel(dcbmDvt);
    }

    public void setEvent() {
        jbtnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtfTensp.getText().length() == 0 || jtfGiaban.getText().length() == 0 || jtfGiavon.getText().length() == 0) {
                    jlbMess.setForeground(Color.red);
                } else {
                    vector = spSerice.getID();
                    SanPham sp = new SanPham();
                    Random rd = new Random();
                    String masp = "SP" + (+100000 + rd.nextInt(900000));
                    while (vector.contains(masp)) {
                        masp = "SP" + (+100000 + rd.nextInt(900000));
                    }
                    sp.setMasp(masp);
                    sp.setTensp(jtfTensp.getText());
                    String madm = dmDAO.getIdByName(jcbLoaisp.getSelectedItem().toString());
                    String dvt = dvtDAO.getIdByName(jcbDvt.getSelectedItem().toString());
                    sp.setMadm(madm);
                    sp.setMadvt(dvt);
                    sp.setGiavon(Integer.parseInt(jtfGiavon.getText()));
                    sp.setGiaban(Integer.parseInt(jtfGiaban.getText()));
                    sp.setSoluongton(Integer.parseInt(jtfslt.getText()));
                    Date date = new Date(System.currentTimeMillis());
                    sp.setNgayAdd(date);
                    sp.setNgayUpdate(date);
                    int result = spSerice.add(sp);
                    if (result != -1) {
                        JOptionPane.showMessageDialog(null, "Thêm thành công");
                    } else {
                        JOptionPane.showMessageDialog(null, "Thêm thất bại.Có lỗi xảy ra!");
                    }
                }
            }

        });
        jbtnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jfrPro.setVisible(false);
            }
        });
    }

}
