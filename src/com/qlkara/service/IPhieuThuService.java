package com.qlkara.service;

import com.qlkara.dao.IPhieuThuDAO;
import com.qlkara.dao.PhieuThuDAO;
import com.qlkara.model.PhieuThu;
import java.util.ArrayList;

/**
 *
 * @author trung98
 */
public class IPhieuThuService implements PhieuThuService {

    PhieuThuDAO ptDAO = null;

    public IPhieuThuService() {
        ptDAO = new IPhieuThuDAO();
    }

    @Override
    public ArrayList<PhieuThu> getAll() {
        return ptDAO.getAll();
    }

    @Override
    public int getTongthu() {
        return ptDAO.getTongthu();

    }

    @Override
    public boolean addReceipt(PhieuThu pt) {
        return ptDAO.addReceipt(pt);
    }

    @Override
    public String getMaphieuTop1() {
        return ptDAO.getMaphieuTop1();
    }

}
