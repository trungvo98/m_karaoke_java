package com.qlkara.controller;

import com.qlkara.model.PhieuThu;
import com.qlkara.service.IPhieuThuService;
import com.qlkara.service.PhieuThuService;
import com.qlkara.utilities.CovertDate;
import com.qlkara.view.ReceiptVoucher;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author trung98
 */
public class ReceiptVoucher_CTL {

    private JButton jbtnSave;
    private JButton jbtnCancel;
    private JTextField jtfMaphieu;
    private JTextField jtfNguoinop;
    private JTextField jtfGiatri;
    private JTextField jtfHangmuc;
    private JTextArea jtaGhichu;
    private JDateChooser jdcNgaygd;
    private JLabel jlbMess;
    private PhieuThuService ptService = null;
    private JFrame jfrRoot;

    public ReceiptVoucher_CTL(JButton jbtnSave, JButton jbtnCancel, JTextField jtfMaphieu, JTextField jtfNguoinop, JTextField jtfGiatri, JTextField jtfHangmuc, JTextArea jtaGhichu, JDateChooser jdcNgaygd, JLabel jlbMess, ReceiptVoucher jfReceiptVoucher) {
        this.jbtnSave = jbtnSave;
        this.jbtnCancel = jbtnCancel;
        this.jtfMaphieu = jtfMaphieu;
        this.jtfNguoinop = jtfNguoinop;
        this.jtfGiatri = jtfGiatri;
        this.jtfHangmuc = jtfHangmuc;
        this.jtaGhichu = jtaGhichu;
        this.jdcNgaygd = jdcNgaygd;
        this.jlbMess = jlbMess;
        ptService = new IPhieuThuService();
        this.jfrRoot = jfReceiptVoucher;
    }

    public int demChuso(int n) {
        int dem = 0;
        while (n != 0) {
            n = n / 10;
            dem++;
        }
        return dem;
    }
    public void resetForm() {
        jtfHangmuc.setText("");
        jtfGiatri.setText("");
        jtfNguoinop.setText("");
        jtaGhichu.setText("");
        jdcNgaygd.setDate(null);
    }
    public void setEvent() {
        jbtnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtfHangmuc.getText().length() == 0 || jtfNguoinop.getText().length() == 0 || jtfGiatri.getText().length() == 0 || jdcNgaygd.getDate() == null) {
                    jlbMess.setForeground(Color.red);
                } else {
                    PhieuThu pt = new PhieuThu();
                    String str = ptService.getMaphieuTop1();
                    int id = Integer.parseInt(str.substring(2, str.length()));
                    int newid = id + 1;
                    String maphieu = null;
                    if (demChuso(newid) == 1) {
                        maphieu = "PT00000" + newid;
                    } else if (demChuso(newid) == 2) {
                        maphieu = "PT0000" + newid;
                    } else if (demChuso(newid) == 3) {
                        maphieu = "PT000" + newid;
                    } else if (demChuso(newid) == 4) {
                        maphieu = "PT00" + newid;
                    } else if (demChuso(newid) == 5) {
                        maphieu = "PT0" + newid;
                    } else if (demChuso(newid) == 6) {
                        maphieu = "PT" + newid;
                    }
                    pt.setMaphieu(maphieu);
                    pt.setLoaiphieu(jtfHangmuc.getText());
                    pt.setNguoinop(jtfNguoinop.getText());
                    pt.setNgaygd(new CovertDate().covertDateToDateSql(jdcNgaygd.getDate()));
                    pt.setLydo(jtaGhichu.getText());
                    pt.setTrigia(Integer.parseInt(jtfGiatri.getText()));
                    boolean result = ptService.addReceipt(pt);
                    if (result) {
                        JOptionPane.showMessageDialog(null, "Thêm phiếu thu thành công!");
                        resetForm();
                    } else {
                        JOptionPane.showConfirmDialog(null, "Thêm thất bại");
                    }
                }
            }
        });
        jbtnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jfrRoot.setVisible(false);
            }
        });
    }
}
