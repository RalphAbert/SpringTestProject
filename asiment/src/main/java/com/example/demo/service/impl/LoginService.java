package com.example.demo.service.impl;

import com.example.demo.model.GioHang;
import com.example.demo.model.KhachHang;
import com.example.demo.repository.IGioHangRepository;
import com.example.demo.repository.ILoginRepository;
import com.example.demo.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService implements ILoginService {
    @Autowired
    private ILoginRepository repository;

    @Autowired
    private IGioHangRepository repositoryGH;

    @Override
    public void add(KhachHang khachHang) {
        // Thêm khách hàng vào cơ sở dữ liệu
        KhachHang savedKhachHang = repository.save(khachHang);

        // Lấy id của khách hàng đã thêm
        String khachHangId = savedKhachHang.getId();

        // Tạo giỏ hàng mới và liên kết với khách hàng
        GioHang gioHang = new GioHang();
        gioHang.setIdkh(khachHang);
        gioHang.setId(khachHangId);

        // Lưu giỏ hàng vào cơ sở dữ liệu
        repositoryGH.save(gioHang);
    }

    @Override
    public boolean checkLogin(String email, String matKhau) {
        Optional<KhachHang> optionalChucVu = Optional.ofNullable(findKhachHangByEmail(email));
        if (optionalChucVu.isPresent() && optionalChucVu.get().getTen().equalsIgnoreCase(matKhau)) {
            // Thực hiện xử lý với đối tượng chucVu
            return true;
        }
        return false;
    }

    @Override
    public KhachHang findKhachHangByEmail(String email) {
        return repository.findKhachHangByEmail(email);
    }

    @Override
    public KhachHang findByResetPassToken(String token) {
        return repository.findByResetPassToken(token);
    }


    public void updateResetPasswordToken(String token, String email) {
        KhachHang chucVu = repository.findKhachHangByEmail(email);
        if (chucVu != null) {
            chucVu.setResetPassToken(token);
            repository.save(chucVu);
        } else {
            throw new RuntimeException("Could not find any customer with the email " + email);
        }
    }


    @Override
    public KhachHang get(String resetPassToken) {
        return repository.findByResetPassToken(resetPassToken);
    }

    public KhachHang getByResetPassToken(String token) {
        return repository.findByResetPassToken(token);
    }

    public void updatePassword(KhachHang chucVu, String newPassword) {
        int maxLength = 50; // Độ dài tối đa của cột 'Ten'
        String trimmedValue = chucVu.getMatKhau();
        if (trimmedValue.length() > maxLength) {
            trimmedValue = trimmedValue.substring(0, maxLength);
        }
        chucVu.setMatKhau(trimmedValue);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        chucVu.setMatKhau(encodedPassword);

        chucVu.setResetPassToken(null);
        repository.save(chucVu);
    }

    @Override
    public KhachHang getKhachHangByResetPassToken(String token) {
        return repository.getKhachHangByResetPassToken(token);
    }
}
