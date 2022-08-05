package com.example.service.facility.impl;

import com.example.model.facility.Facility;
import com.example.repository.facility.IFacilityRepository;
import com.example.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findAll(Pageable pageable, String nameFind) {
        return facilityRepository.findAll(pageable, "%" + nameFind + "%");
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public Optional<Facility> findById(int id) {
        return facilityRepository.findById(id);
    }

    @Override
    public void edit(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void delete(int id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }
}
