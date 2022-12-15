/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.duan1.components;

import com.duan1.DAO.HoaDonChiTietDAO;
import com.duan1.DAO.HoaDonDAO;
import com.duan1.DAO.KhachHangDAO;
import com.duan1.DAO.NhanVienDAO;
import com.duan1.DAO.SanPhamDAO;
import com.duan1.Entity.HoaDon;
import com.duan1.Entity.HoaDonChiTiet;
import com.duan1.Entity.KhachHang;
import com.duan1.Entity.NhanVien;
import com.duan1.Entity.SanPham;
import com.duan1.Helper.Msgbox;
import com.duan1.Helper.XDate;
import com.duan1.swing.DateChooser;
import com.duan1.swing.EventCallBack;
import com.duan1.swing.EventTextField;
import com.duan1.swing.ScrollBarCustom;
import com.duan1.ui.MainJFrame;
import com.sun.source.tree.TryTree;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.GoogleMaterialDesignIcon;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.chainsaw.Main;

public class Form_LSHoaDon extends javax.swing.JPanel {

    HoaDonDAO daoHD = new HoaDonDAO();
    SanPhamDAO daoSP = new SanPhamDAO();

    KhachHangDAO daoKH = new KhachHangDAO();
    HoaDonChiTietDAO daoCT = new HoaDonChiTietDAO();

    List<HoaDon> listHD = daoHD.selectAll();
    MainJFrame frame = new MainJFrame();

    public Form_LSHoaDon() {
        initComponents();
        init();
        TimKiemHD();
        loadDuLieu();
        txtDenNgay.setText("");
        txtTuNgay1.setText("");
    }

    public void TimKiemHD() {
        textFieldAnimationTK.setHintText("Nhập mã hóa đơn");
        textFieldAnimationTK.addEvent(new EventTextField() {

            @Override
            public void onPressed(EventCallBack call) {
                //  Test
                try {
                    for (int i = 1; i <= 100; i++) {
                        Thread.sleep(15);
                    }
                    // loadDuLieu();
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

    public void init() {
        txtTuNgay1.setLabelText("Từ ngày");
        txtDenNgay.setLabelText("Đến ngày");
        ScrollLSHD.setVerticalScrollBar(new ScrollBarCustom());
    }

    void loadDuLieu() {
        DefaultTableModel model = (DefaultTableModel) tblLSHD.getModel();
        model.setRowCount(0);

        try {

            String keywork = textFieldAnimationTK.getText();
            List<HoaDon> listhd = daoHD.selectByKeyword(keywork);

            for (HoaDon hd : listhd) {
                KhachHang kh = daoKH.selectByid(hd.getMaKH());
                long tongTien = daoCT.getTongTien(hd.getMaHD());
                Object[] row = {
                    hd.getMaHD(),
                    hd.getMaNV(),
                    hd.getMaKH(),
                    XDate.toString(hd.getNgayTao(), mauNgay),
                    kh.getTenKH(),
                    tongTien
                };
                model.addRow(row);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "lỗi load dữ liệu");

            e.printStackTrace();
        }
    }

    String mauNgay = "dd-MM-yyyy";

    public void timKiemTheoNgay() {

        DefaultTableModel model = (DefaultTableModel) tblLSHD.getModel();
        model.setRowCount(0);
        try {

            String DenNgay = (txtDenNgay.getText());
            String tuNgay = (txtTuNgay1.getText());
            
            List<HoaDon> listhd = daoHD.selectByDate(tuNgay, DenNgay);

            for (HoaDon hd : listhd) {
                KhachHang kh = daoKH.selectByid(hd.getMaKH());
                long tongTien = daoCT.getTongTien(hd.getMaHD());

                Object[] row = {
                    hd.getMaHD(),
                    hd.getMaNV(),
                    hd.getMaKH(),
                    XDate.toString(hd.getNgayTao(), mauNgay),
                    kh.getTenKH(),
                   tongTien

                };
                model.addRow(row);

            }
        } catch (Exception e) {
            e.printStackTrace();
            Msgbox.info(new MainJFrame(), "Lỗi!");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TuNgay_Date = new com.duan1.swing.DateChooser();
        DenNgay_Date = new com.duan1.swing.DateChooser();
        jLabel2 = new javax.swing.JLabel();
        lblDenNgay = new javax.swing.JLabel();
        lblTuNgay = new javax.swing.JLabel();
        textFieldAnimationTK = new com.duan1.swing.TextFieldAnimation();
        materialTabbed1 = new com.duan1.swing.MaterialTabbed();
        jPanel1 = new javax.swing.JPanel();
        ScrollLSHD = new javax.swing.JScrollPane();
        tblLSHD = new com.duan1.swing.Table();
        txtTuNgay1 = new com.duan1.swing.MyTextField2();
        txtDenNgay = new com.duan1.swing.MyTextField2();
        btnMoi = new com.duan1.swing.Button();

        TuNgay_Date.setForeground(new java.awt.Color(0, 204, 255));
        TuNgay_Date.setToolTipText("");
        TuNgay_Date.setTextRefernce(txtTuNgay1);

        DenNgay_Date.setForeground(new java.awt.Color(0, 204, 255));
        DenNgay_Date.setTextRefernce(txtDenNgay);

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(923, 600));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("LỊCH SỬ HÓA ĐƠN");

        lblDenNgay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/38px_calendar_blue.png"))); // NOI18N
        lblDenNgay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDenNgayMouseClicked(evt);
            }
        });

        lblTuNgay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/38px_calendar_blue.png"))); // NOI18N
        lblTuNgay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTuNgayMouseClicked(evt);
            }
        });

        textFieldAnimationTK.setBackground(new java.awt.Color(222, 214, 214));
        textFieldAnimationTK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldAnimationTKKeyReleased(evt);
            }
        });

        ScrollLSHD.setBorder(null);

        tblLSHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Mã nhân viên", "Mã khách hàng", "Ngày tạo", "Tên khách hàng", "Tổng Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLSHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLSHDMouseClicked(evt);
            }
        });
        ScrollLSHD.setViewportView(tblLSHD);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollLSHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollLSHD, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
        );

        materialTabbed1.addTab("Lịch sử hóa đơn", jPanel1);

        txtDenNgay.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtDenNgayCaretUpdate(evt);
            }
        });
        txtDenNgay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDenNgayMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtDenNgayMouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtDenNgayMouseReleased(evt);
            }
        });

        btnMoi.setText("Làm Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblTuNgay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTuNgay1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblDenNgay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textFieldAnimationTK, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldAnimationTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTuNgay1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDenNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTuNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addComponent(materialTabbed1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblTuNgayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTuNgayMouseClicked
        TuNgay_Date.showPopup();

    }//GEN-LAST:event_lblTuNgayMouseClicked

    private void lblDenNgayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDenNgayMouseClicked
        DenNgay_Date.showPopup();
    }//GEN-LAST:event_lblDenNgayMouseClicked

    private void tblLSHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLSHDMouseClicked

        int index = tblLSHD.getSelectedRow();

        String A = String.valueOf(tblLSHD.getValueAt(index, 0));
        if (evt.getClickCount() == 2) {
            MainJFrame m = new MainJFrame();
//
            JDL_ThongTinChiTiet_LSHoaDon jdl = new JDL_ThongTinChiTiet_LSHoaDon(m, true);
            try {
                jdl.setFrom(listHD.get(index));
                jdl.dulieu(A);
            } catch (ParseException ex) {
                Logger.getLogger(Form_LSHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }

            jdl.setVisible(true);

            System.out.println(A);

        }

    }//GEN-LAST:event_tblLSHDMouseClicked

    private void txtDenNgayMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDenNgayMouseReleased
        // TODO add your handling code here:
  // timKiemTheoNgay();
    }//GEN-LAST:event_txtDenNgayMouseReleased

    private void textFieldAnimationTKKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldAnimationTKKeyReleased
        // TODO add your handling code here:

        loadDuLieu();

    }//GEN-LAST:event_textFieldAnimationTKKeyReleased

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        loadDuLieu();
        txtTuNgay1.setText("");
        txtDenNgay.setText("");
    }//GEN-LAST:event_btnMoiActionPerformed

    private void txtDenNgayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDenNgayMouseClicked
       
       timKiemTheoNgay();
    }//GEN-LAST:event_txtDenNgayMouseClicked

    private void txtDenNgayCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtDenNgayCaretUpdate
        // TODO add your handling code here:
      // timKiemTheoNgay();
    }//GEN-LAST:event_txtDenNgayCaretUpdate

    private void txtDenNgayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDenNgayMouseEntered
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtDenNgayMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.duan1.swing.DateChooser DenNgay_Date;
    private javax.swing.JScrollPane ScrollLSHD;
    private com.duan1.swing.DateChooser TuNgay_Date;
    private com.duan1.swing.Button btnMoi;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDenNgay;
    private javax.swing.JLabel lblTuNgay;
    private com.duan1.swing.MaterialTabbed materialTabbed1;
    private com.duan1.swing.Table tblLSHD;
    private com.duan1.swing.TextFieldAnimation textFieldAnimationTK;
    private com.duan1.swing.MyTextField2 txtDenNgay;
    private com.duan1.swing.MyTextField2 txtTuNgay1;
    // End of variables declaration//GEN-END:variables
}
