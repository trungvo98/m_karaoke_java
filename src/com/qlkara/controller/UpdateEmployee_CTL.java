package com.qlkara.controller;

import com.qlkara.model.NhanVien;
import com.qlkara.service.INhanVienService;
import com.qlkara.service.NhanVienService;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author trung98
 */
public class UpdateEmployee_CTL {

    private JButton jbtnSave;
    private JButton jbtnCancel;
    private JTextField jtfMaNV;
    private JTextField jtfHoTen;
    private JTextField jtfSdt;
    private JDateChooser jdcNgsinh;
    private JDateChooser jdcNgvl;
    private JTextArea jtaDiachi;
    private JComboBox jcbTinhtrang;
    private JRadioButton jrdNam;
    private JRadioButton jrdNu;
    private NhanVienService nvService = null;
    private JFrame jFrame;
    private JLabel jlbMess;

    public UpdateEmployee_CTL(JButton btnSave, JButton btnCancel, JTextField jtfMaNV, JTextField jtfHoTen, JTextField jtfSdt, JDateChooser jdcNgsinh, JDateChooser jdcNgvl, JTextArea jtaDiachi, JComboBox jcbTinhtrang, JRadioButton jrdNam, JRadioButton jrdNu, JFrame jFrame, JLabel jlbMess) {
        this.jbtnSave = btnSave;
        this.jbtnCancel = btnCancel;
        this.jtfMaNV = jtfMaNV;
        this.jtfHoTen = jtfHoTen;
        this.jtfSdt = jtfSdt;
        this.jdcNgsinh = jdcNgsinh;
        this.jdcNgvl = jdcNgvl;
        this.jtaDiachi = jtaDiachi;
        this.jcbTinhtrang = jcbTinhtrang;
        this.jrdNam = jrdNam;
        this.jrdNu = jrdNu;
        this.jFrame = jFrame;
        this.jlbMess = jlbMess;
        nvService = new INhanVienService();
    }

    public void setData(NhanVien nv) {
        jtfMaNV.setText(nv.getManv());
        jtfHoTen.setText(nv.getTennv());
        jdcNgsinh.setDate(nv.getNgsinh());
        jdcNgvl.setDate(nv.getNgvl());
        if (nv.getGioitinh()) {
            jrdNam.setSelected(true);
        } else {
            jrdNu.setSelected(true);
        }
        jtfSdt.setText(nv.getSdt());
        jtaDiachi.setText(nv.getDiachi());
        if (nv.getTrangthai()) {
            jcbTinhtrang.setSelectedIndex(0);
        } else {
            jcbTinhtrang.setSelectedIndex(1);
        }
    }

    public void setEvent() {
        jbtnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                NhanVien nv = new NhanVien();
                nv.setManv(jtfMaNV.getText());
                nv.setTennv(jtfHoTen.getText());
                nv.setNgsinh(covertDateToDateSql(jdcNgsinh.getDate()));
                if (jrdNam.isSelected()) {
                    nv.setGioitinh(true);
                } else {
                    nv.setGioitinh(false);
                }
                nv.setNgvl(covertDateToDateSql(jdcNgvl.getDate()));
                nv.setSdt(jtfSdt.getText());
                nv.setDiachi(jtaDiachi.getText());
                if (jcbTinhtrang.getSelectedIndex() == 0) {
                    nv.setTrangthai(true);
                } else {
                    nv.setTrangthai(false);
                }
                if (showDialog()) {
                    int result = nvService.update(nv);
                    if (result != -1) {
                        JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
                    }
                }
            }

        });
        jbtnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jFrame.setVisible(false);
            }

        });

    }

    public java.sql.Date covertDateToDateSql(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }

    public boolean showDialog() {
        int result = JOptionPane.showConfirmDialog(null, "Bạn muốn cập nhật dữ liệu không", "Thông báo", JOptionPane.YES_NO_OPTION);
        return result == JOptionPane.YES_OPTION;
    }

}
