/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.duan1.components;

import com.duan1.DAO.HoaDonChiTietDAO;
import com.duan1.DAO.HoaDonDAO;
import com.duan1.DAO.KhachHangDAO;
import com.duan1.Entity.HoaDon;
import com.duan1.Entity.HoaDonChiTiet;
import com.duan1.Entity.KhachHang;
import com.duan1.Helper.Msgbox;
import com.duan1.ui.MainJFrame;
import java.awt.Color;
import java.util.Date;
import java.util.List;

/**
 *
 * @author MSI PC
 */
public class JDL_NhapKhachHang extends javax.swing.JDialog {

    List<HoaDonChiTiet> listHDCT = null;
    HoaDonChiTietDAO daoHDCT = new HoaDonChiTietDAO();
    HoaDonDAO daoHD = new HoaDonDAO();
    KhachHangDAO daoKH = new KhachHangDAO();
    long tongTien = 0;
    long tienThanhToan = 0;
    boolean checkThanhToan = false;
    String MAKH = "";
    String SDT_REG = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
    String HOTEN_REG = "^([A-Za-zỲọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂĐ']+)((\\s{1}[A-Za-zỲọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂĐ']+){1,})$";

    MainJFrame f = new MainJFrame();

    /**
     * Creates new form JDL_NhapKhachHang
     */
    public JDL_NhapKhachHang(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        setHint();
        try {
            lblMaKH.setText("KH" + daoKH.initID());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setHint() {
        txtTenKH.setLabelText("Họ và Tên khách hàng");
        txtSDTKH.setLabelText("Số điện thoại");
        txtTienKhachDua.setLabelText("Tiền khách đưa");
        txtGhiChu.setLabelText("Ghi chú");
    }

    public long lamTron(int tongTien) {
        int tienTT = tongTien;
        int donViTram = tongTien % 1000;
        if (donViTram != 0) {
            if (donViTram >= 500) {
                tienTT = tongTien + (1000 - donViTram);
            } else {
                tienTT = tongTien - donViTram;
            }
        }
        return tienTT;
    }

    public void setTongTienSP(int tongTien) {
        this.tongTien = tongTien;
        tienThanhToan = tongTien;
        lblTongTien.setText(tongTien + "");
        lblThanhToan.setText(tienThanhToan + "");
    }

    public List<HoaDonChiTiet> getList(List<HoaDonChiTiet> listHDCT) {
        return this.listHDCT = listHDCT;
    }

    public boolean validateForm() {
        boolean check = true;
        if (txtTenKH.getText().trim().isEmpty()) {
            Msgbox.waring(f, "Bạn chưa nhập tên khách hàng!");
            check = false;
        } else {
            if (!txtTenKH.getText().matches(HOTEN_REG)) {
                Msgbox.waring(f, "Tên phải bao gồm Họ và Tên! VD: Nguyễn Văn A");
                check = false;
            }
        }
        if (txtSDTKH.getText().trim().isEmpty()) {
            Msgbox.waring(f, "Bạn chưa nhập SĐT!");
            check = false;
        } else {
            if (!txtSDTKH.getText().matches(SDT_REG)) {
                Msgbox.waring(f, "SĐT không đúng định dạng!");
                check = false;
            }
        }

        if (txtTienKhachDua.getText().trim().isEmpty()) {
            Msgbox.waring(f, "Bạn chưa nhập tiền khách đưa!");
            check = false;
        } else {
            
            try {
                int so = Integer.parseInt(txtTienKhachDua.getText());
            } catch (Exception e) {
                Msgbox.waring(f, "Tiền khách đưa phải là số!");
                check = false;
            }
            if(txtTienKhachDua.getText().length() > 10){
                Msgbox.waring(f, "Tiền khách đưa vượt quá kí tự cho phép!");
                check = false;
            }
        }
        return check;
    }

    public void thanhToan() {
        String maKH = "";
        String maHD = "";
        boolean check = true;
        if (!validateForm()) {
            return;
        }
        try {
            maKH = "KH" + daoKH.initID();
            maHD = "HD" + daoHD.initID();

            KhachHang kh = new KhachHang(maKH, txtTenKH.getText(), txtSDTKH.getText(), 1);
            daoKH.insert(kh);
            HoaDon hd = new HoaDon(maHD, 0, new Date(), txtGhiChu1.getText(), "NV01", maKH);
            daoHD.insert(hd);

            for (HoaDonChiTiet hdct : listHDCT) {
                try {
                    hdct.setMaHD(hd.getMaHD());
                    daoHDCT.insert(hdct);
                } catch (Exception e) {
                    e.printStackTrace();
                    check = false;
                }
            }

            if (check == false) {
                Msgbox.waring(f, "Đã thêm thất bại!");
                return;
            } else {
                Msgbox.success(f, "Đã thêm thành công!");
                checkThanhToan = true;
            }

            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isSuscess() {
        return checkThanhToan;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTrang1 = new com.duan1.components.panelTrang();
        txtTenKH = new com.duan1.swing.MyTextField2();
        txtSDTKH = new com.duan1.swing.MyTextField2();
        btnThanhToan = new com.duan1.swing.Button();
        btnHuy = new com.duan1.swing.Button();
        txtGhiChu = new com.duan1.swing.TextAreaScroll();
        txtGhiChu1 = new com.duan1.swing.TextArea();
        jLabel5 = new javax.swing.JLabel();
        lblThanhToan = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        txtTienKhachDua = new com.duan1.swing.MyTextField2();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTienTraLai = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblMaKH = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panelTrang1.setBackground(new java.awt.Color(153, 51, 0));

        btnThanhToan.setBackground(new java.awt.Color(123, 181, 74));
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(204, 0, 51));
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy");
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        txtGhiChu1.setColumns(20);
        txtGhiChu1.setRows(5);
        txtGhiChu.setViewportView(txtGhiChu1);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Thanh toán:");

        lblThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblThanhToan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Tổng tiền:");

        lblTongTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTongTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        txtTienKhachDua.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhachDuaCaretUpdate(evt);
            }
        });
        txtTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachDuaActionPerformed(evt);
            }
        });
        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("VND");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("NHẬP THÔNG TIN KHÁCH HÀNG");

        lblTienTraLai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTienTraLai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Trả lại:");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("VND");

        jLabel2.setText("Mã KH:");

        lblMaKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelTrang1Layout = new javax.swing.GroupLayout(panelTrang1);
        panelTrang1.setLayout(panelTrang1Layout);
        panelTrang1Layout.setHorizontalGroup(
            panelTrang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTrang1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelTrang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSDTKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTrang1Layout.createSequentialGroup()
                        .addGroup(panelTrang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTrang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTrang1Layout.createSequentialGroup()
                                .addComponent(lblThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel8))
                            .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(panelTrang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTrang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTrang1Layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblTienTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel10))
                                .addComponent(txtTienKhachDua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTrang1Layout.createSequentialGroup()
                                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTrang1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelTrang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTrang1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTrang1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))))
        );
        panelTrang1Layout.setVerticalGroup(
            panelTrang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTrang1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(panelTrang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSDTKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTrang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTrang1Layout.createSequentialGroup()
                        .addGroup(panelTrang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTrang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)))
                    .addGroup(panelTrang1Layout.createSequentialGroup()
                        .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelTrang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(lblTienTraLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(19, 19, 19)
                .addGroup(panelTrang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTrang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTrang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        thanhToan();
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtTienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachDuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKhachDuaActionPerformed

    private void txtTienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachDuaCaretUpdate


    }//GEN-LAST:event_txtTienKhachDuaCaretUpdate

    private void txtTienKhachDuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyPressed

    }//GEN-LAST:event_txtTienKhachDuaKeyPressed

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        if (txtTienKhachDua.getText().trim().isEmpty()) {
            lblTienTraLai.setText("");
            return;
        }
        long tienTT = tienThanhToan;
        try {
            long tienKhachDua = Long.parseLong(txtTienKhachDua.getText());
            long tienTraLai = tienKhachDua - tienTT;

            if (tienTraLai >= 0) {
                lblTienTraLai.setText(tienTraLai + "");
            }
        } catch (NumberFormatException e) {
            Msgbox.waring(new MainJFrame(), "Nhập quá ký tự cho phép!");
            return;
        }
    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

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
            java.util.logging.Logger.getLogger(JDL_NhapKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDL_NhapKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDL_NhapKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDL_NhapKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDL_NhapKhachHang dialog = new JDL_NhapKhachHang(new javax.swing.JFrame(), true);
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
    private com.duan1.swing.Button btnHuy;
    private com.duan1.swing.Button btnThanhToan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblMaKH;
    private javax.swing.JLabel lblThanhToan;
    private javax.swing.JLabel lblTienTraLai;
    private javax.swing.JLabel lblTongTien;
    private com.duan1.components.panelTrang panelTrang1;
    private com.duan1.swing.TextAreaScroll txtGhiChu;
    private com.duan1.swing.TextArea txtGhiChu1;
    private com.duan1.swing.MyTextField2 txtSDTKH;
    private com.duan1.swing.MyTextField2 txtTenKH;
    private com.duan1.swing.MyTextField2 txtTienKhachDua;
    // End of variables declaration//GEN-END:variables
}
