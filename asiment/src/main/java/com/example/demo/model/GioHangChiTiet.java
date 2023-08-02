package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Gio_Hang_Chi_Tiet")
@Entity
@IdClass(GioHangChiTietId.class)
public class GioHangChiTiet {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_gio_hang")
    private GioHang idGioHang;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_chi_tiet_san_pham")
    private ChiTietSanPham idChiTietSanPham;

    @Column(name = "so_luong")
    private int soLuong;

    @Column(name = "don_gia")
    private BigDecimal donGia;
}
