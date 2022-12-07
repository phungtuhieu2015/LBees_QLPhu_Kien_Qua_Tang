
package com.duan1.Entity;


public class NguoiGiaoHang {

    String maNGH;
    String tenNGH;
    String CCCD;
    String SDT;
    String gmail;
    
    public NguoiGiaoHang() {
    }

    public NguoiGiaoHang(String maNGH, String tenNGH, String CCCD, String SDT, String gmail) {
        this.maNGH = maNGH;
        this.tenNGH = tenNGH;
        this.CCCD = CCCD;
        this.SDT = SDT;
        this.gmail = gmail;
    }

    

    @Override
    public String toString() {
        return getTenNGH() + " - " + getMaNGH();
    }

    public String getMaNGH() {
        return maNGH;
    }

    public void setMaNGH(String maNGH) {
        this.maNGH = maNGH;
    }

    public String getTenNGH() {
        return tenNGH;
    }

    public void setTenNGH(String tenNGH) {
        this.tenNGH = tenNGH;
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
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    
}
