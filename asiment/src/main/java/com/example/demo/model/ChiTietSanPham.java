package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "chi_tiet_san_pham")
@Entity
public class ChiTietSanPham {
    @Id
    @Column(name = "Id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne
    @JoinColumn(name = "idsp")
    private SanPham idSP;

    @ManyToOne
    @JoinColumn(name = "IdNSX")
    private NhaSanXuat idNSX;

    @ManyToOne
    @JoinColumn(name = "Id_Mau_Sac")
    private MauSac idMauSac;

    @ManyToOne
    @JoinColumn(name = "Id_DongSP")
    private DongSanPham idDongSP;

    @Column(name = "NamBH")
    private int namBH;

    @Column(name = "Mo_Ta")
    private String moTa;

    @Column(name = "So_Luong_Ton")
    private int soLuongTon;

    @Column(name = "Gia_Nhap")
    private BigDecimal giaNhap;

    @Column(name = "Gia_Ban")
    private BigDecimal giaBan;

    @Column(name = "Image")
    private String image;
    @Column(name = "canNang")
    private BigDecimal canNang;

}
