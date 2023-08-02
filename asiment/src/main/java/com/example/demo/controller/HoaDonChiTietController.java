package com.example.demo.controller;

import com.example.demo.model.HoaDon;
import com.example.demo.model.KhachHang;
import com.example.demo.repository.IHoaDonChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/hoa-don")
public class HoaDonChiTietController {
    @Autowired
    private IHoaDonChiTietRepository iHoaDonChiTietRepository;

    @PostMapping("/tao-hoa-don-chi-tiet")
    public String taoHoaDonChiTiet(HoaDon hoaDon) {


        return "redirect:/hoa-don"; // Chuyển hướng đến trang giỏ hàng
    }
}
