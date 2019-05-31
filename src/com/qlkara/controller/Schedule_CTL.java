package com.qlkara.controller;

import com.qlkara.model.CaLamViec;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author trung98
 */
public class Schedule_CTL {

    private JTextField jtfTenca;
    private JTextField jtfKyhieu;
    private JTextField jtfSocong;
    private JTextField jtfGiobd;
    private JTextField jtfGiokt;
    private JTextField jtfGiobt_nghi;
    private JTextField jtfGiokt_nghi;
    private JButton jbtnSave;
    private JButton jbtnCancel;

    public Schedule_CTL() {
    }

    public Schedule_CTL(JTextField jtfTenca, JTextField jtfKyhieu, JTextField jtfSocong, JTextField jtfGiobd, JTextField jtfGiokt, JTextField jtfGiobt_nghi, JTextField jtfGiokt_nghi, JButton jbtnSave, JButton jbtnCancel) {
        this.jtfTenca = jtfTenca;
        this.jtfKyhieu = jtfKyhieu;
        this.jtfSocong = jtfSocong;
        this.jtfGiobd = jtfGiobd;
        this.jtfGiokt = jtfGiokt;
        this.jtfGiobt_nghi = jtfGiobt_nghi;
        this.jtfGiokt_nghi = jtfGiokt_nghi;
        this.jbtnSave = jbtnSave;
        this.jbtnCancel = jbtnCancel;
    }

    public void setData(CaLamViec clv) {
        jtfTenca.setText(clv.getTenca());
        jtfKyhieu.setText(Integer.toString(clv.getMaca()));
        jtfGiobd.setText(""+clv.getGiobatdau());
       
        jtfGiokt.setText(""+clv.getGioketthuc());
        jtfSocong.setText(Integer.toString(clv.getSocong()));
        
        
    }
}
