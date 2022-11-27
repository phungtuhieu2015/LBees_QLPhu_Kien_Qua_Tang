/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.DAO;

import com.duan1.Entity.DanhMuc;
import com.duan1.Entity.KhachHang;
import com.duan1.Helper.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class KhachHangDAO extends QLPK<KhachHang, String> {

    String insert_SQL = "INSERT dbo.KhachHang(MaKH,TenKH,SDT,DiemTichLuy)VALUES(?,?,?,?)";
    String update_SQL = "UPDATE dbo.KhachHang SET TenKH=? , SDT=? ,DiemTichLuy=? WHERE MaKH=?";
    String delete_SQL = "DELETE dbo.KhachHang WHERE MaKH =?";
    String select_All_SQL = "SELECT * FROM dbo.KhachHang";
    String select_ByID_SQL = "SELECT * FROM dbo.KhachHang WHERE MaKH=?";

    @Override
    public void insert(KhachHang entity) {
        XJdbc.executeUpdate(insert_SQL, entity.getMaKH(), entity.getTenKH(), entity.getSDT(), entity.getDiemTichLuy());
    }

    @Override
    public void update(KhachHang entity) {
        XJdbc.executeUpdate(update_SQL, entity.getTenKH(), entity.getSDT(), entity.getDiemTichLuy(), entity.getMaKH());
    }

    @Override
    public void delete(String MaKH) {
        XJdbc.executeUpdate(delete_SQL, MaKH);
    }

    @Override
    public List<KhachHang> selectAll() {
        return selectBySql(select_All_SQL);
    }

    @Override
    public KhachHang selectByid(String MaKH) {
        List<KhachHang> list = this.selectBySql(select_ByID_SQL, MaKH);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setMaKH(rs.getString("MaKH"));
                entity.setTenKH(rs.getString("TenKH"));
                entity.setSDT(rs.getString("SDT"));
                entity.setDiemTichLuy(rs.getInt("DiemTichLuy"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
