package ejercicio_2;

import java.util.HashMap;
import java.util.Map;

public class Pedido {

    private final HashMap<Pagable, Integer> productos = new HashMap<>();

    public void agregar(Pagable producto, int cantidad) {
        if (productos.containsKey(producto))
            productos.replace(producto, productos.get(producto) + cantidad);
        else
            productos.put(producto, cantidad);
    }

    private double calcularTotal(MedioDePago medioDePago) {
        double total = 0;
        for (Map.Entry<Pagable, Integer> item : productos.entrySet())
            total += item.getValue() * item.getKey().getPrecioConDescuento(medioDePago);
        return total;
    }

    public double pagar(MedioDePago medioDePago, Propina propina) {
        return propina.aplicarPropina(calcularTotal(medioDePago));
    }

}
