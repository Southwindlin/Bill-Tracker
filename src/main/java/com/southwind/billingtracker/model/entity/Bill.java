package com.southwind.billingtracker.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "bill")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    private String type;

    private LocalDate date;
}