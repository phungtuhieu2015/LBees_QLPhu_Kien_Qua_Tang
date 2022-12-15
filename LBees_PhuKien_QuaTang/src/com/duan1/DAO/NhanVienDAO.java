/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.DAO;

import com.duan1.Helper.XJdbc;
import java.util.List;
import com.duan1.Entity.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class NhanVienDAO extends QLPK<NhanVien, String> {

    String insert_SQL = "INSERT INTO dbo.NhanVien(MaNV,TenNV,GioiTinh,CCCD,SDT,Gmail,ChucVu,GhiChu,HinhAnh)VALUES(?,?,?,?,?,?,?,?,?)";
    String update_SQL = "UPDATE dbo.NhanVien SET TenNV=?,GioiTinh=?,CCCD=?,SDT=?,Gmail=?,ChucVu=?,GhiChu=?,HinhAnh=? WHERE MaNV =?";
    String delete_SQL = "DELETE dbo.NhanVien WHERE MaNV =?";
    String select_All_SQL = "SELECT * FROM dbo.NhanVien";
    String select_ByID_SQL = "SELECT * FROM dbo.NhanVien WHERE MaNV=?";
    String update_SQL_HinhAnh = "UPDATE dbo.NhanVien SET HinhAnh=? WHERE MaNV =?";

    @Override
    public void insert(NhanVien entity) {
        XJdbc.executeUpdate(insert_SQL, entity.getMaNV(), entity.getTenNV(), entity.isGioiTinh(), entity.getCCCD(), entity.getSDT(), entity.getGmail(), entity.isChucVu(), entity.getGhiChu(), entity.getHinhAnh());
    }

    @Override
    public void update(NhanVien entity) {
        XJdbc.executeUpdate(update_SQL, entity.getTenNV(), entity.isGioiTinh(), entity.getCCCD(), entity.getSDT(), entity.getGmail(), entity.isChucVu(), entity.getGhiChu(), entity.getHinhAnh(), entity.getMaNV());
    }
    public void updateHA(String DuongDan , String maNV){
        XJdbc.executeUpdate(update_SQL_HinhAnh,DuongDan,maNV);
    }

    @Override
    public void delete(String key) {
        XJdbc.executeUpdate(delete_SQL, key);
    }

    @Override
    public List<NhanVien> selectAll() {
        return selectBySql(select_All_SQL);
    }

    @Override
    public NhanVien selectByid(String key) {
        List<NhanVien> list = this.selectBySql(select_ByID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setTenNV(rs.getString("TenNV"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setCCCD(rs.getString("CCCD"));
                entity.setSDT(rs.getString("SDT"));
                entity.setGmail(rs.getString("Gmail"));
                entity.setChucVu(rs.getBoolean("ChucVu"));
                entity.setGhiChu(rs.getString("GhiChu"));
                entity.setHinhAnh(rs.getString("HinhAnh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
