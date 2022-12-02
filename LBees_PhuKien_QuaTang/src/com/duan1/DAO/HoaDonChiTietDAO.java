/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.DAO;

import com.duan1.Entity.HoaDonChiTiet;
import com.duan1.Helper.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phung
 */
public class HoaDonChiTietDAO extends QLPK<HoaDonChiTiet, String>{
    
    String insert_SQL = "INSERT INTO dbo.HoaDonChiTiet(SoLuong,ThanhTien,MaSP,MaHD)VALUES(?,?,?,?)";
    String update_SQL = "UPDATE dbo.HoaDonChiTiet SET SoLuong=?,ThanhTien=?,MaSP=?WHERE MaHD =?";
    String delete_SQL = "DELETE dbo.HoaDonChiTiet WHERE MaHD =?";
    String select_All_SQL = "SELECT * FROM dbo.HoaDonChiTiet";
    String select_ByID_SQL = "SELECT * FROM dbo.HoaDonChiTiet WHERE MaHD=?";

    @Override
    public void insert(HoaDonChiTiet entity) {
        XJdbc.executeUpdate(insert_SQL, entity.getSoLuong(), entity.getThanhTien(), entity.getMaSP(), entity.getMaHD());
    }

    @Override
    public void update(HoaDonChiTiet entity) {
        XJdbc.executeUpdate(update_SQL, entity.getSoLuong(), entity.getThanhTien(), entity.getMaSP(), entity.getMaHD());
    }

    @Override
    public void delete(String key) {
        XJdbc.executeUpdate(delete_SQL, key);
    }

    @Override
    public List<HoaDonChiTiet> selectAll() {
        return selectBySql(select_All_SQL);
    }

    @Override
    public HoaDonChiTiet selectByid(String key) {
        List<HoaDonChiTiet> list = this.selectBySql(select_ByID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<HoaDonChiTiet> selectBySql(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                HoaDonChiTiet entity = new HoaDonChiTiet();
                entity.setSoLuong(rs.getInt("SoLuong"));
                entity.setThanhTien(rs.getFloat("ThanhTien"));
                entity.setMaSP(rs.getString("MaSp"));
                entity.setMaHD(rs.getString("MaHD"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
