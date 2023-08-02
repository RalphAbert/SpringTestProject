package com.example.demo.controller;


import com.example.demo.model.SanPham;
import com.example.demo.service.ISanPhamService;
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
@RequestMapping("do-choi")
public class SanPhamController {
    SanPham sp = new SanPham();

    @Autowired
    private ISanPhamService service;

    @GetMapping
    public String viewAll(Model model) {
        List<SanPham> listSanPham = service.fillAll();
        model.addAttribute("doChoi", sp);
        model.addAttribute("ListSP", listSanPham);
        return "do-choi/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(name = "id") String id) {
        service.delete(id);
        return "redirect:/do-choi";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable(name = "id") String id, Model model) {
        SanPham sanPham = service.findSanPhamById(id);
        model.addAttribute("doChoi", sanPham);
        return "do-choi/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(name = "id") String id,
                         @RequestParam(name = "ma") String ma,
                         @RequestParam(name = "ten") String ten) {
        SanPham sp = service.findSanPhamById(id);
        sp.setMa(ma);
        sp.setTen(ten);
        service.update(sp);
        return "redirect:/do-choi";

    }

    @PostMapping("/add")
    public String add(
            @RequestParam(name = "ma") String ma,
            @RequestParam(name = "ten") String ten) {
        SanPham sp = new SanPham();
        sp.setMa(ma);
        sp.setTen(ten);
        service.add(sp);
        return "redirect:/do-choi";

    }
}
