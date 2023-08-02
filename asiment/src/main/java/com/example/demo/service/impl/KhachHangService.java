package com.example.demo.service.impl;

import com.example.demo.model.KhachHang;
import com.example.demo.repository.IKhachHangRepository;
import com.example.demo.service.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangService implements IKhachHangService {
    @Autowired
    private IKhachHangRepository repository;

    @Override
    public void add(KhachHang khachHang) {

    }

    @Override
    public void update(KhachHang khachHang) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<KhachHang> fillAll() {
        return repository.findAll();
    }

//    @Override
//    public KhachHang findKhachHangById(String id) {
//        return repository.findKhachHangById(id);
//    }
}
