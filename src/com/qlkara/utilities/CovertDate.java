package com.qlkara.utilities;

import javax.swing.JOptionPane;

public class CovertDate {

    public java.sql.Date covertDateToDateSql(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }

    public boolean showDialog() {
        int result = JOptionPane.showConfirmDialog(null, "Bạn muốn cập nhật dữ liệu không", "Thông báo", JOptionPane.YES_NO_OPTION);
        return result == JOptionPane.YES_OPTION;

    }
}
