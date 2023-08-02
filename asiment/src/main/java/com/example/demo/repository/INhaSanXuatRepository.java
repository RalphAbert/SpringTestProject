package com.example.demo.repository;


import com.example.demo.model.NhaSanXuat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface INhaSanXuatRepository extends JpaRepository<NhaSanXuat, String> {
    @Override
    List<NhaSanXuat> findAll();

    NhaSanXuat findNhaSanXuatById(String id);


}
