package com.example.demo.repository;


import com.example.demo.model.MauSac;
import com.example.demo.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ISanPhamRepository extends JpaRepository<SanPham, String> {

    @Override
    List<SanPham> findAll();

    SanPham findSanPhamById(String id);
}
