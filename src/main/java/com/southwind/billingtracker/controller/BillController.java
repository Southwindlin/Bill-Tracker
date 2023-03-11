package com.southwind.billingtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.southwind.billingtracker.model.entity.Bill;
import com.southwind.billingtracker.repository.api.BillRepository;

@RestController
@RequestMapping("/bills")
public class BillController {

    @Autowired
    private BillRepository billRepository;

    @GetMapping
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Bill> addBill(@RequestBody Bill bill) {
        Bill newBill = billRepository.save(bill);
        return new ResponseEntity<>(newBill, HttpStatus.CREATED);
    }

}