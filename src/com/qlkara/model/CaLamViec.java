/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlkara.model;

import java.sql.Date;
import java.sql.Time;
import java.util.logging.Logger;


public class CaLamViec {
    int maca;
    String tenca;
    Time giobatdau;
    Time gioketthuc;
    int socong;
    Time gionghibd;
    Time gionghikt;

    public int getMaca() {
        return maca;
    }

    public String getTenca() {
        return tenca;
    }

    public Time getGiobatdau() {
        return giobatdau;
    }

    public Time getGioketthuc() {
        return gioketthuc;
    }

    public int getSocong() {
        return socong;
    }

   

    public void setMaca(int maca) {
        this.maca = maca;
    }

    public void setTenca(String tenca) {
        this.tenca = tenca;
    }

    public void setGiobatdau(Time giobatdau) {
        this.giobatdau = giobatdau;
    }

    public void setGioketthuc(Time gioketthuc) {
        this.gioketthuc = gioketthuc;
    }

    public void setSocong(int socong) {
        this.socong = socong;
    }

    public Time getGionghibd() {
        return gionghibd;
    }

    public Time getGionghikt() {
        return gionghikt;
    }

    public void setGionghibd(Time gionghibd) {
        this.gionghibd = gionghibd;
    }

    public void setGionghikt(Time gionghikt) {
        this.gionghikt = gionghikt;
    }
    

   
    
    
    
    
}
