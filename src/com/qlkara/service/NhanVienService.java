package com.qlkara.service;

import com.qlkara.model.NhanVien;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author trung98
 */
public interface NhanVienService {

    public ArrayList<NhanVien> getList();

    public int addOrUpdate(NhanVien nv);

    public boolean delete(String manv);

    public int add(NhanVien nv);
      public int update(NhanVien nv);

    public Vector<String> getID();
}
