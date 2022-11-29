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
   int SoLuong;	
   double ThanhTien;	
   String MaSP;	
   String MaHD;	

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int SoLuong, double ThanhTien, String MaSP, String MaHD) {
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
        this.MaSP = MaSP;
        this.MaHD = MaHD;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
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
