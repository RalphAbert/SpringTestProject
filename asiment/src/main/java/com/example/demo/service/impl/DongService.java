package com.example.demo.service.impl;

import com.example.demo.model.DongSanPham;
import com.example.demo.repository.IDongSanPhamRepository;
import com.example.demo.service.IDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DongService implements IDongService {

    @Autowired
    private IDongSanPhamRepository repository;

    @Override
    public void add(DongSanPham dongSanPham) {
        repository.save(dongSanPham);
    }

    @Override
    public void update(DongSanPham dongSanPham) {
        repository.save(dongSanPham);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<DongSanPham> fillAll() {
        return repository.findAll();
    }

    @Override
    public DongSanPham findDongSanPhamById(String id) {
        return repository.findDongSanPhamById(id);
    }

}
