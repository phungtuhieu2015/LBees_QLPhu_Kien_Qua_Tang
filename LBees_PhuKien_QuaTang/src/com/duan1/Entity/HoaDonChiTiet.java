/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.Entity;

/**
 *
 * @author asus
 */
public class HoaDonChiTiet {
     int soLuong;
    float thanhTien;
    String MaSP;
    String MaHD;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int soLuong, float thanhTien, String MaSP, String MaHD) {
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.MaSP = MaSP;
        this.MaHD = MaHD;
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

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }
    
}
