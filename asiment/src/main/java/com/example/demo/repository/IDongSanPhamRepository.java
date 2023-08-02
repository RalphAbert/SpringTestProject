package com.example.demo.repository;


import com.example.demo.model.DongSanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDongSanPhamRepository extends JpaRepository<DongSanPham, String> {
    @Override
    List<DongSanPham> findAll();

    DongSanPham findDongSanPhamById(String id);
}
