/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlkara.dao;

import com.qlkara.database.DBConnect;
import com.qlkara.model.CaLamViec;
import com.qlkara.model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author trung98
 */
public class ICaLamViecDAO implements CaLamViecDAO {

    @Override
    public ArrayList<CaLamViec> getAll() {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT * FROM calamviec";
            ArrayList<CaLamViec> list = new ArrayList<>();
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CaLamViec clv = new CaLamViec();
                clv.setMaca(rs.getInt(1));
                clv.setTenca(rs.getString(2));
                clv.setGiobatdau(rs.getTime(3));
                clv.setGioketthuc(rs.getTime(4));
                clv.setSocong(rs.getInt(5));
                clv.setGionghibd(rs.getTime(6));
                clv.setGionghikt(rs.getTime(7));
                list.add(clv);
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

    @Override
    public int addOrUpdate(CaLamViec clv) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO calmviec(maca,tenca,giobatdau,gioketthuc,socong,gionghi) VALUES(?,?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE tenca= VALUES(tenca), giobatdau= VALUES(giobatdau), gioketthuc = VALUES(gioketthuc), socong = VALUES(socong), gionghi = VALUES(gionghi);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, clv.getMaca());
            ps.setString(2, clv.getTenca());
            ps.setTime(3, clv.getGiobatdau());
            ps.setTime(4, clv.getGioketthuc());
            ps.setInt(5, clv.getSocong());
            ps.setTime(6, clv.getGionghibd());
            ps.setTime(7, clv.getGionghikt());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

}
