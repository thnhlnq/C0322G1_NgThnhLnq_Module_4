package com.phone.repository;

import com.phone.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartphoneRepository extends JpaRepository<Smartphone, Integer> {
}
