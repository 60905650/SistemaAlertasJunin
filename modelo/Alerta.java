package modelo;

import java.time.LocalDateTime;

public class Alerta {
    private String mensaje;
    private String nivel;
    private LocalDateTime fechaHora;
    private int idEvento;

    public Alerta(String mensaje, String nivel, LocalDateTime fechaHora, int idEvento) {
        this.mensaje = mensaje;
        this.nivel = nivel;
        this.fechaHora = fechaHora;
        this.idEvento = idEvento;
    }

    // Getters
    public String getMensaje() { return mensaje; }
    public String getNivel() { return nivel; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public int getIdEvento() { return idEvento; }
}
