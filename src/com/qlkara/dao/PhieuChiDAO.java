
package com.qlkara.dao;

import com.qlkara.model.PhieuChi;
import java.util.ArrayList;

/**
 *
 * @author trung98
 */
public interface PhieuChiDAO {
    public ArrayList<PhieuChi> getAll();
    public int getTongchi();
    public boolean addPayment(PhieuChi pc);
    public String getMaphieuTop1();
}
