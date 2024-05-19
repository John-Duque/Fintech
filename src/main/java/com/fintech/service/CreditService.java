package com.fintech.service;

import com.fintech.domain.credit.Credit;
import com.fintech.domain.credit.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditService {

    @Autowired
    private CreditRepository repository;

    public Credit save(Credit credit){
        return repository.save(credit);
    }
}
