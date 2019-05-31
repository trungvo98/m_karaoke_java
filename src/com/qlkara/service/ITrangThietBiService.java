package com.qlkara.service;

import com.qlkara.dao.ITrangThietBiDAO;
import com.qlkara.dao.TrangThietBiDAO;
import com.qlkara.model.TrangThietBi;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author trung98
 */
public class ITrangThietBiService implements TrangThietBiService {

    TrangThietBiDAO ttbDAO = null;

    public ITrangThietBiService() {
        ttbDAO = new ITrangThietBiDAO();
    }

    @Override
    public ArrayList<TrangThietBi> getAll() {
        return ttbDAO.getAll();
    }

    @Override
    public boolean add(TrangThietBi ttb) {
        return ttbDAO.add(ttb);
    }

    @Override
    public Vector getID() {
        return ttbDAO.getID();
    }

    @Override
    public int update(TrangThietBi ttb) {
        return ttbDAO.update(ttb);

    }

}
