package com.qlkara.dao;

import com.qlkara.model.SanPham;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author trung98
 */
public interface SanPhamDAO {

    public ArrayList<SanPham> getAll();

    public ArrayList<SanPham> getByDanhMuc(String madm);

    public ArrayList<SanPham> getBySoluongTon(int slt);

    public int add(SanPham sp);

    public int update(SanPham sp);
    public Vector getID();

}
