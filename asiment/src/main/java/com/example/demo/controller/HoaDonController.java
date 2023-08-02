package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/hoa-don")
public class HoaDonController {
    @Autowired
    private IHoaDonRepository iHoaDonRepository;

    @Autowired
    private IKhachHangRepository khachHangRepository;
    @Autowired
    private IGioHangRepository gioHangRepository;
    @Autowired
    private IGioHangChiTietRepository gioHangChiTietRepository;
    @Autowired
    private IHoaDonChiTietRepository iHoaDonChiTietRepository;

    @GetMapping
    private String viewAll(Model model) {
        List<HoaDon> hoaDons = iHoaDonRepository.findAll();
        model.addAttribute("hoaDons", hoaDons);
        return "hoa-don/hien-thi";
    }

    @PostMapping("/tao-hoa-don/{id}")
    public String taoHoaDon(HoaDon hoaDon, Model model
            , @RequestParam(value = "totalPrice", required = false) BigDecimal totalPrice
            , @RequestParam(value = "userId", required = false) String idkh
    ) {
        KhachHang khachHang = khachHangRepository.findById(idkh).orElse(null);
        GioHang gioHang = gioHangRepository.timGHTheoIdKH(khachHang);
        ;
        List<GioHangChiTiet> gioHangChiTiets = gioHangChiTietRepository.findByIdGioHang(gioHang);
        // Tạo hóa đơn chờ
        hoaDon.setIdkh(khachHang);
        hoaDon.setSdt(null);
        hoaDon.setNgayTao(String.valueOf(LocalDate.now()));
        hoaDon.setNgayThanhToan(null);
        hoaDon.setDiaChi(null);
        hoaDon.setSdt(null);
        hoaDon.setTinhTrang(0);
        hoaDon.setTenNguoiNhan(null);
        hoaDon.setTongTien(totalPrice);

        HoaDon hoaDonVuaTao = iHoaDonRepository.save(hoaDon);
        // tạo hóa đơn chi tiết
        String idHoaDonVuaTao = hoaDonVuaTao.getId();
        HoaDon hoaDonId = iHoaDonRepository.findById(idHoaDonVuaTao).orElse(null);

        for (GioHangChiTiet gioHangChiTiet : gioHangChiTiets) {
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setIdHoaDon(hoaDonId);
            hoaDonChiTiet.setIdChiTietSanPham(gioHangChiTiet.getIdChiTietSanPham());
            hoaDonChiTiet.setSoLuong(gioHangChiTiet.getSoLuong());
            hoaDonChiTiet.setDonGia(gioHangChiTiet.getDonGia());
            iHoaDonChiTietRepository.save(hoaDonChiTiet);
        }
        model.addAttribute("hoaDon", hoaDonVuaTao);
        return "hoa-don/thanh-toan"; // Chuyển hướng đến trang giỏ hàng
    }

    @PostMapping("/thanh-toan/{idHoaDonVuaTao}")
    public String thanhToan(@ModelAttribute("hoaDon") HoaDon hoaDon
            , @PathVariable(name = "idHoaDonVuaTao") String id
            , Model model
    ) {
        HoaDon hoaDonTim = iHoaDonRepository.findById(id).orElse(null);
        if (hoaDon != null) {
            hoaDon.setId(hoaDonTim.getId());
            hoaDon.setIdkh(hoaDonTim.getIdkh());
            hoaDon.setNgayTao(hoaDonTim.getNgayTao());
            hoaDon.setNgayThanhToan(String.valueOf(LocalDate.now()));
            hoaDon.setTinhTrang(1);
            hoaDon.setTongTien(hoaDonTim.getTongTien());
            iHoaDonRepository.save(hoaDon);
        }
        KhachHang khachHang = hoaDonTim.getIdkh();
        GioHang gioHang = gioHangRepository.timGHTheoIdKH(khachHang);
        List<GioHangChiTiet> gioHangChiTiet = gioHangChiTietRepository.findByIdGioHang(gioHang);
        gioHangChiTietRepository.deleteAll(gioHangChiTiet);

        //Hien thi hoa don ra man hinh
        List<HoaDonChiTiet> hoaDonChiTiets = iHoaDonChiTietRepository.timHoaDon(hoaDonTim);
        model.addAttribute("hoaDonChiTiets", hoaDonChiTiets);
        model.addAttribute("khachHang", hoaDonTim.getIdkh());
        model.addAttribute("successMessage", "Bạn đã đặt hàng thành công đơn hàng sẽ đến trong vài ngày nữa");
        return "hoa-don/hoaDonThanhToan"; // Chuyển hướng đến trang giỏ hàng
    }


}
