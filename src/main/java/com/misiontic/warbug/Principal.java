package com.misiontic.warbug;

public class Principal {
    public static void main(String[] args) {

        //Modelar una empresa como una clase de Java
        //Se crea la instancia para el objeto de la clase Empresa
        System.out.println("----------------Modelar una empresa como una clase de java-------------------");
        Empresa empresaInicial = new Empresa("Carvajal S.A.","Cl 27#23-34, Cali, Valle del cauca",1234567890L,"111110-1");
        System.out.println(empresaInicial);

        //Se crea instancia para leer y modificar nombre Empresa
        empresaInicial.setNombreEmpresa("Warbug");
        System.out.println(empresaInicial.getNombreEmpresa());

        //Se crea la instancia para leer y modificar direccion empresa
        empresaInicial.setDireccionEmpresa("Cl 58 #12-12");
        System.out.println(empresaInicial.getDireccionEmpresa());

        //Se crea la instancia para leer y modificar telefono de la empresa
        empresaInicial.setTelefonoEmpresa(318356721L);
        System.out.println(empresaInicial.getTelefonoEmpresa());

        //Se crea la instancia para leer y modificar el NIT de la empresa
        empresaInicial.setNitEmpresa("1113678321-1");
        System.out.println(empresaInicial.getNitEmpresa());

        //-----------------------------------------------------------------
        //Modelar un empleado como una clase de java
        //Se crea la instancia para el objeto de la clase empleado
        Empleado empleado = new Empleado("Mauricio", "mauro.h54@elcorreo.com", "Warbug", "Cajero");

        //1. Es posible crear una nueva instancia de la clase Empleado
        System.out.println(empleado);

        //2. Es posible leer y modificar el nombre del Empleado
        empleado.setNombreEmpleado("Glenda Trivino");
        System.out.println(empleado.getNombreEmpleado());

        //3. Es posible leer y modificar el correo del Empleado"
        empleado.setCorreoEmpleado("glendatrivino@yahoo.es");
        System.out.println(empleado.getCorreoEmpleado());

        //4. Es posible leer y modificar la empresaa a la que pertenece el Empleado
        empleado.setEmpresaEmpleado("Microsoft");
        System.out.println(empleado.getEmpresaEmpleado());

        //5. Es posible leer y modificar el rol del Empleado
        empleado.setRolEmpleado("Administrador");
        System.out.println(empleado.getRolEmpleado());

        //---------------------------------------------------------------------------------------------
        //Modelar el movimiento de dinero como una clase de java
        //Se crea la instancia para el objeto de la clase MovimientoDinero
        MovimientoDinero movimiento = new MovimientoDinero(45456,5454,-654465,"Ingreso","");
        System.out.println(movimiento);

        //Es posible leer y modificar el monto del movimiento
        movimiento.setMontoMovimiento(1574);
        System.out.println("Es posible leer y modificar el monto del movimiento");
        System.out.println(movimiento.getMontoMovimiento());

        //Es posible crear montos positivos y negativos
        movimiento.setMontoPositivo(98765);
        movimiento.setMontoNegativo(-31245);
        System.out.println("Es posible crear montos positivos y negativos");
        System.out.println(movimiento.getMontoPositivo());
        System.out.println(movimiento.getMontoNegativo());

        //Es posible leer y modificar el concepto del movimiento
        System.out.println("Es posible leer y modificar el concepto del movimiento");
        System.out.println(movimiento.getConceptoMovimiento());
        movimiento.setConceptoMovimiento("Gastos administrativos");
        System.out.println(movimiento.getConceptoMovimiento());

        //Es posible definir que usuario fue encargado de registrar el movimiento
        System.out.println("Es posible definir que usuario registro el movimiento");
        movimiento.setUsuarioEncargado("Juan Diego Jimenez");
        System.out.println(movimiento.getUsuarioEncargado());
    }
}
