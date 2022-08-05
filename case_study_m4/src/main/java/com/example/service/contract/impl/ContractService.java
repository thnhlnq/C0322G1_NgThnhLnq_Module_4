package com.example.service.contract.impl;

import com.example.model.contract.Contract;
import com.example.repository.contract.IContractRepository;
import com.example.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {

    @Autowired
    IContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable, String nameFind) {
        return contractRepository.findAll(pageable, "%" + nameFind + "%");
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }
}
