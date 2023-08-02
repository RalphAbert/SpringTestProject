package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.IChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("ban-hang")
public class BanHangController {
    @Autowired
    private IChiTietSanPhamRepository iChiTietSanPhamRepository;
    @Autowired
    private IChiTietSanPhamService iChiTietSanPhamService;
    @Autowired
    private ISanPhamRepository iSanPhamRepository;
    @Autowired
    private IDongSanPhamRepository iDongSanPhamRepository;
    @Autowired
    private IMauSacRepository iMauSacRepository;
    @Autowired
    private INhaSanXuatRepository iNhaSanXuatRepository;
    @Autowired
    private IGioHangChiTietRepository repository;
    @Autowired
    private IGioHangRepository gioHangRepository;
    @Autowired
    private IGioHangChiTietSessionRepo iGioHangChiTietSessionRepo;

    @GetMapping
    public String viewAll(Model model
            , @RequestParam(defaultValue = "1") int page
            , @RequestParam(required = false, name = "tenSanPham") String keyword
            , @RequestParam(name = "min", defaultValue = "0") BigDecimal min,
                          @RequestParam(name = "max", defaultValue = "100000000") BigDecimal max) {
        Page<ChiTietSanPham> listCTSP;
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 8);
        listCTSP = iChiTietSanPhamService.findAll(pageable);
        if (keyword == null || keyword.isBlank() & min == null & max == null) {
            listCTSP = iChiTietSanPhamService.findAll(pageable);
        } else {
            listCTSP = iChiTietSanPhamService.searchByTenAndGiaRange(keyword, min, max, pageable);
        }
        // model.addAttribute("chiTietSPDTO", chiTietSanPhamDTO);
        model.addAttribute("listChiTietSanPham", listCTSP);
        return "ban-hang/hien-thi";
    }

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable(name = "id") String id, Model model) {
        ChiTietSanPham chiTietSanPham = iChiTietSanPhamService.findChiTietSanPhamById(id);
        List<SanPham> listSP = iSanPhamRepository.findAll();
        List<DongSanPham> listDSP = iDongSanPhamRepository.findAll();
        List<MauSac> listMS = iMauSacRepository.findAll();
        List<NhaSanXuat> listNSX = iNhaSanXuatRepository.findAll();
        model.addAttribute("listSP", listSP);
        model.addAttribute("listDSP", listDSP);
        model.addAttribute("listMS", listMS);
        model.addAttribute("listNSX", listNSX);
        model.addAttribute("chiTietSPDTO", chiTietSanPham);
        model.addAttribute("image", chiTietSanPham.getImage());
        return "ban-hang/detail";
    }
}
