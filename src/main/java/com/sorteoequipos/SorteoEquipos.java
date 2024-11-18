/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.sorteoequipos;

import com.sorteoequipos.exception.CustomException;
import com.sorteoequipos.exception.CustomHelp;
import com.sorteoequipos.modelo.EtapaTorneo;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Willian
 */
public class SorteoEquipos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EtapaTorneo et = new EtapaTorneo();
        boolean esValido = false;
        int numero = 0;
        String opcion = null;
        int numberOpcion = 0; 
        CustomHelp validaciones = new CustomHelp();
        
        while (!esValido) {
            System.out.println("");
            System.out.println("1. Octavos de final: ");
            System.out.println("2. Cuartos de final: ");
            System.out.println("3. Semifinal: ");
            System.out.println("4. Final: ");
            System.out.println("");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextLine();
            
            try {
                numberOpcion = Integer.parseInt(opcion);
                esValido = validaciones.validarNumeros(numero, esValido); 
            } catch (Exception e) {
                System.out.println("Ingrese solo numeros"+e.getMessage());
            }
        }

        switch (numberOpcion) {
            case 1:
                System.out.println("Octavos de final");
                //Inicializa el metodo con la etapa y el numero de jugadores
                et.etapaTorneo("Octavos", 16);
                break;
            case 2:
                System.out.println("Cuartos de final");
                et.etapaTorneo("Cuartos", 8);
                break;
            case 3:
                System.out.println("Semifinal");
                et.etapaTorneo("Semifinal", 4);
                break;
            case 4:
                System.out.println("Final");
                et.etapaTorneo("Final", 2);
                break;
            default:
                System.out.println("Opción no válida");

        }
        scanner.close();
    }
}
