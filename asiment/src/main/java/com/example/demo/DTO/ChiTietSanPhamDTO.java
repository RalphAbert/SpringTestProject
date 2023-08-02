package com.example.demo.DTO;

import com.example.demo.model.DongSanPham;
import com.example.demo.model.MauSac;
import com.example.demo.model.NhaSanXuat;
import com.example.demo.model.SanPham;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor

public class ChiTietSanPhamDTO {
    private String id;
    private SanPham idSP;
    private NhaSanXuat idNSX;
    private MauSac idMauSac;
    private DongSanPham idDongSP;
    private int namBH;
    private String moTa;
    private int soLuongTon;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;
    private MultipartFile image;
    private BigDecimal canNang;

    public ChiTietSanPhamDTO() {
        this.id = UUID.randomUUID().toString();
    }


}
