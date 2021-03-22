package ejercicio_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ConcursoTest {

    private final Participante participante = new Participante("39741258");

    @Test
    void inscripcion_de_un_participante_en_fecha() {
        Concurso concurso = obtenerConcursoConInscripcionAbierta();
        concurso.inscribir(participante);
        assertTrue(concurso.estaInscripto(participante));
    }

    @Test
    void inscripcion_de_un_participante_el_primer_dia() {
        Concurso concurso = obtenerConcursoConInscripcionAbiertaAPartirDeHoy();
        concurso.inscribir(participante);
        assertEquals(Concurso.PUNTOS_INSCRIPCION_MISMO_DIA, concurso.cuantosPuntosTiene(participante));
    }

    @Test
    void inscripcion_de_un_participante_fuera_de_fecha() {
        Concurso concurso = obtenerConcursoConInscripcionCerrada();
        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class, () -> concurso.inscribir(participante)
        );
        assertTrue(exception.getMessage().contains("La inscripción no se encuentra abierta."));
    }

    @Test
    void inscripcion_de_un_participante_ya_inscripto() {
        Concurso concurso = obtenerConcursoConInscripcionAbierta();
        concurso.inscribir(participante);
        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class, () -> concurso.inscribir(participante)
        );
        assertEquals(exception.getMessage(), "El participante ya se encuentra inscrito.");
    }

    @Test
    void participante_inscripto_suma_puntos() {
        Concurso concurso = obtenerConcursoConInscripcionAbierta();
        concurso.inscribir(participante);
        int puntosAntes = concurso.cuantosPuntosTiene(participante);
        concurso.sumarPuntos(participante, 10);
        int puntosDespues = concurso.cuantosPuntosTiene(participante);
        assertEquals(puntosAntes + 10, puntosDespues);
    }

    @Test
    void participante_inscripto_no_resta_puntos() {
        Concurso concurso = obtenerConcursoConInscripcionAbierta();
        concurso.inscribir(participante);
        RuntimeException exception = assertThrows(
                RuntimeException.class, () -> concurso.sumarPuntos(participante, -1)
        );
        assertEquals(exception.getMessage(), "No se pueden restar puntos a un participantes");
    }

    @Test
    void participante_no_inscripto_no_suma_puntos() {
        Concurso concurso = obtenerConcursoConInscripcionAbierta();
        RuntimeException exception = assertThrows(
                RuntimeException.class, () -> concurso.sumarPuntos(participante, 10)
        );
        assertEquals(exception.getMessage(), "El participante NO se encuentra inscripto en el concurso");
    }

    private Concurso obtenerConcursoConInscripcionAbierta() {
        LocalDateTime hoy = LocalDateTime.now();
        LocalDateTime ayer = hoy.minusDays(1);
        LocalDateTime manana = hoy.plusDays(1);
        return new Concurso(
                new Fecha(ayer),
                new Fecha(manana)
        );
    }

    private Concurso obtenerConcursoConInscripcionAbiertaAPartirDeHoy() {
        LocalDateTime ahora = LocalDateTime.now();
        LocalDateTime manana = ahora.plusDays(1);
        return new Concurso(
                new Fecha(ahora.minusHours(2)),
                new Fecha(manana)
        );
    }

    private Concurso obtenerConcursoConInscripcionCerrada() {
        LocalDateTime hoy = LocalDateTime.now();
        LocalDateTime ayer = hoy.minusDays(1);
        LocalDateTime antesDeAyer = hoy.minusDays(2);
        return new Concurso(
                new Fecha(antesDeAyer),
                new Fecha(ayer)
        );
    }

}
