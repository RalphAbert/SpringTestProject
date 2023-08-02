package com.example.demo.service;

import com.example.demo.model.KhachHang;

public interface ILoginService {
    void add(KhachHang khachHang);

    boolean checkLogin(String email, String matKhau);

    KhachHang findKhachHangByEmail(String email);

    KhachHang findByResetPassToken(String token);


    void updateResetPasswordToken(String token, String email);


    void updatePassword(KhachHang chucVu, String newPassword);

    KhachHang getKhachHangByResetPassToken(String token);

    KhachHang get(String resetPassToken);
}
