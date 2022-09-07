package com.misiontic.warbug.models;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@RequiredArgsConstructor
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

    public Long getIdEmployee() {
        return idEmployee;
    }

    public String getEmail() {
        return email;
    }

    public Enum_RoleName getRole() {
        return role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Profile getProfile() {
        return profile;
    }

    public String getPassword() {
        return password;
    }
}
