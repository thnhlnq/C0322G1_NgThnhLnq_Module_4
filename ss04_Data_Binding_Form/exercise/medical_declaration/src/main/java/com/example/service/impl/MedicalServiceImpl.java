package com.example.service.impl;

import com.example.model.Medical;
import com.example.repository.MedicalRepository;
import com.example.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalServiceImpl implements MedicalService {

    @Autowired
    MedicalRepository medicalRepository;

    @Override
    public List<Medical> medicals() {
        return medicalRepository.medicals();
    }

    @Override
    public List<String> births() {
        return medicalRepository.births();
    }

    @Override
    public List<String> genders() {
        return medicalRepository.genders();
    }

    @Override
    public List<String> nationalities() {
        return medicalRepository.nationalities();
    }

    @Override
    public List<String> travels() {
        return medicalRepository.travels();
    }

    @Override
    public List<String> startDay() {
        return medicalRepository.startDay();
    }

    @Override
    public List<String> startMonth() {
        return medicalRepository.startMonth();
    }

    @Override
    public List<String> startYear() {
        return medicalRepository.startYear();
    }

    @Override
    public List<String> endDay() {
        return medicalRepository.endDay();
    }

    @Override
    public List<String> endMonth() {
        return medicalRepository.endMonth();
    }

    @Override
    public List<String> endYear() {
        return medicalRepository.endYear();
    }

    @Override
    public Medical findByIdCard(String idCard) {
        return medicalRepository.findByIdCard(idCard);
    }

    @Override
    public void edit(String idCard, Medical medical) {
        medicalRepository.edit(idCard, medical);
    }

    @Override
    public void save(Medical medical) {
        medicalRepository.save(medical);
    }
}
