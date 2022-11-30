/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.DAO;

import com.duan1.Entity.HoaDon;
import com.duan1.Helper.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class HoaDonDAO extends QLPK<HoaDon, String> {

    String insert_SQL = "INSERT dbo.HoaDon(MaHD,NgayTao,TienShip,GhiChu,MaNV,MaKH)VALUES(?,?,?,?,?)";
    String update_SQL = "UPDATE dbo.HoaDon SET NgayTao=?,TienShip ,GhiChu=?,MaNV=?,MaKH=? WHERE MaHD =?";
    String delete_SQL = "DELETE dbo.HoaDon WHERE MaHD =?";
    String select_All_SQL = "SELECT * FROM dbo.HoaDon";
    String select_ByID_SQL = "SELECT * FROM dbo.HoaDon WHERE MaHD=?";
String select_Max_ID = "SELECT MAX(MaKH) FROM dbo.KhachHang";
 String select_ByID_SQL_TK = "SELECT * FROM dbo.HoaDon WHERE NgayTao=?";
    @Override
    public void insert(HoaDon entity) {
        XJdbc.executeUpdate(insert_SQL, entity.getMaHD(), entity.getNgayTao(),entity.getTienShip(), entity.getGhiChu(), entity.getMaNV(), entity.getMaKH());
    }

    @Override
    public void update(HoaDon entity) {
        XJdbc.executeUpdate(update_SQL, entity.getNgayTao(), entity.getGhiChu(),entity.getTienShip(), entity.getMaNV(), entity.getMaKH(), entity.getMaHD());
    }

    @Override
    public void delete(String MaHD) {
        XJdbc.executeUpdate(delete_SQL, MaHD);
    }

    @Override
    public List<HoaDon> selectAll() {
        return selectBySql(select_All_SQL);
    }

    @Override
    public HoaDon selectByid(String MaHD) {
        List<HoaDon> list = this.selectBySql(select_ByID_SQL, MaHD);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
public String select_Last_ID() throws SQLException{
        ResultSet rs =  XJdbc.executeQuery(select_Max_ID);
        return rs.getString("MaHD");
    }
    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
                        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {                
                HoaDon entity  = new HoaDon();
                entity.setMaHD(rs.getString("MaHD"));
                entity.setNgayTao(rs.getDate("NgayTao"));
                entity.setTienShip(rs.getFloat("TienShip"));
                entity.setGhiChu(rs.getString("GhiChu"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setMaKH(rs.getString("MaKH"));
                list.add(entity);
            } 
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<HoaDon> selectByKeyword(String keyword){
        String sql = "SELECT * FROM HoaDon WHERE MaHD LIKE ?";
        return this.selectBySql(sql, "%"+keyword+'%');
    }
    
    public HoaDon selectByid_tk(String NgayTao) {
        List<HoaDon> list = this.selectBySql(select_ByID_SQL_TK, NgayTao);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public List<HoaDon> selectByKeyword_tk(String keyword){
        String sql = "SELECT * FROM HoaDon WHERE NgayTao LIKE ?";
        return  this.selectBySql(sql, "%"+keyword+'%' );
    }
  protected Integer tongSLHoaDon(String sql) throws SQLException {

        int sl = 0;
        try {
            ResultSet rs = XJdbc.executeQuery(sql);
            while (rs.next()) {
                sl = rs.getInt("tong");
                System.out.println(rs.getInt(0));
            }
            rs.getStatement().getConnection().close();

        } catch (Exception e) {
        }
        return sl;
    }

    public int s() throws SQLException {
        String tong = "SELECT  COUNT(MaHD) as'tong'  FROM dbo.HoaDon";
        return tongSLHoaDon(tong);
    }
   
}

