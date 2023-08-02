package com.example.demo.service;

import com.example.demo.model.MauSac;

import java.util.List;

public interface IMauSacService {

    List<MauSac> findAll();

    void add(MauSac mauSac);

    void update(MauSac mauSac);

    void delete(String id);

    MauSac findMauSacById(String id);


}
