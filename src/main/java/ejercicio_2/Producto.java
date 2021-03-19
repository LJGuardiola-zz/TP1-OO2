package ejercicio_2;

import java.util.Objects;

public abstract class Producto implements Pagable {

    private final String nombre;
    private final double precio;

    public Producto(String nombre, double precio) {
        if (nombre == null || nombre.isEmpty())
            throw new IllegalArgumentException("El nombre del producto no debe ser nulo o vacío.");
        this.nombre = nombre;
        if (precio < 0)
            throw new IllegalArgumentException("El precio del producto no debe ser mayor o igual a 0.");
        this.precio = precio;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return nombre.equals(producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

}
