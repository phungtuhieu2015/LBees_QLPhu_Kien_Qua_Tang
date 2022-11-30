/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.Entity;

import java.util.Date;

/**
 *
 * @author asus
 */
public class PhieuNhapKho {

    String maPNK;
    Date ngayNhap;

    public PhieuNhapKho() {
    }

    public PhieuNhapKho(String maPNK, Date ngayNhap) {
        this.maPNK = maPNK;
        this.ngayNhap = ngayNhap;
    }

    public String getMaPNK() {
        return maPNK;
    }

    public void setMaPNK(String maPNK) {
        this.maPNK = maPNK;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    

}
