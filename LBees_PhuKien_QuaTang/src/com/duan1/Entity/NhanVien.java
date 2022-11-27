/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.Entity;

/**
 *
 * @author ASUS
 */
public class NhanVien {

    String MaNV;
    String TenNV;
    boolean GioiTinh;
    String CCCD;
    String SDT;
    String Gmail;
    boolean ChucVuString;
    String GhiChu;
    String HinhAnh;
    String MaTK;

    public NhanVien() {
    }

    public NhanVien(String MaNV, String TenNV, boolean GioiTinh, String CCCD, String SDT, String Gmail, boolean ChucVuString, String GhiChu, String HinhAnh, String MaTK) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.GioiTinh = GioiTinh;
        this.CCCD = CCCD;
        this.SDT = SDT;
        this.Gmail = Gmail;
        this.ChucVuString = ChucVuString;
        this.GhiChu = GhiChu;
        this.HinhAnh = HinhAnh;
        this.MaTK = MaTK;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String Gmail) {
        this.Gmail = Gmail;
    }

    public boolean isChucVuString() {
        return ChucVuString;
    }

    public void setChucVuString(boolean ChucVuString) {
        this.ChucVuString = ChucVuString;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public String getMaTK() {
        return MaTK;
    }

    public void setMaTK(String MaTK) {
        this.MaTK = MaTK;
    }
      
    
    
        
}
