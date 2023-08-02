package com.example.demo.controller;


import com.example.demo.DTO.ChiTietSanPhamDTO;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/chi-tiet-san-pham")
public class ChiTietSanPhamController {
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


    @GetMapping
    public String viewAll(Model model
            , @RequestParam(defaultValue = "1") int page
            , @RequestParam(required = false, name = "tenSanPham") String keyword
            , @RequestParam(name = "min", defaultValue = "0") BigDecimal min,
                          @RequestParam(name = "max", defaultValue = "100000000") BigDecimal max) {
        Page<ChiTietSanPham> listCTSP;
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 5);
        listCTSP = iChiTietSanPhamService.findAll(pageable);
        if (keyword == null || keyword.isBlank() & min == null & max == null) {
            listCTSP = iChiTietSanPhamService.findAll(pageable);
        } else {
            listCTSP = iChiTietSanPhamService.searchByTenAndGiaRange(keyword, min, max, pageable);
        }
        // model.addAttribute("chiTietSPDTO", chiTietSanPhamDTO);
        model.addAttribute("listChiTietSanPham", listCTSP);
        return "chiTietSP/hien-thi";
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
        return "chiTietSP/detail";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("chiTietSPDTO") ChiTietSanPhamDTO chiTietSanPhamDTO, RedirectAttributes redirectAttributes) {
        Optional<ChiTietSanPham> optionalChiTietSanPham = iChiTietSanPhamRepository.findById(chiTietSanPhamDTO.getId());
        ChiTietSanPham chiTietSanPham = null;
        String image = "anh1.jpg";
        Path path = Paths.get("C:\\java5\\asiment\\src\\main\\webapp\\img");
        if (optionalChiTietSanPham.isPresent()) {
            if (chiTietSanPhamDTO.getImage().isEmpty()) {
                image = optionalChiTietSanPham.get().getImage();
            } else {
                try {
                    InputStream inputStream = chiTietSanPhamDTO.getImage().getInputStream();
                    Files.copy(inputStream, path.resolve(chiTietSanPhamDTO.getImage().getOriginalFilename()),
                            StandardCopyOption.REPLACE_EXISTING);
                    image = chiTietSanPhamDTO.getImage().getOriginalFilename().toString();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //save
        } else {
            //add new
            if (!chiTietSanPhamDTO.getImage().isEmpty()) {
                try {
                    InputStream inputStream = chiTietSanPhamDTO.getImage().getInputStream();
                    Files.copy(inputStream, path.resolve(chiTietSanPhamDTO.getImage().getOriginalFilename()),
                            StandardCopyOption.REPLACE_EXISTING);
                    image = chiTietSanPhamDTO.getImage().getOriginalFilename().toString();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        chiTietSanPham = new ChiTietSanPham(chiTietSanPhamDTO.getId(),
                chiTietSanPhamDTO.getIdSP(),
                chiTietSanPhamDTO.getIdNSX(),
                chiTietSanPhamDTO.getIdMauSac(),
                chiTietSanPhamDTO.getIdDongSP(),
                chiTietSanPhamDTO.getNamBH(),
                chiTietSanPhamDTO.getMoTa(), chiTietSanPhamDTO.getSoLuongTon(),
                chiTietSanPhamDTO.getGiaNhap(), chiTietSanPhamDTO.getGiaBan(),
                image, chiTietSanPhamDTO.getCanNang());
        iChiTietSanPhamRepository.save(chiTietSanPham);
        redirectAttributes.addFlashAttribute("successMessage", "Add thành công.");
        return "redirect:/chi-tiet-san-pham";
    }

    @GetMapping("/remove/{id}")
    public String deleteById(@PathVariable(name = "id") String id, RedirectAttributes redirectAttributes) {
        iChiTietSanPhamService.delete(id);
        redirectAttributes.addFlashAttribute("successMessage", "Remove thành công");
        return "redirect:/chi-tiet-san-pham";
    }

    @GetMapping("/formAdd")
    public String goFormAdd(Model model) {
        ChiTietSanPhamDTO chiTietSanPhamDTO = new ChiTietSanPhamDTO();
        List<SanPham> listSP = iSanPhamRepository.findAll();
        List<DongSanPham> listDSP = iDongSanPhamRepository.findAll();
        List<MauSac> listMS = iMauSacRepository.findAll();
        List<NhaSanXuat> listNSX = iNhaSanXuatRepository.findAll();

        model.addAttribute("chiTietSPDTO", chiTietSanPhamDTO);
        model.addAttribute("listSP", listSP);
        model.addAttribute("listDSP", listDSP);
        model.addAttribute("listMS", listMS);
        model.addAttribute("listNSX", listNSX);
        return "chiTietSP/add";
    }

    @RequestMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable(name = "id") String id, Model model) {
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
        ChiTietSanPham chiTietSanPham2 = iChiTietSanPhamService.findChiTietSanPhamById(id);
        model.addAttribute("image", chiTietSanPham2.getImage());
        return "chiTietSP/view-update";
    }

    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute("chiTietSPDTO") ChiTietSanPhamDTO chiTietSanPhamDTO
            , RedirectAttributes redirectAttributes) {
        Optional<ChiTietSanPham> optionalChiTietSanPham = iChiTietSanPhamRepository.findById(chiTietSanPhamDTO.getId());
        ChiTietSanPham chiTietSanPham = null;
        String image = "Logo.png";
        Path path = Paths.get("C:\\java5\\asiment\\src\\main\\webapp\\img/");
        if (optionalChiTietSanPham.isPresent()) {
            chiTietSanPham = optionalChiTietSanPham.get();
            // Update existing
            if (!chiTietSanPhamDTO.getImage().isEmpty()) {
                try {
                    InputStream inputStream = chiTietSanPhamDTO.getImage().getInputStream();
                    Files.copy(inputStream, path.resolve(chiTietSanPhamDTO.getImage().getOriginalFilename()),
                            StandardCopyOption.REPLACE_EXISTING);
                    image = chiTietSanPhamDTO.getImage().getOriginalFilename().toString();
                    // Update image file path
                    chiTietSanPham.setImage(image);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // Update other properties
            chiTietSanPham.setIdSP(chiTietSanPhamDTO.getIdSP());
            chiTietSanPham.setIdNSX(chiTietSanPhamDTO.getIdNSX());
            chiTietSanPham.setIdMauSac(chiTietSanPhamDTO.getIdMauSac());
            chiTietSanPham.setIdDongSP(chiTietSanPhamDTO.getIdDongSP());
            chiTietSanPham.setNamBH(chiTietSanPhamDTO.getNamBH());
            chiTietSanPham.setMoTa(chiTietSanPhamDTO.getMoTa());
            chiTietSanPham.setSoLuongTon(chiTietSanPhamDTO.getSoLuongTon());
            chiTietSanPham.setGiaNhap(chiTietSanPhamDTO.getGiaNhap());
            chiTietSanPham.setGiaBan(chiTietSanPhamDTO.getGiaBan());
            iChiTietSanPhamRepository.save(chiTietSanPham);
        }
        redirectAttributes.addFlashAttribute("successMessage", "Update thành công.");
        return "redirect:/chi-tiet-san-pham";
    }
}