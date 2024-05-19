package com.fintech.domain.credit;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "credits")
@Entity(name = "Credit")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double loanAmount;
    private Double monthlyIncome;

    public Credit(CreditDTO creditDTO){
        this.name = creditDTO.name();
        this.loanAmount = creditDTO.loanAmount();
        this.monthlyIncome = creditDTO.monthlyIncome();
    }

}
