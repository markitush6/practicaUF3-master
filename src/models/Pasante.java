package models;

import com.company.Main;
import interfaces.AccionSanitario;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pasante extends Sanitario implements AccionSanitario {
    private String nombreUni;
    private char nivel;

    public Pasante(String DNI, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, String grado, String especialidad, int anosExperiencia, String nombreUni, char nivel) {
        super(DNI, nombre, apellido1, apellido2, fechaNacimiento, grado, especialidad, anosExperiencia);
        this.nombreUni = nombreUni;
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Pasante{" +
                "nombreUni='" + nombreUni + '\'' +
                ", nivel=" + nivel +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                '}';
    }

    @Override
    public void vacunar(ArrayList<Persona> personas) {
        System.out.println("Yo no puedo vacunar ara llamo a una enfermera");
        boolean validacio = false;
        do {
            int enfermera = (int) (Math.random()* personas.size());
             Persona persona = Main.elegirPersona(personas,enfermera);
            if (persona instanceof Enfermera){
                System.out.println(this.nombre+" es la enfermera que te vacunará");
                ((Enfermera) persona).vacunar();
                validacio = true;
            }
        }while(!validacio);
    }

    @Override
    public void hacerOperacion(ArrayList<Persona> personas) {
        System.out.println("Yo estoy aprenidendo, ara llamo a un doctor.");
        boolean validacio = false;
        do {
            int doctor = (int) (Math.random()* personas.size());
            Persona persona = Main.elegirPersona(personas,doctor);
            if (persona instanceof Doctor){
                System.out.println(this.nombre+" es la enfermera que te vacunará");
                ((Doctor) persona).hacerOperacion();
                validacio = true;
            }
        }while(!validacio);
    }

    

    @Override
    public void testCovid() {
        System.out.println("Ara te vamos a hacer la prueba");
        int prob = (int) (Math.random()*10);
        if (prob > 5){
            System.out.println("Confinado 7 dias, mucha agua i paracetamol cada 8 horas ");
        }else {
            System.out.println("Eres negativo, es un constipado.");
        }

    }
}
