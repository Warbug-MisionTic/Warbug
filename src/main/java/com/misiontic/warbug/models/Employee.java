package com.misiontic.warbug.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Employee {
    private Long id;
    private String email;
    private Profile profile;
    private Enum_RoleName role;
    private Enterprise enterprise;
    private List<Transaction> transactions;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
