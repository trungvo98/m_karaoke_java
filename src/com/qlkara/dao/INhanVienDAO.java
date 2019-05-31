package com.qlkara.dao;

import com.qlkara.database.DBConnect;
import com.qlkara.model.NhanVien;
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
public class INhanVienDAO implements NhanVienDAO {

    @Override
    public ArrayList<NhanVien> getAll() {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT * FROM nhanvien";
            ArrayList<NhanVien> list = new ArrayList<>();
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setManv(rs.getString(1));
                nv.setTennv(rs.getString(2));
                nv.setNgsinh(rs.getDate(3));
                nv.setGioitinh(rs.getBoolean(4));
                nv.setSdt(rs.getString(5));
                nv.setDiachi(rs.getString(6));
                nv.setNgvl(rs.getDate(7));
                nv.setTrangthai(rs.getBoolean(8));
                list.add(nv);
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
    public boolean delete(String manv) {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "DELETE FROM nhanvien where manv=? ";
            PreparedStatement ps = null;
            ps = con.prepareStatement(sql);
            ps.setString(1, manv);
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override

    public int addOrUpdate(NhanVien nv) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO nhanvien(manv,tennv,ngaysinh,gioitinh,sdt,diachi,ngayvl,trangthai) VALUES(?,?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE tennv= VALUES(tennv), ngaysinh= VALUES(ngaysinh), gioitinh = VALUES(gioitinh), sdt = VALUES(sdt), diachi = VALUES(diachi),ngayvl = VALUES(ngayvl), trangthai = VALUES(trangthai);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, nv.getManv());
            ps.setString(2, nv.getTennv());
            ps.setDate(3, nv.getNgsinh());
            ps.setBoolean(4, nv.getGioitinh());
            ps.setString(5, nv.getSdt());
            ps.setString(6, nv.getDiachi());
            ps.setDate(7, nv.getNgvl());
            ps.setBoolean(8, nv.getTrangthai());
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

    @Override
    public int add(NhanVien nv) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO nhanvien(manv,tennv,ngaysinh,gioitinh,sdt,diachi,ngayvl,trangthai) VALUES(?,?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, nv.getManv());
            ps.setString(2, nv.getTennv());
            ps.setDate(3, nv.getNgsinh());
            ps.setBoolean(4, nv.getGioitinh());
            ps.setString(5, nv.getSdt());
            ps.setString(6, nv.getDiachi());
            ps.setDate(7, nv.getNgvl());
            ps.setBoolean(8, nv.getTrangthai());
            int row = ps.executeUpdate();
            ps.close();
            cons.close();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Vector<String> getID() {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT manv FROM nhanvien";
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

    @Override
    public int update(NhanVien nv) {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "UPDATE nhanvien set tennv=? , ngaysinh=?, gioitinh=?,sdt=?,diachi=?,ngayvl=?,trangthai=? where manv=?";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, nv.getTennv());
            ps.setDate(2, nv.getNgsinh());
            ps.setBoolean(3, nv.getGioitinh());
            ps.setString(4, nv.getSdt());
            ps.setString(5, nv.getDiachi());
            ps.setDate(6, nv.getNgvl());
            ps.setBoolean(7, nv.getTrangthai());
            ps.setString(8, nv.getManv());
            int row = ps.executeUpdate();
            ps.close();
            con.close();
            return row;
        } catch (SQLException ex) {
            Logger.getLogger(INhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
