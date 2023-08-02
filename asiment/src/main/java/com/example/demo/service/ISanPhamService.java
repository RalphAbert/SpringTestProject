package com.example.demo.service;

import com.example.demo.model.SanPham;

import java.util.List;

public interface ISanPhamService {
    void add(SanPham sanPham);

    void update(SanPham sanPham);

    void delete(String id);

    List<SanPham> fillAll();

    SanPham findSanPhamById(String id);

}
