/*CREATE DATABASE QL_PHU_KIEN_QUA_TANG;
GO*/
USE QL_PHU_KIEN_QUA_TANG;
GO
--I. TẠO BẢNG
--1. Tạo bảng NhanVien
CREATE TABLE NhanVien
(
    MaNV VARCHAR(10) NOT NULL,
    TenNV NVARCHAR(50) NOT NULL,
    GioiTinh BIT NOT NULL,
    CCCD VARCHAR(50) NOT NULL,
    SDT VARCHAR(15) NOT NULL,
    Gmail VARCHAR(50) NOT NULL,
    ChucVu BIT NOT NULL,
    GhiChu NVARCHAR(200),
    HinhAnh NVARCHAR(200),
);
GO
--2. Tạo bảng TaiKhoan
CREATE TABLE TaiKhoan
(
    MaTK VARCHAR(10) NOT NULL,
    TenTK NVARCHAR(50) NOT NULL,
    MatKhau VARCHAR(50) NOT NULL,
	MaNV VARCHAR(10) NOT NULL,
);
GO
--3. Tạo bảng DanhMuc
CREATE TABLE DanhMuc
(
    MaDM VARCHAR(10) NOT NULL,
    TenDM NVARCHAR(50) NOT NULL
);
GO

--4. Tạo bảng SanPhamBan
CREATE TABLE SanPhamBan
(
    MaSP VARCHAR(10) NOT NULL,
    TenSP NVARCHAR(50) NOT NULL,
    SoLuong INT NOT NULL,
    DonViTinh NVARCHAR(20) NOT NULL,
    DonGia FLOAT NOT NULL,
    TrangThai BIT NOT NULL,
    MaVach VARCHAR(50),
    HinhAnh NVARCHAR(200),
    MaNV VARCHAR(10) NOT NULL,
);

ALTER TABLE SanPhamBan ADD MaDM VARCHAR(10) NOT NULL; --Thêm danh mục vào sản phẩm
GO

--5. Tạo bảng KhachHang
CREATE TABLE KhachHang
(
    MaKH varchar(10) not null,
    TenKH NVARCHAR(50) NOT NULL,
    SDT VARCHAR(15) NOT NULL,
    DiemTichLuy INT,
);
GO

--6. Tạo bảng HoaDonChiTiet
CREATE TABLE HoaDonChiTiet
(
    SoLuong INT NOT NULL,
    ThanhTien FLOAT NOT NULL,
    MaSP VARCHAR(10) NOT NULL,
    MaHD VARCHAR(15) NOT NULL
);
GO

--7. Tạo bảng HoaDon
CREATE TABLE HoaDon
(
    MaHD VARCHAR(15) NOT NULL,
    NgayTao DATE NOT NULL,
	TienShip FLOAT NOT NULL,
    GhiChu NVARCHAR(200),
    MaNV VARCHAR(10) NOT NULL,
    MaKH varchar(10) NOT NULL,
);
GO

--8. Tạo bảng NguoiGiaoHang
CREATE TABLE NguoiGiaoHang
(
    MaNGH VARCHAR(10) NOT NULL,
    TenNGH NVARCHAR(50) NOT NULL,
    CCCD VARCHAR(50) NOT NULL,
    SDT VARCHAR(10) NOT NULL,
    Gmail VARCHAR(50) NOT NULL,
);
GO

--9. Tạo bảng QuaTang
CREATE TABLE QuaTang
(
    MaDH VARCHAR(15) NOT NULL,
    TenNN NVARCHAR(50) NOT NULL,
    DiaChiNN NVARCHAR(200) NOT NULL,
	SDTNN varchar(12) not null,
    NgayGiao DATE NOT NULL,
    TrangThai NVARCHAR(50) NOT NULL,
    GhiChu NVARCHAR(200),
    MaNGH VARCHAR(10) NOT NULL,
    MaHD VARCHAR(15)NOT NULL
);
--10. Tạo bảng phiếu nhập kho
create table PhieuNhapKho(
	MaPNK varchar(15) not null,
	NgayNhap date not null,
)
GO
--11. Tạo bảng PhieuNhapChiTiet
CREATE TABLE PhieuNhapChiTiet(
	MaPNK VARCHAR(15) NOT NULL,
	MaSP VARCHAR(10) NOT NULL,
	SoLuong INT NOT NULL,
	thanhTien FLOAT NOT NULL,
)

GO

--II. TẠO KHÓA CHÍNH

--1. Tạo khóa chỉnh cho bảng TaiKhoan
ALTER TABLE dbo.TaiKhoan ADD CONSTRAINT PK_TaiKhoan PRIMARY KEY (MaTK); --Constraint là những quy tắc được áp dụng trên các cột dữ liệu, trên bảng. Được sử dụng để kiểm tra tính hợp lệ của dữ liệu vào, đảm bảo tính chính xác, tính toàn vẹn của dữ liệu.
GO

--2. Tạo khóa  chính cho bảng NhanVien
ALTER TABLE dbo.NhanVien ADD CONSTRAINT PK_NhanVien PRIMARY KEY (MaNV);
GO

--3. Tạo khóa chính cho bảng DanhMuc
ALTER TABLE dbo.DanhMuc ADD CONSTRAINT PK_DanhMuc PRIMARY KEY (MaDM);
GO

--4. Tạo khóa chính cho bảng SanPhamBan
ALTER TABLE dbo.SanPhamBan
ADD CONSTRAINT PK_SanPhamBan
    PRIMARY KEY (MaSP);
GO

--5. Tạo khóa chính cho bảng KhachHang
ALTER TABLE dbo.KhachHang ADD CONSTRAINT PK_KhachHang PRIMARY KEY (MaKH);
GO

--6. Tạo khóa chính cho bảng HoaDon 
ALTER TABLE dbo.HoaDon ADD CONSTRAINT PK_HoaDon PRIMARY KEY (MaHD);
GO


--7. Tạo Khóa chính cho bảng NguoiGiaoHang
ALTER TABLE dbo.NguoiGiaoHang
ADD CONSTRAINT PK_NguoiGiaoHang
    PRIMARY KEY (MaNGH);
GO

--8. Tạo khóa chính cho bảng QuaTang
ALTER TABLE dbo.QuaTang ADD CONSTRAINT PK_QuaTang PRIMARY KEY (MaDH);
GO

--9. Tạo khóa chính cho bảnh phiếu nhập kho
ALTER TABLE dbo.PhieuNhapKho ADD CONSTRAINT PK_PNK PRIMARY KEY(MaPNK)

GO

--III. RÀNG BUỘC DUY NHẤT
--1. Tạo ràng buộc duy nhất cho bảng TaiKhoan
ALTER TABLE dbo.TaiKhoan ADD CONSTRAINT UQ_TaiKhoan UNIQUE (TenTK);
GO

--2. Tạo ràng buộc duy nhất cho bảng NhanVien
ALTER TABLE dbo.NhanVien ADD CONSTRAINT UQ_NhanVien_CCCD UNIQUE (CCCD);
ALTER TABLE dbo.NhanVien ADD CONSTRAINT UQ_NhanVien_SDT UNIQUE (SDT);
ALTER TABLE dbo.NhanVien ADD CONSTRAINT UQ_NhanVien_Gmail UNIQUE (Gmail);
GO

--3. Tạo ràng buộc duy nhất cho bảng DanhMuc
ALTER TABLE dbo.DanhMuc ADD CONSTRAINT UQ_DM UNIQUE (TenDM);
GO

--4. Tạo ràng buộc duy nhất cho bảng SanPhamBan
ALTER TABLE dbo.SanPhamBan ADD CONSTRAINT UQ_SPB UNIQUE (MaVach);
GO

--5. Tạo ràng buộc duy nhất cho bảng KhachHang
ALTER TABLE dbo.KhachHang ADD CONSTRAINT UQ_KhachHang UNIQUE (SDT);
GO

--6. Tạo ràng buộc duy nhất cho bảng NGH
ALTER TABLE dbo.NguoiGiaoHang ADD CONSTRAINT UQ_NGH_CCCD UNIQUE (CCCD);
ALTER TABLE dbo.NguoiGiaoHang ADD CONSTRAINT UQ_NGH_SDT UNIQUE (SDT);
ALTER TABLE dbo.NguoiGiaoHang ADD CONSTRAINT UQ_NGH_Gmail UNIQUE (Gmail);
GO
--7. Tạo ràng buộc duy nhất cho bảng QuaTang
ALTER TABLE dbo.QuaTang ADD CONSTRAINT UQ_QuaTang_SDT UNIQUE (SDTNN)
--IV. TẠO KHÓA NGOẠI

--1. Tạo khóa ngoại cho bảng SanPhamBan
ALTER TABLE dbo.SanPhamBan
ADD CONSTRAINT FK_SanPhamBan
    FOREIGN KEY (MaNV)
    REFERENCES dbo.NhanVien (MaNV);
GO

--2. Tạo khóa ngoại cho bảng HoaDon
ALTER TABLE dbo.HoaDon
ADD CONSTRAINT FK_HoaDon_KhachHang
    FOREIGN KEY (MaKH)
    REFERENCES dbo.KhachHang (MaKH);
Go
ALTER TABLE dbo.HoaDon
ADD CONSTRAINT FK_HoaDon_NhanVien
    FOREIGN KEY (MaNV)
    REFERENCES dbo.NhanVien (MaNV);
GO

--3. Tạo khóa ngoại cho bảng HoaDonChiTiet
ALTER TABLE dbo.HoaDonChiTiet
ADD CONSTRAINT FK_HoaDonChiTiet_SanPhamBan
    FOREIGN KEY (MaSP)
    REFERENCES dbo.SanPhamBan (MaSP);
Go
ALTER TABLE dbo.HoaDonChiTiet
ADD CONSTRAINT FK_HoaDonChiTiet_HoaDon
    FOREIGN KEY (MaHD)
    REFERENCES dbo.HoaDon (MaHD);
GO

--4. Tạo khóa ngoại cho bảng QuaTang

ALTER TABLE dbo.QuaTang
ADD CONSTRAINT FK_QLQT_NGH
    FOREIGN KEY (MaNGH)
    REFERENCES dbo.NguoiGiaoHang (MaNGH);

GO
--5. Tạo khóa ngoại cho bảng sản phẩm vs danh mục
ALTER TABLE dbo.SanPhamBan
ADD CONSTRAINT FK_SanPhamBan_DanhMuc
    FOREIGN KEY (MaDM)
    REFERENCES DanhMuc (MaDM);
GO
--6. Tạo khóa ngoại cho bảng PhieuNhapChiTiet vs Phiếu nhập kho 
ALTER TABLE dbo.PhieuNhapChiTiet
ADD CONSTRAINT FK_HoaDonpnk_PhieuNhapKho
    FOREIGN KEY (MaPNK)
    REFERENCES  dbo.PhieuNhapKho(MaPNK);
GO
--7. Tạo khóa ngoại cho bảng PhieuNhapChiTiet vs  sản phẩm ban
ALTER TABLE dbo.PhieuNhapChiTiet
ADD CONSTRAINT FK_HoaDonPNK_SanPhamBan
FOREIGN KEY(MaSP)
REFERENCES dbo.SanPhamBan(MaSP)
GO
--8. tạo liên kết khóa ngoại cho bảng Tài khoản vs nhân viên
ALTER TABLE dbo.TaiKhoan
ADD CONSTRAINT FK_TaiKhoan_NhanVien
FOREIGN KEY(MaNV)
REFERENCES dbo.NhanVien(MaNV)
GO
--9. Tạo liên kết khóa ngoại cho bảng qua Tang vs HoaDon
ALTER TABLE QuaTang
ADD CONSTRAINT FK_HoaDon_QuaTang
    FOREIGN KEY (MaHD)
    REFERENCES HoaDon (MaHD);
GO
/*
--IV. LIÊN KẾT 1-1
--1. TaiKhoan - NhanVien
ALTER TABLE dbo.NhanVien
ADD CONSTRAINT FK_NhanVien_TaiKhoang
    FOREIGN KEY (MaTK)
    REFERENCES dbo.TaiKhoan (MaTK);
GO

--2. HoaDon - QuaTang
ALTER TABLE QuaTang
ADD CONSTRAINT FK_HoaDon_QuaTang
    FOREIGN KEY (MaHD)
    REFERENCES HoaDon (MaHD);
GO

*/




--VI. THÊM DỮ LIỆU VÀO BẢNG
--1. Thêm dữ liệu vào bảng NhanVien
INSERT INTO dbo.NhanVien
(
    MaNV,
    TenNV,
    GioiTinh,
    CCCD,
    SDT,
    Gmail,
    ChucVu,
    GhiChu,
    HinhAnh
)
VALUES
('NV01', N'Nguyễn Minh Khôi', 0, '393718371631', '0983781631', 'khoi@gmail.com', '1', N'hay cải ae', ''),
('NV02', N'Nguyễn Nhựt Đông', 1, '393718371632', '0983781632', 'dong@gmail.com', '0', N'Chơi ire non', ''),
('NV03', N'Trần Tấn Khanh', 1, '393718371633', '2995929958', 'khanh@gmail.com', '0', N'Best ad', ''),
('NV04', N'Phùng Tự Hiếu', 1, '393718371634', '0983781633', 'hieu@gmail.com', '0', N'SP bỏ ad hay bị team chửi', ''),
('NV05', N'Nguyễn Văn Hữu Tài', 1, '393718371635', '0983781634', 'tai@gmail.com', '0', N'Hay troll game', '');

GO
--2. Thêm dữ liệu vào bảng TaiKhoan
INSERT INTO dbo.TaiKhoan
(
    MaTK,
    TenTK,
    MatKhau,
	MaNV
)
VALUES
('TK01', 'MinhKhoi', 'minhkhoi123','NV01'),
('TK02', 'NhutDong', 'nhutdong123','NV02'),
('TK03', 'TanKhanh', 'tankhanh123','NV03'),
('TK04', 'TuHieu', 'tuhieu123','NV04'),
('TK05', 'HuuTai', 'huutai123','NV05');

GO


--3. Thêm dữ liệu vào bảng DanhMuc
INSERT INTO dbo.DanhMuc
(
    MaDM,
    TenDM
)
VALUES
('DM01', N'Gấu bông'),
('DM02', N'Da dụng'),
('DM03', N'Móc khóa'),
('DM04', N'Đồ dùng học tập'),
('DM05', N'Thời trang');

GO
--4. Thêm dữ liệu vào bảng SanPhamBan
--DELETE dbo.SanPhamBan;
INSERT INTO dbo.SanPhamBan
(
    MaSP,
    TenSP,
    SoLuong,
    DonGia,
    DonViTinh,
    TrangThai,
    MaVach,
    HinhAnh,
    MaNV,
    MaDM
)
VALUES
('GB01', N'Cá sấu', '20', 70000, N'Con', 1, '0', '', 'NV01', 'DM01'),
('GB02', N'Chim', '10', 50000, N'Con', 1, '1', '', 'NV01', 'DM01'),
('GB03', N'Bò tót', '22', 90000, N'Con', 1, '2', '', 'NV01', 'DM01'),
('GB04', N'Mèo', '24', 60000, N'Con', 1, '3', '', 'NV01', 'DM01'),
('GB05', N'Chó', '23', 80000, N'Con', 1, '4', '', 'NV01', 'DM01'),
('GD01', N'Chén', '26', 20000, N'Bộ', 1, '5', '', 'NV02', 'DM02'),
('GD02', N'Đũa', '10', 20000, N'Bộ', 1, '6', '', 'NV02', 'DM02'),
('GD03', N'Giá', '10', 30000, N'Bộ', 1, '7', '', 'NV02', 'DM02'),
('GD04', N'Bàn chải', '20', 10000, N'cái', 1, '8', '', 'NV02', 'DM02'),
('GD05', N'Xà phòng', '15', 110000, N'Chai', 1, '9', '', 'NV02', 'DM02'),
('MK01', N'Songoku', '10', 30000, N'Cái', 1, '10', '', 'NV03', 'DM03'),
('MK02', N'Doraemon', '10', 30000, N'Cái', 1, '11', '', 'NV03', 'DM03'),
('MK03', N'Dép lào', '10', 15000, N'Cái', 1, '12', '', 'NV03', 'DM03'),
('MK04', N'Đầu lâu', '10', 22000, N'Cái', 1, '13', '', 'NV03', 'DM03'),
('MK05', N'Thanh kiếm', '10', 200000, N'Cái', 1, '14', '', 'NV03', 'DM03'),
('HT01', N'Búp bi', '40', 5000, N'Cây', 1, '15', '', 'NV04', 'DM04'),
('HT02', N'Thước', '40', 5000, N'Cây', 1, '16', '', 'NV04', 'DM04'),
('HT03', N'Gôm', '20', 2000, N'Cái', 1, '17', '', 'NV04', 'DM04'),
('HT04', N'Bút chì', '40', 4000, N'Cây', 1, '18', '', 'NV04', 'DM04'),
('HT05', N'cặp', '22', 200000, N'Cái', 1, '19', '', 'NV04', 'DM04'),
('TT01', N'Giầy thép gai', '10', 200000, N'Cái', 1, '20', '', 'NV05', 'DM05'),
('TT02', N'Dép', '10', 200000, N'Cái', 1, '21', '', 'NV05', 'DM05'),
('TT03', N'Bông tay con bướm', '10', 200000, N'Cái', 1, '22', '', 'NV05', 'DM05'),
('TT04', N'Bông tay bông hoa', '10', 200000, N'Cái', 1, '23', '', 'NV05', 'DM05'),
('TT05', N'Dây chuyền chuộc tội', '10', 200000, N'Cái', 1, '24', '', 'NV05', 'DM05');

GO
--5. Thêm dữ liệu vào bảng KhachHang
INSERT INTO dbo.KhachHang
(
	MaKH,
    TenKH,
    SDT,
    DiemTichLuy
)
VALUES
('KH00001',N'Lê Quang Duy', '0984781746', '0'),
('KH00002',N'Võ Huỳnh Quang Huy', '0984781345', '3'),
('KH00003',N'Phan Tấn Trung', '0984781747', '2'),
('KH00004',N'Chướng Viễn Long', '0984781748', '1'),
('KH00005',N'Nguyễn Vũ Long', '0984781712', '0'),
('KH00006',N'Trương Vĩnh Thanh', '0984781321', '0'),
('KH00007',N'Trần Thanh Lâm', '0984781741', '3'),
('KH00008',N'Đinh Trọng Quyết', '0984781984', '1'),
('KH00009',N'Nguyễn Duy Khánh', '0984711746', '2'),
('KH00010',N'Vĩ Phạm', '0984781743', '0');
GO
--6. Thêm dữ liệu vào bảng HoaDon
INSERT INTO dbo.HoaDon
(
    MaHD,
    NgayTao,
	TienShip,
    GhiChu,
    MaNV,
    MaKH
)
VALUES
('HD2010220001', '10/20/2022',10000, '', 'NV02','KH00001'),
('HD1010220002', '10/10/2022',10000, '', 'NV02','KH00002'),
('HD0310220003', '10/3/2022', 10000,'', 'NV01', 'KH00010'),
('HD0210220004', '10/2/2022',10000, '', 'NV01', 'KH00004'),
('HD0410220005', '10/4/2022',20000, '', 'NV03', 'KH00006'),
('HD2010220006', '10/20/2022',15000,'', 'NV03', 'KH00007'),
('HD2210220007', '10/22/2022',12000, '', 'NV04', 'KH00009'),
('HD2010220008', '10/20/2022', 22000,'', 'NV04', 'KH00010'),
('HD0110220009', '10/1/2022', 10000,'', 'NV05','KH00002'),
('HD2010220010', '10/20/2022', 15000,'', 'NV05','KH00001');
GO
--7. Thêm dữ liệu vào bảng HoaDonChiTiet
INSERT INTO dbo.HoaDonChiTiet
(
    SoLuong,
    ThanhTien,
    MaSP,
    MaHD
)
VALUES
(N'3', '210000', 'GB01', 'HD2010220001'),
(N'3', '150000', 'GB02', 'HD2010220001'),
(N'3', '270000', 'GB03', 'HD1010220002'),
(N'2', '120000', 'GB04', 'HD1010220002'),
(N'2', '160000', 'GB05', 'HD0310220003');
GO

--8. Thêm dữ liệu vào bảng NguoiGiaoHang

INSERT INTO dbo.NguoiGiaoHang
(
    MaNGH,
    TenNGH,
    CCCD,
    SDT,
    Gmail
)
VALUES
('NGH001', N'Đoàn Phúc Hậu', '298471849184', '0918471846', 'hau@gmail.com'),
('NGH002', N'Đoàn Phúc Nghĩa', '298471849384', '0918471146', 'nghia@gmail.com');
GO
--9. Thêm dữ liệu vào bảng QuaTang
INSERT INTO dbo.QuaTang
(
    MaDH,
    TenNN,
    DiaChiNN,
	SDTNN,
    NgayGiao,
    TrangThai,
    GhiChu,
    MaNGH,
    MaHD
)
VALUES
('DH001', N'Nguyễn Đức Trí', N'An Khánh Ninh Kiều','0984716471', '10/22/2022', N'Đã giao xong', N'Dễ vỡ', 'NGH001', 'HD2010220001'),
('DH002', N'Nguyễn Hữu bằng', N'Cầu Bà Bộ','0984716472', '10/22/2022', N'Chưa giao', N'Dễ vỡ', N'NGH002', 'HD1010220002'),
('DH003', N'Trần Văn Được', N'An Khánh Ninh Kiều','0984716473', '10/20/2022', N'Đang giao hàng', N'Dễ vỡ', 'NGH001', 'HD0310220003'),
('DH004', N'Võ Minh Phong', N'Thời Bình - Cà Mau','0984716474', '10/20/2022', N'Đã giao xong', N'Dễ vỡ', 'NGH001', 'HD0210220004'),
('DH005', N'Nguyễn Minh Lộc', N'Bạc Liêu','0984716475', '10/20/2022', N'Đang giao hàng', N'Dễ vỡ', 'NGH001', 'HD0410220005'),
('DH006', N'Bùi Quốc Huy', N'TP-HCM','0984716476','10/20/2022', N'Đang giao hàng', N'Dễ vỡ', 'NGH001', 'HD2010220006');
GO
--10. Thêm dữ liệu vào bảng PhieuNhapKho

INSERT INTO dbo.PhieuNhapKho(
	MaPNK,
	NgayNhap
)
Values
('MP00001','10/16/2022'),
('MP00002','10/12/2022'),
('MP00003','10/2/2022'),
('MP00004','10/14/2022'),
('MP00005','10/28/2022'),
('MP00006','10/15/2022')
GO
--11. Thêm dữ liệu vào bảng PhieuNhapChiTiet
INSERT INTO dbo.PhieuNhapChiTiet
(
    MaPNK,
    MaSP,
	soLuong,
    thanhTien
)
VALUES
('MP00001','GB01',4,280000),
('MP00002','GB02',4,200000),
('MP00003','GB03',3,270000),
('MP00004','GB04',5,300000),
('MP00005','GB05',2,160000)
GO

SELECT * FROM dbo.NhanVien
SELECT * FROM dbo.KhachHang
SELECT * FROM dbo.DanhMuc
SELECT * FROM dbo.SanPhamBan
SELECT * FROM dbo.QuaTang
SELECT * FROM dbo.HoaDon
SELECT * FROM dbo.HoaDonChiTiet
SELECT * FROM dbo.PhieuNhapKho
SELECT * FROM dbo.PhieuNhapChiTiet
