package com.misiontic.warbug.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    //Inyección de dependencias
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_enterprise_id",nullable = false)
    private Enterprise enterprise;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;


    @OneToOne(mappedBy="employee",fetch = FetchType.LAZY)
    private Profile profile;

    @Column(length = 50, nullable = false)
    private String password;
}
