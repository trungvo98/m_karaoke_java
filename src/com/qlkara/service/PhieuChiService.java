package com.qlkara.service;

import com.qlkara.model.PhieuChi;
import java.util.ArrayList;

/**
 *
 * @author trung98
 */
public interface PhieuChiService {

    public ArrayList<PhieuChi> getAll();

    public int getTongchi();

    public boolean addPayment(PhieuChi pc);
     public String getMaphieuTop1();
}
