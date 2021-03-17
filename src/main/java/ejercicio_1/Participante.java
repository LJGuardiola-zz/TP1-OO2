package ejercicio_1;

import java.util.Objects;

public class Participante {

    private final String DNI;

    public Participante(String DNI) {
        if (DNI == null || DNI.isEmpty())
            throw new IllegalArgumentException("El DNI del participante no puede ser nulo o vacío");
        this.DNI = DNI;
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
