package ejercicio_2;

import ejercicio_2.modelo.*;
import ejercicio_2.persistencia.RegistroEnTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PedidoTest {

    private Pedido pedido;
    private RegistroEnTest registro;
    private double totalPlatos, totalBebidas;
    private static final Propina PROPINA_DEFAULT = Propina.ESSA;

    @BeforeEach
    void setUp() {

        registro = new RegistroEnTest();
        pedido = new Pedido(registro);

        pedido.agregar(new PlatoPrincipal("Sandwich de vacío", 450), 3);
        pedido.agregar(new PlatoPrincipal("Milanesa de carne de vaca", 300), 1);
        pedido.agregar(new Bebida("Coca cola", 150), 4);

        totalPlatos = 450 * 3 + 300;
        totalBebidas = 150 * 4;

    }

    @Test
    void pagar_con_visa() {
        pagar(Tarjeta.VISA);
        assertTrue(
                registro.verificar(
                        getMensajeDeRegistro(Tarjeta.VISA)
                )
        );
    }

    @Test
    void pagar_con_mastercard() {
        pagar(Tarjeta.MASTERCARD);
        assertTrue(
                registro.verificar(
                        getMensajeDeRegistro(Tarjeta.MASTERCARD)
                )
        );
    }

    @Test
    void pagar_con_comarca_plus() {
        pagar(Tarjeta.COMARCA_PLUS);
        assertTrue(
                registro.verificar(
                        getMensajeDeRegistro(Tarjeta.COMARCA_PLUS)
                )
        );
    }

    @Test
    void pagar_con_viedma() {
        pagar(Tarjeta.VIEDMA);
        assertTrue(
                registro.verificar(
                        getMensajeDeRegistro(Tarjeta.VIEDMA)
                )
        );
    }

    private String getMensajeDeRegistro(Tarjeta tarjeta) {
        return LocalDate.now() + " || " + obtenerTotalFinal(tarjeta) + "\n";
    }

    private void pagar(MedioDePago medioDePago) {
        pedido.pagar(medioDePago, PROPINA_DEFAULT);
    }

    private double obtenerTotalFinal(MedioDePago medioDePago) {
        return PROPINA_DEFAULT.aplicarPropina(
                totalPlatos * (1 - medioDePago.getDescuentoPlatos()) +
                        totalBebidas * (1 - medioDePago.getDescuentoBebidas())
        );
    }

}
