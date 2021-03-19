package ejercicio_2;

import java.util.HashMap;
import java.util.Map;

public class Pedido {

    private final HashMap<Pagable, Integer> items;

    public Pedido() {
        items = new HashMap<>();
    }

    public void agregar(Pagable producto, int cantidad) {
        if (items.containsKey(producto))
            items.replace(producto, items.get(producto) + cantidad);
        else
            items.put(producto, cantidad);
    }

    private double calcularTotal(MedioDePago medioDePago) {
        double total = 0;
        for (Map.Entry<Pagable, Integer> item : items.entrySet())
            total += item.getValue() * item.getKey().getPrecioConDescuento(medioDePago);
        return total;
    }

    public double pagar(MedioDePago medioDePago, Propina propina) {
        return propina.aplicarPropina(calcularTotal(medioDePago));
    }

}
