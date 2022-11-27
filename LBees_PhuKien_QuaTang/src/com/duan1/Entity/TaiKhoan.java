/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.Entity;

/**
 *
 * @author ASUS
 */
public class TaiKhoan {

    String MaTK;
    String TenTK;
    String MatKhau;

    public TaiKhoan() {
    }

    public TaiKhoan(String MaTK, String TenTK, String MatKhau) {
        this.MaTK = MaTK;
        this.TenTK = TenTK;
        this.MatKhau = MatKhau;
    }

    public String getMaTK() {
        return MaTK;
    }

    public void setMaTK(String MaTK) {
        this.MaTK = MaTK;
    }

    public String getTenTK() {
        return TenTK;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }
    
    

}
