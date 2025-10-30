import controlador.AlertaController;
import vista.VistaAlerta;
import modelo.Alerta;
import java.sql.*;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:sqlserver://localhost:1433;databaseName=sistema_alertas_desastres",
                "usuario",
                "contraseña"
            );

            AlertaController controller = new AlertaController(conn);
            VistaAlerta vista = new VistaAlerta(controller);

            // Insertar alerta de prueba
            Alerta alerta = new Alerta("Inundación en zona norte", "Alta", LocalDateTime.now(), 1);
            controller.insertarAlerta(alerta);

            // Mostrar alertas
            vista.mostrarAlertas();

        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
}
