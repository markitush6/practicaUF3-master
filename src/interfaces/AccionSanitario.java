package interfaces;

import models.Persona;

import java.util.ArrayList;

public interface AccionSanitario {
    void vacunar();

    void vacunar(ArrayList<Persona> personas);

    void hacerOperacion();

    void hacerOperacion(ArrayList<Persona> personas);

    void testCovid();
}
