package models;

import com.company.Main;
import interfaces.AccionSanitario;
import utilitats.Utilities;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hospital {
    private static int recuentoHospitales = 1;
    protected String nombreHospital;
    protected String direcction;
    protected boolean esPrivado;
    private int idHospital;


    public Hospital(String nombreHospital, String direcction, boolean esPrivado) {
        this.nombreHospital = nombreHospital;
        this.direcction = direcction;
        this.esPrivado = esPrivado;
        this.idHospital = Hospital.recuentoHospitales;
        Hospital.recuentoHospitales++;
    }



    public static void modificarPersona(ArrayList<Persona> personas) {
       boolean validacio = true;
        do {
            System.out.println(personas);
            int selecPers = Utilities.llegirInt("Que persona quieres seleccionar?", 1, personas.size() - 1);
            Persona persona = Main.elegirPersona(personas, selecPers);
            int opcio = Utilities.llegirInt("Que atributo quieres modificar:" +
                    "\n\t1.Dni" +
                    "\n\t2.Nombre" +
                    "\n\t3.Primer Cognom" +
                    "\n\t4.Segon Cognom" +
                    "\n\t5.Fecha de nacimiento" +
                    "\n\t6.Salir", 1, 6);
            switch (opcio) {
                case 1:
                    String nuevoAt = Utilities.llegirFrase("Que dni quieres poner:");
                    personas.get(selecPers).setDNI(nuevoAt);
                    nuevoAt = null;
                    modificarPersona(personas);
                    break;
                case 2:
                    nuevoAt = Utilities.llegirFrase("Que dni quieres poner:");
                    personas.get(selecPers).setNombre(nuevoAt);
                    nuevoAt = null;
                    modificarPersona(personas);
                    break;
                case 3:
                    nuevoAt = Utilities.llegirFrase("Que dni quieres poner:");
                    personas.get(selecPers).setApellido1(nuevoAt);
                    nuevoAt = null;
                    modificarPersona(personas);
                    break;
                case 4:
                    nuevoAt = Utilities.llegirFrase("Que dni quieres poner:");
                    personas.get(selecPers).setApellido2(nuevoAt);
                    nuevoAt = null;
                    modificarPersona(personas);
                    break;
                case 5:
                    int dia = Utilities.llegirInt("Pon el dia de nacimeinto.", 1, 31);
                    int mes = Utilities.llegirInt("Pon el mes de nacimeinto", 1, 12);
                    int anio = Utilities.llegirInt("Pon el año de nacimeinto", LocalDate.now().getYear() - 100, LocalDate.now().getYear());
                    personas.get(selecPers).setFechaNacimiento(LocalDate.of(anio, mes, dia));
                    modificarPersona(personas);
                    break;
                case 6:
                    System.out.println("Saliendo");
                    Main.menuSanitario(personas,persona);
                    validacio = false;
            }
        }while (validacio);

    }

    public static void eliminarPersona(ArrayList<Persona> personas) {
    imprimirPersonas(personas);
    int selecPers = Utilities.llegirInt("Escull a la persona que vols eliminar",1,personas.size()-1);
    Persona persona=Main.elegirPersona(personas,selecPers);
    personas.remove(persona);
    }

    public static Persona crearPersona(ArrayList<Persona> persona) {
        Persona personas = null;
        int tipusPersona = Utilities.llegirInt("Escribe el tipo de persona en hopital que quieres crear:\t\n1-Paciente\t\n2-Doctor\t\n3-Enfermera\t\n4-Pasante\t\n5-Salir", 1, 4);

        do {
            switch (tipusPersona) {
                case 1:
                    persona.add(new Paciente(Utilities.llegirFrase("Posa el dni"),
                            Utilities.llegirFrase("Nombre:"),
                            Utilities.llegirFrase("Apellido:"),
                            Utilities.llegirFrase("Segundo Apellido:"),
                            Utilities.inputData(),
                            Utilities.llegirChar("Genere :"),
                            Utilities.llegirBoolean("Es VIP? (si/no)"),
                            Utilities.llegirBoolean("Es mayor de edad? (si/no)"),
                            Utilities.llegirBoolean("Tiene algunas enfermedades? (si/no)")));
                    break;
                case 2:
                    persona.add(new Doctor(Utilities.llegirFrase("Posa el dni"),
                            Utilities.llegirFrase("Nombre:"),
                            Utilities.llegirFrase("Apellido:"),
                            Utilities.llegirFrase("Segundo Apellido:"),
                            Utilities.inputData(),
                            Utilities.llegirFrase("Grado:"),
                            Utilities.llegirFrase("Especialidad :"),
                            Utilities.llegirInt("Anos ecperiencia :", 0, 70),
                            Utilities.llegirBoolean("Es jefe del hospital ?(si/no)"),
                            Utilities.llegirFloat("salario", 0, 10000000)));
                    break;
                case 3:
                    persona.add(new Enfermera(Utilities.llegirFrase("Posa el dni"),
                            Utilities.llegirFrase("Nombre:"),
                            Utilities.llegirFrase("Apellido:"),
                            Utilities.llegirFrase("Segundo Apellido:"),
                            Utilities.inputData(),
                            Utilities.llegirFrase("Grado:"),
                            Utilities.llegirFrase("Especialidad :"),
                            Utilities.llegirInt("Anos ecperiencia :", 0, 70),
                            Utilities.llegirFloat("salario", 0, 10000000),
                            Utilities.llegirFrase("Zona a la que pertenece?" +
                                    "\n\t1.Sur \n 2.Norte \n 3.Este \n 4.Oeste"),
                            Utilities.llegirInt("Indica la planta", 0, 7)

                    ));
                    break;
                case 4:
                    persona.add(new Pasante(Utilities.llegirFrase("Posa el dni"),
                            Utilities.llegirFrase("Nombre:"),
                            Utilities.llegirFrase("Apellido:"),
                            Utilities.llegirFrase("Segundo Apellido:"),
                            Utilities.inputData(),
                            Utilities.llegirFrase("Grado:"),
                            Utilities.llegirFrase("Especialidad :"),
                            Utilities.llegirInt("Anos ecperiencia :", 0, 70),
                            Utilities.llegirFrase("Nombre de la uni: "),
                            Utilities.llegirChar("Nivel:")));
                    break;
                case 5:
                    System.out.println("Salir");
                    Main.menuSanitario(persona, personas);
                    break;
            }
        } while (tipusPersona != 5);
        return personas;
    }

    /**
     * Crear uns quants usuaris per defecte
     *
     * @return Usuaris per defecte
     */
    public static ArrayList<Persona> initPersonas() {
        ArrayList<Persona> personas = new ArrayList<Persona>();
        personas.add(new Doctor("46555877V", "Rosa", "Montoya", "Garcia", LocalDate.parse("2002-08-24"), "Doctorado", "Cirujano cardiotoracico", 4, false, 3000));
        personas.add(new Paciente("23556899B", "Adnrea", "Garcia", "Perez", LocalDate.parse("2003-12-24"), 'F', true, true, true));
        personas.add(new Pasante("11455287N", "Alex", "Valle", "Montoya", LocalDate.parse("1999-08-24"), "Universitario", "Anestesista", 0, "UPC", 'A'));
        personas.add(new Enfermera("45632548A", "Lucas", "Rodriguez", "Parals", LocalDate.parse("1998-06-24"), "Carrera de enfermera", "Enfermeria", 3, 1200, "Sur", 5));
        personas.add(new Doctor("46555888V", "Alexandra", "Kononenko", "Garcia", LocalDate.parse("2002-08-24"), "Doctorado", "Cirujano cardiotoracico", 6, true, 3000));

        return personas;
    }

    /**
     * Mètode per imprimir tots els usuaris de la biblioteca
     *
     * @param personas
     */
    public static void imprimirPersonas(ArrayList<Persona> personas) {
        for (int i = 0; i < personas.size(); i++) {
            System.out.println(i + "->" + personas.get(i));
        }
    }

    public String getNombreHospital() {
        return nombreHospital;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "nombreHospital='" + nombreHospital + '\'' +
                ", direcction='" + direcction + '\'' +
                ", esPrivado=" + esPrivado +
                ", idHospital=" + idHospital +
                '}';
    }
}
