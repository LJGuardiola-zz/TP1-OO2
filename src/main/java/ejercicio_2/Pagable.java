package ejercicio_2;

public interface Pagable {
    double getPrecio();
    double getDescuento(MedioDePago medioDePago);
    default double getPrecioConDescuento(MedioDePago medioDePago) {
        return getPrecio() * (1 - getDescuento(medioDePago));
    }
}
