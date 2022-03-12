package com.company;

import jdk.jshell.execution.Util;
import models.*;
import org.w3c.dom.html.HTMLOptGroupElement;
import utilitats.Utilities;

import java.util.ArrayList;

public class Main {
    final static String GREEN = "\033[32m";
    final static String RED = "\033[31m";
    final static String YELLOW = "\033[33m";
    final static String BLACK = "\033[30m";
    final static String BLUE = "\033[34m";
    final static String PURPLE = "\033[35m";
    final static String CYAN = "\033[36m";
    final static String WHITE = "\033[37m";
    final static String RESET = "\u001B[0m";
    final static String MENUPACIENTE = "Elije un opcion: " +
            "\n\t1.Pedir cita " +
            "\n\t2.Vacuna Covid" +
            "\n\t3.Test Covid" +
            "\n\t4.Salir";

    final static String MENUSANITARIO ="Elige una de las opciones :" +
            "\t\n1.Crear nueva persona" +
            "\t\n2.Eliminar datos de la persona" +
            "\t\n3.Modificar datos de la persona" +
            "\t\n4.Vacunar" +
            "\t\n5.Hacer operacion" +
            "\t\n6.Test Covid" +
            "\t\n7.Salir";

    public static void main(String[] args) {
        inici();
    }
       public static void inici(){
        ArrayList<Persona> personas = Hospital.initPersonas();
        ArrayList<Hospital> hospitales = initHospital();
        System.out.println("\tBienvinid@ al programa!");

        Hospital hospital = elegirHosp(hospitales);

        int indexPersona;
           System.out.println(hospital.getNombreHospital());
        Hospital.imprimirPersonas(personas);
        Persona persona = null;
        String registroPersona = Utilities.llegirFrase("Estas registrado?");
        if (registroPersona.equalsIgnoreCase("si")) {
            indexPersona = Utilities.llegirInt("Elige la persona :", 0, personas.size() - 1);
         persona = elegirPersona(personas,indexPersona);
        } else if (registroPersona.equalsIgnoreCase("no")) {
             persona = Hospital.crearPersona(personas);
        }


        if (persona instanceof Paciente) {

            /*menuPaciente(opcio, personas, persona);*/
        } else if (persona instanceof Sanitario) {
            menuSanitario( personas, persona);
        }

    }

    /*public static void menuPaciente(int opcio, ArrayList<Persona> persones, Persona persona) {
       int opcio;
        boolean validacio = false;
        do {
            opcio = Utilities.llegirInt(MENUPACIENTE, 1, 4);
            switch (opcio) {
                case 1:
                    persona.pedirCita();
                    break;
                case 2:
                    persona.vacuna();
                    break;
                case 3:
                    persona.testCovid();
                    break;
                case 4:
                    //seleccionarPersona();
                    //odificarPersona();
                    break;
                case 5:
                    //citaPrevia();
                    break;
                case 6:
                    //vacunar();
                    break;
                case 7:
                    //testCovid();
                    break;
                case 8:
                    System.out.println("Adeuuu.....");
                    validacio = true;
                    break;

            }
        } while (!validacio);
    }*/
    public static void menuSanitario( ArrayList<Persona> personas, Persona persona) {
       int opcio;
        do {
            opcio = Utilities.llegirInt(YELLOW+MENUSANITARIO+RESET, 1, 7);
                switch (opcio) {
                    case 1:
                        Hospital.crearPersona(personas);
                        System.out.println(personas);
                        break;
                    case 2:
                        Hospital.eliminarPersona(personas);
                        break;
                    case 3:
                        Hospital.modificarPersona(personas);
                        break;
                    case 4:
                        if (persona instanceof Doctor) {
                            ((Doctor) persona).vacunar();
                        }else if (persona instanceof Enfermera){
                            ((Enfermera) persona).vacunar();
                        }else if(persona instanceof Pasante){
                            ((Pasante) persona).vacunar(personas);
                        }
                        break;
                    case 5:
                        if (persona instanceof Doctor) {
                            ((Doctor) persona).hacerOperacion();
                        }else if (persona instanceof Enfermera){
                            ((Enfermera) persona).hacerOperacion();
                        }else if(persona instanceof Pasante){
                            ((Pasante) persona).hacerOperacion(personas);
                        }
                        break;
                    case 6:
                        if (persona instanceof Sanitario) {
                            ((Sanitario) persona).testCovid();
                        }
                        break;
                    case 7:
                        System.out.println("Saliendo...");
                        inici();
                        break;
                   }
            } while (opcio != 7);
    }

    public static Persona elegirPersona( ArrayList<Persona> personas, int indexPersona) {
      return personas.get(indexPersona);

    }
    public static ArrayList<Hospital> initHospital(){
        ArrayList <Hospital> hospital = new ArrayList<Hospital>();
        hospital.add(new Hospital("Hospital del Mar","C.del Mar",false));
        hospital.add(new Hospital("Sant Pau dos de maig","C.Sant pau",true));
        hospital.add(new Hospital("Sant Joan d'espi","Plaza Pedro",false));
        return hospital;
    }
    public static Hospital elegirHosp(ArrayList<Hospital> hospitales){
       int selecHosp=0;

        for (int i = 0; i < hospitales.size(); i++) {
            System.out.println(CYAN+i + "->" + hospitales.get(i));
        }
        selecHosp=Utilities.llegirInt("Elije un hospital:"+RESET,0,hospitales.size());
        return hospitales.get(selecHosp);
    }
}
