/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlkara.dao;

import com.qlkara.bean.DoanhThuOfSanPham_Bean;
import com.qlkara.bean.DoanhThu_Bean;
import com.qlkara.bean.LoiNhuan_Bean;
import com.qlkara.bean.SanPhamBanChay_Bean;
import com.qlkara.database.DBConnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author trung98
 */
public class IThongKeDAO implements ThongKeDAO {

    public ArrayList<DoanhThu_Bean> list_byMonthYear(int year) {
        Connection con = DBConnect.getConnection();
        String sql = "SELECT month(ngayhd), SUM(trigia) as doanhthu FROM hoadon WHERE year(ngayhd)=? GROUP BY month(ngayhd),year(ngayhd) ORDER BY month(ngayhd) ASC";
        ArrayList<DoanhThu_Bean> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, year);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DoanhThu_Bean dt = new DoanhThu_Bean();
                dt.setThang(rs.getInt(1));
                dt.setDoanhthu(rs.getInt(2));
                list.add(dt);
            }
            con.close();
            ps.close();
            rs.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<DoanhThu_Bean> list_byYear() {
        Connection con = DBConnect.getConnection();
        String sql = "SELECT year(ngayhd), SUM(trigia) as doanhthu FROM hoadon GROUP BY year(ngayhd)";
        ArrayList<DoanhThu_Bean> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DoanhThu_Bean dt = new DoanhThu_Bean();
                dt.setNam(rs.getInt(1));
                dt.setDoanhthu(rs.getInt(2));
                list.add(dt);
            }
            con.close();
            ps.close();
            rs.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<SanPhamBanChay_Bean> getList(String madm) {
        Connection con = DBConnect.getConnection();
        String sql1 = "SELECT tenhang,SUM(soluong) as soluong FROM chitiethoadon inner join sanpham on chitiethoadon.masp=sanpham.masp \n"
                + " inner join hoadon on hoadon.sohd=chitiethoadon.sohd\n"
                + "WHERE ngayhd=CURRENT_DATE\n"
                + "GROUP BY chitiethoadon.masp\n"
                + "ORDER BY SUM(soluong) desc\n"
                + "LIMIT 6";
        String sql = "SELECT tensp,SUM(soluong) as soluong FROM chitiethoadon inner join sanpham on chitiethoadon.masp=sanpham.masp inner join danhmuc on sanpham.madm=danhmuc.madm\n"
                + "\n"
                + "WHERE danhmuc.madm=?\n"
                + "GROUP BY chitiethoadon.masp \n"
                + "ORDER BY SUM(soluong) desc\n"
                + "LIMIT 6";
        ArrayList<SanPhamBanChay_Bean> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, madm);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPhamBanChay_Bean spbc = new SanPhamBanChay_Bean();
                spbc.setTensp(rs.getString(1));
                spbc.setSoluong(rs.getInt(2));
                list.add(spbc);
            }
            con.close();
            ps.close();
            rs.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<DoanhThuOfSanPham_Bean> getList_Doanhthu() {
        Connection con = DBConnect.getConnection();
        String sql = "SELECT tensp,SUM(trigia) as doanhthu from hoadon INNER join chitiethoadon on hoadon.sohd=chitiethoadon.sohd  INNER JOIN sanpham on sanpham.masp=chitiethoadon.masp\n"
                + "GROUP BY chitiethoadon.masp\n"
                + "ORDER BY SUM(trigia) DESC\n"
                + "LIMIT 5";
        ArrayList<DoanhThuOfSanPham_Bean> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DoanhThuOfSanPham_Bean dtsp = new DoanhThuOfSanPham_Bean();
                dtsp.setTensp(rs.getString(1));
                dtsp.setDoanhthu(rs.getInt(2));
                list.add(dtsp);
            }
            con.close();
            ps.close();
            rs.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<LoiNhuan_Bean> getList_LoiNhuan() {
        return null;
    }

    @Override
    public ArrayList<DoanhThu_Bean> list_bySelect(Date d1, Date d2) {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT day(ngayhd),month(ngayhd),year(ngayhd),SUM(trigia) as doanhso FROM hoadon WHERE ngayhd BETWEEN ? and ? GROUP BY ngayhd";
            ArrayList<DoanhThu_Bean> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, d1);
            ps.setDate(2, d2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DoanhThu_Bean dt = new DoanhThu_Bean();
                dt.setNgay(rs.getInt(1));
                dt.setThang(rs.getInt(2));
                dt.setNam(rs.getInt(3));
                dt.setDoanhthu(rs.getInt(4));
                list.add(dt);
            }
            con.close();
            ps.close();
            rs.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    @Override
    public ArrayList<DoanhThu_Bean> list_bythisMonth() {
          try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT day(ngayhd),month(ngayhd),year(ngayhd),SUM(trigia) as doanhso FROM hoadon \n" +
"WHERE  ngayhd BETWEEN DATE_FORMAT(DATE_ADD(CURDATE(), INTERVAL 0 MONTH), '%Y-%m-01')  and LAST_DAY(CURRENT_DATE())  GROUP BY ngayhd";
            ArrayList<DoanhThu_Bean> list = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DoanhThu_Bean dt = new DoanhThu_Bean();
                dt.setNgay(rs.getInt(1));
                dt.setThang(rs.getInt(2));
                dt.setNam(rs.getInt(3));
                dt.setDoanhthu(rs.getInt(4));
                list.add(dt);
            }
            con.close();
            ps.close();
            rs.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
