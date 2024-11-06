package com.emi.emi_api.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {

    @NotNull
    @Min(value = 0, message = "Loan value must be a positive number.") 
    private double loanValue;

    @NotNull
    @Max(value = 100, message = "Interest rate cannot be more than 100.")
    @Min(value = 0, message = "Interest rate must be positive.")
    private double yearlyInterestRate;

    @NotNull
    @Max(value = 30, message = "Loan term cannot exceed 30 years.")
    @Min(value = 0, message = "Loan term must be positive.")
    private int loanTerm;

}
