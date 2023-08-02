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
@Table(name = "Hoa_Don")
@Entity
public class HoaDon {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne
    @JoinColumn(name = "idkh")
    private KhachHang idkh;

    @Column(name = "Ngay_Tao")
    private String ngayTao;

    @Column(name = "Ngay_Thanh_Toan")
    private String ngayThanhToan;

    @Column(name = "Tinh_Trang")
    private Integer tinhTrang;

    @Column(name = "Ten_Nguoi_Nhan")
    private String tenNguoiNhan;

    @Column(name = "Dia_Chi")
    private String diaChi;

    @Column(name = "sdt")
    private String sdt;
    @Column(name = "Tong_Tien")
    private BigDecimal tongTien;
}
