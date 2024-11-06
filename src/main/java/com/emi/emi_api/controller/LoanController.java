package com.emi.emi_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emi.emi_api.model.Loan;
import com.emi.emi_api.service.LoanService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/calculate-emi")
    public ResponseEntity<Double> calculateEmi(@Valid @RequestBody Loan loanRequest) {
        double emi = loanService.calculateEmi(loanRequest);
        return ResponseEntity.ok(emi);
    }
}
