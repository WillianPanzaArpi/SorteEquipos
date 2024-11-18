/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sorteoequipos.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Willian
 */
public class EtapaTorneo {

    private String nombreEtapa;
    private ArrayList<Equipo> equipo;

    public EtapaTorneo() {
    }

    public EtapaTorneo(String nombreEtapa, ArrayList<Equipo> equipo) {
        this.nombreEtapa = nombreEtapa;
        this.equipo = equipo;
    }

    public String getNombreEtapa() {
        return nombreEtapa;
    }

    public void setNombreEtapa(String nombreEtapa) {
        this.nombreEtapa = nombreEtapa;
    }

    public void etapaTorneo(String nombEtapa, int etapaNum) {
        nombreEtapa = nombEtapa;
        registrarEquipo(etapaNum);
        emparejarEquipos(equipo);
    }

    public ArrayList<Equipo> getEquipo() {
        return equipo;
    }

    public void setEquipo(ArrayList<Equipo> equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "EtapaTorneo{" + "nombreEtapa=" + nombreEtapa + ", equipo=" + equipo + '}';
    }

    public ArrayList<Equipo> registrarEquipo(int etapaNum) {
        equipo = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        List<Equipo> equipos = new ArrayList<>();

        System.out.println("Ingrese los nombres de los "+etapaNum+" equipos:");
        for (int i = 0; i < etapaNum; i++) {
            System.out.print("Equipo " + (i + 1) + ": ");
            String nombreEquipo = scanner.nextLine();
            equipos.add(new Equipo(nombreEquipo));
        }
        System.out.println("");
        System.out.println("Nombre de los equipos");
        for (Equipo e : equipos) {
            System.out.println(e);
        }
        
        scanner.close();

        return equipo = (ArrayList<Equipo>) equipos;
    }

    public void emparejarEquipos(ArrayList listEquipo) {

        ArrayList<Equipo> listaEquiGanadores = new ArrayList<>();
        if (nombreEtapa.equals("Octavos") || nombreEtapa.equals("Cuartos")|| nombreEtapa.equals("Semifinal")|| nombreEtapa.equals("Final")) {
            //baraja o mezcla los equipos
            Collections.shuffle(listEquipo);
            Random ramdom = new Random();

            System.out.println("");
            System.out.println("Emparejamientos:" + nombreEtapa);
            
            //Realiza el vs de equipos
            for (int i = 0; i < listEquipo.size(); i += 2) {
                Equipo equi1 = (Equipo) listEquipo.get(i);
                Equipo equi2 = (Equipo) listEquipo.get(i + 1);

                //Selecciona el ganador aleatoreamente.
                Equipo ganador = ramdom.nextBoolean() ? equi1 : equi2;
                System.out.println(equi1 + " vs " + equi2 + " - Ganador: " + ganador);
                listaEquiGanadores.add(ganador);
            }

        }
        
        //Nombre de las etapas segun se clasifica. 
        if(nombreEtapa.equals("Octavos")){
            nombreEtapa = "Cuartos";
            emparejarEquipos(listaEquiGanadores); 
        }else if(nombreEtapa.equals("Cuartos")){
            nombreEtapa = "Semifinal";
            emparejarEquipos(listaEquiGanadores); 
        }else if(nombreEtapa.equals("Semifinal")){
            nombreEtapa = "Final";
            emparejarEquipos(listaEquiGanadores); 
        }else if(nombreEtapa.equals("Semifinal")){
            nombreEtapa = "Final";
            emparejarEquipos(listaEquiGanadores); 
        }
    }

}
