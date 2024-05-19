package com.fintech.domain.credit;

public record CreditReturnDTO(Long id, String name, Double loanAmount, Double monthlyIncome ) {
    public CreditReturnDTO(Credit credit){
        this(credit.getId(), credit.getName(), credit.getLoanAmount(), credit.getMonthlyIncome());
    }
}
