package com.duan1.components;

import com.duan1.DAO.DanhMucDAO;
import com.duan1.Entity.DanhMuc;
import com.duan1.Entity.TaiKhoan;
import com.duan1.swing.EventCallBack;
import com.duan1.swing.EventTextField;
import com.duan1.swing.MessageDialog;
import com.duan1.swing.Notification;
import com.duan1.swing.ScrollBarCustom;
import com.duan1.ui.MainJFrame;
import java.awt.Cursor;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ASUS
 */
public class Form_QLDanhMuc extends javax.swing.JPanel {

    DanhMucDAO daoDM = new DanhMucDAO();
    MainJFrame frame = new MainJFrame();
    List<DanhMuc> listDM = daoDM.selectAll();
    public int index;
    DefaultTableModel model;
    MessageDialog mdl = new MessageDialog(frame);

    public Form_QLDanhMuc() {
        initComponents();
        setHin();
        TimKiem();
        loadDataDM();
        ThanhTruotDM();

    }

    public void setHin() {
        txtMaDanhMuc.setHint("Nhập mã mã danh mục");
        txtTenDanhMuc.setHint("Nhập tên danh mục");
        //đổi con chuột
        btnCuoi.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnDau.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLui.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnMoi.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSua.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnThem.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnToi.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnXoa.setCursor(new Cursor(Cursor.HAND_CURSOR));
        txtTimKiem.setCursor(new Cursor(Cursor.HAND_CURSOR));
        txtMaDanhMuc.setCursor(new Cursor(Cursor.HAND_CURSOR));
        txtTenDanhMuc.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Tabpane.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tblDanhMuc.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }
    //tạo thanh trượt trong table

    public void ThanhTruotDM() {
        ScrollTK.setVerticalScrollBar(new ScrollBarCustom());
    }

    public void TimKiem() {
        txtTimKiem.setHintText("Nhập mã danh muc");
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
    //load dữ liệu lên bảng

    public void loadDataDM() {
        DefaultTableModel model = (DefaultTableModel) tblDanhMuc.getModel();
        model.setRowCount(0);
        listDM = daoDM.selectAll();
        try {
            for (DanhMuc dm : listDM) {

                Object[] row = {
                    dm.getMaDM(),
                    dm.getTenDM()
                };
                model.addRow(row);
            }

        } catch (Exception e) {
            Notification noti = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.CENTER, "Lỗi thêm dữ liệu vào danh mục");
            noti.showNotification();
        }
    }

    public void display(int index) {
        DanhMuc danhMuc = listDM.get(index);
        setForm(danhMuc);
    }

    public void setForm(DanhMuc danhMuc) {
        DanhMuc dm = daoDM.selectByid(danhMuc.getMaDM());
        txtMaDanhMuc.setText(danhMuc.getMaDM());
        txtTenDanhMuc.setText(danhMuc.getTenDM());

    }

    public void updateStatus() {
        if (index == 0) {
            btnDau.setEnabled(false);
            btnLui.setEnabled(false);
        } else {
            btnDau.setEnabled(true);
            btnLui.setEnabled(true);
        }
        if (index == listDM.size() - 1) {
            btnToi.setEnabled(false);
            btnDau.setEnabled(false);
        } else {
            btnToi.setEnabled(true);
            btnDau.setEnabled(true);
        }
    }
    //lấy giá trị

    public void edit() {
        tblDanhMuc.setRowSelectionInterval(index, index);
        display(index);
        updateStatus();
    }

    //tạo nút quay lại hàng đầu tiên
    public void firs() {
        index = 0;
        edit();
    }

    //tạo nút tới hàng cuối cùng
    public void last() {
        index = listDM.size() - 1;
        edit();
    }

    //tạo nút lùi lại 1 hàng
    public void prev() {
        if (index <= 0) {
            last();
        } else {
            index--;
        }
        edit();

    }

    //tạo nút tới 1 hàng
    public void next() {
        if (index == listDM.size() - 1) {
            firs();
        } else {
            index++;
        }
        edit();

    }

    public void findIdAndName(String IdAndName) {
        model = (DefaultTableModel) tblDanhMuc.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        tblDanhMuc.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(IdAndName, 0, 1));
    }

    //hỗ trợ thêm sửa xoá
    public DanhMuc getForm() {
        DanhMuc dm = new DanhMuc();
        dm.setMaDM(txtMaDanhMuc.getText());
        dm.setTenDM(txtTenDanhMuc.getText());

        return dm;
    }

    //xoá sạch bảng
    public void clear() {
        txtMaDanhMuc.setText("");
        txtTenDanhMuc.setText("");

    }
    //kiểm trả lỗi

    public boolean check() {

        if (txtMaDanhMuc.getText().trim().isEmpty()) {
            Notification noti = new Notification(frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Không được để trống mã danh mục");
            noti.showNotification();
            return false;
        }
        if (txtTenDanhMuc.getText().trim().isEmpty()) {
            Notification noti = new Notification(frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Không được để trống tên danh mục");
            noti.showNotification();
            return false;
        }
        return true;
    }
    //tạo nút thêm

    public void Them() {
        DanhMuc dm = getForm();

        if (dm != null) {
            try {
                daoDM.insert(dm);
                loadDataDM();
                clear();
                Notification noti = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Thêm danh mục thành công");
                noti.showNotification();
            } catch (Exception e) {
                Notification noti = new Notification(frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Thêm danh mục không thành công");
                noti.showNotification();
            }
        }

    }
    //tạo nút cập nhật

    public void capNhat() {
        DanhMuc tk = getForm();
        try {
            daoDM.update(tk);
            loadDataDM();
            clear();
            Notification noti = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Cập nhật danh mục  thành công");
            noti.showNotification();
        } catch (Exception e) {
            Notification noti = new Notification(frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Cập nhật danh mục không thành công");
            noti.showNotification();
        }
    }

    //tạo nút xoá
    public void xoa() {
        mdl.showMessage("XÓA DANH MỤC", "Bạn có chắc chắn xóa danh mụckhông");

        if (mdl.getMessageType() == MessageDialog.MessageType.OK) {
            String maKH = txtMaDanhMuc.getText();
            try {
                daoDM.delete(maKH);
                loadDataDM();
                Notification noti = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Xóa danh mục thành công");
                noti.showNotification();
            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(this, "Loi xoa ");
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new com.duan1.swing.TextFieldAnimation();
        Tabpane = new com.duan1.swing.MaterialTabbed();
        pnlCapNhat = new javax.swing.JPanel();
        txtMaDanhMuc = new com.duan1.swing.MyTextField();
        txtTenDanhMuc = new com.duan1.swing.MyTextField();
        btnMoi = new com.duan1.swing.Button();
        btnXoa = new com.duan1.swing.Button();
        btnSua = new com.duan1.swing.Button();
        btnThem = new com.duan1.swing.Button();
        btnDau = new com.duan1.swing.Button();
        btnLui = new com.duan1.swing.Button();
        btnToi = new com.duan1.swing.Button();
        btnCuoi = new com.duan1.swing.Button();
        pnlDanhSach = new javax.swing.JPanel();
        ScrollTK = new javax.swing.JScrollPane();
        tblDanhMuc = new com.duan1.swing.Table();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("DANH MỤC");

        txtTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTimKiemMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtTimKiemMouseReleased(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        pnlCapNhat.setBackground(new java.awt.Color(255, 255, 255));

        txtMaDanhMuc.setEditable(false);

        btnMoi.setText("Mới");
        btnMoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnDau.setText("<");
        btnDau.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDauActionPerformed(evt);
            }
        });

        btnLui.setText("|<");
        btnLui.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuiActionPerformed(evt);
            }
        });

        btnToi.setText(">|");
        btnToi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnToi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToiActionPerformed(evt);
            }
        });

        btnCuoi.setText(">");
        btnCuoi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCapNhatLayout = new javax.swing.GroupLayout(pnlCapNhat);
        pnlCapNhat.setLayout(pnlCapNhatLayout);
        pnlCapNhatLayout.setHorizontalGroup(
            pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCapNhatLayout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDau, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLui, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnToi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCapNhatLayout.createSequentialGroup()
                        .addComponent(txtMaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(txtTenDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
        );
        pnlCapNhatLayout.setVerticalGroup(
            pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLui, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnToi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(216, Short.MAX_VALUE))
        );

        Tabpane.addTab("Cập nhật", pnlCapNhat);

        ScrollTK.setBorder(null);

        tblDanhMuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã danh muc", "Tên danh mục"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhMucMouseClicked(evt);
            }
        });
        ScrollTK.setViewportView(tblDanhMuc);

        javax.swing.GroupLayout pnlDanhSachLayout = new javax.swing.GroupLayout(pnlDanhSach);
        pnlDanhSach.setLayout(pnlDanhSachLayout);
        pnlDanhSachLayout.setHorizontalGroup(
            pnlDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollTK, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
        );
        pnlDanhSachLayout.setVerticalGroup(
            pnlDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollTK, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );

        Tabpane.addTab("Danh sách", pnlDanhSach);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addContainerGap(816, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(11, 11, 11))
                .addComponent(Tabpane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(565, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(Tabpane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(30, 30, 30)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        String timKiem = txtTimKiem.getText();
        findIdAndName(timKiem);
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDauActionPerformed
        firs();
    }//GEN-LAST:event_btnDauActionPerformed

    private void btnLuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuiActionPerformed
        prev();
    }//GEN-LAST:event_btnLuiActionPerformed

    private void btnToiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToiActionPerformed
        next();
    }//GEN-LAST:event_btnToiActionPerformed

    private void btnCuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiActionPerformed
        last();
    }//GEN-LAST:event_btnCuoiActionPerformed

    private void txtTimKiemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMousePressed
        String timKiem = txtTimKiem.getText();
        findIdAndName(timKiem);
    }//GEN-LAST:event_txtTimKiemMousePressed

    private void txtTimKiemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseReleased
        String timKiem = txtTimKiem.getText();
        findIdAndName(timKiem);
    }//GEN-LAST:event_txtTimKiemMouseReleased

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (check()) {
            Them();

        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (check()) {
            capNhat();
            loadDataDM();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        xoa();
        clear();
        loadDataDM();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblDanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhMucMouseClicked
        if (evt.getClickCount() == 2) {
            int sec = tblDanhMuc.getSelectedRow();

            display(sec);
            Tabpane.setSelectedIndex(0);

        }
    }//GEN-LAST:event_tblDanhMucMouseClicked

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        clear();
    }//GEN-LAST:event_btnMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollTK;
    private com.duan1.swing.MaterialTabbed Tabpane;
    private com.duan1.swing.Button btnCuoi;
    private com.duan1.swing.Button btnDau;
    private com.duan1.swing.Button btnLui;
    private com.duan1.swing.Button btnMoi;
    private com.duan1.swing.Button btnSua;
    private com.duan1.swing.Button btnThem;
    private com.duan1.swing.Button btnToi;
    private com.duan1.swing.Button btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlCapNhat;
    private javax.swing.JPanel pnlDanhSach;
    private com.duan1.swing.Table tblDanhMuc;
    private com.duan1.swing.MyTextField txtMaDanhMuc;
    private com.duan1.swing.MyTextField txtTenDanhMuc;
    private com.duan1.swing.TextFieldAnimation txtTimKiem;
    // End of variables declaration//GEN-END:variables

}
