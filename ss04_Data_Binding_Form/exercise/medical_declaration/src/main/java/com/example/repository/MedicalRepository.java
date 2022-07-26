package com.example.repository;

import com.example.model.Medical;

import java.util.List;

public interface MedicalRepository {

    List<Medical> medicals();

    List<String> births();

    List<String> genders();

    List<String> nationalities();

    List<String> travels();

    List<String> startDay();

    List<String> startMonth();

    List<String> startYear();

    List<String> endDay();

    List<String> endMonth();

    List<String> endYear();

    Medical findByIdCard(String idCard);

    void edit(String idCard, Medical medical);

    void save(Medical medical);
}
