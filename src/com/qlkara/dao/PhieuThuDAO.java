/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlkara.dao;

import com.qlkara.model.PhieuThu;
import java.util.ArrayList;

/**
 *
 * @author trung98
 */
public interface PhieuThuDAO {

    public ArrayList<PhieuThu> getAll();

    public int getTongthu();

    public boolean addReceipt(PhieuThu pt);

    public String getMaphieuTop1();

}
