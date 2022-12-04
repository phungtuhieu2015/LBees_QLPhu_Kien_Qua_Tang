package com.duan1.components;

import com.duan1.DAO.HoaDonDAO;
import com.duan1.DAO.KhachHangDAO;
import com.duan1.DAO.NguoiGiaoHangDAO;
import com.duan1.DAO.QuaTangDAO;
import com.duan1.Entity.HoaDon;
import com.duan1.Entity.HoaDonChiTiet;
import com.duan1.Entity.KhachHang;
import com.duan1.Entity.NguoiGiaoHang;
import com.duan1.Entity.QuaTang;
import com.duan1.Entity.SanPham;
import com.duan1.Entity.TaiKhoan;
import com.duan1.Helper.Msgbox;
import com.duan1.Helper.XDate;
import com.duan1.swing.Dates;
import com.duan1.swing.EventCallBack;
import com.duan1.swing.EventTextField;
import com.duan1.swing.MessageDialog;
import com.duan1.swing.Notification;
import com.duan1.swing.ScrollBarCustom;
import com.duan1.ui.MainJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

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

    public int index;
    DefaultTableModel model;

    String mauNgay = "dd-MM-yyyy";
    private int MONTH = 1;
    private int YEAR = 2021;
    private int DAY = 1;
    Date date = new Date();

    public Form_QuaTang() {
        initComponents();
        setHint();
        TimKiem();
        init();
        ThanhTruotQT();

    }

    public void init() {
        Scroll_GioHang.setVerticalScrollBar(new ScrollBarCustom());
        Scroll_SPBan.setVerticalScrollBar(new ScrollBarCustom());
        loadData();
        fillComboboxTrangThai();
        fillComboboxNGH();
        fillComboboxTrangThaiGiaoHang();
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

    }

    public void TimKiem() {
        txtTimKiem.setHintText("Nhập ");
        txtTimKiemGH.setHintText("Nhập tên đơn hàng");
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

    public void clear() {
        txtDiaChiNN.setText("");
        txtGhiChu.setText("");
        txtMaDH.setText("");
        txtMaHD.setText("");
        txtNgayGiao.setText("");
        txtSDTKH.setText("");
        txtSDTNN.setText("");
        txtTenKH.setText("");
        txtTenNN.setText("");
        cboNGH.setSelectedIndex(0);
        cboTrangThai.setSelectedIndex(1);

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
        cboNGH.setSelectedItem(ngh.getTenNGH() + " - " + ngh.getMaNGH());
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
        String trangThai_GH[] = {"Đã giao xong", "Chưa giao", "Đang giao hàng", "Đã huỷ"};
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboTrangThai.getModel();
        model.removeAllElements();

        for (String string : trangThai_GH) {
            model.addElement(string);
        }
    }

    public void fillComboboxTrangThaiGiaoHang() {
       String trangThai_GH[] = {"Lọc trạng thái","Đã giao xong", "Chưa giao", "Đang giao hàng", "Đã huỷ"};
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboLocTheoTrangThai.getModel();
        model.removeAllElements();

        for (String string : trangThai_GH) {
            model.addElement(string);
        }
    
    }
    
    public void Load_Cbb_TrangTh(String IdAndName) {
        model = (DefaultTableModel) tblQuaTang.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        tblQuaTang.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + IdAndName,   7));
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

    //tạo nút thêm
    public void insert() {
        QuaTang tk = getForm();

        if (tk != null) {
            try {
                daoQT.insert(tk);
                loadData();
                clear();
                Notification noti = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Thêm quà tặng thành công");
                noti.showNotification();
            } catch (Exception e) {
                Notification noti = new Notification(frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Thêm quà tặng không thành công");
                noti.showNotification();
            }
        }

    }

    public void delete() {
        if (Msgbox.yesNo("BẠN CÓ CHẮC CHẮN", "muốn xoá đi đơn hàng không")) {

            String maDH = txtMaDH.getText();
            daoQT.delete(maDH);
            loadData();
            clear();
            Msgbox.success(frame, "Xóa đơn hàng thành công");

        } else {
            // Msgbox.waring(frame, "Xóa đơn hàng không thành công");
            return;
        }
    }

    public void update() {
        QuaTang modelQT = getForm();
        try {
            daoQT.update(modelQT);
            loadData();
            clear();

        } catch (RuntimeException e) {

        }
    }

    //cập nhật tình trạng của 4 nút
    public void updateStatus() {
        if (index == 0) {
            btnFirst.setEnabled(false);
            btnPrev.setEnabled(false);
        } else {
            btnFirst.setEnabled(true);
            btnPrev.setEnabled(true);
        }
        if (index == listQT.size() - 1) {
            btnNext.setEnabled(false);
            btnLast.setEnabled(false);
        } else {
            btnNext.setEnabled(true);
            btnLast.setEnabled(true);
        }
    }

    //lấy giá trị
    public void edit() {
        tblQuaTang.setRowSelectionInterval(index, index);
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
        index = listQT.size() - 1;
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
        if (index == listQT.size() - 1) {
            firs();
        } else {
            index++;
        }
        edit();

    }

    public void findIdAndName(String IdAndName) {
        model = (DefaultTableModel) tblQuaTang.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        tblQuaTang.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + IdAndName, 0, 3, 4, 5, 6, 7, 8));
    }
    //kiểm trả lỗi

    public boolean check() {
        if (txtTenKH.getText().trim().isEmpty()) {
            Notification noti = new Notification(frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Không được để trống tên khách hàng");
            noti.showNotification();
            return false;
        }

        if (txtSDTKH.getText().trim().isEmpty()) {
            Notification noti = new Notification(frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Không được để trống số điện thoại khách hàng");
            noti.showNotification();
            return false;
        }
        if (txtTenNN.getText().trim().isEmpty()) {
            Notification noti = new Notification(frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Không được để trống tên người nhận");
            noti.showNotification();
            return false;
        }
        if (txtSDTNN.getText().trim().isEmpty()) {
            Notification noti = new Notification(frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Không được để số điện thoại người nhận");
            noti.showNotification();
            return false;
        }
        if (txtDiaChiNN.getText().trim().isEmpty()) {
            Notification noti = new Notification(frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Không được để trống địa chỉ người nhận");
            noti.showNotification();
            return false;
        }
        if (txtMaDH.getText().trim().isEmpty()) {
            Notification noti = new Notification(frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Không được để trống mã đơn hàng");
            noti.showNotification();
            return false;
        }
        if (txtNgayGiao.getText().trim().isEmpty()) {
            Notification noti = new Notification(frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Không được để trống ngày giao");
            noti.showNotification();
            return false;
        }
       
        if (txtMaHD.getText().trim().isEmpty()) {
            Notification noti = new Notification(frame, Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Không được để trống mã hoá đơn");
            noti.showNotification();
            return false;
        }

        return true;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelQuaTang = new com.duan1.swing.MaterialTabbed();
        pnlBanHang = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Tabpane1 = new com.duan1.swing.MaterialTabbed();
        pnlDanhSach1 = new javax.swing.JPanel();
        Scroll_GioHang = new javax.swing.JScrollPane();
        tblGioHang = new com.duan1.swing.Table();
        Tabpane2 = new com.duan1.swing.MaterialTabbed();
        pnlDanhSach2 = new javax.swing.JPanel();
        Scroll_SPBan = new javax.swing.JScrollPane();
        tblSanPham = new com.duan1.swing.Table();
        jLabel2 = new javax.swing.JLabel();
        btnDatHang = new com.duan1.swing.Button();
        btnDatHang1 = new com.duan1.swing.Button();
        btnXoaKhoiGio = new com.duan1.swing.Button();
        txtTimKiemGH = new com.duan1.swing.TextFieldAnimation();
        pnlCapNhat = new javax.swing.JPanel();
        btn = new javax.swing.JPanel();
        pnlThemSuaXoa = new javax.swing.JPanel();
        btnThem = new com.duan1.swing.Button();
        btnSua = new com.duan1.swing.Button();
        btnXoa = new com.duan1.swing.Button();
        btnMoi = new com.duan1.swing.Button();
        pnlDieuHuong = new javax.swing.JPanel();
        btnFirst = new com.duan1.swing.Button();
        btnPrev = new com.duan1.swing.Button();
        btnNext = new com.duan1.swing.Button();
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
        cboLocTheoTrangThai = new com.duan1.swing.ComboBoxSuggestion();
        txtTimKiem = new com.duan1.swing.TextFieldAnimation();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(923, 604));
        setMinimumSize(new java.awt.Dimension(923, 604));
        setPreferredSize(new java.awt.Dimension(923, 604));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        pnlDanhSach1.setBackground(new java.awt.Color(255, 255, 255));

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Scroll_GioHang.setViewportView(tblGioHang);

        javax.swing.GroupLayout pnlDanhSach1Layout = new javax.swing.GroupLayout(pnlDanhSach1);
        pnlDanhSach1.setLayout(pnlDanhSach1Layout);
        pnlDanhSach1Layout.setHorizontalGroup(
            pnlDanhSach1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDanhSach1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Scroll_GioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlDanhSach1Layout.setVerticalGroup(
            pnlDanhSach1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDanhSach1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Scroll_GioHang, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );

        Tabpane1.addTab("Giỏ Hàng", pnlDanhSach1);

        pnlDanhSach2.setBackground(new java.awt.Color(255, 255, 255));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Số Lượng", "Đơn Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        Scroll_SPBan.setViewportView(tblSanPham);

        javax.swing.GroupLayout pnlDanhSach2Layout = new javax.swing.GroupLayout(pnlDanhSach2);
        pnlDanhSach2.setLayout(pnlDanhSach2Layout);
        pnlDanhSach2Layout.setHorizontalGroup(
            pnlDanhSach2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Scroll_SPBan, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
        );
        pnlDanhSach2Layout.setVerticalGroup(
            pnlDanhSach2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDanhSach2Layout.createSequentialGroup()
                .addComponent(Scroll_SPBan, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Tabpane2.addTab("Sản Phẩm Bán", pnlDanhSach2);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Camera");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnDatHang.setText("Xóa tất cả");
        btnDatHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatHangActionPerformed(evt);
            }
        });

        btnDatHang1.setText("Đặt hàng");
        btnDatHang1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDatHang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatHang1ActionPerformed(evt);
            }
        });

        btnXoaKhoiGio.setText("Xóa khỏi giỏ");
        btnXoaKhoiGio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoaKhoiGio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKhoiGioActionPerformed(evt);
            }
        });

        txtTimKiemGH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTimKiemGHMousePressed(evt);
            }
        });
        txtTimKiemGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemGHActionPerformed(evt);
            }
        });
        txtTimKiemGH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemGHKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Tabpane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnXoaKhoiGio, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnDatHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Tabpane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addComponent(txtTimKiemGH, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Tabpane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnXoaKhoiGio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDatHang1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(txtTimKiemGH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(Tabpane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBanHangLayout = new javax.swing.GroupLayout(pnlBanHang);
        pnlBanHang.setLayout(pnlBanHangLayout);
        pnlBanHangLayout.setHorizontalGroup(
            pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 918, Short.MAX_VALUE)
            .addGroup(pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBanHangLayout.createSequentialGroup()
                    .addGap(0, 1, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 2, Short.MAX_VALUE)))
        );
        pnlBanHangLayout.setVerticalGroup(
            pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
            .addGroup(pnlBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBanHangLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panelQuaTang.addTab("Bán hàng", pnlBanHang);

        pnlCapNhat.setBackground(new java.awt.Color(255, 255, 255));

        btn.setBackground(new java.awt.Color(255, 255, 255));

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

        btnFirst.setText("<");
        btnFirst.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        pnlDieuHuong.add(btnFirst);

        btnPrev.setText("|<");
        btnPrev.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });
        pnlDieuHuong.add(btnPrev);

        btnNext.setText(">|");
        btnNext.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        pnlDieuHuong.add(btnNext);

        btnLast.setText(">");
        btnLast.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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

        javax.swing.GroupLayout btnLayout = new javax.swing.GroupLayout(btn);
        btn.setLayout(btnLayout);
        btnLayout.setHorizontalGroup(
            btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(btnLayout.createSequentialGroup()
                        .addComponent(pnlThemSuaXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174)
                        .addComponent(pnlDieuHuong, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ahihi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(btnLayout.createSequentialGroup()
                            .addGroup(btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                    .addComponent(txtTenKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(txtSDTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSDTNN, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTenNN, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(113, 113, 113)
                            .addGroup(btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMaDH, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                .addComponent(cboNGH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                .addComponent(txtMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDiaChiNN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNgayGiao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        btnLayout.setVerticalGroup(
            btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnLayout.createSequentialGroup()
                .addGroup(btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btnLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSDTKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(btnLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(txtDiaChiNN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgayGiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenNN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDTNN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNGH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ahihi, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlThemSuaXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDieuHuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 121, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCapNhatLayout = new javax.swing.GroupLayout(pnlCapNhat);
        pnlCapNhat.setLayout(pnlCapNhatLayout);
        pnlCapNhatLayout.setHorizontalGroup(
            pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlCapNhatLayout.setVerticalGroup(
            pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelQuaTang.addTab("Cập Nhật", pnlCapNhat);

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

        cboLocTheoTrangThai.setEditable(false);
        cboLocTheoTrangThai.setToolTipText("112");
        cboLocTheoTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocTheoTrangThaiActionPerformed(evt);
            }
        });

        txtTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTimKiemMousePressed(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlDanhSachLayout = new javax.swing.GroupLayout(pnlDanhSach);
        pnlDanhSach.setLayout(pnlDanhSachLayout);
        pnlDanhSachLayout.setHorizontalGroup(
            pnlDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollQT, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDanhSachLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cboLocTheoTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        pnlDanhSachLayout.setVerticalGroup(
            pnlDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDanhSachLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLocTheoTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollQT, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE))
        );

        panelQuaTang.addTab("Danh Sách", pnlDanhSach);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelQuaTang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelQuaTang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblQuaTangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuaTangMouseClicked

        if (evt.getClickCount() == 2) {

            int sec = tblQuaTang.getSelectedRow();
            display(sec);
            panelQuaTang.setSelectedIndex(1);
        }
    }//GEN-LAST:event_tblQuaTangMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        MainJFrame m = new MainJFrame();
        if (check()) {
        insert();
        new JDL_XacNhanThongTin_QuaTang(m, true).setVisible(true);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int vitri = tblQuaTang.getSelectedRow();
        if (vitri >= 0) {
            update();
        } else {
            Msgbox.waring(frame, "Bạn chưa chọn đơn hàng nào để cập nhật");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int vitri = tblQuaTang.getSelectedRow();
        if (vitri >= 0) {
            delete();
        } else {
            Msgbox.waring(frame, "Bạn chưa chọn đơn hàng nào để xoá");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        clear();
        loadData();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        prev();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        firs();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        String timKiem = txtTimKiem.getText();
        findIdAndName(timKiem);
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMousePressed
        String timKiem = txtTimKiem.getText();
        findIdAndName(timKiem);
    }//GEN-LAST:event_txtTimKiemMousePressed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked

    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnXoaKhoiGioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKhoiGioActionPerformed
//        index = tblGioHang.getSelectedRow();
//        delete(index);
    }//GEN-LAST:event_btnXoaKhoiGioActionPerformed

    private void btnDatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatHangActionPerformed
        // TODO add your handling code here:
//        deleteAll();
    }//GEN-LAST:event_btnDatHangActionPerformed

    private void btnDatHang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatHang1ActionPerformed
//        if (listHDCT.isEmpty()) {
//            Msgbox.waring(f, "Chưa có sản phẩm trong giỏ hàng!");
//            return;
//        }
//        JDL_NhapKhachHang bh = new JDL_NhapKhachHang(f, true);
//        bh.getList(listHDCT);
//        bh.setVisible(true);
    }//GEN-LAST:event_btnDatHang1ActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        String timKiem = txtTimKiem.getText();
        findIdAndName(timKiem);
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void cboLocTheoTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLocTheoTrangThaiActionPerformed
        String load = (String) cboLocTheoTrangThai.getSelectedItem();
        if (load == "Lọc trạng thái") {
            load = "";//quay lại ban đầu
        }
        Load_Cbb_TrangTh(load);
    }//GEN-LAST:event_cboLocTheoTrangThaiActionPerformed

    private void txtTimKiemGHMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemGHMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemGHMousePressed

    private void txtTimKiemGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemGHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemGHActionPerformed

    private void txtTimKiemGHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemGHKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemGHKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollQT;
    private javax.swing.JScrollPane Scroll_GioHang;
    private javax.swing.JScrollPane Scroll_SPBan;
    private com.duan1.swing.MaterialTabbed Tabpane1;
    private com.duan1.swing.MaterialTabbed Tabpane2;
    private com.duan1.swing.TextAreaScroll ahihi;
    private javax.swing.JPanel btn;
    private com.duan1.swing.Button btnDatHang;
    private com.duan1.swing.Button btnDatHang1;
    private com.duan1.swing.Button btnFirst;
    private com.duan1.swing.Button btnLast;
    private com.duan1.swing.Button btnMoi;
    private com.duan1.swing.Button btnNext;
    private com.duan1.swing.Button btnPrev;
    private com.duan1.swing.Button btnSua;
    private com.duan1.swing.Button btnThem;
    private com.duan1.swing.Button btnXoa;
    private com.duan1.swing.Button btnXoaKhoiGio;
    private com.duan1.swing.ComboBoxSuggestion cboLocTheoTrangThai;
    private com.duan1.swing.ComboBoxSuggestion cboNGH;
    private com.duan1.swing.ComboBoxSuggestion cboTrangThai;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private com.duan1.swing.MaterialTabbed panelQuaTang;
    private javax.swing.JPanel pnlBanHang;
    private javax.swing.JPanel pnlCapNhat;
    private javax.swing.JPanel pnlDanhSach;
    private javax.swing.JPanel pnlDanhSach1;
    private javax.swing.JPanel pnlDanhSach2;
    private javax.swing.JPanel pnlDieuHuong;
    private javax.swing.JPanel pnlThemSuaXoa;
    private com.duan1.swing.Table tblGioHang;
    private com.duan1.swing.Table tblQuaTang;
    private com.duan1.swing.Table tblSanPham;
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
    private com.duan1.swing.TextFieldAnimation txtTimKiemGH;
    // End of variables declaration//GEN-END:variables
}
