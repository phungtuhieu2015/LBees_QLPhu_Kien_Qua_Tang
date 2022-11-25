/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.duan1.components;

import com.duan1.swing.EventCallBack;
import com.duan1.swing.EventTextField;
import com.duan1.swing.Notification;
import com.duan1.ui.MainJFrame;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Rectangle;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.metal.MetalTabbedPaneUI;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.interpolation.PropertySetter;

/**
 *
 * @author ASUS
 */
public class Form_LSHoaDon extends javax.swing.JPanel {

    MainJFrame ab = new MainJFrame();

    /**
     * Creates new form Form_QLKhachHang
     */
    public Form_LSHoaDon() {
        initComponents();
        setHint();
        TimKiem();

    }

    public void TimKiem() {
        txtTimKiem.setHintText("Nhập mã, tên khách hàng");
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

    public void setHint() {
        txtMaKhachHang.setHint("Nhập mã khách hàng");
        txtTenKhachHang.setHint("Nhập tên khách hàng");
        txtSDT.setHint("Nhập số điện thoại");
        txtDiemTichLuy.setHint("Nhập điểm tích lũy");
    }

    public boolean checkText() {

        if (txtMaKhachHang.getText().trim().isEmpty()) {
            //JOptionPane.showMessageDialog(this, "Nhập mã khách hàng");
            Notification noti = new Notification(ab, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Nhập mã khách hàng");
            noti.showNotification();
            txtMaKhachHang.requestFocus();
            return false;
        }

        if (txtTenKhachHang.getText().trim().isEmpty()) {
            //JOptionPane.showMessageDialog(this, "Nhập tên khách hàng");
            Notification noti = new Notification(ab, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Nhập tên khách hàng");
            noti.showNotification();
            txtTenKhachHang.requestFocus();
            return false;
        }

        String PHONE = "^0[9384]{1}\\d{8}$";
        boolean phone = txtSDT.getText().matches(PHONE);

        if (txtSDT.getText().trim().isEmpty()) {
            //JOptionPane.showMessageDialog(this, "Nhập số điện thoại khách hàng", "Lỗi số điện thoại", JOptionPane.QUESTION_MESSAGE);
            Notification noti = new Notification(ab, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Nhập số điện thoại khách hàng");
            noti.showNotification();
            txtSDT.requestFocus();
            return false;
        }
        if (phone != true) {
            //JOptionPane.showMessageDialog(this, "Nhập số điện thoại khách hàng không Đúng Dịnh Dạng ", "Lỗi số điện thoại", JOptionPane.QUESTION_MESSAGE);
            Notification noti = new Notification(ab, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Nhập số điện thoại khách hàng không Đúng Dịnh Dạng");
            noti.showNotification();
            txtSDT.requestFocus();
            return false;
        }

        if (txtDiemTichLuy.getText().trim().isEmpty()) {
            //JOptionPane.showMessageDialog(this, "Nhập điểm tích lũy");
            Notification noti = new Notification(ab, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Nhập điểm tích lũy");
            noti.showNotification();
            txtDiemTichLuy.requestFocus();
            return false;
        } else {
            try {

                double diemtichluy = Double.parseDouble(txtDiemTichLuy.getText());
                if (diemtichluy < 0) {
                    //JOptionPane.showMessageDialog(this, "Nhập điểm tích lũy lớn hơn 0");
                    Notification noti = new Notification(ab, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Nhập điểm tích lũy lớn hơn 0");
                    noti.showNotification();
                    txtDiemTichLuy.requestFocus();
                    return false;
                }

            } catch (Exception e) {
                //JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Số điểm tích lũy");
                Notification noti = new Notification(ab, Notification.Type.INFO, Notification.Location.TOP_RIGHT, "Vui lòng nhập số điểm tích lũy");
                noti.showNotification();
                txtDiemTichLuy.requestFocus();
                return false;
            }
        }
        return true;
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
        pnlCapNhat = new javax.swing.JPanel();
        pnlText = new javax.swing.JPanel();
        txtMaKhachHang = new com.duan1.swing.MyTextField();
        txtTenKhachHang = new com.duan1.swing.MyTextField();
        txtSDT = new com.duan1.swing.MyTextField();
        txtDiemTichLuy = new com.duan1.swing.MyTextField();
        pnlThemSuaXoa = new javax.swing.JPanel();
        btnThem = new com.duan1.swing.Button();
        btnSua = new com.duan1.swing.Button();
        btnXoa = new com.duan1.swing.Button();
        btnMoi = new com.duan1.swing.Button();
        pnlDieuHuong = new javax.swing.JPanel();
        button6 = new com.duan1.swing.Button();
        button7 = new com.duan1.swing.Button();
        button8 = new com.duan1.swing.Button();
        button2 = new com.duan1.swing.Button();
        pnlDanhSach = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new com.duan1.swing.Table();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(923, 604));
        setMinimumSize(new java.awt.Dimension(923, 604));
        setPreferredSize(new java.awt.Dimension(923, 604));

        pnlCapNhat.setBackground(new java.awt.Color(255, 255, 255));

        pnlText.setBackground(new java.awt.Color(255, 255, 255));

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

        button6.setText("<");
        button6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pnlDieuHuong.add(button6);

        button7.setText("|<");
        button7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pnlDieuHuong.add(button7);

        button8.setText(">|");
        button8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pnlDieuHuong.add(button8);

        button2.setText(">");
        button2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pnlDieuHuong.add(button2);

        javax.swing.GroupLayout pnlTextLayout = new javax.swing.GroupLayout(pnlText);
        pnlText.setLayout(pnlTextLayout);
        pnlTextLayout.setHorizontalGroup(
            pnlTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTextLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(pnlTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119)
                .addGroup(pnlTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiemTichLuy, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(129, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTextLayout.createSequentialGroup()
                .addComponent(pnlThemSuaXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlDieuHuong, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlTextLayout.setVerticalGroup(
            pnlTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTextLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnlTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(pnlTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiemTichLuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
                .addGroup(pnlTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDieuHuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlThemSuaXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout pnlCapNhatLayout = new javax.swing.GroupLayout(pnlCapNhat);
        pnlCapNhat.setLayout(pnlCapNhatLayout);
        pnlCapNhatLayout.setHorizontalGroup(
            pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlCapNhatLayout.setVerticalGroup(
            pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Tabpane.addTab("Cập Nhật", pnlCapNhat);

        pnlDanhSach.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Khách Hàng", "Tên Khách Hàng", "Số Điện Thoại", "Điểm Tích Lũy"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);
        if (tblKhachHang.getColumnModel().getColumnCount() > 0) {
            tblKhachHang.getColumnModel().getColumn(0).setResizable(false);
            tblKhachHang.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblKhachHang.getColumnModel().getColumn(1).setResizable(false);
            tblKhachHang.getColumnModel().getColumn(1).setPreferredWidth(240);
            tblKhachHang.getColumnModel().getColumn(2).setPreferredWidth(190);
            tblKhachHang.getColumnModel().getColumn(3).setMinWidth(50);
            tblKhachHang.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        javax.swing.GroupLayout pnlDanhSachLayout = new javax.swing.GroupLayout(pnlDanhSach);
        pnlDanhSach.setLayout(pnlDanhSachLayout);
        pnlDanhSachLayout.setHorizontalGroup(
            pnlDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
        );
        pnlDanhSachLayout.setVerticalGroup(
            pnlDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );

        Tabpane.addTab("Danh Sách", pnlDanhSach);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabpane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        Tabpane.setSelectedIndex(0);
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (checkText() == true) {
            Notification noti = new Notification(ab, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Thêm thành công");
            noti.showNotification();
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (checkText() == false) {
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn sửa khách hàng không?", "hỏi?", JOptionPane.YES_OPTION) == JOptionPane.NO_OPTION) {
            Notification noti = new Notification(ab, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Sửa khách hàng không thành công");
            noti.showNotification();
            return;
        }
        Notification noti = new Notification(ab, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Sửa khách hàng thành công");
        noti.showNotification();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa khách hàng không?", "hỏi?", JOptionPane.YES_OPTION) == JOptionPane.NO_OPTION) {
            Notification noti = new Notification(ab, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Xóa khách hàng không thành công");
            noti.showNotification();
            return;
        }
        Notification noti = new Notification(ab, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Xóa khách hàng thành công");
        noti.showNotification();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        txtMaKhachHang.setText("");
        txtTenKhachHang.setText("");
        txtSDT.setText("");
        txtDiemTichLuy.setText("");
    }//GEN-LAST:event_btnMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.duan1.swing.MaterialTabbed Tabpane;
    private com.duan1.swing.Button btnMoi;
    private com.duan1.swing.Button btnSua;
    private com.duan1.swing.Button btnThem;
    private com.duan1.swing.Button btnXoa;
    private com.duan1.swing.Button button2;
    private com.duan1.swing.Button button6;
    private com.duan1.swing.Button button7;
    private com.duan1.swing.Button button8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCapNhat;
    private javax.swing.JPanel pnlDanhSach;
    private javax.swing.JPanel pnlDieuHuong;
    private javax.swing.JPanel pnlText;
    private javax.swing.JPanel pnlThemSuaXoa;
    private com.duan1.swing.Table tblKhachHang;
    private com.duan1.swing.MyTextField txtDiemTichLuy;
    private com.duan1.swing.MyTextField txtMaKhachHang;
    private com.duan1.swing.MyTextField txtSDT;
    private com.duan1.swing.MyTextField txtTenKhachHang;
    private com.duan1.swing.TextFieldAnimation txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
