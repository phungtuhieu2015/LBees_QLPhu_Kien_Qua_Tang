/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.Entity;

/**
 *
 * @author ASUS
 */
public class NguoiGiaoHang {

    String MaNGH;
    String TenNGH;
    String CCCD;
    String SDT;
    String Gmail;

    public NguoiGiaoHang() {
    }

    @Override
    public String toString() {
        return getTenNGH() + " - " + getMaNGH();
    }
    
    
    public NguoiGiaoHang(String MaNGH, String TenNGH, String CCCD, String SDT, String Gmail) {
        this.MaNGH = MaNGH;
        this.TenNGH = TenNGH;
        this.CCCD = CCCD;
        this.SDT = SDT;
        this.Gmail = Gmail;
    }

    public String getMaNGH() {
        return MaNGH;
    }

    public void setMaNGH(String MaNGH) {
        this.MaNGH = MaNGH;
    }

    public String getTenNGH() {
        return TenNGH;
    }

    public void setTenNGH(String TenNGH) {
        this.TenNGH = TenNGH;
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
    
    
}
