package com.example.demo.repository;

import com.example.demo.model.GioHang;
import com.example.demo.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGioHangRepository extends JpaRepository<GioHang, String> {
    @Override
    List<GioHang> findAll();

    @Query("select gh from GioHang gh where gh.idkh= :idkh")
    GioHang timGHTheoIdKH(@Param("idkh") KhachHang id);
}
