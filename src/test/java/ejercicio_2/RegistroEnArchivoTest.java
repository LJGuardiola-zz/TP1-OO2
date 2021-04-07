package ejercicio_2;

import ejercicio_2.modelo.Registro;
import ejercicio_2.persistencia.RegistroEnArchivo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class RegistroEnArchivoTest {

    @Test
    void registrar_mensaje_en_archivo() {
        String mensaje = LocalDate.now().toString() + " || 1500";
        Registro registro = new RegistroEnArchivo(
                System.getProperty("java.io.tmpdir") + "registro.txt"
        );
        registro.registrar(mensaje);
        Assertions.assertTrue(
                registro.verificar(mensaje)
        );
    }

}
