package com.misiontic.warbug.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "profile")


public class Profile {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long idProfile;

 @Column(length = 50, nullable = false, unique = true)
 private String image;

 @Column(length = 50, nullable = false, unique = true)
 private String phone;

 @JsonBackReference
 @OneToOne()
 @JoinColumn(name = "fk_employee_id",nullable = false)
 private Employee employee;

 private LocalDateTime createdAt = LocalDateTime.now();

 private LocalDateTime updatedAt;

}
