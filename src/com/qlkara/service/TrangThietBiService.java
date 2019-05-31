package com.qlkara.service;

import com.qlkara.model.TrangThietBi;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author trung98
 */
public interface TrangThietBiService {

    public ArrayList<TrangThietBi> getAll();

    public boolean add(TrangThietBi ttb);

    public Vector getID();

    public int update(TrangThietBi ttb);
}
