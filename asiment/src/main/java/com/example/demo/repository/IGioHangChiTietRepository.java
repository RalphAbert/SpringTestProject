package com.example.demo.repository;

import com.example.demo.model.GioHang;
import com.example.demo.model.GioHangChiTiet;
import com.example.demo.model.GioHangChiTietId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGioHangChiTietRepository extends JpaRepository<GioHangChiTiet, GioHangChiTietId> {

    List<GioHangChiTiet> findAll();

    List<GioHangChiTiet> findByIdGioHang(GioHang idGioHang);
//    @Query("select ghct from GioHangChiTiet ghct where ghct.idGioHang= :idGioHang")
//    List<GioHangChiTiet> findAllBy(@Param("idGioHang") GioHang gioHang);

}
