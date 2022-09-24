package com.example.service;

import com.example.model.TinTuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ITinTucService {

    Page<TinTuc> findAll(Pageable pageable, String nameFind);

    void save(TinTuc customer);

    Optional<TinTuc> findById(int id);

    void delete(int id);
}
