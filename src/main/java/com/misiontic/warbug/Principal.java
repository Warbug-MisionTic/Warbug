package com.misiontic.warbug;

import com.misiontic.warbug.models.Empresa;

public class Principal {
    public static void main(String[] args) {
        /*
        Se crea la instancia para el objeto de la clase Empresa
         */
        Empresa empresaInicial = new Empresa("Carvajal S.A.","Cl 27#23-34, Cali, Valle del cauca",1234567890l,"111110-1");
        System.out.println(empresaInicial);

        /*
        Se crea instancia para leer y modificar nombre Empresa
        */
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


    }
}
