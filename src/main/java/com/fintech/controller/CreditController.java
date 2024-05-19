package com.fintech.controller;

import com.fintech.domain.credit.Credit;
import com.fintech.domain.credit.CreditDTO;
import com.fintech.domain.credit.CreditReturnDTO;
import com.fintech.service.CreditService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/credits")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @PostMapping
    @Transactional
    public ResponseEntity<CreditReturnDTO> save(@RequestBody @Valid CreditDTO creditDTO) {
        Credit credit = new Credit(creditDTO);
        creditService.save(credit);
        return ResponseEntity.ok(new CreditReturnDTO(credit));
    }
}
