package com.example.repository.facility;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IFacilityRepository extends JpaRepository<Facility, Integer> {

    @Query(value = "select * from facility where name like :nameFind", nativeQuery = true)
    Page<Facility> findAll(Pageable pageable, @Param("nameFind") String nameFind);
}
