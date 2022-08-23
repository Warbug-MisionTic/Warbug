package com.misiontic.warbug.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class MovimientoDinero {
    private double montoMovimiento;
    private double montoPositivo;
    private double montoNegativo;
    private String conceptoMovimiento;

}
