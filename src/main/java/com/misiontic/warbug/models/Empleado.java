package com.misiontic.warbug.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Empleado {
    private String nombreEmpleado;
    private String correoEmpleado;
    private String empresaEmpleado;
    private String rolEmpleado;

}
