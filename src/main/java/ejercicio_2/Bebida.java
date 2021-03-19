package ejercicio_2;

import java.util.Objects;

public class Bebida implements Pagable {

    private final String nombre;
    private final double precio;

    public Bebida(String nombre, double precio) {
        if (nombre == null || nombre.isEmpty())
            throw new IllegalArgumentException("El nombre de la bebida no debe ser nulo o vacío.");
        this.nombre = nombre;
        if (precio < 0)
            throw new IllegalArgumentException("El precio de la bebida debe ser mayor o igual a 0.");
        this.precio = precio;
    }


    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public double getDescuento(MedioDePago medioDePago) {
        return medioDePago.getDescuentoBebidas();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bebida bebida = (Bebida) o;
        return nombre.equals(bebida.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

}
