/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlkara.service;

import com.qlkara.model.SanPham;
import com.qlkara.model.TrangThietBi;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author trung98
 */
public interface SanPhamService {

    public ArrayList<SanPham> getAll();

    public ArrayList<SanPham> getByDanhMuc(String madm);

    public int add(SanPham sp);

    public int update(SanPham sp);
    public Vector getID();
}
