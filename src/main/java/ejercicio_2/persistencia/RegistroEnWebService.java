package ejercicio_2.persistencia;

import ejercicio_2.modelo.Registro;

public class RegistroEnWebService implements Registro {

    @Override
    public void registrar(String message) {
        System.out.println("Consumiendo web service");
    }

}
