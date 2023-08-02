package com.example.demo.service;

import com.example.demo.model.DongSanPham;
import com.example.demo.model.KhachHang;

import java.util.List;

public interface IKhachHangService {
    void add(KhachHang khachHang);

    void update(KhachHang khachHang);

    void delete(String id);

    List<KhachHang> fillAll();

//    KhachHang findKhachHangById(String id);
}
