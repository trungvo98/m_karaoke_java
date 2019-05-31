/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlkara.service;

import com.qlkara.dao.IPhieuNhapHangDAO;
import com.qlkara.dao.PhieuNhapHangDAO;
import com.qlkara.model.PhieuNhapHang;
import java.util.ArrayList;

/**
 *
 * @author trung98
 */
public class IPhieuNhapHangService implements PhieuNhapHangService{
    
    PhieuNhapHangDAO pnhService = null;

    public IPhieuNhapHangService() {
        pnhService = new IPhieuNhapHangDAO();
    }
    

    @Override
    public ArrayList<PhieuNhapHang> getAll() {
        return pnhService.getAll();
    }
    
}
