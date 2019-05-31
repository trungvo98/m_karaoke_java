package com.qlkara.model;

import java.sql.Date;

/**
 *
 * @author trung98
 */
public class SanPham {

    private String masp;
    private String tensp;
    private String madm;
    private String madvt;
    private int soluongton;
    private int giavon;
    private int giaban;
    private Date ngayAdd;
    private Date ngayUpdate;
    private String ghichu;
    private String imageID;

    public String getMasp() {
        return masp;
    }

    public String getTensp() {
        return tensp;
    }

    public String getMadm() {
        return madm;
    }

    public String getMadvt() {
        return madvt;
    }

    public int getSoluongton() {
        return soluongton;
    }

    public int getGiaban() {
        return giaban;
    }

    public Date getNgayAdd() {
        return ngayAdd;
    }

    public Date getNgayUpdate() {
        return ngayUpdate;
    }

    public String getGhichu() {
        return ghichu;
    }

    public String getImageID() {
        return imageID;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public void setMadm(String madm) {
        this.madm = madm;
    }

    public void setMadvt(String madvt) {
        this.madvt = madvt;
    }

    public void setSoluongton(int soluongton) {
        this.soluongton = soluongton;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public void setNgayAdd(Date ngayAdd) {
        this.ngayAdd = ngayAdd;
    }

    public void setNgayUpdate(Date ngayUpdate) {
        this.ngayUpdate = ngayUpdate;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public int getGiavon() {
        return giavon;
    }

    public void setGiavon(int giavon) {
        this.giavon = giavon;
    }

}
