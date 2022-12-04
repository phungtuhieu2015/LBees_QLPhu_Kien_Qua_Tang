/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.Entity;

/**
 *
 * @author MSI PC
 */
public class HoaDonChiTiet {
   int soLuong;	
   double thanhTien;	
   String maSP;	
   String maHD;	

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int soLuong, double thanhTien, String maSP, String maHD) {
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.maSP = maSP;
        this.maHD = maHD;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    
	
}
