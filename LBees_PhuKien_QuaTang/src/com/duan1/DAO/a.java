/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duan1.DAO;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author phung
 */
public class a {

    public static void main(String[] args) {
//        String id = "0001";
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
//        int idNumber = Integer.parseInt(id);
//        String newID = String.format(sdf.format(date)+"%04d", idNumber+=1);
//        String id = "KH0001";
//        int idNumber = Integer.parseInt(id.replaceAll("\\D", ""));
//        String newID = String.format("%05d", idNumber += 1);
//        System.out.println(newID);
        KhachHangDAO khDao = new KhachHangDAO();
        HoaDonDAO hddao = new HoaDonDAO();
        try {
            String id = khDao.initID();
        System.out.println(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
