package com.example.demo.service;

import com.example.demo.model.DongSanPham;

import java.util.List;

public interface IDongService {
    void add(DongSanPham dongSanPham);

    void update(DongSanPham dongSanPham);

    void delete(String id);

    List<DongSanPham> fillAll();

    DongSanPham findDongSanPhamById(String id);


}
