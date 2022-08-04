package com.example.service.facility;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {

    Page<Facility> findAll(Pageable pageable);

    void save(Facility facility);

    Optional<Facility> findById(int id);

    void edit(Facility facility);

    void delete(int id);

    Page<Facility> findByName(String nameFind, Pageable pageable);

    List<Facility> findAll();
}
