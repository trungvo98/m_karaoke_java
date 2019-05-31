package com.qlkara.dao;

import com.qlkara.database.DBConnect;
import com.qlkara.model.PhieuThu;
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
public class IPhieuThuDAO implements PhieuThuDAO {

    @Override
    public ArrayList<PhieuThu> getAll() {
        try {
            Connection con = DBConnect.getConnection();
            ArrayList<PhieuThu> list = new ArrayList<>();
            String sql = "SELECT * FROM phieuthu ";
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhieuThu pt = new PhieuThu();
                pt.setMaphieu(rs.getString(1));
                pt.setNguoinop(rs.getString(2));
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
    public int getTongthu() {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT SUM(giatri) as Tongthu from phieuthu";
            int Tongthu = 0;
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tongthu = rs.getInt(1);
            }
            return Tongthu;
        } catch (SQLException ex) {
            Logger.getLogger(IPhieuChiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public boolean addReceipt(PhieuThu pt) {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "INSERT INTO phieuthu(maphieu,nguoinop,loaiphieu,lydo,ngaygd,giatri) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, pt.getMaphieu());
            ps.setString(2, pt.getNguoinop());
            ps.setString(3, pt.getLoaiphieu());
            ps.setString(4, pt.getLydo());
            ps.setDate(5, pt.getNgaygd());
            ps.setInt(6, pt.getTrigia());
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
            String sql = "SELECT maphieu FROM phieuthu ORDER BY maphieu DESC LIMIT 1";
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
