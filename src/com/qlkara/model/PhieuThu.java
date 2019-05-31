package com.qlkara.model;

import java.sql.Date;

/**
 *
 * @author trung98
 */
public class PhieuThu {

    private String maphieu;
    private String nguoinop;
    private String loaiphieu;
    private String lydo;
    private Date ngaygd;
    private int trigia;

    public String getMaphieu() {
        return maphieu;
    }

    public String getNguoinop() {
        return nguoinop;
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

    public void setNguoinop(String nguoinop) {
        this.nguoinop = nguoinop;
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

    public String getLydo() {
        return lydo;
    }

    public void setLydo(String lydo) {
        this.lydo = lydo;
    }

}
