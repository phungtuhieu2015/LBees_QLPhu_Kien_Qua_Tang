/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.duan1.components;

import com.duan1.DAO.HoaDonDAO;
import com.duan1.DAO.KhachHangDAO;
import com.duan1.DAO.NguoiGiaoHangDAO;
import com.duan1.DAO.QuaTangDAO;
import com.duan1.Entity.HoaDon;
import com.duan1.Entity.KhachHang;
import com.duan1.Entity.NguoiGiaoHang;
import com.duan1.Entity.QuaTang;
import com.duan1.Helper.XDate;
import com.duan1.swing.EventCallBack;
import com.duan1.swing.EventTextField;
import com.duan1.swing.MessageDialog;
import com.duan1.swing.Notification;
import com.duan1.swing.ScrollBarCustom;
import com.duan1.ui.MainJFrame;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Form_QuaTang extends javax.swing.JPanel {

    QuaTangDAO daoQT = new QuaTangDAO();
    KhachHangDAO daoKH = new KhachHangDAO();
    NguoiGiaoHangDAO daoNGH = new NguoiGiaoHangDAO();
    HoaDonDAO daoHD = new HoaDonDAO();

    List<QuaTang> listQT = daoQT.selectAll();
    List<KhachHang> listKH = daoKH.selectAll();
    List<NguoiGiaoHang> listNGH = daoNGH.selectAll();

    MainJFrame frame = new MainJFrame();
    MessageDialog mdl = new MessageDialog(frame);

    String mauNgay = "dd-MM-yyyy";

    /**
     * Creates new form Form_QLKhachHang
     */
    public Form_QuaTang() {
        initComponents();
        setHint();
        TimKiem();
        loadData();
        ThanhTruotQT();
        fillComboboxTrangThai();
        fillComboboxNGH();

    }

    public void setHint() {
        txtTenKH.setLabelText("Tên khách hàng");
        txtTenNN.setLabelText("Tên người nhận");
        txtDiaChiNN.setLabelText("Địa chỉ người nhận");
        txtMaDH.setLabelText("Mã đơn hàng");
        txtSDTKH.setLabelText("Số điện thoại khách hàng");
        txtSDTNN.setLabelText("Số điện thoại người nhận");
        txtNgayGiao.setLabelText("Ngày giao");
        txtMaHD.setLabelText("Mã hóa đơn");
        ahihi.setLabelText("Ghi chú");
        txtTimKiem.setHintText("Tìm theo tên khách hàng, tên người nhận, mã đơn hàng");

    }

    public void TimKiem() {
        txtTimKiem.setHintText("Nhập mã hoặc tên tài khoản");
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

    public void ThanhTruotQT() {
        ScrollQT.setVerticalScrollBar(new ScrollBarCustom());
    }

    public void loadData() {
        DefaultTableModel model = (DefaultTableModel) tblQuaTang.getModel();
        model.setRowCount(0);

        try {
            for (QuaTang qt : listQT) {

                Object[] row = {
                    qt.getMaDH(),
                    qt.getMaHD(),
                    qt.getMaNGH(),
                    qt.getTenNN(),
                    qt.getDiaChiNN(),
                    qt.getSDTNN(),
                    qt.getNgayGiao(),
                    qt.getTrangThai(),
                    qt.getGhiChu()
                };
                model.addRow(row);
            }

        } catch (Exception e) {
            Notification noti = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.CENTER, "Lỗi thêm dữ liệu vào quà tặng");
            noti.showNotification();
        }
    }

    public void setForm(QuaTang qt) {
        HoaDon hd = daoHD.selectByid(qt.getMaHD());
        KhachHang kh = daoKH.selectByid(hd.getMaKH());
        NguoiGiaoHang ngh = daoNGH.selectByid(qt.getMaNGH());
        txtMaDH.setText(qt.getMaDH());
        txtTenNN.setText(qt.getTenNN());
        txtDiaChiNN.setText(qt.getDiaChiNN());
        txtSDTNN.setText(qt.getSDTNN());
        txtNgayGiao.setText(String.valueOf(qt.getNgayGiao()));
        txtMaHD.setText(qt.getMaHD());
        txtGhiChu.setText(qt.getGhiChu());
        
        txtTenKH.setText(kh.getTenKH());
        txtSDTKH.setText(kh.getSDT());
        
        cboTrangThai.setSelectedItem(qt.getTrangThai());
        cboNGH.setSelectedItem(ngh.getTenNGH() + " - " +ngh.getMaNGH());
    }

    public QuaTang getForm() {
        QuaTang qt = new QuaTang();
        qt.setMaDH(txtMaDH.getText());
        qt.setMaHD(txtMaHD.getText());
        qt.setMaNGH(String.valueOf(cboNGH.getSelectedItem()));
        qt.setTenNN(txtTenKH.getText());
        qt.setDiaChiNN(txtDiaChiNN.getText());
        qt.setSDTNN(txtSDTNN.getText());
        qt.setNgayGiao(XDate.toDate(txtNgayGiao.getText(), mauNgay));
        qt.setGhiChu(txtMaDH.getText());
        return qt;
    }

    public void display(int index) {
        QuaTang qt = listQT.get(index);
        setForm(qt);
    }

    public void fillComboboxTrangThai() {
        String trangThai_GH[] = {"Đã giao xong", "Chưa giao", "Đang giao hàng"};
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboTrangThai.getModel();
        model.removeAllElements();

        for (String string : trangThai_GH) {
            model.addElement(string);
        }
    }

    public void fillComboboxNGH() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboNGH.getModel();
        model.removeAllElements();
        try {
            for (NguoiGiaoHang ngh : listNGH) {
                model.addElement(ngh);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
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

        txtTimKiem = new com.duan1.swing.TextFieldAnimation();
        Tabpane = new com.duan1.swing.MaterialTabbed();
        pnls = new javax.swing.JPanel();
        btnNext = new javax.swing.JPanel();
        pnlThemSuaXoa = new javax.swing.JPanel();
        btnThem = new com.duan1.swing.Button();
        btnSua = new com.duan1.swing.Button();
        btnXoa = new com.duan1.swing.Button();
        btnMoi = new com.duan1.swing.Button();
        pnlDieuHuong = new javax.swing.JPanel();
        btnFirst = new com.duan1.swing.Button();
        btnPrev = new com.duan1.swing.Button();
        btnNextt = new com.duan1.swing.Button();
        btnLast = new com.duan1.swing.Button();
        ahihi = new com.duan1.swing.TextAreaScroll();
        txtGhiChu = new com.duan1.swing.TextArea();
        cboTrangThai = new com.duan1.swing.ComboBoxSuggestion();
        cboNGH = new com.duan1.swing.ComboBoxSuggestion();
        txtTenNN = new com.duan1.swing.MyTextField2();
        txtDiaChiNN = new com.duan1.swing.MyTextField2();
        txtMaDH = new com.duan1.swing.MyTextField2();
        txtSDTKH = new com.duan1.swing.MyTextField2();
        txtSDTNN = new com.duan1.swing.MyTextField2();
        txtNgayGiao = new com.duan1.swing.MyTextField2();
        txtMaHD = new com.duan1.swing.MyTextField2();
        txtTenKH = new com.duan1.swing.MyTextField2();
        pnlDanhSach = new javax.swing.JPanel();
        ScrollQT = new javax.swing.JScrollPane();
        tblQuaTang = new com.duan1.swing.Table();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(923, 604));
        setMinimumSize(new java.awt.Dimension(923, 604));
        setPreferredSize(new java.awt.Dimension(923, 604));

        pnls.setBackground(new java.awt.Color(255, 255, 255));

        btnNext.setBackground(new java.awt.Color(255, 255, 255));

        pnlThemSuaXoa.setBackground(new java.awt.Color(255, 255, 255));
        pnlThemSuaXoa.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        btnThem.setText("Thêm");
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        pnlThemSuaXoa.add(btnThem);

        btnSua.setText("Sửa");
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        pnlThemSuaXoa.add(btnSua);

        btnXoa.setText("Xóa");
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        pnlThemSuaXoa.add(btnXoa);

        btnMoi.setText("Mới");
        btnMoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });
        pnlThemSuaXoa.add(btnMoi);

        pnlDieuHuong.setBackground(new java.awt.Color(255, 255, 255));
        pnlDieuHuong.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        btnFirst.setText("|<");
        btnFirst.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        pnlDieuHuong.add(btnFirst);

        btnPrev.setText("<");
        btnPrev.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });
        pnlDieuHuong.add(btnPrev);

        btnNextt.setText(">");
        btnNextt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNextt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNexttActionPerformed(evt);
            }
        });
        pnlDieuHuong.add(btnNextt);

        btnLast.setText(">|");
        btnLast.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        pnlDieuHuong.add(btnLast);

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        ahihi.setViewportView(txtGhiChu);

        cboTrangThai.setToolTipText("");
        cboTrangThai.setDoubleBuffered(true);

        javax.swing.GroupLayout btnNextLayout = new javax.swing.GroupLayout(btnNext);
        btnNext.setLayout(btnNextLayout);
        btnNextLayout.setHorizontalGroup(
            btnNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnNextLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(btnNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(btnNextLayout.createSequentialGroup()
                        .addComponent(pnlThemSuaXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174)
                        .addComponent(pnlDieuHuong, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(btnNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ahihi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(btnNextLayout.createSequentialGroup()
                            .addGroup(btnNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cboTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                .addComponent(txtTenNN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDiaChiNN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMaDH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTenKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(119, 119, 119)
                            .addGroup(btnNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cboNGH, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                .addComponent(txtSDTKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSDTNN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNgayGiao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMaHD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        btnNextLayout.setVerticalGroup(
            btnNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnNextLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(btnNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDTKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(btnNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenNN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDTNN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(btnNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChiNN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayGiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(btnNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(btnNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNGH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ahihi, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(btnNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlThemSuaXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDieuHuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlsLayout = new javax.swing.GroupLayout(pnls);
        pnls.setLayout(pnlsLayout);
        pnlsLayout.setHorizontalGroup(
            pnlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlsLayout.setVerticalGroup(
            pnlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Tabpane.addTab("Cập Nhật", pnls);

        pnlDanhSach.setBackground(new java.awt.Color(255, 255, 255));

        ScrollQT.setBackground(new java.awt.Color(255, 255, 255));
        ScrollQT.setBorder(null);

        tblQuaTang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã DH", "Mã HD", "Mã NGH", "Tên NN", "Địa chỉ NN", "SĐT NN", "Ngày giao", "Trạng thái", "Ghi Chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblQuaTang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuaTangMouseClicked(evt);
            }
        });
        ScrollQT.setViewportView(tblQuaTang);

        javax.swing.GroupLayout pnlDanhSachLayout = new javax.swing.GroupLayout(pnlDanhSach);
        pnlDanhSach.setLayout(pnlDanhSachLayout);
        pnlDanhSachLayout.setHorizontalGroup(
            pnlDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollQT, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
        );
        pnlDanhSachLayout.setVerticalGroup(
            pnlDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollQT, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );

        Tabpane.addTab("Danh Sách", pnlDanhSach);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabpane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tabpane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblQuaTangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuaTangMouseClicked

        if (evt.getClickCount() == 2) {

            int sec = tblQuaTang.getSelectedRow();
            display(sec);
            Tabpane.setSelectedIndex(0);
        }
    }//GEN-LAST:event_tblQuaTangMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed


    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed

    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNexttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNexttActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNexttActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLastActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollQT;
    private com.duan1.swing.MaterialTabbed Tabpane;
    private com.duan1.swing.TextAreaScroll ahihi;
    private com.duan1.swing.Button btnFirst;
    private com.duan1.swing.Button btnLast;
    private com.duan1.swing.Button btnMoi;
    private javax.swing.JPanel btnNext;
    private com.duan1.swing.Button btnNextt;
    private com.duan1.swing.Button btnPrev;
    private com.duan1.swing.Button btnSua;
    private com.duan1.swing.Button btnThem;
    private com.duan1.swing.Button btnXoa;
    private com.duan1.swing.ComboBoxSuggestion cboNGH;
    private com.duan1.swing.ComboBoxSuggestion cboTrangThai;
    private javax.swing.JPanel pnlDanhSach;
    private javax.swing.JPanel pnlDieuHuong;
    private javax.swing.JPanel pnlThemSuaXoa;
    private javax.swing.JPanel pnls;
    private com.duan1.swing.Table tblQuaTang;
    private com.duan1.swing.MyTextField2 txtDiaChiNN;
    private com.duan1.swing.TextArea txtGhiChu;
    private com.duan1.swing.MyTextField2 txtMaDH;
    private com.duan1.swing.MyTextField2 txtMaHD;
    private com.duan1.swing.MyTextField2 txtNgayGiao;
    private com.duan1.swing.MyTextField2 txtSDTKH;
    private com.duan1.swing.MyTextField2 txtSDTNN;
    private com.duan1.swing.MyTextField2 txtTenKH;
    private com.duan1.swing.MyTextField2 txtTenNN;
    private com.duan1.swing.TextFieldAnimation txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
