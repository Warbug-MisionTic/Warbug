package com.misiontic.warbug.models;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@RequiredArgsConstructor
@Entity
@Table (name ="transaction")

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaction;

    @Column(length = 50, nullable = false)
    private String concept;

    @Column(length = 50, nullable = false)
    private float amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_employee_id",nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_enterprise_id",nullable = false)
    private Enterprise enterprise;


    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;

    public Long getIdTransaction() {
        return idTransaction;
    }

    public String getConcept() {
        return concept;
    }

    public float getAmount() {
        return amount;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
