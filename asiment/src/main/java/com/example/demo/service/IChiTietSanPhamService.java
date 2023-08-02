package com.example.demo.service;

import com.example.demo.model.ChiTietSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IChiTietSanPhamService {
    ChiTietSanPham add(ChiTietSanPham chiTietSanPham);

    void delete(String id);

    ChiTietSanPham findChiTietSanPhamById(String id);

    Page<ChiTietSanPham> findAll(Pageable pageable);

    Page<ChiTietSanPham> searchByTen(String ten, Pageable pageable);

    Page<ChiTietSanPham> searchByTenAndGiaRange(String ten, BigDecimal min, BigDecimal max, Pageable pageable);
}
