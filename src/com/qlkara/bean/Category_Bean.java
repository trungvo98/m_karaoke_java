/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlkara.bean;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author trung98
 */
public class Category_Bean {
    String kind ;
    JPanel jpn;
    JLabel jlb;

    public Category_Bean() {
    }

    public Category_Bean(String kind, JPanel jpn, JLabel jlb) {
        this.kind = kind;
        this.jpn = jpn;
        this.jlb = jlb;
    }

    public String getKind() {
        return kind;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public JLabel getJlb() {
        return jlb;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }

    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }
    
}
