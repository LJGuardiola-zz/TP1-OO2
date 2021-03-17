package ejercicio_2;

public class Main {

    public static void main(String[] args) {

        Pedido pedido = new Pedido();

        pedido.agregarPlato(new PlatoPrincipal("Sandwich de vacío", 450), 3);
        pedido.agregarBebida(new Bebida("Coca cola", 150), 3);

        System.out.println(pedido.pagar(MedioDePago.VISA, Propina.ESSA));

    }

}
