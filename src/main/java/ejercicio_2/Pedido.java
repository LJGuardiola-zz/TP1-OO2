package ejercicio_2;

import java.util.HashMap;
import java.util.Map;

public class Pedido {

    private final HashMap<PlatoPrincipal, Integer> platos = new HashMap<>();
    private final HashMap<Bebida, Integer> bebidas = new HashMap<>();

    public Pedido() {}

    public void agregarPlato(PlatoPrincipal plato, int cantidad) {
        if (platos.containsKey(plato))
            platos.replace(plato, platos.get(plato) + cantidad);
        else
            platos.put(plato, cantidad);
    }

    public void agregarBebida(Bebida bebida, int cantidad) {
        if (bebidas.containsKey(bebida))
            bebidas.replace(bebida, bebidas.get(bebida) + cantidad);
        else
            bebidas.put(bebida, cantidad);
    }

    public double pagar(MedioDePago medioDePago, Propina propina) {
        double total = 0;
        // formula aplicada: cantidad * precio * descuento aplicado.
        for (Map.Entry<PlatoPrincipal, Integer> item : platos.entrySet())
            total += item.getValue() * item.getKey().getPrecio() * (1 - medioDePago.getDescuentoPlatos());
        for (Map.Entry<Bebida, Integer> item : bebidas.entrySet())
            total += item.getValue() * item.getKey().getPrecio() * (1 - medioDePago.getDescuentoBebidas());
        // Sumar propina
        return total * (1 + propina.getPropina());
    }

}
