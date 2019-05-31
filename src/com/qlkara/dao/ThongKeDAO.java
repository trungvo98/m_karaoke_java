package com.qlkara.dao;

import com.qlkara.bean.DoanhThuOfSanPham_Bean;
import com.qlkara.bean.DoanhThu_Bean;
import com.qlkara.bean.LoiNhuan_Bean;
import com.qlkara.bean.SanPhamBanChay_Bean;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author trung98
 */
public interface ThongKeDAO {

    public ArrayList<DoanhThu_Bean> list_byMonthYear(int year);

    public ArrayList<SanPhamBanChay_Bean> getList(String madm);

    public ArrayList<DoanhThuOfSanPham_Bean> getList_Doanhthu();

    public ArrayList<LoiNhuan_Bean> getList_LoiNhuan();

    public ArrayList<DoanhThu_Bean> list_byYear();
    public ArrayList<DoanhThu_Bean> list_bySelect(Date d1,Date d2);
      public ArrayList<DoanhThu_Bean> list_bythisMonth();
}
