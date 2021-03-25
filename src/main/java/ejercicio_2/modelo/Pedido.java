package ejercicio_2.modelo;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Pedido {

    private final HashMap<Pagable, Integer> items = new HashMap<>();
    private final Registro registro;

    public Pedido(Registro registro) {
        this.registro = registro;
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

    public void pagar(MedioDePago medioDePago, Propina propina) {
        double total = propina.aplicarPropina(calcularTotal(medioDePago));
        registro.registrar(LocalDate.now() + " || " + total + "\n");
    }

}
