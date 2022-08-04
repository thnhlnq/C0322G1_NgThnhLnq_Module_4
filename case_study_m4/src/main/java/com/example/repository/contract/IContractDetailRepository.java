package com.example.repository.contract;

import com.example.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
}
