package com.misiontic.warbug.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Profile {
 private String idProfile;
 private String image;
 private String phone;
 private Employee user;
 private LocalDateTime createdAt;
 private LocalDateTime updatedAt;



}
