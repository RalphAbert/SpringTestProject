package com.example.demo.controller;

import com.example.demo.model.DongSanPham;
import com.example.demo.model.KhachHang;
import com.example.demo.service.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {
    KhachHang khachHang = new KhachHang();
    @Autowired
    private IKhachHangService service;

    @GetMapping
    private String viewAll(Model model) {
        List<KhachHang> khachHangs = service.fillAll();
        model.addAttribute("khachHangs", khachHangs);
        model.addAttribute("khachHang", khachHang);
        return "khach-hang/hien-thi";
    }
}
