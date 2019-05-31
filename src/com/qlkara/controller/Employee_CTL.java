package com.qlkara.controller;

import com.qlkara.model.NhanVien;
import com.qlkara.service.INhanVienService;
import com.qlkara.service.NhanVienService;
import com.qlkara.utilities.CheckData;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.Random;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Employee_CTL {

    private JButton btnSave;
    private JButton btnCancel;
    private JTextField jtfMaNV;
    private JTextField jtfHoTen;
    private JTextField jtfSdt;
    private JDateChooser jdcNgsinh;
    private JDateChooser jdcNgvl;
    private JTextArea jtaDiachi;
    private JComboBox jcbTinhtrang;
    private JRadioButton jrdNam;
    private JRadioButton jrdNu;
    private NhanVien nv = null;
    private NhanVienService nvService = null;
    private JFrame jFrame;
    private JLabel jlbMess;
    private static Vector vector = null;

    public Employee_CTL(JFrame jf, JButton btnSave, JButton btnCancel, JTextField jtfMaNV, JTextField jtfHoTen, JTextField jtfSdt, JDateChooser jdcNgsinh, JDateChooser jdcNgvl, JTextArea jtaDiachi, JComboBox jcbTinhtrang, JRadioButton jrdNam, JRadioButton jrdNu, JLabel jlbMes) {

        this.jFrame = jf;
        this.btnSave = btnSave;
        this.btnCancel = btnCancel;
        this.jtfMaNV = jtfMaNV;
        this.jtfHoTen = jtfHoTen;
        this.jtfSdt = jtfSdt;
        this.jdcNgsinh = jdcNgsinh;
        this.jdcNgvl = jdcNgvl;
        this.jtaDiachi = jtaDiachi;
        this.jcbTinhtrang = jcbTinhtrang;
        this.jrdNam = jrdNam;
        this.jrdNu = jrdNu;
        this.nvService = new INhanVienService();
        this.jlbMess = jlbMes;
    }

    public boolean checkData() {
        CheckData check = new CheckData();
        if (!check.checkName(jtfHoTen.getText())) {
            JOptionPane.showMessageDialog(null, "Họ tên không hợp lệ");
            jtfHoTen.requestFocus();
            return false;
        } else if (!check.checkPhone(jtfSdt.getText())) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
            jtfSdt.requestFocus();
            return false;
        } else if (!check.checkDate(covertDateToDateSql(jdcNgsinh.getDate()))) {
            JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ");
            jdcNgsinh.requestFocus();
            return false;
        } else if (!check.checkDate(covertDateToDateSql(jdcNgvl.getDate()))) {
            JOptionPane.showMessageDialog(null, "Ngày vào làm không hợp lệ");
            jdcNgvl.requestFocus();
            return false;
        } else if (!check.checkAddress(jtaDiachi.getText())) {
            JOptionPane.showMessageDialog(null, "Địa chỉ không hợp lệ");
            jtaDiachi.requestFocus();
            return false;
        }
        return true;
    }

    public void setEvent() {
        btnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vector = nvService.getID();
                NhanVien nv = new NhanVien();
                Random rd = new Random();
                String manv = "NV" + (+100000 + rd.nextInt(900000));
                while (vector.contains(manv)) {
                    manv = "NV" + (+100000 + rd.nextInt(900000));
                }
                nv.setManv(manv);
                nv.setTennv(jtfHoTen.getText());
                nv.setNgsinh(covertDateToDateSql(jdcNgsinh.getDate()));
                nv.setGioitinh(jrdNam.isSelected());
                nv.setNgvl(covertDateToDateSql(jdcNgvl.getDate()));
                nv.setSdt(jtfSdt.getText());
                nv.setDiachi(jtaDiachi.getText());
                nv.setTrangthai(jcbTinhtrang.getSelectedIndex() == 0 ? true : false);

                int result = nvService.add(nv);
                if (result != 0) {
                    JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm nhân viên thất bại");
                }
            }
        });
        btnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jFrame.setVisible(false);
            }
        });
    }

    public java.sql.Date covertDateToDateSql(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }

}
