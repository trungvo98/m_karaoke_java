/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlkara.model;

import java.sql.Date;


public class PhieuNhapHang {
    private String mapnh ;
    private Date ngaynhap;
    private int mancc;
    private int sotien;
    private int thanhtoan;
    private String trangthai;

    public String getMapnh() {
        return mapnh;
    }

    public Date getNgaynhap() {
        return ngaynhap;
    }

    public int getMancc() {
        return mancc;
    }

    public int getSotien() {
        return sotien;
    }

    public int getThanhtoan() {
        return thanhtoan;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setMapnh(String mapnh) {
        this.mapnh = mapnh;
    }

    public void setNgaynhap(Date ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public void setMancc(int mancc) {
        this.mancc = mancc;
    }

    public void setSotien(int sotien) {
        this.sotien = sotien;
    }

    public void setThanhtoan(int thanhtoan) {
        this.thanhtoan = thanhtoan;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
    
    
}
