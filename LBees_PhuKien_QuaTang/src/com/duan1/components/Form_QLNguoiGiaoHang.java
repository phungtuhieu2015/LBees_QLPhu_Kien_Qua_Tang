/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.duan1.components;

import com.duan1.DAO.NguoiGiaoHangDAO;
import com.duan1.Entity.NguoiGiaoHang;
import com.duan1.Helper.Msgbox;
import com.duan1.swing.EventCallBack;
import com.duan1.swing.EventTextField;
import com.duan1.swing.MessageDialog;
import com.duan1.swing.Notification;
import com.duan1.swing.ScrollBarCustom;
import com.duan1.ui.MainJFrame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ASUS
 */
public class Form_QLNguoiGiaoHang extends javax.swing.JPanel {

    MainJFrame frame = new MainJFrame();
    DefaultTableModel tblModel = new DefaultTableModel();
    List<NguoiGiaoHang> listNGH = new ArrayList<>();
    NguoiGiaoHangDAO dao = new NguoiGiaoHangDAO();
    int index = 0;

    /**
     * Creates new form Form_QLNguoiGiaoHang
     */
    public Form_QLNguoiGiaoHang() {
        initComponents();
        init();
    }

    public void ThanhTruotTb() {
        ScrollNGH.setVerticalScrollBar(new ScrollBarCustom());
    }

    public void init() {
        setHint();
        TimKiem();
        ThanhTruotTb();
        initTable();
        loadData();
    }

    public void TimKiem() {
        txtTimKiem.setHintText("Nhập mã, tên giao hàng");
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
        txtMaNGH.setHint("Nhập mã người giao hàng");
        txtTenNGH.setHint("Tên mã người giao hàng");
        txtEmail.setHint("Nhập Email");
        txtCCCD.setHint("Nhập căn cước công dân");
        txtSDT.setHint("Nhập số điện thoại");

    }

    public void insert() {
        NguoiGiaoHang n = new NguoiGiaoHang();
        n = getForm();
        if (n != null) {
            dao.insert(n);
            loadData();
            Msgbox.success(frame, "Thêm thành công!");
            clear();
        }
    }

    public void update() {
        NguoiGiaoHang n = new NguoiGiaoHang();
        n = getForm();
        dao.update(n);
        loadData();
        Msgbox.success(frame, "Update thành công!");
        clear();

    }

    public void delete() {
        if (Msgbox.yesNo("bạn có muốn xóa", "bạn chắc chắn không???")) {
            dao.delete(txtMaNGH.getText());
            loadData();
            Msgbox.success(frame, "Xóa thành công?");
            clear();
        }
    }

    public void clear() {
        NguoiGiaoHang n = new NguoiGiaoHang();
        setForm(n);
    }

    public void initTable() {
        String[] cols = new String[]{"Mã Người Giao Hàng", "Tên Người Giao Hàng", "CCCD", "Số Điện Thoại", "Gmail"};
        tblModel.setColumnIdentifiers(cols);
        tblNGH.setModel(tblModel);
    }

    public void loadData() {
        while (tblModel.getRowCount() > 0) {
            tblModel.removeRow(0);
        }
        listNGH = dao.selectAll();
        for (NguoiGiaoHang ngh : listNGH) {
            Object[] cols = new Object[]{ngh.getMaNGH(), ngh.getTenNGH(), ngh.getCCCD(), ngh.getSDT(), ngh.getGmail()};
            tblModel.addRow(cols);
        }
    }

    public NguoiGiaoHang getForm() {
        NguoiGiaoHang n = new NguoiGiaoHang();
        n.setMaNGH(txtMaNGH.getText());
        n.setTenNGH(txtTenNGH.getText());
        n.setCCCD(txtCCCD.getText());
        n.setSDT(txtSDT.getText());
        n.setGmail(txtEmail.getText());
        return n;
    }

    public void setForm(NguoiGiaoHang n) {
        txtMaNGH.setText(n.getMaNGH());
        txtTenNGH.setText(n.getTenNGH());
        txtCCCD.setText(n.getCCCD());
        txtSDT.setText(n.getSDT());
        txtEmail.setText(n.getGmail());
    }

    public void display(int index) {
        NguoiGiaoHang n = listNGH.get(index);
        txtMaNGH.setText(n.getMaNGH());
        txtTenNGH.setText(n.getTenNGH());
        txtCCCD.setText(n.getCCCD());
        txtSDT.setText(n.getSDT());
        txtEmail.setText(n.getGmail());
    }

    public void findIdAndName(String IdAndName) {
        tblModel = (DefaultTableModel) tblNGH.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(tblModel);
        tblNGH.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + IdAndName, 0, 1));
    }

    public void edit() {
        tblNGH.setRowSelectionInterval(index, index);
        display(index);
    }
    //fist

    public void firs() {
        index = 0;
        edit();
    }

    //end
    public void last() {
        index = listNGH.size() - 1;
        edit();
    }

    //prev
    public void prev() {
        if (index <= 0) {
            last();
        } else {
            index--;
        }
        edit();

    }

    //next
    public void next() {
        if (index == listNGH.size() - 1) {
            firs();
        } else {
            index++;
        }
        edit();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTimKiem = new com.duan1.swing.TextFieldAnimation();
        tabPane = new com.duan1.swing.MaterialTabbed();
        pnlCapNhat = new javax.swing.JPanel();
        pnlText = new javax.swing.JPanel();
        txtMaNGH = new com.duan1.swing.MyTextField();
        txtTenNGH = new com.duan1.swing.MyTextField();
        txtSDT = new com.duan1.swing.MyTextField();
        txtEmail = new com.duan1.swing.MyTextField();
        txtCCCD = new com.duan1.swing.MyTextField();
        pnlThemSuaXoa = new javax.swing.JPanel();
        button6 = new com.duan1.swing.Button();
        button7 = new com.duan1.swing.Button();
        button8 = new com.duan1.swing.Button();
        button2 = new com.duan1.swing.Button();
        pnlDieuHuong = new javax.swing.JPanel();
        btnThem = new com.duan1.swing.Button();
        btnSua = new com.duan1.swing.Button();
        btnXoa = new com.duan1.swing.Button();
        btnMoi = new com.duan1.swing.Button();
        pnlDanhSach = new javax.swing.JPanel();
        ScrollNGH = new javax.swing.JScrollPane();
        tblNGH = new com.duan1.swing.Table();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(923, 604));
        setMinimumSize(new java.awt.Dimension(923, 604));
        setPreferredSize(new java.awt.Dimension(923, 604));

        txtTimKiem.setBackground(new java.awt.Color(222, 214, 214));
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        pnlCapNhat.setBackground(new java.awt.Color(255, 255, 255));

        pnlText.setBackground(new java.awt.Color(255, 255, 255));

        pnlThemSuaXoa.setBackground(new java.awt.Color(255, 255, 255));
        pnlThemSuaXoa.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        button6.setText("<");
        button6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });
        pnlThemSuaXoa.add(button6);

        button7.setText("|<");
        button7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });
        pnlThemSuaXoa.add(button7);

        button8.setText(">|");
        button8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });
        pnlThemSuaXoa.add(button8);

        button2.setText(">");
        button2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        pnlThemSuaXoa.add(button2);

        pnlDieuHuong.setBackground(new java.awt.Color(255, 255, 255));
        pnlDieuHuong.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        btnThem.setText("Thêm");
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        pnlDieuHuong.add(btnThem);

        btnSua.setText("Sửa");
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        pnlDieuHuong.add(btnSua);

        btnXoa.setText("Xóa");
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        pnlDieuHuong.add(btnXoa);

        btnMoi.setText("Mới");
        btnMoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });
        pnlDieuHuong.add(btnMoi);

        javax.swing.GroupLayout pnlTextLayout = new javax.swing.GroupLayout(pnlText);
        pnlText.setLayout(pnlTextLayout);
        pnlTextLayout.setHorizontalGroup(
            pnlTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTextLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(pnlTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtTenNGH, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtMaNGH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119)
                .addGroup(pnlTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(pnlTextLayout.createSequentialGroup()
                .addComponent(pnlDieuHuong, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 351, Short.MAX_VALUE)
                .addComponent(pnlThemSuaXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlTextLayout.setVerticalGroup(
            pnlTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTextLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnlTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNGH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(pnlTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenNGH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(pnlTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTextLayout.createSequentialGroup()
                        .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                        .addComponent(pnlDieuHuong, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTextLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnlThemSuaXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

        tabPane.addTab("Cập Nhật", pnlCapNhat);

        ScrollNGH.setBackground(new java.awt.Color(255, 255, 102));
        ScrollNGH.setBorder(null);

        tblNGH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Người Giao Hàng", "Tên Người Giao Hàng", "CCCD", "Số Điện Thoại", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNGH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNGHMouseClicked(evt);
            }
        });
        ScrollNGH.setViewportView(tblNGH);
        if (tblNGH.getColumnModel().getColumnCount() > 0) {
            tblNGH.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblNGH.getColumnModel().getColumn(2).setPreferredWidth(25);
            tblNGH.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        javax.swing.GroupLayout pnlDanhSachLayout = new javax.swing.GroupLayout(pnlDanhSach);
        pnlDanhSach.setLayout(pnlDanhSachLayout);
        pnlDanhSachLayout.setHorizontalGroup(
            pnlDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollNGH, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
        );
        pnlDanhSachLayout.setVerticalGroup(
            pnlDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollNGH, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        tabPane.addTab("Danh Sách", pnlDanhSach);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("QUẢN LÝ NGƯỜI GIAO HÀNG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void tblNGHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNGHMouseClicked
        // TODO add your handling code here:
        index = tblNGH.getSelectedRow();
        display(index);
        tabPane.setSelectedIndex(0);
    }//GEN-LAST:event_tblNGHMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

        update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        txtMaNGH.setText("");
        txtTenNGH.setText("");
        txtCCCD.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
    }//GEN-LAST:event_btnMoiActionPerformed

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        findIdAndName(txtTimKiem.getText());
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        // TODO add your handling code here:
        prev();
    }//GEN-LAST:event_button6ActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        // TODO add your handling code here:
        firs();
    }//GEN-LAST:event_button7ActionPerformed

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
        // TODO add your handling code here:
        last();
    }//GEN-LAST:event_button8ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        next();
    }//GEN-LAST:event_button2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollNGH;
    private com.duan1.swing.Button btnMoi;
    private com.duan1.swing.Button btnSua;
    private com.duan1.swing.Button btnThem;
    private com.duan1.swing.Button btnXoa;
    private com.duan1.swing.Button button2;
    private com.duan1.swing.Button button6;
    private com.duan1.swing.Button button7;
    private com.duan1.swing.Button button8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlCapNhat;
    private javax.swing.JPanel pnlDanhSach;
    private javax.swing.JPanel pnlDieuHuong;
    private javax.swing.JPanel pnlText;
    private javax.swing.JPanel pnlThemSuaXoa;
    private com.duan1.swing.MaterialTabbed tabPane;
    private com.duan1.swing.Table tblNGH;
    private com.duan1.swing.MyTextField txtCCCD;
    private com.duan1.swing.MyTextField txtEmail;
    private com.duan1.swing.MyTextField txtMaNGH;
    private com.duan1.swing.MyTextField txtSDT;
    private com.duan1.swing.MyTextField txtTenNGH;
    private com.duan1.swing.TextFieldAnimation txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
