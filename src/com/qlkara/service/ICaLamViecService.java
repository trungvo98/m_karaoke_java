/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlkara.service;

import com.qlkara.dao.CaLamViecDAO;
import com.qlkara.dao.ICaLamViecDAO;
import com.qlkara.model.CaLamViec;
import java.util.ArrayList;

/**
 *
 * @author trung98
 */
public class ICaLamViecService implements CaLamViecService{
    
    CaLamViecDAO clvService=null;

    public ICaLamViecService() {
         clvService = new ICaLamViecDAO();
    }
    
    @Override
    public ArrayList<CaLamViec> getAll() {
        return clvService.getAll();
        
    }

    @Override
    public int addOrUpdate(CaLamViec clv) {
        return clvService.addOrUpdate(clv);
    }
    
}
