package com.duan1.ui;

import com.duan1.DAO.NhanVienDAO;
import com.duan1.DAO.TaiKhoanDAO;

import com.duan1.Helper.Auth;
import com.duan1.Helper.Msgbox;
import java.awt.Color;


public class DoiMatKhauJFrame extends javax.swing.JFrame {
    TaiKhoanDAO daoTK = new TaiKhoanDAO();

    public DoiMatKhauJFrame() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));

        txtMK.setHint("nhập mật khẩu mới");
        txtMatKhauCu.setHint("Mật khẩu cũ");
        txtMK02.setHint("nhập lại mật khẩu mới");
        txtTenTK.setText(Auth.tk.getTenTK());
    }
     private void Pass() {
//        if (!Auth.tk.getTenTK().equals(txtTenTK.getText())) {
//            Msgbox.waring(this, "Bạn nhập sai tên đăng nhập!");
//            return;
//        }
        if (!Auth.tk.getMatKhau().equals(String.valueOf(txtMatKhauCu.getText()))) {
            Msgbox.waring(this, "Bạn nhập sai mật khẩu cũ!");
            return;
        }
        if (!String.valueOf(txtMK.getPassword()).equals(String.valueOf(txtMK02.getPassword()))) {
            Msgbox.waring(this, "Mật khẩu không trùng nhau!");
            return;
        }
        Auth.tk.setMatKhau(String.valueOf(txtMK02.getPassword()));
        daoTK.update(Auth.tk);
        Msgbox.info(this, "Bạn đã đổi thành công mật khẩu");
        this.dispose();
   }
     public boolean check() {
//        if (txtTenTK.getText().length() < 3) {
//            if (txtTenTK.getText().length() == 0) {
//                Msgbox.waring(this, "Tên đăng nhập không được để trống");
//                return false;
//            }
//            if (txtTenTK.getText().length() > 0 && txtTenTK.getText().length() < 3) {
//                Msgbox.waring(this, "Tên đăng nhập phải nhập ít nhất 3 ký tự");
//                return false;
//            }
//        }
        if (txtMK.getText().length() < 5) {
            if (txtMK.getText().length() == 0) {
                Msgbox.waring(this, "Mật khẩu không được để trống");
                return false;
            }
            if (txtMK.getText().length() > 0 && txtMK.getText().length() < 5) {
                Msgbox.waring(this, "Mật khẩu phải nhập ít nhất 5 ký tự");
                return false;
            }
        }
        if (txtMK02.getText().length() < 3) {
            if (txtMK02.getText().length() == 0) {
                Msgbox.waring(this, "nhập lại mật khẩu không được để trống");
                return false;
            }
        }
        return true;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.duan1.components.panelLogin_Border();
        panelLogin_left2 = new com.duan1.components.panelLogin_left();
        jLabel1 = new javax.swing.JLabel();
        txtTenTK = new com.duan1.swing.MyTextField();
        txtMK02 = new com.duan1.swing.MyPassField();
        txtMatKhauCu = new com.duan1.swing.MyPassField();
        lblthoat = new javax.swing.JLabel();
        button1 = new com.duan1.swing.Button();
        txtMK = new com.duan1.swing.MyPassField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelBorder1.add(panelLogin_left2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 452, 504));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐỔI MẬT KHẨU");
        panelBorder1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 200, 49));

        txtTenTK.setIconTrc(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/32_User.png"))); // NOI18N
        panelBorder1.add(txtTenTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 240, 36));

        txtMK02.setIconTrc(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/32_Pass.png"))); // NOI18N
        panelBorder1.add(txtMK02, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 240, 36));

        txtMatKhauCu.setIconTrc(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/30px_pincode.png"))); // NOI18N
        panelBorder1.add(txtMatKhauCu, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 226, 240, 40));

        lblthoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/36px__logout.png"))); // NOI18N
        lblthoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblthoatMouseClicked(evt);
            }
        });
        panelBorder1.add(lblthoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 440, -1, -1));

        button1.setText("Đổi mật khẩu");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panelBorder1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 390, 110, 30));

        txtMK.setIconTrc(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/32_Pass.png"))); // NOI18N
        panelBorder1.add(txtMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 240, 36));

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

    private void lblthoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblthoatMouseClicked
        // TODO add your handling code here:
        new MainJFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_lblthoatMouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        if (check()) {
            Pass();
        }
    }//GEN-LAST:event_button1ActionPerformed
    
  
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
            java.util.logging.Logger.getLogger(DoiMatKhauJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhauJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhauJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhauJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoiMatKhauJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.duan1.swing.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblthoat;
    private com.duan1.components.panelLogin_Border panelBorder1;
    private com.duan1.components.panelLogin_left panelLogin_left2;
    private com.duan1.swing.MyPassField txtMK;
    private com.duan1.swing.MyPassField txtMK02;
    private com.duan1.swing.MyPassField txtMatKhauCu;
    private com.duan1.swing.MyTextField txtTenTK;
    // End of variables declaration//GEN-END:variables

    
}
