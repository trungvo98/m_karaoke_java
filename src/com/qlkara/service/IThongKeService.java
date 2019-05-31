/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlkara.service;

import com.qlkara.bean.DoanhThuOfSanPham_Bean;
import com.qlkara.bean.DoanhThu_Bean;
import com.qlkara.bean.SanPhamBanChay_Bean;
import com.qlkara.dao.IThongKeDAO;
import com.qlkara.dao.ThongKeDAO;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author trung98
 */
public class IThongKeService implements ThongKeService {

    ThongKeDAO tkService = null;

    public IThongKeService() {
        this.tkService = new IThongKeDAO();
    }

    @Override
    public ArrayList<SanPhamBanChay_Bean> getList(String madm) {
        return tkService.getList(madm);
    }

    @Override
    public ArrayList<DoanhThuOfSanPham_Bean> getList_Doanhthu() {
        return tkService.getList_Doanhthu();
    }

    @Override
    public ArrayList<DoanhThu_Bean> list_byYear() {
        return tkService.list_byYear();
    }

    @Override
    public ArrayList<DoanhThu_Bean> list_byMonthYear(int year) {
        return tkService.list_byMonthYear(year);
    }

    @Override
    public ArrayList<DoanhThu_Bean> list_bySelect(Date d1, Date d2) {
        return tkService.list_bySelect(d1, d2);
    }

    @Override
    public ArrayList<DoanhThu_Bean> list_bythisMonth() {
        return tkService.list_bythisMonth();

    }

}
