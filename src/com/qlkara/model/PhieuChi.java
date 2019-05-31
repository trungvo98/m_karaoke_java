package com.qlkara.model;

import java.sql.Date;

/**
 *
 * @author trung98
 */
public class PhieuChi {

    private String maphieu;
    private String nguoinhan;
    private String loaiphieu;
    private String lydo;
    private Date ngaygd;
    private int trigia;

    public String getMaphieu() {
        return maphieu;
    }

  

    public String getLoaiphieu() {
        return loaiphieu;
    }

    public Date getNgaygd() {
        return ngaygd;
    }

    public int getTrigia() {
        return trigia;
    }

    public void setMaphieu(String maphieu) {
        this.maphieu = maphieu;
    }

  

    public void setLoaiphieu(String loaiphieu) {
        this.loaiphieu = loaiphieu;
    }

    public void setNgaygd(Date ngaygd) {
        this.ngaygd = ngaygd;
    }

    public void setTrigia(int trigia) {
        this.trigia = trigia;
    }

    public String getNguoinhan() {
        return nguoinhan;
    }

    public String getLydo() {
        return lydo;
    }

    public void setNguoinhan(String nguoinhan) {
        this.nguoinhan = nguoinhan;
    }

    public void setLydo(String lydo) {
        this.lydo = lydo;
    }

}
