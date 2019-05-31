package com.qlkara.controller;

import com.qlkara.model.SanPham;
import com.qlkara.model.TrangThietBi;
import com.qlkara.service.ISanPhamService;
import com.qlkara.service.ITrangThietBiService;
import com.qlkara.service.SanPhamService;
import com.qlkara.service.TrangThietBiService;
import com.qlkara.utilities.ClassTableModel;
import com.qlkara.utilities.MyDocumentListener;
import com.qlkara.view.Equipment;
import com.qlkara.view.Product;
import com.qlkara.view.UpdateEquipment;
import com.qlkara.view.UpdateProduct;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Cell;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MaintainGoods_CTL {

    private JButton jbtnAddPro;
    private JButton jbtnExportPro;
    private JButton jbtnAddEqui;
    private JButton jbtnExportEqui;
    private JTextField jtfSearch1;
    private JTextField jtfSearch2;
    private JPanel jpnView1;
    private JPanel jpnView2;
    private SanPhamService spService = null;
    private TrangThietBiService ttbService = null;
    private String[] listColumns = {"STT", "Mã sản phẩm", "Tên sản phẩm", "Giá vốn", "Giá bán", "Tồn kho"};
    private String[] listColumns2 = {"STT", "Mã thiết bị", "Tên thiết bị", "Nước sản xuất", "Giá mua", "Tồn kho",};
    private TableRowSorter<TableModel> sorter;
    private DefaultTableModel dtmSP;
    private DefaultTableModel dtmTTB;
    private JTable tableSP;
    private JTable tableTTB;

    public MaintainGoods_CTL(JPanel jpnView1, JPanel jpnView2, JTextField jtfSearch1, JTextField jtfSearch2, JButton jbtnAddPro, JButton jbtnExportPro, JButton jbtnAddEqui, JButton jbtnExportEqui) {
        this.jpnView1 = jpnView1;
        this.jpnView2 = jpnView2;
        this.jtfSearch1 = jtfSearch1;
        this.jtfSearch2 = jtfSearch2;
        this.jbtnAddPro = jbtnAddPro;
        this.jbtnExportPro = jbtnExportPro;
        this.jbtnAddEqui = jbtnAddEqui;
        this.jbtnExportEqui = jbtnExportEqui;
        spService = new ISanPhamService();
        ttbService = new ITrangThietBiService();
    }

    /*public void addOrUpdate() {
        dtm = (DefaultTableModel) table.getModel();
        int selectedRowIndex = table.getSelectedRow();
        selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);

        SanPham sp = new SanPham();
        sp.setMasp(dtm.getValueAt(selectedRowIndex, 1).toString());
        sp.setTensp((String) dtm.getValueAt(selectedRowIndex, 2));
        sp.setGiavon((int) dtm.getValueAt(selectedRowIndex, 3));
        sp.setGiaban((int) dtm.getValueAt(selectedRowIndex, 4));
        sp.setSoluongton((int) dtm.getValueAt(selectedRowIndex, 5));

        Product jfrProduct = new Product(sp);
        jfrProduct.setTitle("Sửa thông tin sản phẩm");
        jfrProduct.setResizable(false);
        jfrProduct.setLocationRelativeTo(null);
        jfrProduct.setVisible(true);

    }*/
    public void setDataToTableSanPham(int temp) {

        ArrayList<SanPham> list = spService.getAll();
        ArrayList<SanPham> listWater = spService.getByDanhMuc("DM001");
        ArrayList<SanPham> lisBread = spService.getByDanhMuc("DM002");
        if (temp == 1) {
            dtmSP = new ClassTableModel().setTableSanPham(list, listColumns);
        } else if (temp == 2) {
            dtmSP = new ClassTableModel().setTableSanPham(listWater, listColumns);
        } else {
            dtmSP = new ClassTableModel().setTableSanPham(lisBread, listColumns);
        }
        tableSP = new JTable(dtmSP);
        sorter = new TableRowSorter<>(dtmSP);
        tableSP.setRowSorter(sorter);

        tableSP.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        tableSP.getTableHeader().setPreferredSize(new Dimension(100, 50));
        tableSP.setRowHeight(45);

        tableSP.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && tableSP.getSelectedRow() != -1) {
                    SanPham sp = new SanPham();
                    dtmSP = (DefaultTableModel) tableSP.getModel();
                    int selectedRowIndex = tableSP.getSelectedRow();
                    selectedRowIndex = tableSP.convertRowIndexToModel(selectedRowIndex);

                    sp.setMasp(dtmSP.getValueAt(selectedRowIndex, 1).toString());
                    sp.setTensp((String) dtmSP.getValueAt(selectedRowIndex, 2));
                    sp.setGiavon((int) dtmSP.getValueAt(selectedRowIndex, 3));
                    sp.setGiaban((int) dtmSP.getValueAt(selectedRowIndex, 4));
                    // sp.setMadm(madm);
                    sp.setSoluongton((int) dtmSP.getValueAt(selectedRowIndex, 5));
                    UpdateProduct jfrProduct = new UpdateProduct(sp);
                    jfrProduct.setTitle("Sửa thông tin sản phẩm");
                    jfrProduct.setResizable(false);
                    jfrProduct.setLocationRelativeTo(null);
                    jfrProduct.setVisible(true);
                }
            }

        });
        //
        MyDocumentListener doc = new MyDocumentListener();
        doc.setJtfSearch(jtfSearch1);
        doc.setSorter(sorter);
        jtfSearch1.getDocument().addDocumentListener(doc);
        //

        tableSP.validate();
        tableSP.repaint();
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(tableSP);
        scroll.setPreferredSize(new Dimension(1350, 400));
        tableSP.getColumnModel().getColumn(0).setPreferredWidth(20);
        tableSP.getColumnModel().getColumn(2).setPreferredWidth(400);
        jpnView1.removeAll();
        jpnView1.setLayout(new CardLayout());
        jpnView1.add(scroll);
        jpnView1.validate();
        jpnView1.repaint();

    }

    public void setDataToTableTrangThietBi() {
        ArrayList<TrangThietBi> list = ttbService.getAll();
        dtmTTB = new ClassTableModel().setTableTrangThietBi(list, listColumns2);
        tableTTB = new JTable(dtmTTB);
        sorter = new TableRowSorter<>(tableTTB.getModel());
        tableTTB.setRowSorter(sorter);

        jtfSearch2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch2.getText();
                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch2.getText();
                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        tableTTB.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        tableTTB.getTableHeader().setPreferredSize(new Dimension(100, 50));
        // Độ rộng các cột 

        tableTTB.getColumnModel().getColumn(0).setPreferredWidth(20);
        tableTTB.getColumnModel().getColumn(2).setPreferredWidth(400);
        /*jtb.getColumnModel().getColumn(0).setMaxWidth(50);
        jtb.getColumnModel().getColumn(0).setMinWidth(50);
        jtb.getColumnModel().getColumn(0).setPreferredWidth(50);
        jtb.getColumnModel().getColumn(1).setMaxWidth(50);
        jtb.getColumnModel().getColumn(1).setMinWidth(50);
        jtb.getColumnModel().getColumn(1).setPreferredWidth(50);
        jtb.getColumnModel().getColumn(4).setMaxWidth(80);
        jtb.getColumnModel().getColumn(4).setMinWidth(80);
        jtb.getColumnModel().getColumn(4).setPreferredWidth(80);
        jtb.getColumnModel().getColumn(7).setMaxWidth(200);
        jtb.getColumnModel().getColumn(7).setMinWidth(200);
        jtb.getColumnModel().getColumn(7).setPreferredWidth(200);*/
        // Độ rộng các cột
        tableTTB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && tableTTB.getSelectedRow() != -1) {

                    dtmTTB = (DefaultTableModel) tableTTB.getModel();

                    if (tableTTB.getSelectedRow() == -1) {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên bạn muốn cập nhật !");
                    } else {
                        int selectedRowIndex = tableTTB.getSelectedRow();
                        selectedRowIndex = tableTTB.convertRowIndexToModel(selectedRowIndex);
                        TrangThietBi ttb = new TrangThietBi();
                        ttb.setMatb(dtmTTB.getValueAt(selectedRowIndex, 1).toString());
                        ttb.setTentb((String) dtmTTB.getValueAt(selectedRowIndex, 2));
                        ttb.setNuocsx(dtmTTB.getValueAt(selectedRowIndex, 3).toString());
                        ttb.setGiamua((int) dtmTTB.getValueAt(selectedRowIndex, 4));
                        ttb.setSoluongton((int) dtmTTB.getValueAt(selectedRowIndex, 5));
                        UpdateEquipment jfEquipment = new UpdateEquipment(ttb);
                        jfEquipment.setTitle("Sửa thông tin thiết bị");
                        jfEquipment.setVisible(true);
                        jfEquipment.setResizable(false);
                        jfEquipment.setLocationRelativeTo(null);
                    }

                }
            }
        });
        tableTTB.setRowHeight(45);
        tableTTB.validate();
        tableTTB.repaint();
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(tableTTB);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView2.removeAll();
        jpnView2.setLayout(new CardLayout());
        jpnView2.add(scroll);
        jpnView2.validate();
        jpnView2.repaint();

    }

    public void setEvent() {
        jbtnAddPro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Product jfrProduct = new Product();
                jfrProduct.setVisible(true);
                jfrProduct.setTitle("Thêm mới sản phẩm");
                jfrProduct.setLocationRelativeTo(null);
            }

        });
        jbtnAddEqui.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Equipment jfrEquipment = new Equipment();
                jfrEquipment.setVisible(true);
                jfrEquipment.setTitle("Thêm mới trang thiết bị");
                jfrEquipment.setLocationRelativeTo(null);
            }

        });
        jbtnExportPro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ArrayList<SanPham> list = spService.getAll();
                XSSFWorkbook wb = new XSSFWorkbook();
                XSSFSheet sheet = wb.createSheet("Result");
                sheet.setColumnWidth(0, 2000);
                sheet.setColumnWidth(1, 3000);
                sheet.setColumnWidth(2, 3000);
                sheet.setColumnWidth(3, 7000);
                sheet.setColumnWidth(4, 3000);

                int rownum = 2;
                XSSFRow row = null;
                XSSFCell cell = null;

                row = sheet.createRow(rownum);

                XSSFRow title = sheet.createRow(0);
                XSSFCell titleCell = title.createCell(2);

                titleCell.setCellValue("DANH SÁCH SẢN PHẨM");

                // Số TT
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("Số TT");
                //  cell.setCellStyle(styleBold);
                // Môn học
                cell = row.createCell(1, CellType.NUMERIC);
                cell.setCellValue("Mã sản phẩm");
                //  cell.setCellStyle(styleBold);
                // Điểm quá trình
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("Tên sản phẩm");
                // cell.setCellStyle(styleBold);
                // Điểm giữa kỳ
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Mã danh mục");
                // cell.setCellStyle(styleBold);
                // Điểm cuối kỳ
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue("Mã đơn vị tính");
                // cell.setCellStyle(styleBold);
                // Điểm trung bình
                cell = row.createCell(5, CellType.NUMERIC);
                cell.setCellValue("Giá vốn");
                // cell.setCellStyle(styleBold);

                cell = row.createCell(6, CellType.NUMERIC);
                cell.setCellValue("Giá bán");
                //  cell.setCellStyle(styleBold);

                cell = row.createCell(7, CellType.NUMERIC);
                cell.setCellValue("Số lượng tồn");
                // cell.setCellStyle(styleBold);

                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue("Ngày thêm vào");
                //  cell.setCellStyle(styleBold);
                cell = row.createCell(9, CellType.STRING);
                cell.setCellValue("Ngày cập nhật");
                //  cell.setCellStyle(styleBold);
                cell = row.createCell(10, CellType.STRING);
                cell.setCellValue("Ghi chú");
                //  cell.setCellStyle(styleBold);

                for (int i = 0; i < list.size(); i++) {
                    rownum++;
                    row = sheet.createRow(rownum);

                    // Số TT
                    cell = row.createCell(0, CellType.NUMERIC);
                    cell.setCellValue(i + 1);
                    //cell.setCellStyle(styleData);
                    // Mã LHP 
                    cell = row.createCell(1, CellType.STRING);
                    cell.setCellValue(list.get(i).getMasp());
                    // cell.setCellStyle(styleData);

                    // Mã MH 
                    cell = row.createCell(2, CellType.STRING);
                    cell.setCellValue(list.get(i).getTensp());
                    // cell.setCellStyle(styleData);
                    // Tên MH 
                    cell = row.createCell(3, CellType.STRING);
                    cell.setCellValue(list.get(i).getMadm());
                    // cell.setCellStyle(styleData);
                    // Mã GVCT
                    cell = row.createCell(4, CellType.STRING);
                    cell.setCellValue(list.get(i).getMadm());
                    // cell.setCellStyle(styleData);
                    // Thứ
                    cell = row.createCell(5, CellType.NUMERIC);
                    cell.setCellValue(list.get(i).getGiavon());
                    //  cell.setCellStyle(styleData);
                    // Ca
                    cell = row.createCell(6, CellType.NUMERIC);
                    cell.setCellValue(list.get(i).getGiaban());
                    // cell.setCellStyle(styleData);
                    // Phòng
                    cell = row.createCell(7, CellType.NUMERIC);
                    cell.setCellValue(list.get(i).getSoluongton());
                    // cell.setCellStyle(styleData);
                    // Ngày thi
                    cell = row.createCell(8);
                    cell.setCellValue(list.get(i).getNgayAdd());
                    //cell.setCellStyle(styleData);      
                    cell = row.createCell(9);
                    cell.setCellValue(list.get(i).getNgayUpdate());

                    cell = row.createCell(10, CellType.STRING);
                    cell.setCellValue(list.get(i).getGhichu());
                }

                File file = new File("E:/Export/" + "dssp" + ".xlsx");
                file.getParentFile().mkdirs();

                try {
                    FileOutputStream outFile = new FileOutputStream(file);
                    wb.write(outFile);
                    Desktop desktop = Desktop.getDesktop();
                    desktop.open(file);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MaintainGoods_CTL.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MaintainGoods_CTL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }

    public void setEventRadionButton(JRadioButton jrdAll, JRadioButton jrdWater, JRadioButton jrdBread) {
        jrdAll.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                setDataToTableSanPham(1);
            }
        });
        jrdWater.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                setDataToTableSanPham(2);
            }
        });
        jrdBread.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                setDataToTableSanPham(3);
            }
        });

    }

}
