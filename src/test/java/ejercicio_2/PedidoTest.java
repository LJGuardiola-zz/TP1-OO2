package ejercicio_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    private Pedido pedido;
    private double totalVisa, totalMasterCard, totalComarcaPlus, totalViedma;

    @BeforeEach
    void setUp() {

        pedido = new Pedido();

        pedido.agregarPlato(new PlatoPrincipal("Sandwich de vacío", 450), 3);
        pedido.agregarPlato(new PlatoPrincipal("Milanesa de carne de vaca", 300), 1);
        pedido.agregarBebida(new Bebida("Coca cola", 150), 4);

        double totalPlatos = 450 * 3 + 300;
        double totalBebidas = 150 * 4;

        totalVisa = (totalPlatos * (1 - MedioDePago.VISA.getDescuentoPlatos()) +
                    totalBebidas * (1 - MedioDePago.VISA.getDescuentoBebidas())) * (1 + Propina.ESSA.getPropina());

        totalMasterCard =   (totalPlatos * (1 - MedioDePago.MASTERCARD.getDescuentoPlatos()) +
                            totalBebidas * (1 - MedioDePago.MASTERCARD.getDescuentoBebidas())) * (1 + Propina.ESSA.getPropina());

        totalComarcaPlus =  (totalPlatos * (1 - MedioDePago.COMARCA_PLUS.getDescuentoPlatos()) +
                            totalBebidas * (1 - MedioDePago.COMARCA_PLUS.getDescuentoBebidas())) * (1 + Propina.ESSA.getPropina());

        totalViedma =   (totalPlatos * (1 - MedioDePago.VIEDMA.getDescuentoPlatos()) +
                        totalBebidas * (1 - MedioDePago.VIEDMA.getDescuentoBebidas())) * (1 + Propina.ESSA.getPropina());

    }

    @Test
    void pagar_con_visa() {
        assertEquals(pedido.pagar(MedioDePago.VISA, Propina.ESSA), totalVisa);
    }

    @Test
    void pagar_con_mastercard() {
        assertEquals(pedido.pagar(MedioDePago.MASTERCARD, Propina.ESSA), totalMasterCard);
    }

    @Test
    void pagar_con_comarca_plus() {
        assertEquals(pedido.pagar(MedioDePago.COMARCA_PLUS, Propina.ESSA), totalComarcaPlus);
    }

    @Test
    void pagar_con_viedma() {
        assertEquals(pedido.pagar(MedioDePago.VIEDMA, Propina.ESSA), totalViedma);
    }

}
