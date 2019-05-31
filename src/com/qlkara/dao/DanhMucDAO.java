/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlkara.dao;

import com.qlkara.model.DanhMuc;
import java.util.ArrayList;

/**
 *
 * @author trung98
 */
public interface DanhMucDAO {

    public ArrayList<DanhMuc> getAll();

    public String getIdByName(String name) ;
}
