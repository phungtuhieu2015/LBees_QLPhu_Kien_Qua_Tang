/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.duan1.components;

import com.duan1.DAO.HoaDonChiTietDAO;
import com.duan1.DAO.SanPhamDAO;
import com.duan1.Entity.HoaDon;
import com.duan1.Entity.HoaDonChiTiet;
import com.duan1.Entity.SanPham;
import com.duan1.Helper.Msgbox;
import com.duan1.swing.ScrollBarCustom;
import com.duan1.ui.MainJFrame;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Form_QLBanHang extends javax.swing.JPanel {

    SanPhamDAO daoSP = new SanPhamDAO();
    List<SanPham> listSP = null;
    List<HoaDonChiTiet> listHDCT = new ArrayList<>();
    HoaDonChiTietDAO daoHDCT = new HoaDonChiTietDAO();
    String keyword = "";
    String sl;
    int index = -1;
    MainJFrame f = new MainJFrame();

    /**
     * Creates new form Form_QLBanHang
     */
    public Form_QLBanHang() {
        initComponents();
        init();
    }

    public void init() {
        Scroll_GioHang.setVerticalScrollBar(new ScrollBarCustom());
        Scroll_SPBan.setVerticalScrollBar(new ScrollBarCustom());
        txtTimKiem.setHintText("Nhập mã, tên sản phẩm...");
        loadData();
    }

    public void loadData() {
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        listSP = daoSP.selectByKeyword(keyword);
        try {
            for (SanPham sp : listSP) {
                Object[] row = {
                    sp.getMaSP(),
                    sp.getTenSP(),
                    sp.getSoLuong(),
                    sp.getDonGia(),};
                model.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    public void clearGH() {
        listHDCT.removeAll(listHDCT);
        loadDataToGH();
    }
// Nếu trùng mã sẽ câp nhập số lượng
    // ngược lại sẽ thêm

    public void addDataGH(int index) {
        SanPham sp = listSP.get(index);
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        hdct.setMaHD(sp.getMaSP());
        hdct.setMaSP(sp.getMaSP());
        hdct.setSoLuong(Integer.parseInt(sl));
        hdct.setThanhTien(hdct.getSoLuong() * sp.getDonGia());
        listHDCT.add(hdct);
        loadDataToGH();
    }

    public void updateGH(int index) {
        SanPham sp = listSP.get(index);
        boolean check = true;
        MainJFrame frame = new MainJFrame();
        String mess = "mã sản phẩm: " + sp.getMaSP() + "\nTên sản phẩm: " + sp.getTenSP() + "\nNhập số lượng: ";
        sl = JOptionPane.showInputDialog(frame, mess, "Nhập số lượng sản phẩm", JOptionPane.INFORMATION_MESSAGE);
        if (sl == null) {
            return;
        }
        try {
            if (sl.trim().isEmpty()) {
                Msgbox.waring(frame, "Bạn chưa nhập số lượng");
                return;
            }
            int s = Integer.parseInt(sl);
        } catch (NumberFormatException e) {
            Msgbox.waring(frame, "Vui lòng nhập số!");
            return;
        }

        for (HoaDonChiTiet h : listHDCT) {
            if (h.getMaSP().equals(sp.getMaSP())) {
                boolean choice = Msgbox.yesNo("Xác nhận thêm", "Sản phẩm đã được thêm\n Bạn có muốn thêm nữa không?");
                if (choice) {
                    h.setSoLuong(h.getSoLuong() + Integer.parseInt(sl));
                    h.setThanhTien(h.getSoLuong() * sp.getDonGia());
                    check = false;
                    loadDataToGH();
                    break;
                }
            }
        }
        if (check) {
            addDataGH(index);
        }
    }

    public void loadDataToGH() {
        DefaultTableModel model = (DefaultTableModel) tblGioHang.getModel();
        model.setRowCount(0);
        try {
            for (HoaDonChiTiet hdct : listHDCT) {
                SanPham sp = daoSP.selectByid(hdct.getMaSP());
                Object[] row = {
                    hdct.getMaSP(),
                    sp.getTenSP(),
                    hdct.getSoLuong(),
                    sp.getDonGia(),
                    hdct.getThanhTien()
                };
                model.addRow(row);
                model.fireTableDataChanged();
            }
        } catch (Exception e) {
        }
    }

    public void deleteAll() {
        if (listHDCT.isEmpty()) {
            Msgbox.waring(f, "Không có sản phẩm nào để xóa!");
            return;
        }
        boolean chon = Msgbox.yesNo("Xóa tất cả giỏ hàng", "Bạn có chắc chắn muốn xóa ?");
        if (chon) {
            listHDCT.removeAll(listHDCT);
            loadDataToGH();
        }
    }

    public void delete(int index) {
        if (listHDCT.isEmpty()) {
            Msgbox.waring(f, "Không có sản phẩm nào để xóa!");
            return;
        }
        if (index < 0) {
            Msgbox.waring(f, "Bạn chưa chọn sản phẩm để xóa!");
            return;
        }
        boolean chon = Msgbox.yesNo("Xóa khỏi giỏ hàng", "Bạn có chắc chắn muốn xóa ?");
        if (chon) {
            listHDCT.remove(index);
            loadDataToGH();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Tabpane = new com.duan1.swing.MaterialTabbed();
        pnlDanhSach = new javax.swing.JPanel();
        Scroll_GioHang = new javax.swing.JScrollPane();
        tblGioHang = new com.duan1.swing.Table();
        Tabpane1 = new com.duan1.swing.MaterialTabbed();
        pnlDanhSach1 = new javax.swing.JPanel();
        Scroll_SPBan = new javax.swing.JScrollPane();
        tblSanPham = new com.duan1.swing.Table();
        pnlThemSuaXoa1 = new javax.swing.JPanel();
        btnXoaKhoiGio = new com.duan1.swing.Button();
        btnDatHang = new com.duan1.swing.Button();
        btnDatHang1 = new com.duan1.swing.Button();
        jLabel2 = new javax.swing.JLabel();
        txtTimKiem = new com.duan1.swing.TextFieldAnimation();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("QUẢN LÝ BÁN HÀNG");

        pnlDanhSach.setBackground(new java.awt.Color(255, 255, 255));

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Scroll_GioHang.setViewportView(tblGioHang);

        javax.swing.GroupLayout pnlDanhSachLayout = new javax.swing.GroupLayout(pnlDanhSach);
        pnlDanhSach.setLayout(pnlDanhSachLayout);
        pnlDanhSachLayout.setHorizontalGroup(
            pnlDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
            .addGroup(pnlDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlDanhSachLayout.createSequentialGroup()
                    .addComponent(Scroll_GioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlDanhSachLayout.setVerticalGroup(
            pnlDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 194, Short.MAX_VALUE)
            .addGroup(pnlDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Scroll_GioHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
        );

        Tabpane.addTab("Giỏ Hàng", pnlDanhSach);

        pnlDanhSach1.setBackground(new java.awt.Color(255, 255, 255));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Số Lượng", "Đơn Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        Scroll_SPBan.setViewportView(tblSanPham);

        javax.swing.GroupLayout pnlDanhSach1Layout = new javax.swing.GroupLayout(pnlDanhSach1);
        pnlDanhSach1.setLayout(pnlDanhSach1Layout);
        pnlDanhSach1Layout.setHorizontalGroup(
            pnlDanhSach1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 906, Short.MAX_VALUE)
            .addGroup(pnlDanhSach1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Scroll_SPBan, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE))
        );
        pnlDanhSach1Layout.setVerticalGroup(
            pnlDanhSach1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
            .addGroup(pnlDanhSach1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlDanhSach1Layout.createSequentialGroup()
                    .addComponent(Scroll_SPBan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Tabpane1.addTab("Sản Phẩm Bán", pnlDanhSach1);

        pnlThemSuaXoa1.setBackground(new java.awt.Color(255, 255, 255));
        pnlThemSuaXoa1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        btnXoaKhoiGio.setText("Xóa khỏi giỏ");
        btnXoaKhoiGio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoaKhoiGio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKhoiGioActionPerformed(evt);
            }
        });
        pnlThemSuaXoa1.add(btnXoaKhoiGio);

        btnDatHang.setText("Xóa tất cả");
        btnDatHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatHangActionPerformed(evt);
            }
        });
        pnlThemSuaXoa1.add(btnDatHang);

        btnDatHang1.setText("Đặt hàng");
        btnDatHang1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDatHang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatHang1ActionPerformed(evt);
            }
        });
        pnlThemSuaXoa1.add(btnDatHang1);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Camera");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tabpane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(jLabel1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(pnlThemSuaXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Tabpane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(174, 174, 174)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Tabpane, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlThemSuaXoa1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tabpane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaKhoiGioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKhoiGioActionPerformed
        index = tblGioHang.getSelectedRow();
        delete(index);
    }//GEN-LAST:event_btnXoaKhoiGioActionPerformed

    private void btnDatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatHangActionPerformed
        // TODO add your handling code here:
        deleteAll();
    }//GEN-LAST:event_btnDatHangActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        index = tblSanPham.getSelectedRow();
        if (evt.getClickCount() == 2) {
            updateGH(index);
        }
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnDatHang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatHang1ActionPerformed
        if (listHDCT.isEmpty()) {
            Msgbox.waring(f, "Chưa có sản phẩm trong giỏ hàng!");
            return;
        }
        int tongTien = 0;
        for (HoaDonChiTiet hdct : listHDCT) {
            tongTien += hdct.getThanhTien();
        }
        JDL_NhapKhachHang bh = new JDL_NhapKhachHang(f, true);
        bh.getList(listHDCT);
        bh.setTongTienSP(tongTien);
        bh.setVisible(true);
        if (bh.isSuscess()) {
            clearGH();
        }
    }//GEN-LAST:event_btnDatHang1ActionPerformed

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate

    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped

    }//GEN-LAST:event_txtTimKiemKeyTyped

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        keyword = txtTimKiem.getText();
        loadData();
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        keyword = txtTimKiem.getText();
        loadData();
    }//GEN-LAST:event_txtTimKiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Scroll_GioHang;
    private javax.swing.JScrollPane Scroll_SPBan;
    private com.duan1.swing.MaterialTabbed Tabpane;
    private com.duan1.swing.MaterialTabbed Tabpane1;
    private com.duan1.swing.Button btnDatHang;
    private com.duan1.swing.Button btnDatHang1;
    private com.duan1.swing.Button btnXoaKhoiGio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pnlDanhSach;
    private javax.swing.JPanel pnlDanhSach1;
    private javax.swing.JPanel pnlThemSuaXoa1;
    private com.duan1.swing.Table tblGioHang;
    private com.duan1.swing.Table tblSanPham;
    private com.duan1.swing.TextFieldAnimation txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
