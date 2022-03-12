package models;

import interfaces.AccionSanitario;
import utilitats.Utilities;

import java.time.LocalDate;
import java.util.ArrayList;

public class Enfermera extends Sanitario implements AccionSanitario {
    private float salario;
    private String zona;
    private int planta;

    public Enfermera(String DNI, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, String grado, String especialidad, int anosExperiencia, float salario, String zona,int planta) {
        super(DNI, nombre, apellido1, apellido2, fechaNacimiento, grado, especialidad, anosExperiencia);
        this.salario = salario;
        this.zona = zona;
        this.planta=planta;
    }

    @Override
    public void vacunar() {
       int opcio = Utilities.llegirInt("Que vacuna quieres: " +
                            "\t\n1.Pfizer" +
                            "\t\n2.Moderna" +
                            "\t\n3.Johnson",1,3);
        switch (opcio){
            case 1:
                String dosis = Utilities.llegirFrase("Es la teva primera dosis");
                if (dosis.equalsIgnoreCase("si")){
                    System.out.println("Estas vacunat,Torna dins de 15 dies ");
                }else if (dosis.equalsIgnoreCase("no")){
                    System.out.println("Ja tens les dues dosis...");
                }

                break;
            case 2:
                String dosisMod = Utilities.llegirFrase("Es la teva primera dosis");
                if (dosisMod.equalsIgnoreCase("si")){
                    System.out.println("Estas vacunat,Torna dins de 30 dies ");
                }else if (dosisMod.equalsIgnoreCase("no")){
                    System.out.println("Ja tens les dues dosis...");
                }
                break;
            case 3:
                System.out.println("Estas vacunat");
                break;
        }
    }

    @Override
    public void vacunar(ArrayList<Persona> personas) {

    }


    @Override
    public void hacerOperacion() {

    }

    @Override
    public void hacerOperacion(ArrayList<Persona> personas) {
        System.out.println("Yo no opero, pero te voy a preparar para la operacion");
    }


    public void testCovid() {
        System.out.println("Ara te vamos a hacer la prueba");
        int prob = (int) (Math.random() * 10);
        if (prob > 5) {
            System.out.println("Confinado 7 dias, mucha agua i paracetamol cada 8 horas ");
        } else {
            System.out.println("Eres negativo, es un constipado.");
        }
    }
}
