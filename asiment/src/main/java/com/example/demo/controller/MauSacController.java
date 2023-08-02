package com.example.demo.controller;


import com.example.demo.model.MauSac;
import com.example.demo.service.IMauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("mau-sac")
public class MauSacController {
    MauSac ms = new MauSac();

    @Autowired
    private IMauSacService service;

    @GetMapping
    public String viewAll(Model model) {
        List<MauSac> listMS = service.findAll();
        model.addAttribute("mauSac", ms);
        model.addAttribute("listMS", listMS);
        return "mau-sac/hien-thi";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(name = "id") String id) {
        service.delete(id);
        return "redirect:/mau-sac";
    }

    @GetMapping("/view-update/{id}")
    public String detail(@PathVariable(name = "id") String id, Model model) {
        MauSac mauSac = service.findMauSacById(id);
        model.addAttribute("mauSac", mauSac);
        return "mau-sac/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(name = "id") String id,
                         @RequestParam(name = "ma") String ma,
                         @RequestParam(name = "ten") String ten) {

        MauSac loaiSP = service.findMauSacById(id);
        loaiSP.setMa(ma);
        loaiSP.setTen(ten);
        service.update(loaiSP);
        return "redirect:/mau-sac";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute(name = "mauSac") MauSac mauSac) {

        service.add(mauSac); // Assuming the service or repository has a suitable method to create a new record

        return "redirect:/mau-sac";
    }

//    @PostMapping("/add")
//    public String addMauSac(@ModelAttribute("mauSac") MauSac mauSacRequest, BindingResult result) {
//        // Kiểm tra tính hợp lệ của dữ liệu
//        if (result.hasErrors()) {
//            // Nếu có lỗi, trả về view "mau-sac/hien-thi" để hiển thị lại form với thông báo lỗi
//            return "mau-sac/hien-thi";
//        }
//
//        // Tạo đối tượng MauSac từ dữ liệu nhập vào
//        MauSac mauSac = new MauSac();
//        mauSac.setId(mauSacRequest.getId());
//        mauSac.setMa(mauSacRequest.getMa());
//        mauSac.setTen(mauSacRequest.getTen());
//
//        // Gọi phương thức add() của service để thêm đối tượng MauSac vào cơ sở dữ liệu
//        service.add(mauSac);
//
//        // Chuyển hướng người dùng đến đường dẫn "/mau-sac/hien-thi" sau khi thêm thành công
//        return "redirect:/mau-sac";
//    }
}