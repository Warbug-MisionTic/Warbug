package com.misiontic.warbug.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class Enterprise {
    private Long idEnterprise;
    private String name;
    private String document;
    private String phone;
    private String address;
    private List<Employee> employee;
    private List<Transaction> transactions;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
