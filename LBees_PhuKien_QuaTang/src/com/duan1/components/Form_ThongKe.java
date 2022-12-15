package com.duan1.components;

import com.duan1.DAO.HoaDonDAO;
import com.duan1.DAO.ThongKeDAO;
import com.duan1.Entity.HoaDon;
import com.duan1.Helper.XDate;
import com.duan1.swing.EventCallBack;
import com.duan1.swing.EventTextField;
import com.duan1.ui.MainJFrame;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Form_ThongKe extends javax.swing.JPanel {

    ThongKeDAO daoTKe = new ThongKeDAO();
    HoaDon hd = new HoaDon();
    HoaDonDAO daoHD = new HoaDonDAO();
    String mauNgay = "dd-MM-yyyy";

    public Form_ThongKe() {
        initComponents();
        setHin();
        TimKiem();
        txtTuNgay.setText("");
        txtDenNgay.setText("");
//        fillTableDoanhThu();
//        fillComboBoxNam();
    }

    public void setHin() {
        txtTuNgay.setLabelText("Từ ngày");
        txtDenNgay.setLabelText("Đến ngày");
        lblSLHoadon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblIconNX.setCursor(new Cursor(Cursor.HAND_CURSOR));
        try {
            int TongHD = daoTKe.tongSLHoaDD();
            lblSLHoadon.setText("Tổng số lượng hoá đơn : " + String.valueOf(TongHD));

            int tongNhap = daoTKe.tongSLNhapKho();
            lblNhapKho.setText(String.valueOf(tongNhap) + " SP");

            int XuatNhap = daoTKe.tongSLXuatK();
            lblXuatKho.setText(String.valueOf(XuatNhap) + " SP");

            int TongDT = daoTKe.tongDoanhThu();
            lblTongDoanhThu.setText(String.valueOf(TongDT) + " VNĐ");

            int TonKho = daoTKe.tongToanKho();
            lblTonKho.setText(String.valueOf(TonKho) + " SP");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void TimKiem() {
        txtTimKiem.setHintText("Nhập mã để tìm kiếm");
        txtTimKiem.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                //  Test
                try {
                    for (int i = 1; i <= 100; i++) {

                        Thread.sleep(5);
                    }
                    call.done();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }

            @Override
            public void onCancel() {

            }
        });
    }

    void fillTableDoanhThu() {
        DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
        model.setRowCount(0);
        Date d = new Date();
        String tn = "01-01-1975";
        String dn = XDate.toString(d, mauNgay);

        if (!txtDenNgay.getText().trim().isEmpty() && !txtTuNgay.getText().trim().isEmpty()) {
            tn = txtTuNgay.getText();
            dn = txtDenNgay.getText();
        }

        Date tuNgay = XDate.toDate(tn, mauNgay);
        Date denNgay = XDate.toDate(dn, mauNgay);
        List<Object[]> list = daoTKe.getDoanhThu(tuNgay, denNgay);
        for (Object[] row : list) {
            model.addRow(row);
        }

    }

    void fillComboBoxNam() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboDoanhThuu.getModel();
        model.removeAllElements();

        List<HoaDon> list = daoHD.selectAll();
        for (HoaDon kh : list) {
            int nam = kh.getNgayTao().getYear() + 1900;
            if (model.getIndexOf(nam) < 0) {
                model.addElement(nam);
            }
        }

        cboDoanhThuu.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TuNgay_Date = new com.duan1.swing.DateChooser();
        DenNgay_Date = new com.duan1.swing.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        table3 = new com.duan1.swing.MaterialTabbed();
        pnlCapNhat1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDoanhThu = new com.duan1.swing.Table();
        pnlDanhSach1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table5 = new com.duan1.swing.Table();
        txtTimKiem = new com.duan1.swing.TextFieldAnimation();
        lblTuNgay1 = new javax.swing.JLabel();
        lblDenNgay1 = new javax.swing.JLabel();
        cboDoanhThuu = new com.duan1.swing.ComboBoxSuggestion();
        txtTuNgay = new com.duan1.swing.MyTextField2();
        txtDenNgay = new com.duan1.swing.MyTextField2();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTonKho = new javax.swing.JLabel();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        jLabel11 = new javax.swing.JLabel();
        lblTongDoanhThu = new javax.swing.JLabel();
        lblSLHoadon = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        kGradientPanel6 = new keeptoo.KGradientPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblIconNX = new javax.swing.JLabel();
        lblNhapKho = new javax.swing.JLabel();
        lblXuatKho = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        TuNgay_Date.setForeground(new java.awt.Color(0, 204, 255));
        TuNgay_Date.setTextRefernce(txtTuNgay);

        DenNgay_Date.setForeground(new java.awt.Color(0, 204, 255));
        DenNgay_Date.setTextRefernce(txtDenNgay);

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pnlCapNhat1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setBorder(null);

        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã doanh thu", "Ngày tạo", "Tổng tiền"
            }
        ));
        jScrollPane3.setViewportView(tblDoanhThu);

        javax.swing.GroupLayout pnlCapNhat1Layout = new javax.swing.GroupLayout(pnlCapNhat1);
        pnlCapNhat1.setLayout(pnlCapNhat1Layout);
        pnlCapNhat1Layout.setHorizontalGroup(
            pnlCapNhat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
        );
        pnlCapNhat1Layout.setVerticalGroup(
            pnlCapNhat1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
        );

        table3.addTab("Doanh thu", pnlCapNhat1);

        jScrollPane4.setBorder(null);

        table5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Số lượng bán ", "Tổng tiền"
            }
        ));
        jScrollPane4.setViewportView(table5);

        javax.swing.GroupLayout pnlDanhSach1Layout = new javax.swing.GroupLayout(pnlDanhSach1);
        pnlDanhSach1.setLayout(pnlDanhSach1Layout);
        pnlDanhSach1Layout.setHorizontalGroup(
            pnlDanhSach1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
        );
        pnlDanhSach1Layout.setVerticalGroup(
            pnlDanhSach1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
        );

        table3.addTab("Sản phẩm", pnlDanhSach1);

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        lblTuNgay1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/38px_calendar_blue.png"))); // NOI18N
        lblTuNgay1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTuNgay1MouseClicked(evt);
            }
        });

        lblDenNgay1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/38px_calendar_blue.png"))); // NOI18N
        lblDenNgay1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDenNgay1MouseClicked(evt);
            }
        });

        cboDoanhThuu.setEditable(false);
        cboDoanhThuu.setToolTipText("112");
        cboDoanhThuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDoanhThuuActionPerformed(evt);
            }
        });

        txtTuNgay.setText("");

        kGradientPanel4.setkEndColor(new java.awt.Color(207, 61, 226));
        kGradientPanel4.setkStartColor(new java.awt.Color(117, 81, 251));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("TỒN KHO");

        lblTonKho.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        lblTonKho.setForeground(new java.awt.Color(255, 255, 255));
        lblTonKho.setText("2 000");

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTonKho, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTonKho)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kGradientPanel5.setkEndColor(new java.awt.Color(153, 204, 255));
        kGradientPanel5.setkStartColor(new java.awt.Color(0, 0, 102));

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("TỔNG DOANH THU");

        lblTongDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        lblTongDoanhThu.setForeground(new java.awt.Color(255, 255, 255));
        lblTongDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTongDoanhThu.setText("0 VNĐ");

        lblSLHoadon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSLHoadon.setForeground(new java.awt.Color(204, 204, 204));
        lblSLHoadon.setText("ton kho");
        lblSLHoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSLHoadonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSLHoadonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSLHoadonMouseExited(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/1x_TongDT.png"))); // NOI18N

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout kGradientPanel5Layout = new javax.swing.GroupLayout(kGradientPanel5);
        kGradientPanel5.setLayout(kGradientPanel5Layout);
        kGradientPanel5Layout.setHorizontalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel5Layout.createSequentialGroup()
                        .addComponent(lblTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(kGradientPanel5Layout.createSequentialGroup()
                        .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(lblSLHoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        kGradientPanel5Layout.setVerticalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel5Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblSLHoadon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        kGradientPanel6.setkEndColor(new java.awt.Color(252, 215, 146));
        kGradientPanel6.setkStartColor(new java.awt.Color(216, 109, 10));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("TỔNG NHẬP XUẤT KHO");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 9)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("TỔNG NHẬP :");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 9)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("TỔNG  XUẤT :");

        lblIconNX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/1x_NhappXuat.png"))); // NOI18N
        lblIconNX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIconNXMouseClicked(evt);
            }
        });

        lblNhapKho.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblNhapKho.setForeground(new java.awt.Color(255, 255, 255));
        lblNhapKho.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNhapKho.setText("0");
        lblNhapKho.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblXuatKho.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblXuatKho.setForeground(new java.awt.Color(255, 255, 255));
        lblXuatKho.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblXuatKho.setText("0");

        jSeparator3.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cái");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cái");

        javax.swing.GroupLayout kGradientPanel6Layout = new javax.swing.GroupLayout(kGradientPanel6);
        kGradientPanel6.setLayout(kGradientPanel6Layout);
        kGradientPanel6Layout.setHorizontalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(lblIconNX)
                .addGap(8, 8, 8))
            .addGroup(kGradientPanel6Layout.createSequentialGroup()
                .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblXuatKho, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(lblNhapKho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(kGradientPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel6Layout.setVerticalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel6Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel14)
                .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel6Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNhapKho, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(kGradientPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblXuatKho)
                        .addComponent(jLabel4))
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblIconNX)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("THỐNG KÊ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(table3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(kGradientPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTuNgay1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDenNgay1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboDoanhThuu, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kGradientPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTuNgay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTuNgay1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDenNgay1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDenNgay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboDoanhThuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(table3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblDenNgay1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDenNgay1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblDenNgay1MouseClicked

    private void lblTuNgay1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTuNgay1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTuNgay1MouseClicked

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void cboDoanhThuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDoanhThuuActionPerformed
        fillTableDoanhThu();
    }//GEN-LAST:event_cboDoanhThuuActionPerformed

    private void lblIconNXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconNXMouseClicked
        MainJFrame f = new MainJFrame();
        jdl_BieuDoTron bdt = new jdl_BieuDoTron(f, true);
        bdt.bieuDo(Integer.parseInt(lblNhapKho.getText()), Integer.parseInt(lblXuatKho.getText()));
        bdt.setVisible(true);
    }//GEN-LAST:event_lblIconNXMouseClicked

    private void lblSLHoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSLHoadonMouseClicked
        if (evt.getClickCount() == 2) {
            MainJFrame m = new MainJFrame();
            m.showForm(new Form_LSHoaDon());
            m.setVisible(true);

        }
    }//GEN-LAST:event_lblSLHoadonMouseClicked

    private void lblSLHoadonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSLHoadonMouseEntered
      lblSLHoadon.setForeground(Color.white);
    }//GEN-LAST:event_lblSLHoadonMouseEntered

    private void lblSLHoadonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSLHoadonMouseExited
       lblSLHoadon.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_lblSLHoadonMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.duan1.swing.DateChooser DenNgay_Date;
    private com.duan1.swing.DateChooser TuNgay_Date;
    private com.duan1.swing.ComboBoxSuggestion cboDoanhThuu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel5;
    private keeptoo.KGradientPanel kGradientPanel6;
    private javax.swing.JLabel lblDenNgay1;
    private javax.swing.JLabel lblIconNX;
    private javax.swing.JLabel lblNhapKho;
    private javax.swing.JLabel lblSLHoadon;
    private javax.swing.JLabel lblTonKho;
    private javax.swing.JLabel lblTongDoanhThu;
    private javax.swing.JLabel lblTuNgay1;
    private javax.swing.JLabel lblXuatKho;
    private javax.swing.JPanel pnlCapNhat1;
    private javax.swing.JPanel pnlDanhSach1;
    private com.duan1.swing.MaterialTabbed table3;
    private com.duan1.swing.Table table5;
    private com.duan1.swing.Table tblDoanhThu;
    private com.duan1.swing.MyTextField2 txtDenNgay;
    private com.duan1.swing.TextFieldAnimation txtTimKiem;
    private com.duan1.swing.MyTextField2 txtTuNgay;
    // End of variables declaration//GEN-END:variables
}
