package com.qlkara.dao;

import com.qlkara.model.TrangThietBi;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author trung98
 */
public interface TrangThietBiDAO {

    public ArrayList<TrangThietBi> getAll();

    public ArrayList<TrangThietBi> getByDanhMuc(String madm);

    public ArrayList<TrangThietBi> getBySoluongTon(int slt);

    public boolean add(TrangThietBi ttb);

    public Vector getID();

    public int update(TrangThietBi ttb);

}
