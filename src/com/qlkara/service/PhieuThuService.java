package com.qlkara.service;

import com.qlkara.model.PhieuThu;
import java.util.ArrayList;

/**
 *
 * @author trung98
 */
public interface PhieuThuService {

    public ArrayList<PhieuThu> getAll();

    public int getTongthu();

    public boolean addReceipt(PhieuThu pt);

    public String getMaphieuTop1();
}
