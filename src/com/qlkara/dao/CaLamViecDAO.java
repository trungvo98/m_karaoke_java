
package com.qlkara.dao;

import com.qlkara.model.CaLamViec;
import java.util.ArrayList;

/**
 *
 * @author trung98
 */
public interface CaLamViecDAO {
    public ArrayList<CaLamViec> getAll();
    public int addOrUpdate(CaLamViec clv);
    
}
