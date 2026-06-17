package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableService {

    List<Vegetable> findAll();

    Vegetable findById(Long id);

    List<Vegetable> findAllAsc();

    List<Vegetable> findAllDesc();

    List<Vegetable> findByName(String name);

    Vegetable save(Vegetable vegetable);

    void delete(Long id);
}