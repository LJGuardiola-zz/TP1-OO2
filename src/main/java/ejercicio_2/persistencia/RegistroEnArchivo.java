package ejercicio_2.persistencia;

import ejercicio_2.modelo.Registro;

import java.io.*;

public class RegistroEnArchivo implements Registro {

    private final File file;

    public RegistroEnArchivo(String path) {
        file = new File(path);
    }

    @Override
    public void registrar(String mensaje) {
        try (Writer writer = new FileWriter(file)) {
            writer.write(mensaje);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo registrar el mensaje.", e);
        }
    }

}
