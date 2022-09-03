package com.misiontic.warbug.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "employee")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false)
    private Enum_RoleName role;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //Inyección de dependencias
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_enterprise_id",nullable = false)
    @JsonBackReference

    private Enterprise enterprise;

    //private List<Transaction> transactions;

    //@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    //private Profile profile;




}
