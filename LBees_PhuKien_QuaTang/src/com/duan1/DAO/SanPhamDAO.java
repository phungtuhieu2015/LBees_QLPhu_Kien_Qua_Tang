/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.DAO;

import com.duan1.Entity.SanPham;
import com.duan1.Helper.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class SanPhamDAO extends QLPK<SanPham, String> {

    String insert_SQL = "INSERT INTO SanPham (MaSP, MaVach, MaDM, MaDVT, TenSP, SoLuongTonKho, HinhAnh, TrangThai) VALUES  (?,?,?,?,?,?,?,?)";
    String update_SQL = "UPDATE SanPham SET MaDM = ? , MaDVT = ? , TenSP = ? , SoLuongTonKho = ? , HinhAnh = ? , TrangThai = ? WHERE MaSP = ?";
    String delete_SQL = "DELETE SanPham WHERE MaSP =?";
    String select_All_SQL = "SELECT * FROM SanPham";
    String select_ByID_SQL = "SELECT * FROM SanPham WHERE MaSP=?";
    String select_ByMV_SQL = "SELECT * FROM SanPham WHERE MaVach=?";
    String select_BySL_SQL = "Update SanPham set SoLuongTonKho=? WHERE MaSP= ?";
    String select_ByTT_SQL = "Update SanPham  set TrangThai=? WHERE MaSP= ?";
    String select_ThongKeSP = "SELECT MaSP ,SoLuong, (SoLuong * DonGia ) AS N'Tổng tiền' FROM dbo.SanPhamBan";

    @Override
    public void insert(SanPham entity) {
        XJdbc.executeUpdate(insert_SQL, entity.getMaSP(),
                entity.getMaVach(), entity.getMaDM(), entity.getMaDVT(), entity.getTenSP(),
                entity.getSoLuongTonKho(), entity.getHinhAnh(), entity.getTrangThai());
    }

    public void updateTT(String maSP, String trangThai) {
        XJdbc.executeUpdate(select_ByTT_SQL, trangThai, maSP);
    }

    @Override
    public void update(SanPham entity) {
        XJdbc.executeUpdate(update_SQL,
                entity.getMaVach(), entity.getMaDM(), entity.getMaDVT(), entity.getTenSP(),
                entity.getSoLuongTonKho(), entity.getHinhAnh(), entity.getTrangThai(), entity.getMaSP());
    }

    public void updateSL(String MaSP, int sl) {
        XJdbc.executeUpdate(select_BySL_SQL, sl, MaSP);
    }

    @Override
    public void delete(String key) {
        XJdbc.executeUpdate(delete_SQL, key);
    }

    @Override
    public List<SanPham> selectAll() {
        return selectBySql(select_All_SQL);
    }

    @Override
    public SanPham selectByid(String key) {
        List<SanPham> list = this.selectBySql(select_ByID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public SanPham selectByMV(String key) {
        List<SanPham> list = this.selectBySql(select_ByMV_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                SanPham entity = new SanPham();
                entity.setMaSP(rs.getString("MaSP"));
                entity.setMaDM(rs.getInt("MaDM"));
                entity.setMaDVT(rs.getInt("MaDVT"));
                entity.setMaVach(rs.getString("MaVach"));
                entity.setTenSP(rs.getString("TenSP"));
                entity.setSoLuongTonKho(rs.getInt("SoLuongTonKho"));
                entity.setTrangThai(rs.getString("TrangThai"));
                entity.setHinhAnh(rs.getString("HinhAnh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<SanPham> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM dbo.SanPhamBan WHERE MaSP LIKE ? OR TenSP LIKE  ?";
        return this.selectBySql(sql, "%" + keyword + "%", "%" + keyword + "%");
    }
}
