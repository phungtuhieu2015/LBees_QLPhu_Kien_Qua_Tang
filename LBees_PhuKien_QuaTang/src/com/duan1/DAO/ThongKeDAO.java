
package com.duan1.DAO;

import com.duan1.Helper.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;


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
}
