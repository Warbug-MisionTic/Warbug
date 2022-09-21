package com.misiontic.warbug.models;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "employee")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;

    @Column(length = 50, nullable = true, unique = false)
    private String email;

    @Column(length = 50, nullable = true, unique = false)
    private String name;

    @Transient
    private String passwordConfirm;


    private String username;
    @Column(length = 50, nullable = true)
    @ManyToMany
    private Set<Role> role;

    @Column(length = 50, nullable = true)
    private String phone;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "fk_enterprise_id",nullable = true)
    private Enterprise enterprise;

    @Column(length = 500, nullable = true)
    private String password;


}
