package com.qlkara.controller;

import com.qlkara.model.PhieuChi;
import com.qlkara.service.IPhieuChiService;
import com.qlkara.service.PhieuChiService;
import com.qlkara.utilities.CovertDate;
import com.qlkara.view.PaymentVoucher;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
public class PaymentVoucher_CTL {
    
    private JButton jbtnSave;
    private JButton jbtnCancel;
    private JTextField jtfMaphieu;
    private JTextField jtfNguonhan;
    private JTextField jtfHangmuc;
    private JTextField jtfGiatri;
    private JDateChooser jdcNgaygd;
    private JTextArea jtaGhichu;
    private JLabel jlbMess;
    private PhieuChiService pcService = null;
    private JFrame jfrRoot;
    
    public PaymentVoucher_CTL(JButton jbtnSave, JButton jbtnCancel, JTextField jtfMaphieu, JTextField jtfNguonhan, JTextField jtfHangmuc, JTextField jtfGiatri, JDateChooser jdcNgaygd, JTextArea jtaGhichu, JLabel jlbMess, PaymentVoucher jfrPaymentVoucher) {
        this.jbtnSave = jbtnSave;
        this.jbtnCancel = jbtnCancel;
        this.jtfMaphieu = jtfMaphieu;
        this.jtfNguonhan = jtfNguonhan;
        this.jtfHangmuc = jtfHangmuc;
        this.jtfGiatri = jtfGiatri;
        this.jdcNgaygd = jdcNgaygd;
        this.jtaGhichu = jtaGhichu;
        this.jlbMess = jlbMess;
        pcService = new IPhieuChiService();
        this.jfrRoot = jfrPaymentVoucher;
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
        jtfNguonhan.setText("");
        jtfGiatri.setText("");
        jtaGhichu.setText("");
        jdcNgaygd.setDate(null);
        
    }
    
    public void setEvent() {
        jbtnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtfHangmuc.getText().length() == 0 || jtfNguonhan.getText().length() == 0 || jtfGiatri.getText().length() == 0 || jdcNgaygd.getDate() == null) {
                    jlbMess.setForeground(Color.red);
                } else {
                    PhieuChi pc = new PhieuChi();
                    String str = pcService.getMaphieuTop1();
                    int id = Integer.parseInt(str.substring(2, str.length()));
                    int newid = id + 1;
                    String maphieu = null;
                    if (demChuso(newid) == 1) {
                        maphieu = "PC00000" + newid;
                    } else if (demChuso(newid) == 2) {
                        maphieu = "PC0000" + newid;
                    } else if (demChuso(newid) == 3) {
                        maphieu = "PC000" + newid;
                    } else if (demChuso(newid) == 4) {
                        maphieu = "PC00" + newid;
                    } else if (demChuso(newid) == 5) {
                        maphieu = "PC0" + newid;
                    } else if (demChuso(newid) == 6) {
                        maphieu = "PC" + newid;
                    }
                    pc.setMaphieu(maphieu);
                    pc.setNguoinhan(jtfNguonhan.getText());
                    pc.setLoaiphieu(jtfHangmuc.getText());
                    pc.setNgaygd(new CovertDate().covertDateToDateSql(jdcNgaygd.getDate()));
                    pc.setLydo(jtaGhichu.getText());
                    pc.setTrigia(Integer.parseInt(jtfGiatri.getText()));
                    boolean result = pcService.addPayment(pc);
                    if (result) {
                        JOptionPane.showMessageDialog(null, "Thêm phiếu chi thành công!");
                        resetForm();
                    } else {
                        JOptionPane.showMessageDialog(null, "Thêm thất bại");
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
