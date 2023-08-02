package com.example.demo.repository;

import com.example.demo.model.ChiTietSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface IChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham, String> {
    @Override
    Page<ChiTietSanPham> findAll(Pageable pageable);

    ChiTietSanPham findChiTietSanPhamById(String id);

    @Query("SELECT ctsp FROM ChiTietSanPham ctsp WHERE ctsp.idSP.ten LIKE %:ten%")
    Page<ChiTietSanPham> searchByTen(@Param("ten") String ten, Pageable pageable);


    @Query("SELECT ctsp FROM ChiTietSanPham ctsp WHERE ctsp.idSP.ten LIKE %:ten% AND ctsp.giaBan BETWEEN :min AND :max")
    Page<ChiTietSanPham> searchByTenAndGiaRange(@Param("ten") String ten, @Param("min") BigDecimal min, @Param("max") BigDecimal max, Pageable pageable);


}
