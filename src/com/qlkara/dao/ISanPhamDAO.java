package com.qlkara.dao;

import com.qlkara.database.DBConnect;
import com.qlkara.model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class ISanPhamDAO implements SanPhamDAO {

    @Override
    public ArrayList<SanPham> getAll() {
        try {
            Connection con = DBConnect.getConnection();
            ArrayList<SanPham> list = new ArrayList<>();
            String sql = "SELECT * FROM sanpham";
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMasp(rs.getString(1));
                sp.setTensp(rs.getString(2));
                sp.setMadm(rs.getString(3));
                sp.setMadvt(rs.getString(4));
                sp.setGiavon(rs.getInt(5));
                sp.setGiaban(rs.getInt(6));
                sp.setSoluongton(rs.getInt(7));
                sp.setNgayAdd(rs.getDate(8));
                sp.setNgayUpdate(rs.getDate(9));
                list.add(sp);
            }
            con.close();
            ps.close();
            rs.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ISanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<SanPham> getByDanhMuc(String madm) {
        try {
            Connection con = new DBConnect().getConnection();
            String sql = "SELECT * FROM sanpham WHERE madm=?";
            ArrayList<SanPham> list = new ArrayList<>();
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, madm);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMasp(rs.getString(1));
                sp.setTensp(rs.getString(2));
                sp.setMadm(rs.getString(3));
                sp.setMadvt(rs.getString(4));
                sp.setGiavon(rs.getInt(5));
                sp.setGiaban(rs.getInt(6));
                sp.setSoluongton(rs.getInt(7));
                sp.setNgayAdd(rs.getDate(8));
                sp.setNgayUpdate(rs.getDate(9));
                list.add(sp);
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
    public ArrayList<SanPham> getBySoluongTon(int slt) {
        return null;
    }

    @Override
    public int add(SanPham sp) {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "INSERT INTO sanpham(masp,tensp,madm,madvt,giamua,giaban,soluongton,ngayAdd,ngayUpdate,ghichu) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, sp.getMasp());
            ps.setString(2, sp.getTensp());
            ps.setString(3, sp.getMadm());
            ps.setString(4, sp.getMadvt());
            ps.setInt(5, sp.getGiavon());
            ps.setInt(6, sp.getGiaban());
            ps.setInt(7, sp.getSoluongton());
            ps.setDate(8, sp.getNgayAdd());
            ps.setDate( 9, sp.getNgayUpdate());
            ps.setString(10, sp.getGhichu());
            int row = ps.executeUpdate();
            con.close();
            ps.close();
            return row;
        } catch (SQLException ex) {
            Logger.getLogger(ISanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return -1;
    }

    @Override
    public int update(SanPham sp) {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "UPDATE sanpham set tensp=?,giamua=?,giaban=? ,soluongton=?,ngayUpdate=?,ghichu=? where masp=?";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, sp.getTensp());
            ps.setInt(2, sp.getGiavon());
            ps.setInt(3, sp.getGiaban());
            ps.setInt(4, sp.getSoluongton());
            ps.setDate(5, sp.getNgayUpdate());
            ps.setString(6, sp.getGhichu());
            ps.setString(7, sp.getMasp());
            int row = ps.executeUpdate();
            con.close();
            ps.close();
            return row;
        } catch (SQLException ex) {
            Logger.getLogger(ISanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public Vector getID() {
         try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT masp FROM sanpham";
            Vector<String> vector = new Vector<String>();
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                vector.add(id);
            }
            ps.close();
            rs.close();
            con.close();
            return vector;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
