package vista;

import modelo.Alerta;
import controlador.AlertaController;
import java.util.List;

public class VistaAlerta {
    private final AlertaController controller;

    public VistaAlerta(AlertaController controller) {
        this.controller = controller;
    }

    public void mostrarAlertas() {
        try {
            List<Alerta> alertas = controller.listarAlertas();
            for (Alerta a : alertas) {
                System.out.println("⚠️ ALERTA: " + a.getMensaje() +
                                   " | Nivel: " + a.getNivel() +
                                   " | Fecha: " + a.getFechaHora() +
                                   " | ID Evento: " + a.getIdEvento());
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar alertas: " + e.getMessage());
        }
    }
}
