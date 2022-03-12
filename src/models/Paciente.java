package models;

import interfaces.AccionPaciente;

import java.time.LocalDate;

public class Paciente extends Persona implements AccionPaciente {
    private char genere;
    private boolean esVIP;
    private boolean esMayor;
    private boolean enfermedades;
    private int identificador;
    private static int recuentoPacientes = 1;


    public Paciente(String DNI, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, char genere, boolean esVIP, boolean esMayor, boolean enfermedades) {
        super(DNI, nombre, apellido1, apellido2, fechaNacimiento);
        this.genere = genere;
        this.esVIP = esVIP;
        this.esMayor = esMayor;
        this.enfermedades = enfermedades;
        this.identificador = Paciente.recuentoPacientes;
        Paciente.recuentoPacientes++;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "genere=" + genere +
                ", esVIP=" + esVIP +
                ", esMayor=" + esMayor +
                ", enfermedades='" + enfermedades + '\'' +
                ", identificador=" + identificador +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                '}';
    }

    @Override
    public void pedirCita() {

    }

    @Override
    public void vacunaCovid() {

    }


    public void testCovid() {

    }
}
