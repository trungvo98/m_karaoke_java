/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlkara.dao;

import com.qlkara.database.DBConnect;
import com.qlkara.model.DonViTinh;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author trung98
 */
public class IDonViTinhDAO implements DonViTinhDAO {

    @Override
    public ArrayList<DonViTinh> getAll() {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT * FROM donvitinh";
            ArrayList<DonViTinh> list = new ArrayList<>();
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DonViTinh dvt = new DonViTinh();
                dvt.setMadvt(rs.getString(1));
                dvt.setTendvt(rs.getString(2));
                dvt.setGhichu(rs.getString(3));
                list.add(dvt);
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
            String sql = "SELECT madvt FROM donvitinh where tendvt=?";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String madvt = rs.getString(1);

            ps.close();
            rs.close();
            con.close();
            return madvt;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
