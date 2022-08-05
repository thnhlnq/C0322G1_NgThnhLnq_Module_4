package com.example.repository.contract;

import com.example.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value = "select * from contract where customers like :nameFind or facilities like :nameFind", nativeQuery = true)
    Page<Contract> findAll(Pageable pageable, @Param("nameFind") String nameFind);
}
