package ejercicio_2.persistencia;

import ejercicio_2.modelo.Registro;

public class RegistroEnTest implements Registro {

    private String almacen;

    @Override
    public void registrar(String message) {
        almacen += message;
    }

    @Override
    public boolean verificar(String message) {
        return almacen.contains(message);
    }

}
