/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlkara.dao;

import com.qlkara.model.NhanVien;
import java.util.ArrayList;
import java.util.Vector;

public interface NhanVienDAO {

    public ArrayList<NhanVien> getAll();

    public int addOrUpdate(NhanVien nv);

    public boolean delete(String manv);

    public int add(NhanVien nv);
    
    public int update(NhanVien nv);
    public Vector<String> getID();
    
}
