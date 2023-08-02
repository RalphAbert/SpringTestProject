package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HoaDonChiTietId implements Serializable {
    private HoaDon idHoaDon;
    private ChiTietSanPham idChiTietSanPham;
}
