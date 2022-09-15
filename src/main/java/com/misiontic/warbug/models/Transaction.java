package com.misiontic.warbug.models;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
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

    @ManyToOne()
    @JoinColumn(name = "fk_employee_id",nullable = false)
    private Employee employee;

    @ManyToOne()
    @JoinColumn(name = "fk_enterprise_id",nullable = false)
    private Enterprise enterprise;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;
}
