package com.example.demo.service.impl;

import com.example.demo.model.SanPham;
import com.example.demo.repository.ISanPhamRepository;
import com.example.demo.service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamService implements ISanPhamService {
    @Autowired
    private ISanPhamRepository repository;

    @Override
    public void add(SanPham sanPham) {
        repository.save(sanPham);
    }

    @Override
    public void update(SanPham sanPham) {
        repository.save(sanPham);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<SanPham> fillAll() {
        return repository.findAll();
    }


    @Override
    public SanPham findSanPhamById(String id) {
        return repository.findSanPhamById(id);
    }


}
