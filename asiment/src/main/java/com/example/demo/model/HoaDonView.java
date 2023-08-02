package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HoaDonView {
    private String tenKH;
    private String tenSP;

    private Integer soLuong;
    private BigDecimal donGia;


}
