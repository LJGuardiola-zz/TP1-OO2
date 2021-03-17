package ejercicio_1;

import java.util.Objects;

public class Participante {

    private final String DNI;
    private final String nombre;
    private final String apellido;

    public Participante(String DNI, String nombre, String apellido) {

        if (DNI == null || DNI.isEmpty())
            throw new IllegalArgumentException("El DNI del participante no puede ser nulo o vacío");

        if (nombre == null || nombre.isEmpty())
            throw new IllegalArgumentException("El nombre del participante no puede ser nulo o vacío");

        if (apellido == null || apellido.isEmpty())
            throw new IllegalArgumentException("El apellido del participante no puede ser nulo o vacío");

        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participante that = (Participante) o;
        return Objects.equals(DNI, that.DNI);
    }

    @Override
    public int hashCode() {
        return Objects.hash(DNI);
    }

}
