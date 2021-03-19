package ejercicio_2;

public enum Propina {

    BOE(0.02), MEE(0.03), ESSA(0.05);

    private final double propina;

    Propina(double propina) {
        this.propina = propina;
    }

    public double aplicarPropina(double total) {
        return total * (1 + propina);
    }

}
