/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlkara.model;

import java.sql.Date;

/**
 *
 * @author trung98
 */
public class NhanVien {
    private String manv;
    private String tennv;
    private Date ngsinh;
    private boolean gioitinh;
    private String sdt;
    private String diachi;
    private Date ngvl;
    private boolean trangthai;

    public String getManv() {
        return manv;
    }

    public String getTennv() {
        return tennv;
    }

    public Date getNgsinh() {
        return ngsinh;
    }

    public boolean getGioitinh() {
        return gioitinh;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public void setNgsinh(Date ngsinh) {
        this.ngsinh = ngsinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setNgvl(Date ngvl) {
        this.ngvl = ngvl;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public String getSdt() {
        return sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public Date getNgvl() {
        return ngvl;
    }

    public boolean getTrangthai() {
        return trangthai;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "manv=" + manv + ", tennv=" + tennv + '}';
    }

   
    
    
}
