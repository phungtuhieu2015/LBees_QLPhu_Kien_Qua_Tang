
package com.duan1.DAO;


import com.duan1.Entity.DonHang;
import com.duan1.Helper.XJdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DonHangDAO extends QLPK<DonHang, String> {

    String insert_SQL = "INSERT INTO DonHang (MaDH, MaKH, MaHD, TenNN, SdtNN, DiaChiNN, NgayGiao, GhiChu) VALUES  (?,?,?,?,?,?,?,?)";
    String update_SQL = "UPDATE DonHang SET  TenNN = ? , SdtNN = ? , DiaChiNN = ? , NgayGiao = ? , GhiChu = ? WHERE MaDH = ?";
    String delete_SQL = "DELETE  DonHang WHERE MaDH =?";
    String select_All_SQL = "SELECT * FROM DonHang ";
    String select_ByID_SQL = "SELECT * FROM DonHang  WHERE MaDH = ?";
    String select_Max_Id = "SELECT Max(SUBSTRING(MaDH,LEN(MaDH) - 3,LEN(MaDH)))FROM QuaTang";
    @Override
    public void insert(DonHang entity) {
        XJdbc.executeUpdate(insert_SQL, entity.getMaDH(), entity.getMaKH(),entity.getMaHD(),entity.getTenNN(), 
                entity.getSdtNN(),entity.getDiaChiNN(), 
                entity.getNgayGiao(), entity.getGhiChu());
    }

    @Override
    public void update(DonHang entity) {
        XJdbc.executeUpdate(update_SQL, entity.getTenNN(), 
                entity.getSdtNN(),entity.getDiaChiNN(), 
                entity.getNgayGiao(), entity.getGhiChu(),entity.getMaDH());
    }

    @Override

    public void delete(String key) {
        XJdbc.executeUpdate(delete_SQL, key);
    }

    @Override
    public List<DonHang> selectAll() {
        return selectBySql(select_All_SQL);
    }

    @Override
    public DonHang selectByid(String key) {
        List<DonHang> list = this.selectBySql(select_ByID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<DonHang> selectBySql(String sql, Object... args) {
        List<DonHang> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while (rs.next()) {
                DonHang entity = new DonHang();
                entity.setMaDH(rs.getString("MaDH"));
                entity.setTenNN(rs.getString("TenNN"));
                entity.setDiaChiNN(rs.getString("DiaChiNN"));
                entity.setSdtNN(rs.getString("SdtNN"));
                entity.setNgayGiao(rs.getDate("NgayGiao"));
                entity.setGhiChu(rs.getString("GhiChu"));
                entity.setMaHD(rs.getString("MaHD"));
                entity.setDiaChiNN(rs.getString("DiaChiNN"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getLastID() throws SQLException {
            ResultSet rs = XJdbc.executeQuery(select_Max_Id);
            String id = null;
            if (rs.next()) {
                id = rs.getString(1);
            }
            rs.getStatement().getConnection().close();
            return id;
    }
    public String initID () throws SQLException {
        String id = getLastID();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
        int idNumber = Integer.parseInt(id);
        String newID = String.format(sdf.format(date) + "%04d", idNumber += 1);
        return newID;
    }
}