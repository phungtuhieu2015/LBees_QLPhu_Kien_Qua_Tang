/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.Entity;

/**
 *
 * @author asus
 */
public class PhieuNhapChiTiet {
    String maPNK;
    String maSP;
    int soLuong;
    float thanhTien;

    public PhieuNhapChiTiet() {
    }

    public PhieuNhapChiTiet(String maPNK, String maSP, int soLuong, float thanhTien) {
        this.maPNK = maPNK;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public String getMaPNK() {
        return maPNK;
    }

    public void setMaPNK(String maPNK) {
        this.maPNK = maPNK;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
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

   
    
}
