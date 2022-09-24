package com.misiontic.warbug.models;

import lombok.Data;

@Data
public class EmployeeProfile {
    private Long id;
    private String name;
    private String email;
    private String phone;
}
