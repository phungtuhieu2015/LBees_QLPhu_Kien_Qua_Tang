/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.DAO;

import com.duan1.Entity.PhieuNhapKho;
import com.duan1.Helper.XJdbc;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author asus
 */
public class PhieuNhapKhoDAO extends QLPK<PhieuNhapKho, String> {

    String insert_SQL = "INSERT INTO dbo.PhieuNhapKho(MaPNK,SoLuong,ThanhTien,NgayNhap,MaSP)VALUES(?,?,?,?,?)";
    String update_SQL = "UPDATE dbo.PhieuNhapKho SET SoLuong=?,ThanhTien=?,NgayNhap=?,MaSP=?  WHERE MaPNK =?";
    String delete_SQL = "DELETE dbo.PhieuNhapKho WHERE MaPNK =?";
    String select_All_SQL = "SELECT * FROM dbo.PhieuNhapKho";
    String select_ByID_SQL = "SELECT * FROM dbo.PhieuNhapKho WHERE MaPNK=?";

    @Override
    public void insert(PhieuNhapKho entity) {
        XJdbc.executeUpdate(insert_SQL, entity.getMaPNK(), entity.getSoLuong(), entity.getThanhTien(), entity.getNgayNhap(), entity.getMaSP());
    }

    @Override
    public void update(PhieuNhapKho entity) {
        XJdbc.executeUpdate(update_SQL, entity.getSoLuong(), entity.getThanhTien(), entity.getNgayNhap(), entity.getMaSP(), entity.getMaPNK());
    }

    @Override
    public void delete(String key) {
        XJdbc.executeUpdate(delete_SQL, key);
    }

    @Override
    public List<PhieuNhapKho> selectAll() {
        return selectBySql(select_All_SQL);
    }

    @Override
    public PhieuNhapKho selectByid(String key) {
        List<PhieuNhapKho> list = this.selectBySql(select_ByID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<PhieuNhapKho> selectBySql(String sql, Object... args) {
        List<PhieuNhapKho> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                PhieuNhapKho entity = new PhieuNhapKho();
                entity.setMaPNK(rs.getString("MaPNK"));
                entity.setSoLuong(rs.getInt("SoLuong"));
                entity.setThanhTien(rs.getFloat("ThanhTien"));
                entity.setNgayNhap(rs.getDate("NgayNhap"));
                entity.setMaSP(rs.getString("MaSP"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
