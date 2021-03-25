package ejercicio_2.persistencia;

import ejercicio_2.modelo.Registro;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class RegistroEnArchivo implements Registro {

    private final String ruta;

    public RegistroEnArchivo(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public void registrar(String mensaje) {
        try {
            Files.write(Paths.get(ruta), mensaje.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo registrar el mensaje.", e);
        }
    }

}
