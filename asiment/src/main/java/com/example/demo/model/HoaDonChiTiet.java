package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@IdClass(HoaDonChiTietId.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Hoa_Don_Chi_Tiet")
@Entity
public class HoaDonChiTiet {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_Hoa_Don")
    private HoaDon idHoaDon;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_Chi_Tiet_San_Pham")
    private ChiTietSanPham idChiTietSanPham;

    @Column(name = "So_Luong")
    private Integer soLuong;
    @Column(name = "Don_Gia")
    private BigDecimal donGia;
}
