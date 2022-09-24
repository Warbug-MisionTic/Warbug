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

    @Column(length = 50,unique = true)
    private String username;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String role;

    @Column(length = 50)
    private String phone;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "fk_enterprise_id")
    private Enterprise enterprise;

    @Column(length = 200)
    private String password;
}
