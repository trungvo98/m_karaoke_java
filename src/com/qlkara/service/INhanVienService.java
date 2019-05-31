/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlkara.service;

import com.qlkara.dao.INhanVienDAO;
import com.qlkara.dao.NhanVienDAO;
import com.qlkara.model.NhanVien;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author trung98
 */
public class INhanVienService implements NhanVienService {

    private NhanVienDAO nvDAO = null;

    public INhanVienService() {
        nvDAO = new INhanVienDAO();
    }

    @Override
    public ArrayList<NhanVien> getList() {
        return nvDAO.getAll();
    }

    @Override
    public boolean delete(String manv) {
        return nvDAO.delete(manv);
    }

    @Override
    public int addOrUpdate(NhanVien nv) {
        return nvDAO.addOrUpdate(nv);
    }

    @Override
    public int add(NhanVien nv) {
        return nvDAO.add(nv);
    }

    @Override
    public Vector<String> getID() {
        return nvDAO.getID();

    }

    @Override
    public int update(NhanVien nv) {
        return nvDAO.update(nv);
    }

}
