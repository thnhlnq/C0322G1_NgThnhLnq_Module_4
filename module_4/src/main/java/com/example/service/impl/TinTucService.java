package com.example.service.impl;

import com.example.model.TinTuc;
import com.example.repository.ITinTucRepository;
import com.example.service.ITinTucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TinTucService implements ITinTucService {

    @Autowired
    ITinTucRepository tinTucRepository;

    @Override
    public Page<TinTuc> findAll(Pageable pageable, String nameFind) {
        return tinTucRepository.findAll(pageable, "%" + nameFind + "%");
    }

    @Override
    public void save(TinTuc tinTuc) {
        tinTucRepository.save(tinTuc);
    }

    @Override
    public Optional<TinTuc> findById(int id) {
        return tinTucRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        tinTucRepository.deleteById(id);
    }
}
