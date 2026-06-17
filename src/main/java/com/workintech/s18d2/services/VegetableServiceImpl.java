package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.VegetableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VegetableServiceImpl implements VegetableService {

    private final VegetableRepository vegetableRepository;

    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> findAll() {
        return vegetableRepository.findAll();
    }

    @Override
    public Vegetable findById(Long id) {
        if (id < 0) {
            throw new PlantException("Id 0'dan küçük olamaz.");
        }

        return vegetableRepository.findById(id)
                .orElseThrow(() -> new PlantException("Vegetable bulunamadı."));
    }

    @Override
    public List<Vegetable> findAllAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> findAllDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public List<Vegetable> findByName(String name) {
        return vegetableRepository.searchByName(name);
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public void delete(Long id) {
        vegetableRepository.deleteById(id);
    }
}