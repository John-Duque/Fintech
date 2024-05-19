package com.fintech.domain.credit;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreditDTO(
        @NotBlank(message = "Name is mandatory")
        @Size(min = 3, max = 100, message = "Name must be between 2 and 100 characters")
        String name,

        @NotNull(message = "Loan amount is mandatory")
        @Min(value = 1, message = "Loan amount must be greater than zero")
        Double loanAmount,
        @NotNull(message = "Monthly income is mandatory")
        @Min(value = 1, message = "Monthly income must be greater than zero")
        Double monthlyIncome) {
}
