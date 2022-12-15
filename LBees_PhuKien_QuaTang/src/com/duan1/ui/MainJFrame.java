package com.duan1.ui;

import com.duan1.DAO.NhanVienDAO;
import com.duan1.DAO.TaiKhoanDAO;
import com.duan1.Entity.NhanVien;
import com.duan1.Entity.TaiKhoan;
import com.duan1.Helper.Auth;
import com.duan1.Helper.ImgHelper;
import com.duan1.Helper.Msgbox;
import com.duan1.components.Form_LSHoaDon;
import com.duan1.components.Form_Load;
import com.duan1.components.Form_QLBanHang;
import com.duan1.components.Form_QLDanhMuc;
import com.duan1.components.Form_QLKhachHang;
import com.duan1.components.Form_QLNguoiGiaoHang;
import com.duan1.components.Main_Form;
import com.duan1.components.Form_QLNhanVien;
import com.duan1.components.Form_QLSanPham;
import com.duan1.components.Form_QLTaiKhoan;
import com.duan1.components.Form_TaiKhoanCuaBan;
import com.duan1.components.Form_QuaTang;
import com.duan1.components.Form_ThongKe;
import com.duan1.swing.EventMenuSelected;
import java.awt.Component;
import com.duan1.components.Form_ThongKe;
import com.duan1.components.Main_Form;
import com.duan1.components.Form_QLBanHang;
import com.duan1.components.JDL_ThongTinChiTiet_LSHoaDon;
import com.duan1.components.jdl_GTQT;
import com.duan1.swing.EventMenuSelected;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.Timer;

public class MainJFrame extends javax.swing.JFrame {

    private final JPopupMenu popupMenu = new JPopupMenu();
    private JMenuItem menuItem = null;
    Timer thoiGian;
    private static MainJFrame mainJFrame;
    NhanVienDAO daoNV = new NhanVienDAO();

    public MainJFrame() {

        initComponents();

        init();
        initMoving(this);
        dongHo();
        creatPopupMenu(this);
        setavatar();
        this.setIconImage(ImgHelper.APP_ICON);
    }
    int indexx = 0;

    public void setavatar() {
        NhanVien nv = daoNV.selectByid(Auth.tk.getMaNV());
        new ImgHelper().loadHinhVaoForm(nv.getHinhAnh(), lblAvatar);
    }

    public void checkDN() {

        if (Auth.isLogin()) {
            lblTen.setText("Xin chào: " + Auth.tenNV());
            if (Auth.role()) {
                lblCVFN.setText("Chức vụ: Quản lý");
            } else {
                lblCVFN.setText("Chức vụ: Nhân viên");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng đăng nhập", "Hệ thống", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    private void init() {
        mainJFrame = this;
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int index, int indexSubMenu) {
//               if(!Form_QLSanPham.checkBtn) {
//                   Msgbox.waring(mainJFrame, "Vui lòng kết thúc lần nhập kho trước khi thoát!");
//                   return;
//               }
                if (index == 0 && indexSubMenu == 0) {
                    if (indexx == 3) {
                        Form_QLBanHang.checks = 0;
                    }
                    showForm(new Main_Form());
                } else if (index == 1 && indexSubMenu == 1) {

                    Form_QLBanHang.checks = 0;
                    showForm(new Form_QLKhachHang());

                } else if (index == 1 && indexSubMenu == 2) {
                    if (Auth.role()) {
                    } else {
                        Msgbox.waring(mainJFrame, "Phần này chỉ dành cho quản lý!");
                        return;
                    }
                    Form_QLBanHang.checks = 0;
                    showForm(new Form_QLNhanVien());

                } else if (index == 1 && indexSubMenu == 3) {
                    Form_QLBanHang.checks = 0;
                    showForm(new Form_QLNguoiGiaoHang());

                } else if (index == 1 && indexSubMenu == 4) {
                    if (Auth.role()) {
                    } else {
                        Msgbox.waring(mainJFrame, "Phần này chỉ dành cho quản lý!");
                        return;
                    }
                    Form_QLBanHang.checks = 0;

                    showForm(new Form_QLTaiKhoan());

                } else if (index == 1 && indexSubMenu == 5) {
                    if (Auth.role()) {
                    } else {
                        Msgbox.waring(mainJFrame, "Phần này chỉ dành cho quản lý!");
                        return;
                    }
                    Form_QLBanHang.checks = 0;

                    showForm(new Form_QLDanhMuc());
                } else if (index == 2 && indexSubMenu == 0) {
                    Form_QLBanHang.checks = 0;
                    showForm(new Form_QLSanPham());

                } else if (index == 3 && indexSubMenu == 0) {
                    indexx = index;
                    Form_QLBanHang.checks = 1;
                    showForm(new Form_QLBanHang());

                } else if (index == 4 && indexSubMenu == 0) {
                    Form_QLBanHang.checks = 0;
                    showForm(new Form_LSHoaDon());

                } else if (index == 5 && indexSubMenu == 0) {
                    if (Auth.role()) {
                    } else {
                        Msgbox.waring(mainJFrame, "Phần này chỉ dành cho quản lý!");
                        return;
                    }
                    Form_QLBanHang.checks = 0;
//                    try {
                    showForm(new Form_ThongKe());
//                    } catch (SQLException ex) {
//                        Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                } else if (index == 6 && indexSubMenu == 0) {
                    Form_QLBanHang.checks = 2;
                    showForm(new Form_QuaTang());

                } else {
                    Form_QLBanHang.checks = 0;
                }
            }
        });
        menu.setSelectedIndex(0, 0);
    }

    public void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.repaint();
        body.revalidate();
    }

    public static MainJFrame getMain() {
        return mainJFrame;
    }
    int x;
    int y;

    public void initMoving(JFrame frame) {
        panelThoat.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                x = evt.getX();
                y = evt.getY();
            }
        });
        panelThoat.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                frame.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }

        });
    }

//    public void setform(){
//        lblTen.setText(Auth.tenNV());
//        lblCVFN.setText(Auth.role());
//    }
    @SuppressWarnings("unchecksed")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        panelMenuu = new javax.swing.JPanel();
        menu = new com.duan1.swing.Menu();
        panelThoat = new javax.swing.JPanel();
        lblThoat = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        lblAvatar = new javax.swing.JLabel();
        lblDongHo = new javax.swing.JLabel();
        lblCVFN = new javax.swing.JLabel();
        lblBaCham = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setToolTipText("");

        panelMenuu.setBackground(new java.awt.Color(255, 255, 255));

        panelThoat.setBackground(new java.awt.Color(27, 178, 222));

        lblThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/16_Thoat_16.png"))); // NOI18N
        lblThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThoatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblThoatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblThoatMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelThoatLayout = new javax.swing.GroupLayout(panelThoat);
        panelThoat.setLayout(panelThoatLayout);
        panelThoatLayout.setHorizontalGroup(
            panelThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThoatLayout.createSequentialGroup()
                .addComponent(lblThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelThoatLayout.setVerticalGroup(
            panelThoatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblThoat, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelMenuuLayout = new javax.swing.GroupLayout(panelMenuu);
        panelMenuu.setLayout(panelMenuuLayout);
        panelMenuuLayout.setHorizontalGroup(
            panelMenuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuuLayout.createSequentialGroup()
                .addGroup(panelMenuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelThoat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelMenuuLayout.setVerticalGroup(
            panelMenuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuuLayout.createSequentialGroup()
                .addComponent(panelThoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setOpaque(false);
        body.setLayout(new java.awt.BorderLayout());

        lblAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/48_avatar_48.png"))); // NOI18N
        lblAvatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAvatarMouseClicked(evt);
            }
        });

        lblDongHo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDongHo.setText("00:00:00");

        lblCVFN.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblCVFN.setText("admin");
        lblCVFN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCVFNMouseClicked(evt);
            }
        });

        lblBaCham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/baCham_32.png"))); // NOI18N
        lblBaCham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBaChamMouseClicked(evt);
            }
        });

        lblTen.setText("Khanh");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(panelMenuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(lblAvatar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCVFN, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTen, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDongHo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBaCham, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblTen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCVFN, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBaCham))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void creatPopupMenu(JFrame jFrame) {
        menuItem = new JMenuItem(
                "Đăng xuất",
                new ImageIcon(".\\src\\com\\duan1\\icon\\16_dangXuat_16.png")
        );
        //apply desc
        menuItem.getAccessibleContext().setAccessibleDescription("Đăng xuất");
        //Add an Action Listener
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //showForm(new panelTaiKhoanCuaBan ());

            }
        });
        popupMenu.add(menuItem);

        menuItem = new JMenuItem(
                "Đổi mật khẩu",
                new ImageIcon(".\\src\\com\\duan1\\icon\\16_quenmatkhau_16.png")
        );

        //apply desc
        menuItem.getAccessibleContext().setAccessibleDescription("Đổi mật khẩu");
        //Add an Action Listener
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DoiMatKhauJFrame().setVisible(true);

            }
        });
        popupMenu.add(menuItem);

        menuItem = new JMenuItem(
                "Giới thiệu ứng dụng",
                new ImageIcon(".\\src\\com\\duan1\\icon\\16_gif_16.png")
        );
        //apply desc
        menuItem.getAccessibleContext().setAccessibleDescription("Giới thiệu ứng dụng");
        //Add an Action Listener
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainJFrame m = new MainJFrame();
                jdl_GTQT jdl = new jdl_GTQT(m, true);
                jdl.setVisible(true);
            }
        });
        popupMenu.add(menuItem);
    }

    public void dongHo() {
        thoiGian = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Date hienTai = new Date();
                SimpleDateFormat dinhDang = new SimpleDateFormat("hh:mm:ss");
                lblDongHo.setText(dinhDang.format(hienTai));
            }
        });
        thoiGian.start();
    }


    private void lblThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseClicked
        Form_QLBanHang.checks = 0;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Auth.clear();
        System.exit(0);
    }//GEN-LAST:event_lblThoatMouseClicked

    private void lblBaChamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBaChamMouseClicked
        int mPoX = MouseInfo.getPointerInfo().getLocation().x;
        int mPoY = MouseInfo.getPointerInfo().getLocation().y;

        //showw popupmenu
        popupMenu.show(this, 1050, 45);
    }//GEN-LAST:event_lblBaChamMouseClicked

    private void lblAvatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAvatarMouseClicked
        new Form_TaiKhoanCuaBan(this, rootPaneCheckingEnabled).setVisible(true);

    }//GEN-LAST:event_lblAvatarMouseClicked

    private void lblCVFNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCVFNMouseClicked

    }//GEN-LAST:event_lblCVFNMouseClicked

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased

    }//GEN-LAST:event_formKeyReleased

    private void lblThoatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseEntered
        lblThoat.setBackground(Color.red);
        lblThoat.setOpaque(true);
    }//GEN-LAST:event_lblThoatMouseEntered

    private void lblThoatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseExited
        lblThoat.setBackground(panelThoat.getBackground());
        lblThoat.setOpaque(true);
    }//GEN-LAST:event_lblThoatMouseExited

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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Load().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel body;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblBaCham;
    private javax.swing.JLabel lblCVFN;
    private javax.swing.JLabel lblDongHo;
    private javax.swing.JLabel lblTen;
    private javax.swing.JLabel lblThoat;
    private com.duan1.swing.Menu menu;
    private javax.swing.JPanel panelMenuu;
    private javax.swing.JPanel panelThoat;
    // End of variables declaration//GEN-END:variables

    public void show(Form_QuaTang qt) {
        body.removeAll();
        body.add(qt);
        body.repaint();
        body.revalidate();
    }
}
