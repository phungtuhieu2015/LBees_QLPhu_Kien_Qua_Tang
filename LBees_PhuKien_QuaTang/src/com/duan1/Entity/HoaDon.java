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
public class HoaDon {

    String MaHD;
    Date NgayTao;
    String GhiChu;
    String MaNV;
    String MaKH;

    public HoaDon() {
    }

    public HoaDon(String MaHD, Date NgayTao, String GhiChu, String MaNV, String MaKH) {
        this.MaHD = MaHD;
        this.NgayTao = NgayTao;
        this.GhiChu = GhiChu;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }
    
}