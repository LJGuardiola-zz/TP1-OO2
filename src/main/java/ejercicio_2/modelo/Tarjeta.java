package ejercicio_2.modelo;

public enum Tarjeta implements MedioDePago {

    VISA(0, 0.03),
    MASTERCARD(0.02,0),
    COMARCA_PLUS(0.02,0.02),
    VIEDMA(0,0);

    private final double descuentoPlatos, descuentoBebidas;

    Tarjeta(double descuentoPlatos, double descuentoBebidas) {
        this.descuentoPlatos = descuentoPlatos;
        this.descuentoBebidas = descuentoBebidas;
    }

    @Override
    public double getDescuentoPlatos() {
        return descuentoPlatos;
    }

    @Override
    public double getDescuentoBebidas() {
        return descuentoBebidas;
    }

}
