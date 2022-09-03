package com.misiontic.warbug.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "employee")
@JsonIgnoreProperties({"idEnterprise"})
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
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Employee.class)
    @JoinColumn(name = "idEnterprise")
    private Enterprise enterprise;

    //private List<Transaction> transactions;

    //@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Profile profile;




}
