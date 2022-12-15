/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.duan1.components;

import com.duan1.DAO.NhanVienDAO;
import com.duan1.DAO.TaiKhoanDAO;
import com.duan1.Entity.HoaDon;
import com.duan1.Entity.HoaDonChiTiet;
import com.duan1.Entity.KhachHang;
import com.duan1.Entity.NhanVien;
import com.duan1.Entity.SanPham;
import com.duan1.Entity.TaiKhoan;
import com.duan1.Helper.Auth;
import com.duan1.Helper.ImgHelper;
import com.duan1.Helper.Msgbox;
import com.duan1.ui.DoiMatKhauJFrame;
import com.duan1.ui.MainJFrame;
import com.duan1.ui.loginJFrame;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Form_TaiKhoanCuaBan extends javax.swing.JDialog {

    MainJFrame frame = new MainJFrame();
    NhanVienDAO daoNV = new NhanVienDAO();
    TaiKhoanDAO daoTK = new TaiKhoanDAO();

    List<NhanVien> listNV = daoNV.selectAll();
    List<TaiKhoan> listTK = daoTK.selectAll();

    public Form_TaiKhoanCuaBan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setForm();

    }

    public void setForm() {
        txtHinh.setVisible(false);
        NhanVien nv = daoNV.selectByid(Auth.tk.getMaNV());
        lblMaNV.setText(nv.getMaNV());
        lblTenNV.setText(nv.getTenNV());
        if (nv.isGioiTinh()) {
            lblGioiTinh.setText("Nam");
        } else {
            lblGioiTinh.setText("Nữ");
        }
        lblcancuoc.setText(nv.getCCCD());
        lblSDT.setText(nv.getSDT());
        lblgmail.setText(nv.getGmail());
        lbltkkk.setText(Auth.tk.getTenTK());
//        lblmatkhau.setText(Auth.tk.getMatKhau());
        lblmatkhau.setText("*****");
        new ImgHelper().loadHinhVaoForm(nv.getHinhAnh(), lblHinh);
    }

//    public void display(int index) throws ParseException {
//        TaiKhoan tk = listTK.get(index);
//        setForm(tk);
//
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblMaNV = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblgmail = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblTenNV = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblcancuoc = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbltkkk = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblmatkhau = new javax.swing.JLabel();
        lblHinh = new javax.swing.JLabel();
        txtHinh = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        button2 = new com.duan1.swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("THÔNG TIN TÀI KHOẢN");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/info.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        jLabel2.setText("Mã nhân viên:");

        lblMaNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMaNV.setText("th");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        jLabel4.setText("Gmail:");

        lblgmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblgmail.setText("th");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        jLabel8.setText("Tên nhân viên:");

        lblTenNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenNV.setText("th");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        jLabel10.setText("Giới tính:");

        lblcancuoc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblcancuoc.setText("th");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        jLabel12.setText("CCCD:");

        lblGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGioiTinh.setText("th");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        jLabel15.setText("Số điện thoại:");

        lblSDT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSDT.setText("th");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        jLabel5.setText("Tên tài khoản:");

        lbltkkk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbltkkk.setText("th");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 15)); // NOI18N
        jLabel6.setText("Mật khẩu:");

        lblmatkhau.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblmatkhau.setText("th");

        lblHinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/Avatar.png"))); // NOI18N
        lblHinh.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lblHinh.setMaximumSize(new java.awt.Dimension(122, 122));
        lblHinh.setMinimumSize(new java.awt.Dimension(122, 122));
        lblHinh.setPreferredSize(new java.awt.Dimension(122, 122));
        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
        });

        button2.setBackground(new java.awt.Color(51, 153, 255));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Đổi mật khẩu");
        button2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel15))
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(lblSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(lbltkkk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(lblcancuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel10))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblmatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblgmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(181, 181, 181)))
                .addGap(42, 42, 42))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(txtHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(txtHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblTenNV)
                    .addComponent(jLabel2)
                    .addComponent(lblMaNV))
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblcancuoc)
                    .addComponent(jLabel10)
                    .addComponent(lblGioiTinh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblgmail)
                    .addComponent(lblSDT)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblmatkhau)
                    .addComponent(jLabel5)
                    .addComponent(lbltkkk))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
        // TODO add your handling code here:
        ImgHelper n = new ImgHelper();
        n.ChonHinh(frame, lblHinh, txtHinh);
        boolean check = Msgbox.yesNo("Thay đổi ảnh đại diện", "Bạn có muốn thay đổi ảnh đại diện của mình hay không");
        if (check) {
            daoNV.updateHA(txtHinh.getText(), lblMaNV.getText());
        } else {
            NhanVien nv = daoNV.selectByid(Auth.tk.getMaNV());
            new ImgHelper().loadHinhVaoForm(nv.getHinhAnh(), lblHinh);
        }
    }//GEN-LAST:event_lblHinhMouseClicked

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new DoiMatKhauJFrame().setVisible(true);

    }//GEN-LAST:event_button2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_TaiKhoanCuaBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_TaiKhoanCuaBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_TaiKhoanCuaBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_TaiKhoanCuaBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Form_TaiKhoanCuaBan dialog = new Form_TaiKhoanCuaBan(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.duan1.swing.Button button2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblTenNV;
    private javax.swing.JLabel lblcancuoc;
    private javax.swing.JLabel lblgmail;
    private javax.swing.JLabel lblmatkhau;
    private javax.swing.JLabel lbltkkk;
    private javax.swing.JTextField txtHinh;
    // End of variables declaration//GEN-END:variables
}
