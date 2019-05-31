package com.qlkara.utilities;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author trung98
 */
public class MyDocumentListener implements DocumentListener {

    private JTextField jtfSearch;
    private TableRowSorter<TableModel> sorter;

    public void setJtfSearch(JTextField jtfSearch) {
        this.jtfSearch = jtfSearch;
    }

    public void setSorter(TableRowSorter<TableModel> sorter) {
        this.sorter = sorter;
    }
    

    @Override
    public void insertUpdate(DocumentEvent e) {
        String text = jtfSearch.getText();
        if (text.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        String text = jtfSearch.getText();
        if (text.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
