package models;

import interfaces.AccionSanitario;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sanitario extends Persona implements AccionSanitario {
    private String grado;
    private String especialidad;
    private int anosExperiencia;

    public Sanitario(String DNI, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, String grado, String especialidad, int anosExperiencia) {
        super(DNI, nombre, apellido1, apellido2, fechaNacimiento);
        this.grado = grado;
        this.especialidad = especialidad;
        this.anosExperiencia = anosExperiencia;
    }

    @Override
    public String toString() {
        return "Sanitario{" +
                "nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", grado='" + grado + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", anosExperiencia=" + anosExperiencia +
                '}';
    }

    @Override
    public void vacunar() {

    }

    @Override
    public void vacunar(ArrayList<Persona> personas) {

    }

    @Override
    public void hacerOperacion() {

    }

    @Override
    public void hacerOperacion(ArrayList<Persona> personas) {

    }

    public void testCovid() {
        System.out.println("Ara te vamos a hacer la prueba");
        int prob = (int) (Math.random()*10);
        if (prob > 5){
            System.out.println("Confinado 7 dias, mucha agua i paracetamol cada 8 horas ");
        }else{
            System.out.println("Eres negativo, es un constipado.");
        }
    }
}
