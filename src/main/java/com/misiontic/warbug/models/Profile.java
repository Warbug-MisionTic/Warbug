package com.misiontic.warbug.models;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@RequiredArgsConstructor
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

 @OneToOne()
 @JoinColumn(name = "fk_employee_id",nullable = false)
 private Employee employee;

 private LocalDateTime createdAt = LocalDateTime.now();

 private LocalDateTime updatedAt;

 public Long getIdProfile() {
  return idProfile;
 }

 public String getImage() {
  return image;
 }

 public String getPhone() {
  return phone;
 }

 public Employee getEmployee() {
  return employee;
 }

 public LocalDateTime getCreatedAt() {
  return createdAt;
 }

 public LocalDateTime getUpdatedAt() {
  return updatedAt;
 }
}
