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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(mensaje);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo registrar el mensaje.", e);
        }
    }

    @Override
    public boolean verificar(String message) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines().anyMatch(line -> line.equals(message));
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer el archivo de registro.", e);
        }
    }

}
