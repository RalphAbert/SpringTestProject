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
public class GioHangChiTietId implements Serializable {
    private GioHang idGioHang;
    private ChiTietSanPham idChiTietSanPham;

}
