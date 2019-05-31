package com.qlkara.dao;

import com.qlkara.database.DBConnect;
import com.qlkara.model.PhieuChi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trung98
 */
public class IPhieuChiDAO implements PhieuChiDAO {

    @Override
    public ArrayList<PhieuChi> getAll() {

        try {
            Connection con = DBConnect.getConnection();
            ArrayList<PhieuChi> list = new ArrayList<>();
            String sql = "SELECT * FROM phieuchi ";
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhieuChi pt = new PhieuChi();
                pt.setMaphieu(rs.getString(1));
                pt.setNguoinhan(rs.getString(2));
                pt.setLoaiphieu(rs.getString(3));
                pt.setLydo(rs.getString(4));
                pt.setNgaygd(rs.getDate(5));
                pt.setTrigia(rs.getInt(6));
                list.add(pt);
            }
            con.close();
            ps.close();
            rs.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(IPhieuThuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public int getTongchi() {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT SUM(giatri) as Tongchi from phieuchi";
            int Tongchi = 0;
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tongchi = rs.getInt(1);
            }
            return Tongchi;
        } catch (SQLException ex) {
            Logger.getLogger(IPhieuChiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public boolean addPayment(PhieuChi pc) {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "INSERT INTO phieuchi(maphieu,nguoinhan,loaiphieu,lydo,ngaygd,giatri) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, pc.getMaphieu());
            ps.setString(2, pc.getNguoinhan());
            ps.setString(3, pc.getLoaiphieu());
            ps.setString(4, pc.getLydo());
            ps.setDate(5, pc.getNgaygd());
            ps.setInt(6, pc.getTrigia());
            ps.executeUpdate();
            con.close();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(IPhieuThuDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public String getMaphieuTop1() {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT maphieu FROM phieuchi ORDER BY maphieu DESC LIMIT 1";
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(IPhieuChiDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
