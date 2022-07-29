package com.phone.service;

import com.phone.model.Smartphone;

import java.util.Optional;

public interface ISmartphoneService {

    Iterable<Smartphone> findAll();

    Optional<Smartphone> findById(Integer id);

    Smartphone save(Smartphone smartPhone);

    void remove(Integer id);
}
