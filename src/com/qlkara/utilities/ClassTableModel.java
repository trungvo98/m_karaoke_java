package com.qlkara.utilities;

import com.qlkara.model.CaLamViec;
import com.qlkara.model.TrangThietBi;
import com.qlkara.model.NhanVien;
import com.qlkara.model.PhieuChi;
import com.qlkara.model.PhieuNhapHang;
import com.qlkara.model.PhieuThu;
import com.qlkara.model.SanPham;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author trung98
 */
public class ClassTableModel {

    public DefaultTableModel setTableNhanVien(ArrayList<NhanVien> list, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        int rows = list.size();
        Object[] obj = null;
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                NhanVien nv = list.get(i);
                obj = new Object[columns];
                obj[0] = (i + 1);
                obj[1] = nv.getManv();
                obj[2] = nv.getTennv();
                obj[3] = nv.getNgsinh();
                obj[4] = nv.getGioitinh() == true ? "Nam" : "Nữ";
                obj[5] = nv.getNgvl();
                obj[6] = nv.getSdt();
                obj[7] = nv.getDiachi();
                obj[8] = nv.getTrangthai() == true ? "Đang làm" : "Đã nghỉ";
                dtm.addRow(obj);
            }
        }
        return dtm;
    }

    public DefaultTableModel setTableCaLamViec(ArrayList<CaLamViec> list, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        int rows = list.size();
        Object[] obj = null;
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                CaLamViec clv = list.get(i);
                obj = new Object[columns];
                obj[0] = (i + 1);
                obj[1] = clv.getTenca();
                obj[2] = clv.getMaca();
                obj[3] = clv.getGiobatdau();
                obj[4] = clv.getGioketthuc();
                obj[5] = clv.getSocong();
                Time a = clv.getGionghibd();
                a.getHours();
                a.getMinutes();
                String time1 = Integer.toString(clv.getGiobatdau().getHours()) + ":" + Integer.toString(clv.getGiobatdau().getMinutes());
                String time2 = Integer.toString(clv.getGioketthuc().getHours()) + ":" + Integer.toString(clv.getGioketthuc().getMinutes());
                obj[6] = time1 + "-" + time2;

                dtm.addRow(obj);
            }
        }
        return dtm;
    }

    public DefaultTableModel setTablePhieuNhapHang(ArrayList<PhieuNhapHang> list, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        int rows = list.size();
        Object[] obj = null;
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                PhieuNhapHang pnh = list.get(i);
                obj = new Object[columns];
                obj[0] = (i + 1);
                obj[1] = pnh.getMapnh();
                obj[2] = pnh.getNgaynhap();
                obj[3] = pnh.getMancc();
                obj[4] = pnh.getSotien();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }

    public DefaultTableModel setTableHangHoa(ArrayList<SanPham> list, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        int rows = list.size();
        Object[] obj = null;
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                SanPham sp = list.get(i);
                obj = new Object[columns];
                obj[0] = (i + 1);
                obj[1] = (sp.getMasp());
                obj[2] = (sp.getTensp());
                obj[3] = (sp.getSoluongton());
                obj[4] = (sp.getNgayUpdate());
                dtm.addRow(obj);
            }
        }
        return dtm;
    }

    public DefaultTableModel setTableThuChi(ArrayList<PhieuThu> listThu, ArrayList<PhieuChi> listChi, String[] listColumnn, int id) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(listColumnn);
        int columns = listColumnn.length;
        int rows1 = listThu.size();
        int rows2 = listChi.size();

        Object[] obj = null;
        if (id == 1) {
            if (rows1 > 0) {
                for (int i = 0; i < rows1; i++) {
                    PhieuThu pt = listThu.get(i);
                    obj = new Object[columns];
                    obj[0] = (i + 1);
                    obj[1] = pt.getMaphieu();
                    obj[2] = pt.getNguoinop();
                    obj[3] = pt.getLoaiphieu();
                    obj[4] = pt.getLydo();
                    obj[5] = pt.getNgaygd();
                    obj[6] = pt.getTrigia();
                    dtm.addRow(obj);
                }
            }
            if (rows2 > 0) {
                for (int i = 0; i < rows2; i++) {
                    PhieuChi pc = listChi.get(i);
                    obj = new Object[columns];
                    obj[0] = (rows1 + i + 1);
                    obj[1] = pc.getMaphieu();
                    obj[2] = pc.getNguoinhan();
                    obj[3] = pc.getLoaiphieu();
                    obj[4] = pc.getLydo();
                    obj[5] = pc.getNgaygd();
                    obj[6] = pc.getTrigia();
                    dtm.addRow(obj);
                }

            }
        } else if (id == 2) {
            for (int i = 0; i < rows1; i++) {
                PhieuThu pt = listThu.get(i);
                obj = new Object[columns];
                obj[0] = (i + 1);
                obj[1] = pt.getMaphieu();
                obj[2] = pt.getNguoinop();
                obj[3] = pt.getLoaiphieu();
                obj[4] = pt.getLydo();
                obj[5] = pt.getNgaygd();
                obj[6] = pt.getTrigia();
                dtm.addRow(obj);
            }

        } else if (id == 3) {
            for (int i = 0; i < rows2; i++) {
                PhieuChi pc = listChi.get(i);
                obj = new Object[columns];
                obj[0] = (i + 1);
                obj[1] = pc.getMaphieu();
                obj[2] = pc.getNguoinhan();
                obj[3] = pc.getLoaiphieu();
                obj[4] = pc.getLydo();
                obj[5] = pc.getNgaygd();
                obj[6] = pc.getTrigia();
                dtm.addRow(obj);
            }

        }
        return dtm;

    }

    public DefaultTableModel setTableSanPham(ArrayList<SanPham> list, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        int rows = list.size();

        Object[] obj = null;
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                SanPham sp = list.get(i);
                obj = new Object[columns];
                obj[0] = (i + 1);
                obj[1] = sp.getMasp();
                obj[2] = sp.getTensp();
                obj[3] = sp.getGiavon();
                obj[4] = sp.getGiaban();
                obj[5] = sp.getSoluongton();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }

    public DefaultTableModel setTableTrangThietBi(ArrayList<TrangThietBi> list, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        int rows = list.size();
        Object[] obj = null;
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                TrangThietBi ttb = list.get(i);
                obj = new Object[columns];
                obj[0] = (i + 1);
                obj[1] = ttb.getMatb();
                obj[2] = ttb.getTentb();
                obj[3] = ttb.getNuocsx();
                obj[4] = ttb.getGiamua();
                obj[5] = ttb.getSoluongton();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }

}
