package com.southwind.billingtracker.repository.api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.southwind.billingtracker.model.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findAll();
    Bill save(Bill bill);
}
