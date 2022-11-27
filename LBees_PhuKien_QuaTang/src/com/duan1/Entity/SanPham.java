/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.Entity;

/**
 *
 * @author ASUS
 */
public class SanPham {

    String MaSP;
    String TenSP;
    int SoLuong;
    String DonViTinh;
    double DonGia ;
    boolean TrangThai;
    String MaVach;
    String HinhAnh;
    String MaNV;
    String MaDM;

    public SanPham() {
    }

    public SanPham(String MaSP, String TenSP, int SoLuong, String DonViTinh, double DonGia, boolean TrangThai, String MaVach, String HinhAnh, String MaNV, String MaDM) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
        this.DonViTinh = DonViTinh;
        this.DonGia = DonGia;
        this.TrangThai = TrangThai;
        this.MaVach = MaVach;
        this.HinhAnh = HinhAnh;
        this.MaNV = MaNV;
        this.MaDM = MaDM;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String DonViTinh) {
        this.DonViTinh = DonViTinh;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getMaVach() {
        return MaVach;
    }

    public void setMaVach(String MaVach) {
        this.MaVach = MaVach;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaDM() {
        return MaDM;
    }

    public void setMaDM(String MaDM) {
        this.MaDM = MaDM;
    }
    
    
}
