/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.DAO;

import com.duan1.Entity.NguoiGiaoHang;
import com.duan1.Helper.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class NguoiGiaoHangDAO extends QLPK<NguoiGiaoHang, String> {

    String insert_SQL = "INSERT INTO dbo.NguoiGiaoHang(MaNGH,TenNGH,CCCD,SDT,Gmail)VALUES(?,?,?,?,?)";
    String update_SQL = "UPDATE dbo.NguoiGiaoHang SET TenNGH=? ,CCCD=?,SDT=?,Gmail=? WHERE MaNGH=? ";
    String delete_SQL = "DELETE dbo.NguoiGiaoHang WHERE MaNGH =?";
    String select_All_SQL = "SELECT * FROM dbo.NguoiGiaoHang";
    String select_ByID_SQL = "SELECT * FROM dbo.NguoiGiaoHang WHERE MaNGH=?";
    String select_Max_ID = "SELECT MAX(MaNGH) FROM dbo.NguoiGiaoHang";

    @Override
    public void insert(NguoiGiaoHang entity) {
        XJdbc.executeUpdate(insert_SQL, entity.getMaNGH(), entity.getTenNGH(), entity.getCCCD(), entity.getSDT(), entity.getGmail());
    }

    @Override
    public void update(NguoiGiaoHang entity) {
        XJdbc.executeUpdate(update_SQL, entity.getTenNGH(), entity.getCCCD(), entity.getSDT(), entity.getGmail(), entity.getMaNGH());
    }

    @Override
    public void delete(String MaNGH) {
        XJdbc.executeUpdate(delete_SQL, MaNGH);
    }

    @Override
    public List<NguoiGiaoHang> selectAll() {
        return selectBySql(select_All_SQL);

    }

    @Override
    public NguoiGiaoHang selectByid(String key) {
        List<NguoiGiaoHang> list = this.selectBySql(select_ByID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    public String select_Last_ID() throws SQLException {
        ResultSet rs = XJdbc.executeQuery(select_Max_ID);
        return rs.getString("MaNGH");
    }

    public String getLastID() throws SQLException {
        ResultSet rs = XJdbc.executeQuery(select_Max_ID);
        if (rs.next()) {
            return rs.getString(1);
        }
        return null;
    }
    
    public String initID() throws SQLException {
        String id = getLastID();
        int idNumber = Integer.parseInt(id.replaceAll("\\D+",""));
        String newID = String.format("%05d", idNumber += 1);
        return newID;
    }

    @Override
    protected List<NguoiGiaoHang> selectBySql(String sql, Object... args) {
        List<NguoiGiaoHang> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                NguoiGiaoHang entity = new NguoiGiaoHang();
                entity.setMaNGH(rs.getString("MaNGH"));
                entity.setTenNGH(rs.getString("TenNGH"));
                entity.setCCCD(rs.getString("CCCD"));
                entity.setSDT(rs.getString("SDT"));
                entity.setGmail(rs.getString("Gmail"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
