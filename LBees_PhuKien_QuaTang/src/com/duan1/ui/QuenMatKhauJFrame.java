/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.duan1.ui;

import com.duan1.DAO.NhanVienDAO;
import com.duan1.DAO.TaiKhoanDAO;
import com.duan1.Entity.NhanVien;
import com.duan1.Entity.TaiKhoan;
import com.duan1.Helper.Msgbox;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class QuenMatKhauJFrame extends javax.swing.JFrame {

    /**
     * Creates new form QuenMatKhauJFrame
     */
    public QuenMatKhauJFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }
    TaiKhoanDAO daoTK = new TaiKhoanDAO();
    NhanVienDAO daoNV = new NhanVienDAO();
    List<TaiKhoan> listTK = new ArrayList<>();
    List<NhanVien> listNV = new ArrayList<>();

    public boolean checkLoiMK() {
        if (!txtMK.getText().equals(txtMK02.getText())) {
            Msgbox.waring(this, "mật khẩu không trùng nhau");
            return false;
        }
        return true;
    }

    public void Check() {
        listTK = daoTK.selectAll();
        listNV = daoNV.selectAll();
        for (NhanVien nv : listNV) {
            if (nv.getGmail().equals(txtSDTOrGmail.getText()) || nv.getSDT().equals(txtSDTOrGmail.getText())) {
                TaiKhoan n = new TaiKhoan();
                for (TaiKhoan tk : listTK) {
                    if (tk.getMaNV().equals(nv.getMaNV())) {
                        n.setMaTK(tk.getMaTK());
                        n.setTenTK(tk.getTenTK());
                        n.setMatKhau(txtMK.getText());
                        daoTK.update(n);
                        Msgbox.success(this, "ĐỔi thành công mật khẩu!");
                        new loginJFrame().setVisible(true);
                        this.dispose();
                        return;
                    }
                }

            }
        }
        Msgbox.waring(this, "Số điện thoại hoặc gmail không tồn tại!");
        return;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.duan1.components.panelLogin_Border();
        jLabel4 = new javax.swing.JLabel();
        panelLogin_left2 = new com.duan1.components.panelLogin_left();
        jLabel1 = new javax.swing.JLabel();
        txtSDTOrGmail = new com.duan1.swing.MyTextField();
        txtMK02 = new com.duan1.swing.MyPassField();
        lblthoat = new javax.swing.JLabel();
        txtMK = new com.duan1.swing.MyPassField();
        txtHinh = new javax.swing.JTextField();
        button2 = new com.duan1.swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_bee_127px.png"))); // NOI18N
        panelBorder1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 140, 130));
        panelBorder1.add(panelLogin_left2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 504));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUÊN MẬT KHẨU");
        panelBorder1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 230, 49));

        txtSDTOrGmail.setIconTrc(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/30px_pincode.png"))); // NOI18N
        panelBorder1.add(txtSDTOrGmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 240, 36));

        txtMK02.setIconTrc(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/32_Pass.png"))); // NOI18N
        panelBorder1.add(txtMK02, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 240, 36));

        lblthoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/36px__logout.png"))); // NOI18N
        lblthoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblthoatMouseClicked(evt);
            }
        });
        panelBorder1.add(lblthoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 440, -1, -1));

        txtMK.setIconTrc(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/32_Pass.png"))); // NOI18N
        panelBorder1.add(txtMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 240, 36));
        panelBorder1.add(txtHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        button2.setBackground(new java.awt.Color(51, 153, 255));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Đổi mật khẩu");
        button2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        panelBorder1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 390, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblthoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblthoatMouseClicked
        // TODO add your handling code here:
        new loginJFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblthoatMouseClicked

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        if (checkLoiMK()) {
            Check();
        }

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
            java.util.logging.Logger.getLogger(QuenMatKhauJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhauJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhauJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhauJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuenMatKhauJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.duan1.swing.Button button2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblthoat;
    private com.duan1.components.panelLogin_Border panelBorder1;
    private com.duan1.components.panelLogin_left panelLogin_left2;
    private javax.swing.JTextField txtHinh;
    private com.duan1.swing.MyPassField txtMK;
    private com.duan1.swing.MyPassField txtMK02;
    private com.duan1.swing.MyTextField txtSDTOrGmail;
    // End of variables declaration//GEN-END:variables
}
