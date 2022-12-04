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

    String maDH;
    String tenNN;
    String diaChiNN;
    String SDTNN;
    Date ngayGiao;
    String trangThai;
    String ghiChu;
    String maNGH;
    String maHD;

    public QuaTang() {
    }

    public QuaTang(String maDH, String tenNN, String diaChiNN, String SDTNN, Date ngayGiao, String trangThai, String ghiChu, String maNGH, String maHD) {
        this.maDH = maDH;
        this.tenNN = tenNN;
        this.diaChiNN = diaChiNN;
        this.SDTNN = SDTNN;
        this.ngayGiao = ngayGiao;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
        this.maNGH = maNGH;
        this.maHD = maHD;
    }

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public String getTenNN() {
        return tenNN;
    }

    public void setTenNN(String tenNN) {
        this.tenNN = tenNN;
    }

    public String getDiaChiNN() {
        return diaChiNN;
    }

    public void setDiaChiNN(String diaChiNN) {
        this.diaChiNN = diaChiNN;
    }

    public String getSDTNN() {
        return SDTNN;
    }

    public void setSDTNN(String SDTNN) {
        this.SDTNN = SDTNN;
    }

    public Date getNgayGiao() {
        return ngayGiao;
    }

    public void setNgayGiao(Date ngayGiao) {
        this.ngayGiao = ngayGiao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaNGH() {
        return maNGH;
    }

    public void setMaNGH(String maNGH) {
        this.maNGH = maNGH;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

}
