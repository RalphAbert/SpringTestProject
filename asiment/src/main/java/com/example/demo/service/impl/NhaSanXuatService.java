package com.example.demo.service.impl;

import com.example.demo.model.NhaSanXuat;
import com.example.demo.repository.INhaSanXuatRepository;
import com.example.demo.service.INhaSanXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhaSanXuatService implements INhaSanXuatService {

    @Autowired
    private INhaSanXuatRepository repository;

    @Override
    public void add(NhaSanXuat nhaSanXuat) {
        repository.save(nhaSanXuat);
    }

    @Override
    public void update(NhaSanXuat nhaSanXuat) {
        repository.save(nhaSanXuat);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public NhaSanXuat findNhaSanXuatById(String id) {
        return repository.findNhaSanXuatById(id);
    }

    @Override
    public List<NhaSanXuat> fillAll() {
        return repository.findAll();
    }
}
