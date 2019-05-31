package com.qlkara.service;

import com.qlkara.dao.IPhieuChiDAO;
import com.qlkara.dao.PhieuChiDAO;
import com.qlkara.model.PhieuChi;
import java.util.ArrayList;

/**
 *
 * @author trung98
 */
public class IPhieuChiService implements PhieuChiService {

    PhieuChiDAO pcDAO = null;

    public IPhieuChiService() {

        pcDAO = new IPhieuChiDAO();
    }

    @Override
    public ArrayList<PhieuChi> getAll() {
        return pcDAO.getAll();
    }

    @Override
    public int getTongchi() {
        return pcDAO.getTongchi();

    }

    @Override
    public boolean addPayment(PhieuChi pc) {
        return pcDAO.addPayment(pc);
    }

    @Override
    public String getMaphieuTop1() {
        return pcDAO.getMaphieuTop1();
    }

}
