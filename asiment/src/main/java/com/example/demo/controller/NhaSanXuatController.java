package com.example.demo.controller;


import com.example.demo.model.NhaSanXuat;
import com.example.demo.service.INhaSanXuatService;
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
@RequestMapping("nha-san-xuat")
public class NhaSanXuatController {

    NhaSanXuat nhaSanXuat = new NhaSanXuat();

    @Autowired
    private INhaSanXuatService service;

    @GetMapping
    public String viewAll(Model model) {
        List<NhaSanXuat> nsx = service.fillAll();
        model.addAttribute("listNhaSanXuat", nsx);
        model.addAttribute("nhaSanXuat", nhaSanXuat);
        return "nha-san-xuat/hien-thi";
    }

    @PostMapping("/add")
    public String add(@RequestParam(name = "ma") String ma, @RequestParam(name = "ten") String ten) {
        NhaSanXuat nhaSanXuat = new NhaSanXuat();
        nhaSanXuat.setMa(ma);
        nhaSanXuat.setTen(ten);
        service.add(nhaSanXuat);
        return "redirect:/nha-san-xuat";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable(name = "id") String id, Model model) {
        NhaSanXuat nx = service.findNhaSanXuatById(id);
        model.addAttribute("nhaSanXuat", nx);
        return "nha-san-xuat/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(name = "id") String id,
                         @RequestParam(name = "ma") String ma, @RequestParam(name = "ten") String ten) {
        NhaSanXuat nhaSanXuat = service.findNhaSanXuatById(id);
        nhaSanXuat.setMa(ma);
        nhaSanXuat.setTen(ten);
        service.update(nhaSanXuat);
        return "redirect:/nha-san-xuat";

    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") String id) {
        NhaSanXuat n = service.findNhaSanXuatById(id);
        service.delete(id);
        return "redirect:/nha-san-xuat";
    }

}
