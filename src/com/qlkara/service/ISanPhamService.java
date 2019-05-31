/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlkara.service;

import com.qlkara.dao.ISanPhamDAO;
import com.qlkara.dao.ITrangThietBiDAO;
import com.qlkara.dao.SanPhamDAO;
import com.qlkara.model.TrangThietBi;
import java.util.ArrayList;
import com.qlkara.dao.TrangThietBiDAO;
import com.qlkara.model.SanPham;
import java.util.Vector;

/**
 *
 * @author trung98
 */
public class ISanPhamService implements SanPhamService {

    SanPhamDAO spDAO = null;

    public ISanPhamService() {
        spDAO = new ISanPhamDAO();
    }

    @Override
    public ArrayList<SanPham> getAll() {
        return spDAO.getAll();
    }

    @Override
    public ArrayList<SanPham> getByDanhMuc(String madm) {
        return spDAO.getByDanhMuc(madm);
    }

    @Override
    public int add(SanPham sp) {
        return spDAO.add(sp);
    }

    @Override
    public int update(SanPham sp) {
        return spDAO.update(sp);
    }

    @Override
    public Vector getID() {
        return spDAO.getID();
    }

}
