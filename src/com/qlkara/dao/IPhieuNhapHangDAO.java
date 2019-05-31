/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlkara.dao;

import com.qlkara.database.DBConnect;
import com.qlkara.model.PhieuNhapHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author trung98
 */
public class IPhieuNhapHangDAO  implements PhieuNhapHangDAO{

    @Override
    public ArrayList<PhieuNhapHang> getAll() {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT * FROM nhanvien";
            ArrayList<PhieuNhapHang> list = new ArrayList<>();
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhieuNhapHang pnh = new PhieuNhapHang();
                pnh.setMapnh(rs.getString(1));
                pnh.setMancc(rs.getInt(2));
                pnh.setNgaynhap(rs.getDate(3));
                pnh.setSotien(rs.getInt(4));
                pnh.setThanhtoan(rs.getInt(5));
                pnh.setTrangthai(rs.getString(6));
                list.add(pnh);
            }
            ps.close();
            rs.close();
            con.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
