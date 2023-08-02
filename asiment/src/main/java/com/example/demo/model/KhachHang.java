package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Khach_Hang")
@Entity
public class KhachHang {
    @Id
    @Column(name = "Id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "Sdt")
    private String sdt;
    @Column(name = "Dia_Chi")
    private String diaChi;
    @Column(name = "Mat_Khau")
    private String matKhau;
    @Column(name = "Email")
    private String email;
    @Column(name = "reset_pass_token")
    private String resetPassToken;

    @Column(name = "quyen")
    private String quyen;
}
