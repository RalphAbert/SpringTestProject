package com.example.demo.repository;

import com.example.demo.model.HoaDon;
import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.model.HoaDonChiTietId;
import com.example.demo.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, HoaDonChiTietId> {
    List<HoaDonChiTiet> findAll();


    @Query("SELECT a FROM HoaDonChiTiet a WHERE a.idHoaDon = :idhd")
    List<HoaDonChiTiet> timHoaDon(@Param("idhd") HoaDon idhd);

}
