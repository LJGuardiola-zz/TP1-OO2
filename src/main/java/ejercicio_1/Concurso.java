package ejercicio_1;

import java.util.HashMap;
import java.util.Map;

public class Concurso {

    public static final int PUNTOS_INSCRIPCION_MISMO_DIA = 10;

    private final Fecha fechaDeInicio;
    private final Fecha fechaDeCierre;

    private final Map<Participante, Integer> participantes = new HashMap<>();

    public Concurso(Fecha fechaDeInicio, Fecha fechaDeCierre) {
        this.fechaDeInicio = fechaDeInicio;
        this.fechaDeCierre = fechaDeCierre;
    }

    public String getFechaDeInicioSerializada() {
        return fechaDeInicio.getFechaSerializada();
    }

    public String getFechaDeCierreSerializada() {
        return fechaDeCierre.getFechaSerializada();
    }

    public void sumarPuntos(Participante participante, int puntosASumar) {
        if (puntosASumar <= 0)
            throw new RuntimeException("No se pueden restar puntos a un participantes");
        verificarInscripcion(participante);
        participantes.compute(participante, (noUsado, puntos) -> puntos += puntosASumar);
    }

    public void inscribir(Participante participante) {
        if ( ! estaAbiertaLaInscripcion())
            throw new RuntimeException(
                    "La inscripción no se encuentra abierta." +
                            " ejercicio_1.Fecha de inicio: " + getFechaDeInicioSerializada() +
                            " ejercicio_1.Fecha de cierre: " + getFechaDeCierreSerializada()
            );
        if (estaInscripto(participante))
            throw new RuntimeException("El participante ya se encuentra inscrito.");
        int puntosIniciales = 0;
        if (fechaDeInicio.esHoy())
            puntosIniciales += PUNTOS_INSCRIPCION_MISMO_DIA;
        participantes.put(participante, puntosIniciales);
    }

    public boolean estaInscripto(Participante participante) {
        return participantes.containsKey(participante);
    }

    public boolean estaAbiertaLaInscripcion() {
        return Fecha.hoyEstaEntre(fechaDeInicio, fechaDeCierre);
    }

    public int cuantosPuntosTiene(Participante participante) {
        verificarInscripcion(participante);
        return participantes.get(participante);
    }

    private void verificarInscripcion(Participante participante) {
        if (!participantes.containsKey(participante))
            throw new RuntimeException(
                    "El participante NO se encuentra inscripto en el concurso"
            );
    }

}
