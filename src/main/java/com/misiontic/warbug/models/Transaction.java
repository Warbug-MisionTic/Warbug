package com.misiontic.warbug.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Transaction {
    private Long idTransaction;
    private String concept;
    private float amount;
    private Enterprise enterprise;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
