package com.misiontic.warbug.models;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "enterprise")

public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnterprise;

    @Column(length = 50, nullable = true)
    private String name;

    @Column(length = 50, nullable = true , unique = true)
    private String email;

    @Column(length = 50 , nullable = true)
    private String document;

    @Column(length = 50, nullable = true)
    private String phone;

    @Column(length = 50, nullable = true)
    private String address;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;
}
