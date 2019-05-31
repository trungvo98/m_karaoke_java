/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlkara.service;

import com.qlkara.model.CaLamViec;
import java.util.ArrayList;

/**
 *
 * @author trung98
 */
public interface CaLamViecService {
    public ArrayList<CaLamViec> getAll();
    public int addOrUpdate(CaLamViec clv);
}
