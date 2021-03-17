package ejercicio_2;

import java.util.HashMap;
import java.util.Map;

public class Pedido {

    private final HashMap<Producto, Integer> productos = new HashMap<>();

    public Pedido() {}

    public void agregar(Producto producto, int cantidad) {
        if (productos.containsKey(producto))
            productos.replace(producto, productos.get(producto) + cantidad);
        else
            productos.put(producto, cantidad);
    }

    private double calcularTotal(MedioDePago medioDePago) {
        double total = 0;
        for (Map.Entry<Producto, Integer> item : productos.entrySet()) {
            Producto producto = item.getKey();
            int cantidad = item.getValue();
            total += cantidad * producto.getPrecio() * (1 - producto.getDescuento(medioDePago));
        }
        return total;
    }

    public double pagar(MedioDePago medioDePago, Propina propina) {
        return calcularTotal(medioDePago) * (1 + propina.getPropina());
    }

}
