/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.Helper;

import com.duan1.Entity.NhanVien;

/**
 *
 * @author asus
 */
public class Auth {
    //Đối tượng chứa thông tin người sử dụng sau khi đăng nhập
    public static NhanVien nv = null;
    //Xóa người đăng nhập sau khi đăng xuất
    public static void clear(){
        Auth.nv =null;
    }
    //Kiểm tra xem Nhân viên có đăng nhập hay không
    public static boolean isLogin(){
        return Auth.nv != null;
    }
    //Kiểm tra vai trò của nhân viên đó
    public static String role(){
        return nv.isChucVu()? "Quản lý" : "Nhân viên";
    } 
}
