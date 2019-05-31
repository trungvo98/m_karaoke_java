/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlkara.model;

/**
 *
 * @author trung98
 */
public class KhachHang {
    private int makh;
    private String hoten;
    private String cmnd;

    public String getCmnd() {
        return cmnd;
    }

    public String getHoten() {
        return hoten;
    }

    public int getMakh() {
        return makh;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }
    
    
}
