/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.DAO;


import com.duan1.Entity.TaiKhoan;
import com.duan1.Helper.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class TaiKhoanDAO extends QLPK<TaiKhoan, String> {

    String insert_SQL = "INSERT INTO dbo.TaiKhoan(MaTK,TenTK,MatKhau)VALUES(?,?,?)";
    String update_SQL = "UPDATE dbo.TaiKhoan SET TenTK=?,MatKhau=?  WHERE MaTK =?";
    String delete_SQL = "DELETE dbo.Taihoan WHERE MaTK =?";
    String select_All_SQL = "SELECT * FROM dbo.TaiKhoan";
    String select_ByID_SQL = "SELECT * FROM dbo.TaiKhoan WHERE MaTK=?";

    @Override
    public void insert(TaiKhoan entity) {
        XJdbc.executeUpdate(insert_SQL, entity.getMaTK(), entity.getTenTK(), entity.getMatKhau());
    }

    @Override
    public void update(TaiKhoan entity) {
        XJdbc.executeUpdate(update_SQL, entity.getTenTK(), entity.getMaTK(), entity.getMaTK());
    }

    @Override
    public void delete(String key) {
        XJdbc.executeUpdate(delete_SQL, key);
    }

    @Override
    public List<TaiKhoan> selectAll() {
        return selectBySql(select_All_SQL);
    }

    @Override
    public TaiKhoan selectByid(String key) {
        List<TaiKhoan> list = this.selectBySql(select_ByID_SQL,key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<TaiKhoan> selectBySql(String sql, Object... args) {
                List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                TaiKhoan entity = new TaiKhoan();
                entity.setMaTK(rs.getString("MaTK"));
                entity.setTenTK(rs.getString("TenTK"));
                entity.setMatKhau(rs.getString("MatKhau"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
