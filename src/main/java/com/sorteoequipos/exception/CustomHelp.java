/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sorteoequipos.exception;

/**
 *
 * @author Willian
 */
public class CustomHelp {

    public CustomHelp() {
    }

    public void validarLetras(String nombreEquipo) throws CustomException {
        if (!nombreEquipo.matches("[a-zA-Z]+")) {
            throw new CustomException("Ingrese solo letras");
        }
    }

    public boolean validarNumeros(int numero, boolean valido) throws CustomException {
        if (numero >= 0 || numero <= 4) {
            valido = true; 
        }else{
            throw new CustomException("Ingrese valores dentro del rango 1 a 4");
        }
        return valido;
    }
}
