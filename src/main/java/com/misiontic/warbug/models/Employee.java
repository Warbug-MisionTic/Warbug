package com.misiontic.warbug.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference(value = "enterprise-trans")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_enterprise_id",nullable = false)
    private Enterprise enterprise;

    @JsonManagedReference(value = "employee-trans")
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;

    @JsonManagedReference(value = "profile-trans")
    @OneToOne(mappedBy="employee",fetch = FetchType.LAZY)
    private Profile profile;

    @Column(length = 50, nullable = false)
    private String password;
}
