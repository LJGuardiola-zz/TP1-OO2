package ejercicio_2;

public class PlatoPrincipal extends Producto implements Pagable {

    public PlatoPrincipal(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public double getDescuento(MedioDePago medioDePago) {
        return medioDePago.getDescuentoPlatos();
    }

}
