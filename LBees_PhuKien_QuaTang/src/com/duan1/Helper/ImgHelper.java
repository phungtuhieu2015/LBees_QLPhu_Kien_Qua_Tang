/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.duan1.Helper;

import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author DELL-PC
 */
public class ImgHelper {

//    public static final Image APP_ICON;
//
//    static {
//        String file = "LBees_PhuKien_QuaTang\\Picture\\tray.png";
////        APP_ICON = new ImageIcon(ImgHelper.class.getResource(file)).getImage();
//    }

    public static boolean saveLogo(File file) {
        File dir = new File("Picture");
        if (!dir.exists()) {   //Không tìm thấy tệp!  .check file có tồn tại không.
            dir.mkdirs();    //Phương thức mkdir() được sử dụng để tạo ra dường dẫn thư mục và tất cả các đường dẫn thư mục con của nó.
        }
        File newFile = new File(dir, file.getName()); //Cú pháp sau tạo một đối tượng File mới bởi việc biến đổi chuỗi pathname đã cho thành một pathname trừu tượng.

        try {
            Path source = Paths.get(file.getAbsolutePath());  //Lấy đường dẫn của file  cũ
            Path destination = Paths.get(newFile.getAbsolutePath()); //mới
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING); //Replace exitsting thực hiện duy chuyển ngay cả khi các tập tin đích tồn tại, nếu đích là một liên kết tượng trưng thì nó được thay thế những gì nó trỏ tới không bị ảnh hưởng
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * * Đọc hình ảnh logo chuyên đề * @param fileName là tên file logo
     *
     *
     * @return ảnh đọc được
     */
    public static ImageIcon readLogo(String fileName) {
        File path = new File("Picture", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }

    /**
     * * Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
     */
    //public static NhanVien USER = null;

    /**
     * * Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
     */
    public static void logoff() {
        // ImgHelper.USER = null;
    }

    /**
     * * Kiểm tra xem đăng nhập hay chưa * @return đăng nhập hay chưa
     */
    // public static boolean authenticated() {
    //return ImgHelper.USER != null;
    //}
}
