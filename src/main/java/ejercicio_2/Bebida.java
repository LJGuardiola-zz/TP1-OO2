package ejercicio_2;

public class Bebida extends Producto {

    public Bebida(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public double getDescuento(MedioDePago medioDePago) {
        return medioDePago.getDescuentoBebidas();
    }

}
