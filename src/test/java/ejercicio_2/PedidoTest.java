package ejercicio_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    private Pedido pedido;
    private double totalPlatos, totalBebidas;
    private static final Propina PROPINA_DEFAULT = Propina.ESSA;

    @BeforeEach
    void setUp() {

        pedido = new Pedido();

        pedido.agregar(new PlatoPrincipal("Sandwich de vacío", 450), 3);
        pedido.agregar(new PlatoPrincipal("Milanesa de carne de vaca", 300), 1);
        pedido.agregar(new Bebida("Coca cola", 150), 4);

        totalPlatos = 450 * 3 + 300;
        totalBebidas = 150 * 4;

    }

    @Test
    void pagar_con_visa() {
        assertEquals(
                pagar(Tarjeta.VISA),
                obtenerTotalFinal(Tarjeta.VISA));
    }

    @Test
    void pagar_con_mastercard() {
        assertEquals(
                pagar(Tarjeta.MASTERCARD),
                obtenerTotalFinal(Tarjeta.MASTERCARD)
        );
    }

    @Test
    void pagar_con_comarca_plus() {
        assertEquals(
                pagar(Tarjeta.COMARCA_PLUS),
                obtenerTotalFinal(Tarjeta.COMARCA_PLUS)
        );
    }

    @Test
    void pagar_con_viedma() {
        assertEquals(
                pagar(Tarjeta.VIEDMA),
                obtenerTotalFinal(Tarjeta.VIEDMA)
        );
    }

    private double pagar(MedioDePago medioDePago) {
        return pedido.pagar(medioDePago, PROPINA_DEFAULT);
    }

    private double obtenerTotalFinal(MedioDePago medioDePago) {
        return PROPINA_DEFAULT.aplicarPropina(
                totalPlatos * (1 - medioDePago.getDescuentoPlatos()) +
                     totalBebidas * (1 - medioDePago.getDescuentoBebidas())
        );
    }

}
