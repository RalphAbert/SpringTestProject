package com.example.demo.service.impl;

import com.example.demo.model.ChiTietSanPham;
import com.example.demo.repository.IChiTietSanPhamRepository;
import com.example.demo.service.IChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ChiTietSanPhamService implements IChiTietSanPhamService {

    @Autowired
    private IChiTietSanPhamRepository repository;

    @Override
    public ChiTietSanPham add(ChiTietSanPham chiTietSanPham) {
        repository.save(chiTietSanPham);
        return chiTietSanPham;
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public ChiTietSanPham findChiTietSanPhamById(String id) {
        return repository.findChiTietSanPhamById(id);
    }

    @Override
    public Page<ChiTietSanPham> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<ChiTietSanPham> searchByTen(String ten, Pageable pageable) {
        return repository.searchByTen(ten, pageable);
    }

    @Override
    public Page<ChiTietSanPham> searchByTenAndGiaRange(String ten, BigDecimal min, BigDecimal max, Pageable pageable) {
        return repository.searchByTenAndGiaRange(ten, min, max, pageable);
    }


}
