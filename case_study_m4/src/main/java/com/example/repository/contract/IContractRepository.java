package com.example.repository.contract;

import com.example.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IContractRepository extends JpaRepository<Contract, Integer> {
}
