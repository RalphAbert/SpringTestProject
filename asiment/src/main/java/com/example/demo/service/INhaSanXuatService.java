package com.example.demo.service;

import com.example.demo.model.NhaSanXuat;

import java.util.List;

public interface INhaSanXuatService {
    void add(NhaSanXuat nhaSanXuat);

    void update(NhaSanXuat nhaSanXuat);

    void delete(String id);

    NhaSanXuat findNhaSanXuatById(String id);

    List<NhaSanXuat> fillAll();
}
