package models;

import java.time.LocalDate;

public abstract class Persona  {
    private String DNI;
    protected String nombre;
    protected String apellido1;
    protected String apellido2;
    private LocalDate fechaNacimiento;


    public Persona(String DNI, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento) {
        this.DNI =DNI;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public abstract String toString();
}
