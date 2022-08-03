package com.example.repository.facility;

import com.example.model.facility.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IFacilityTypeRepository extends JpaRepository<FacilityType, Integer> {
}
