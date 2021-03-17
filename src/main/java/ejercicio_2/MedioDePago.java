package ejercicio_2;

public enum MedioDePago {

    VISA(0, 0.03),
    MASTERCARD(0.02,0),
    COMARCA_PLUS(0.02,0.02),
    VIEDMA(0,0);

    private final double descuentoPlatos, descuentoBebidas;

    MedioDePago(double descuentoPlatos, double descuentoBebidas) {
        this.descuentoPlatos = descuentoPlatos;
        this.descuentoBebidas = descuentoBebidas;
    }

    public double getDescuentoPlatos() {
        return descuentoPlatos;
    }

    public double getDescuentoBebidas() {
        return descuentoBebidas;
    }

}
