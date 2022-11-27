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
    int soLuong;
    float thanhTien;
    Date NgayNhap;
    String maSP;

    public PhieuNhapKho() {
    }

    public PhieuNhapKho(String maPNK, int soLuong, float thanhTien, Date NgayNhap, String maSP) {
        this.maPNK = maPNK;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.NgayNhap = NgayNhap;
        this.maSP = maSP;
    }

    public String getMaPNK() {
        return maPNK;
    }

    public void setMaPNK(String maPNK) {
        this.maPNK = maPNK;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

}
