package ejercicio_1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Fecha {

    private final LocalDateTime date;

    public Fecha(LocalDateTime date) {
        this.date = date;
    }

    private String serializarFecha(LocalDateTime fecha) {
        return fecha.format(
                DateTimeFormatter.ofPattern(
                        "dd/MM/yyyy HH:mm"
                )
        );
    }

    public String getFechaSerializada() {
        return serializarFecha(date);
    }

    public boolean esHoy() {
        return date.toLocalDate().equals(LocalDate.now());
    }

    public static boolean hoyEstaEntre(Fecha inicio, Fecha fin) {
        LocalDateTime ahora = LocalDateTime.now();
        return ahora.isAfter(inicio.date) && ahora.isBefore(fin.date);
    }

}
