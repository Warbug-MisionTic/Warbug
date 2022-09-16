package com.misiontic.warbug.models;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "employee")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false, unique = false)
    private String name;

    @Column(length = 50, nullable = false)
    private Enum_RoleName role;



    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "fk_enterprise_id",nullable = false)
    private Enterprise enterprise;

    @Column(length = 50, nullable = false)
    private String password;
}
