package com.example.demo.controller;

import com.example.demo.model.DongSanPham;
import com.example.demo.model.SanPham;
import com.example.demo.service.IDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("dong-san-pham")
public class DongController {

    DongSanPham dong = new DongSanPham();

    @Autowired
    private IDongService service;

    @GetMapping
    private String viewAll(Model model) {
        List<DongSanPham> dongSanPham = service.fillAll();
        model.addAttribute("listDong", dongSanPham);
        model.addAttribute("dongDoChoi", dong);
        return "dong/hien-thi";
    }

    @PostMapping("/add")
    private String add(@RequestParam(name = "ma") String ma,
                       @RequestParam(name = "ten") String ten) {

        DongSanPham dongSanPham = new DongSanPham();
        dongSanPham.setMa(ma);
        dongSanPham.setTen(ten);
        service.add(dongSanPham);
        return "redirect:/dong-san-pham";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(name = "id") String id,
                         @RequestParam(name = "ma") String ma,
                         @RequestParam(name = "ten") String ten) {
        DongSanPham dsp = service.findDongSanPhamById(id);
        dsp.setMa(ma);
        dsp.setTen(ten);
        service.update(dsp);
        return "redirect:/do-choi";

    }


    @GetMapping("/view-update/{id}")
    private String viewUpdate(@PathVariable(name = "id") String id, Model model) {
        DongSanPham dongSanPham = service.findDongSanPhamById(id);
        model.addAttribute("dongDoChoi", dongSanPham);
        return "dong/edit";
    }


    @GetMapping("/delete/{id}")
    private String delete(@PathVariable(name = "id") String id, Model model) {
        DongSanPham dongSanPham = service.findDongSanPhamById(id);
        service.delete(id);
        return "redirect:/dong-san-pham";
    }

}
