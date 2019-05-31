package com.qlkara.bean;

import java.sql.Date;

/**
 *
 * @author trung98
 */
public class DoanhThu_Bean {

    private int ngay;
    private int thang;
    private int nam;
    private int doanhthu;

    public DoanhThu_Bean() {
    }

    public int getNgay() {
        return ngay;
    }

    public int getThang() {
        return thang;
    }

    public int getNam() {
        return nam;
    }

    public int getDoanhthu() {
        return doanhthu;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public void setDoanhthu(int doanhthu) {
        this.doanhthu = doanhthu;
    }

}
