package com.duan1.ui;

import com.duan1.DAO.TaiKhoanDAO;
import com.duan1.Entity.TaiKhoan;
import com.duan1.Helper.Auth;
import com.duan1.Helper.ImgHelper;
import com.duan1.Helper.Msgbox;
import com.duan1.components.Form_Load;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class loginJFrame extends javax.swing.JFrame {

    public loginJFrame() {
        initComponents();
        this.setIconImage(ImgHelper.APP_ICON);
        lblThoat.setCursor(new Cursor(Cursor.HAND_CURSOR));
        txtMatKhau.setCursor(new Cursor(Cursor.HAND_CURSOR));
        txtTenTK.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnDangNhap.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbldn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
    }

    TaiKhoanDAO dao = new TaiKhoanDAO();
    List<TaiKhoan> list = new ArrayList<>();

    public void login() {
        int i = 0;
        list = dao.selectAll();
        for (TaiKhoan t : list) {
            try {
                if (t.getTenTK().equalsIgnoreCase(txtTenTK.getText())) {
                    TaiKhoan tk = new TaiKhoan();
                    tk = list.get(i);
                    if (t.getMatKhau().equals(txtMatKhau.getText())) {
                        Auth.tk = tk;
                        new Form_Load().setVisible(true);
                        this.dispose();
                        return;
                    } else {
                        Msgbox.waring(this, "Sai mật khẩu");
                        lbldn.setText("Hãy thử lại");
                    }

                }
            } catch (Exception e) {
                Msgbox.waring(this, "Lỗi truy vấn");
            }
            i++;
        }
        Msgbox.waring(this, "Nhân viên không tồn tại");
        lbldn.setText("Hãy thử lại");

    }

    public void exit() {
        //if (Msgbox.yesNo("Thoát chương trình", "Bạn có muốn thoát hay không ?")) {
        System.exit(0);
        // }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.duan1.components.panelLogin_Border();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblThoat = new javax.swing.JLabel();
        panelLogin_left2 = new com.duan1.components.panelLogin_left();
        txtTenTK = new com.duan1.swing.MyTextField();
        txtMatKhau = new com.duan1.swing.MyPassField();
        jLabel2 = new javax.swing.JLabel();
        lbldn = new javax.swing.JLabel();
        btnDangNhap = new com.duan1.swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Pristina", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome to LBEES");
        panelBorder1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 360, 100));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_bee_127px.png"))); // NOI18N
        panelBorder1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 140, 130));

        lblThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/16_Thoat_16.png"))); // NOI18N
        lblThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThoatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblThoatMouseEntered(evt);
            }
        });
        panelBorder1.add(lblThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));
        panelBorder1.add(panelLogin_left2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 452, 504));

        txtTenTK.setText("nhutdong");
        txtTenTK.setIconTrc(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/32_User.png"))); // NOI18N
        panelBorder1.add(txtTenTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 240, 36));

        txtMatKhau.setText("nhutdong123");
        txtMatKhau.setIconTrc(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/32_Pass.png"))); // NOI18N
        txtMatKhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMatKhauKeyReleased(evt);
            }
        });
        panelBorder1.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 240, 36));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ĐĂNG NHẬP");
        panelBorder1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 160, 49));

        lbldn.setForeground(new java.awt.Color(0, 0, 204));
        lbldn.setText("Quên mật khẩu?");
        panelBorder1.add(lbldn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, 90, 30));

        btnDangNhap.setBackground(new java.awt.Color(51, 153, 255));
        btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        btnDangNhap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnDangNhapKeyPressed(evt);
            }
        });
        panelBorder1.add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void lblThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseClicked
        exit();
    }//GEN-LAST:event_lblThoatMouseClicked

    private void lblThoatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseEntered

    }//GEN-LAST:event_lblThoatMouseEntered

    private void txtMatKhauKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatKhauKeyReleased
      if (evt.getKeyChar()== KeyEvent.VK_ENTER){
             login();
        this.dispose();
        }
    }//GEN-LAST:event_txtMatKhauKeyReleased

    private void btnDangNhapKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnDangNhapKeyPressed
          if (evt.getKeyChar()== KeyEvent.VK_ENTER){
             login();
        this.dispose();
        }
    }//GEN-LAST:event_btnDangNhapKeyPressed

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
            java.util.logging.Logger.getLogger(loginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.duan1.swing.Button btnDangNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JLabel lbldn;
    private com.duan1.components.panelLogin_Border panelBorder1;
    private com.duan1.components.panelLogin_left panelLogin_left2;
    private com.duan1.swing.MyPassField txtMatKhau;
    private com.duan1.swing.MyTextField txtTenTK;
    // End of variables declaration//GEN-END:variables
}
