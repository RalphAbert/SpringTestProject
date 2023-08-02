package com.example.demo.controller;

import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.GioHang;
import com.example.demo.model.GioHangChiTiet;
import com.example.demo.model.KhachHang;
import com.example.demo.repository.IGioHangChiTietRepository;
import com.example.demo.repository.IGioHangChiTietSessionRepo;
import com.example.demo.repository.IGioHangRepository;
import com.example.demo.repository.IKhachHangRepository;
import com.example.demo.service.IChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/gio-hang")
public class GioHangChiTietController {
    @Autowired
    private IGioHangChiTietRepository repository;
    @Autowired
    private IGioHangRepository gioHangRepository;
    @Autowired
    private IGioHangChiTietSessionRepo iGioHangChiTietSessionRepo;
    @Autowired
    IChiTietSanPhamService iChiTietSanPhamService;
    @Autowired
    IKhachHangRepository khachHangRepository;

    @GetMapping("/{userId}")
    private String viewAll(Model model,
                           @PathVariable(name = "userId") String id) {
        // tìm khach hang co id
        KhachHang khachHang = khachHangRepository.findById(id).orElse(null);

        // Tìm đối tượng GioHang tương ứng với id
        GioHang gioHang = gioHangRepository.timGHTheoIdKH(khachHang);
        List<GioHangChiTiet> gioHangChiTiets = repository.findByIdGioHang(gioHang);
        model.addAttribute("gioHangChiTiets", gioHangChiTiets);
        model.addAttribute("gioHang", gioHang);
        return "gio-hang/hien-thi";
    }

    @PostMapping("/add-to-cart/{id}")
    public String addToCart(@PathVariable("id") String idctsp, RedirectAttributes redirectAttributes,
                            @RequestParam(value = "userId", required = false) String idkh) {

        // tìm khach hang co id
        KhachHang khachHang = khachHangRepository.findById(idkh).orElse(null);

        // Tìm đối tượng GioHang tương ứng với idkh
        GioHang gioHang = gioHangRepository.timGHTheoIdKH(khachHang);
        ChiTietSanPham chiTietSanPham = iChiTietSanPhamService.findChiTietSanPhamById(idctsp);
        iGioHangChiTietSessionRepo.addToCart(gioHang, chiTietSanPham);
        redirectAttributes.addFlashAttribute("user", khachHang);
        return "redirect:/gio-hang/" + idkh; // Chuyển hướng đến trang giỏ hàng
    }

    @PostMapping("/tru-san-pham/{id}")
    public String truSanPham(@PathVariable("id") String idctsp
            , RedirectAttributes redirectAttributes
            , @RequestParam(value = "userId", required = false) String idkh) {
        // tìm khach hang co id
        KhachHang khachHang = khachHangRepository.findById(idkh).orElse(null);

        // Tìm đối tượng GioHang tương ứng với idkh
        GioHang gioHang = gioHangRepository.timGHTheoIdKH(khachHang);
        ChiTietSanPham chiTietSanPham = iChiTietSanPhamService.findChiTietSanPhamById(idctsp);
        iGioHangChiTietSessionRepo.truSanPham(gioHang, chiTietSanPham);
        redirectAttributes.addFlashAttribute("user", khachHang);
        return "redirect:/gio-hang/" + idkh; // Chuyển hướng đến trang giỏ hàng
    }

    @PostMapping("/xoa-san-pham/{id}")
    public String xoaSanPham(@PathVariable("id") String idctsp
            , RedirectAttributes redirectAttributes
            , @RequestParam(value = "userId", required = false) String idkh
    ) {
        // tìm khach hang co id
        KhachHang khachHang = khachHangRepository.findById(idkh).orElse(null);

        // Tìm đối tượng GioHang tương ứng với idkh
        GioHang gioHang = gioHangRepository.timGHTheoIdKH(khachHang);
        ChiTietSanPham chiTietSanPham = iChiTietSanPhamService.findChiTietSanPhamById(idctsp);
        iGioHangChiTietSessionRepo.xoaSanPham(gioHang, chiTietSanPham);
        redirectAttributes.addFlashAttribute("user", khachHang);
        return "redirect:/gio-hang/" + idkh; // Chuyển hướng đến trang giỏ hàng
    }
}
