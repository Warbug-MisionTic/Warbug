package com.misiontic.warbug;

import com.misiontic.warbug.models.Empleado;
import com.misiontic.warbug.models.Empresa;

public class Principal {
    public static void main(String[] args) {

        //Se crea la instancia para el objeto de la clase Empresa
        System.out.println("----------------Modelar una empresa como una clase de java-------------------");
        Empresa empresaInicial = new Empresa("Carvajal S.A.","Cl 27#23-34, Cali, Valle del cauca",1234567890l,"111110-1");
        System.out.println(empresaInicial);

        //Se crea instancia para leer y modificar nombre Empresa

        empresaInicial.setNombreEmpresa("Warbug");
        System.out.println(empresaInicial.getNombreEmpresa());

        //Se crea la instancia para leer y modificar direccion empresa
        empresaInicial.setDireccionEmpresa("Cl 58 #12-12");
        System.out.println(empresaInicial.getDireccionEmpresa());

        //Se crea la instancia para leer y modificar telefono de la empresa
        empresaInicial.setTelefonoEmpresa(3183567212l);
        System.out.println(empresaInicial.getTelefonoEmpresa());

        //Se crea la instancia para leer y modificar el NIT de la empresa
        empresaInicial.setNitEmpresa("1113678321-1");
        System.out.println(empresaInicial.getNitEmpresa());

        //------------------------------------------------------------------
        //Modelar un empleado como una clase de java
        Empleado empleado = new Empleado("Mauricio", "mauro.h54@elcorreo.com", "Warbug", "Cajero");
        System.out.println("----------------Modelar un empleado como una clase de java-------------------");

        System.out.println("1. Es posible crear una nueva instancia de la clase Empleado");
        System.out.println(empleado);

        System.out.println("2. Es posible leer y modificar el nombre del Empleado");
        empleado.setNombreEmpleado("Glenda Trivino");
        System.out.println(empleado.getNombreEmpleado());

        System.out.println("3. Es posible leer y modificar la empresaa a la que pertenece el Empleado");
        empleado.setEmpresaEmpleado("Microsoft");
        System.out.println(empleado.getEmpresaEmpleado());

    }
}
