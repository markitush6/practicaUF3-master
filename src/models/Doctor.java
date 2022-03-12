package models;

import interfaces.AccionSanitario;
import utilitats.Utilities;

import java.time.LocalDate;
import java.util.ArrayList;

public class Doctor extends Sanitario implements AccionSanitario {
    private boolean esJefe;
    private float salario;


    public Doctor(String DNI, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, String grado, String especialidad, int anosExperiencia, boolean esJefe, float salario) {
        super(DNI, nombre, apellido1, apellido2, fechaNacimiento, grado, especialidad, anosExperiencia);
        this.esJefe = esJefe;
        this.salario = salario;
    }


    @Override
    public void vacunar() {
        System.out.println("Yo no vacuno");
    }

    @Override
    public void vacunar(ArrayList<Persona> personas) {

    }

    @Override
    public void hacerOperacion() {
        int probabilidades = (int) (Math.random() * 100);
        if (probabilidades < 50) {
            System.out.println("El paciente a vivido");
        } else {
            System.out.println("El paciente ha muerto");
        }


    }

    @Override
    public void hacerOperacion(ArrayList<Persona> personas) {

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
