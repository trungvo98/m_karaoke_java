/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlkara.dao;

import com.mysql.cj.xdevapi.Result;
import java.sql.PreparedStatement;
import com.qlkara.database.DBConnect;
import com.qlkara.model.TrangThietBi;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trung98
 */
public class ITrangThietBiDAO implements TrangThietBiDAO {

    @Override
    public ArrayList<TrangThietBi> getAll() {
        try {
            Connection con = new DBConnect().getConnection();
            String sql = "SELECT * FROM trangthietbi";
            ArrayList<TrangThietBi> list = new ArrayList<>();
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TrangThietBi ttb = new TrangThietBi();
                ttb.setMatb(rs.getString(1));
                ttb.setTentb(rs.getString(2));
                ttb.setGiamua(rs.getInt(3));
                ttb.setNuocsx(rs.getString(4));
                ttb.setSoluongton(rs.getInt(5));
                ttb.setNgayAdd(rs.getDate(6));
                ttb.setNgayUpdate(rs.getDate(7));
                list.add(ttb);
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
    public ArrayList<TrangThietBi> getByDanhMuc(String madm) {
        try {
            Connection con = new DBConnect().getConnection();
            String sql = "SELECT * FROM sanpham WHERE madm=?";
            ArrayList<TrangThietBi> list = new ArrayList<>();
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, madm);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TrangThietBi ttb = new TrangThietBi();
                ttb.setMatb(rs.getString(1));
                ttb.setTentb(rs.getString(2));
                ttb.setGiamua(rs.getInt(3));
                ttb.setSoluongton(rs.getInt(4));
                ttb.setNgayAdd(rs.getDate(5));
                list.add(ttb);
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
    public ArrayList<TrangThietBi> getBySoluongTon(int slt) {
        return null;
    }

    @Override
    public boolean add(TrangThietBi ttb) {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "INSERT INTO trangthietbi(mathietbi,tenthietbi,giamua,nuocsx,soluongton,ngayAdd,ngayUpdate) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, ttb.getMatb());
            ps.setString(2, ttb.getTentb());
            ps.setInt(3, ttb.getGiamua());
            ps.setString(4, ttb.getNuocsx());
            ps.setInt(5, ttb.getSoluongton());
            ps.setDate(6, ttb.getNgayAdd());
            ps.setDate(7, ttb.getNgayUpdate());
            ps.executeUpdate();
            con.close();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ITrangThietBiDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Vector getID() {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT mathietbi FROM trangthietbi";
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            Vector vector = new Vector();
            while (rs.next()) {
                vector.add(rs.getString(1));
            }
            ps.close();
            rs.close();
            con.close();
            return vector;
        } catch (SQLException ex) {
            Logger.getLogger(ITrangThietBiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int update(TrangThietBi ttb) {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "UPDATE trangthietbi set tenthietbi=?,giamua=?,nuocsx=? ,soluongton=?,ngayUpdate=? where mathietbi=?";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, ttb.getTentb());
            ps.setInt(2, ttb.getGiamua());
            ps.setString(3, ttb.getNuocsx());
            ps.setInt(4, ttb.getSoluongton());
            ps.setDate(5, ttb.getNgayUpdate());
            ps.setString(6, ttb.getMatb());
            int row = ps.executeUpdate();
            con.close();
            ps.close();
            return row;
        } catch (SQLException ex) {
            Logger.getLogger(ISanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

}
