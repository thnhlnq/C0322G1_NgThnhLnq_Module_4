package com.example.repository.contract;

import com.example.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {
}
