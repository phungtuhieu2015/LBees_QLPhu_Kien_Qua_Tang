/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.Entity;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class QuaTang {

    String MaDH;
    String TenNN;
    String DiaChiNN;
    String SDTNN;
    Date NgayGiao;
    String TrangThai;
    String GhiChu;
    String MaNGH;
    String MaHD;

    public QuaTang() {
    }

    public QuaTang(String MaDH, String TenNN, String DiaChiNN, String SDTNN, Date NgayGiao, String TrangThai, String GhiChu, String MaNGH, String MaHD) {
        this.MaDH = MaDH;
        this.TenNN = TenNN;
        this.DiaChiNN = DiaChiNN;
        this.SDTNN = SDTNN;
        this.NgayGiao = NgayGiao;
        this.TrangThai = TrangThai;
        this.GhiChu = GhiChu;
        this.MaNGH = MaNGH;
        this.MaHD = MaHD;
    }

    public String getMaDH() {
        return MaDH;
    }

    public void setMaDH(String MaDH) {
        this.MaDH = MaDH;
    }

    public String getTenNN() {
        return TenNN;
    }

    public void setTenNN(String TenNN) {
        this.TenNN = TenNN;
    }

    public String getDiaChiNN() {
        return DiaChiNN;
    }

    public void setDiaChiNN(String DiaChiNN) {
        this.DiaChiNN = DiaChiNN;
    }

    public String getSDTNN() {
        return SDTNN;
    }

    public void setSDTNN(String SDTNN) {
        this.SDTNN = SDTNN;
    }

    public Date getNgayGiao() {
        return NgayGiao;
    }

    public void setNgayGiao(Date NgayGiao) {
        this.NgayGiao = NgayGiao;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getMaNGH() {
        return MaNGH;
    }

    public void setMaNGH(String MaNGH) {
        this.MaNGH = MaNGH;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    
}
