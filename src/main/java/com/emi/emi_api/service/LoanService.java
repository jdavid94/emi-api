package com.emi.emi_api.service;

import org.springframework.stereotype.Service;

import com.emi.emi_api.model.Loan;
import com.emi.emi_api.utils.EmiFormat;

@Service
public class LoanService {

    

    public double calculateEmi(Loan loanRequest) {
        // Validate input values
        validateLoanInputs(loanRequest);

        double loanValue = loanRequest.getLoanValue();
        double annualInterestRate = loanRequest.getYearlyInterestRate();
        int years = loanRequest.getLoanTerm();            

        try { 
            // Convert annual rate to monthly and years to months
            double monthlyInterestRate = annualInterestRate / 12 / 100;
            int months = years * 12;

            // EMI calculation formula
            double emi = loanValue * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, months) /
                    (Math.pow(1 + monthlyInterestRate, months) - 1);

            return EmiFormat.roundToTwoDecimals(emi);
            
        } catch (ArithmeticException e) { 
            throw new IllegalArgumentException("Error during EMI calculation: " + e.getMessage()); 
        }
    }

    private void validateLoanInputs(Loan loanRequest) {
        if (loanRequest.getLoanValue() == 0 || loanRequest.getYearlyInterestRate() == 0 
        || loanRequest.getLoanTerm() == 0) {
            throw new IllegalArgumentException("Loan value, Interest rate, and Loan Term must have a value.");
        }
    }
}
