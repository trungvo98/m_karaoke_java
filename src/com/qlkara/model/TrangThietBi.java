package com.qlkara.model;

import java.sql.Date;

/**
 *
 * @author trung98
 */
public class TrangThietBi {

    private String matb;
    private String tentb;
    private int giamua;
    private int soluongton;
    private String nuocsx;
    private Date ngayAdd;
    private Date ngayUpdate;

    public String getMatb() {
        return matb;
    }

    public String getTentb() {
        return tentb;
    }

    public int getGiamua() {
        return giamua;
    }

    public int getSoluongton() {
        return soluongton;
    }

    public Date getNgayAdd() {
        return ngayAdd;
    }

    public Date getNgayUpdate() {
        return ngayUpdate;
    }

    public void setMatb(String matb) {
        this.matb = matb;
    }

    public void setTentb(String tentb) {
        this.tentb = tentb;
    }

    public void setGiamua(int giamua) {
        this.giamua = giamua;
    }

    public void setSoluongton(int soluongton) {
        this.soluongton = soluongton;
    }

    public void setNgayAdd(Date ngayAdd) {
        this.ngayAdd = ngayAdd;
    }

    public void setNgayUpdate(Date ngayUpdate) {
        this.ngayUpdate = ngayUpdate;
    }

    public String getNuocsx() {
        return nuocsx;
    }

    public void setNuocsx(String nuocsx) {
        this.nuocsx = nuocsx;
    }

}
