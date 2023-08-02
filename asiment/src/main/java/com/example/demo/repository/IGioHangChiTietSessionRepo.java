package com.example.demo.repository;

import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.GioHang;

public interface IGioHangChiTietSessionRepo {
    void addToCart(GioHang gioHang, ChiTietSanPham chiTietSanPham);

    void truSanPham(GioHang gioHang, ChiTietSanPham chiTietSanPham);

    void xoaSanPham(GioHang gioHang, ChiTietSanPham chiTietSanPham);
}
