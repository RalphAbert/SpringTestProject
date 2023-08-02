package com.example.demo.repository;

import com.example.demo.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ILoginRepository extends JpaRepository<KhachHang, String> {
    @Override
    List<KhachHang> findAll();

    KhachHang findKhachHangByEmail(String email);


    KhachHang getKhachHangByResetPassToken(String token);

    KhachHang findByResetPassToken(String token);
}
