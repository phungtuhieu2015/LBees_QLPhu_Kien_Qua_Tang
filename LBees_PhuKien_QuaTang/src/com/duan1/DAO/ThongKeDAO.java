
package com.duan1.DAO;

import com.duan1.Helper.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ThongKeDAO {

    //////////////////////////////Thống kê Tổng số lượng hoá đơn
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

    public int tongSLHoaDD() throws SQLException {
        String tong = "SELECT  COUNT(MaHD) as'tong'  FROM dbo.HoaDon";
        return tongSLHoaDon(tong);
    }

    
    ///////////////////////Thống kê tổng nhập khho
    protected Integer tongSLNP(String sql) throws SQLException {

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

    public int tongSLNhapKho() throws SQLException {
        String tong = "SELECT COUNT(MaPNK) AS'Tong' FROM dbo.PhieuNhapKho";
        return tongSLNP(tong);
    }
    
    
   ///thống kê tổng xuất kho
    
    public int tongSLXuatK() throws SQLException {
         String tong = "SELECT COUNT(MaHD) AS'Tong' FROM dbo.HoaDon";
        return tongSLNP(tong);
    }
    
     public int tongDoanhThu() throws SQLException {
         String tong = " SELECT  SUM(ThanhTien) -SUM(TienShip) AS'tong'  FROM dbo.HoaDon INNER JOIN dbo.HoaDonChiTiet ON HoaDonChiTiet.MaHD = HoaDon.MaHD";
        return tongSLNP(tong);
    }
     public int tongToanKho() throws SQLException {
         String tong = "SELECT SUM(SoLuong) AS'tong' FROM dbo.SanPhamBan";
        return tongSLNP(tong);
    }
   
     public List<Object[]> getDoanhThu(Date tuNgay , Date denNgay) {
        List<Object[]> list = new ArrayList<>();
          
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_ThongKeDoanhThu (?),(?)}";
                rs = XJdbc.executeQuery(sql, tuNgay, denNgay);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaHD"), rs.getDate("NgayTao"), rs.getDouble("DThu")};
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
