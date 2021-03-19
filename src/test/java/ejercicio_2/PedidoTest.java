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
                pedido.pagar(Tarjeta.VISA, PROPINA_DEFAULT),
                obtenerTotalFinal(Tarjeta.VISA));
    }

    @Test
    void pagar_con_mastercard() {
        assertEquals(
                pedido.pagar(Tarjeta.MASTERCARD, PROPINA_DEFAULT),
                obtenerTotalFinal(Tarjeta.MASTERCARD)
        );
    }

    @Test
    void pagar_con_comarca_plus() {
        assertEquals(
                pedido.pagar(Tarjeta.COMARCA_PLUS, PROPINA_DEFAULT),
                obtenerTotalFinal(Tarjeta.COMARCA_PLUS)
        );
    }

    @Test
    void pagar_con_viedma() {
        assertEquals(
                pedido.pagar(Tarjeta.VIEDMA, PROPINA_DEFAULT),
                obtenerTotalFinal(Tarjeta.VIEDMA)
        );
    }

    private double obtenerTotalFinal(MedioDePago medioDePago) {
        return PROPINA_DEFAULT.aplicarPropina(
                totalPlatos * (1 - medioDePago.getDescuentoPlatos()) +
                     totalBebidas * (1 - medioDePago.getDescuentoBebidas())
        );
    }

}
