/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlkara.dao;

import com.qlkara.database.DBConnect;
import com.qlkara.model.DanhMuc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author trung98
 */
public class IDanhMucDAO implements DanhMucDAO {

    @Override
    public ArrayList<DanhMuc> getAll() {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT * FROM danhmuc";
            ArrayList<DanhMuc> list = new ArrayList<>();
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DanhMuc dm = new DanhMuc();
                dm.setMadm(rs.getString(1));
                dm.setTendm(rs.getString(2));

                list.add(dm);
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
    public String getIdByName(String name) {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT madm FROM danhmuc where tendm=?";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String madm = rs.getString(1);
            
            ps.close();
            rs.close();
            con.close();
            return madm;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
