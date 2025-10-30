package controlador;

import modelo.Alerta;
import java.sql.*;
import java.util.*;

public class AlertaController {
    private final Connection conn;

    public AlertaController(Connection conn) {
        this.conn = conn;
    }

    public void insertarAlerta(Alerta alerta) throws SQLException {
        CallableStatement stmt = conn.prepareCall("{call sp_insertar_alerta(?, ?, ?, ?)}");
        stmt.setString(1, alerta.getMensaje());
        stmt.setString(2, alerta.getNivel());
        stmt.setTimestamp(3, Timestamp.valueOf(alerta.getFechaHora()));
        stmt.setInt(4, alerta.getIdEvento());
        stmt.execute();
        stmt.close();
    }

    public List<Alerta> listarAlertas() throws SQLException {
        List<Alerta> lista = new ArrayList<>();
        CallableStatement stmt = conn.prepareCall("{call sp_listar_alertas()}");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Alerta a = new Alerta(
                rs.getString("mensaje"),
                rs.getString("nivel"),
                rs.getTimestamp("fechaHora").toLocalDateTime(),
                rs.getInt("idEvento")
            );
            lista.add(a);
        }

        rs.close();
        stmt.close();
        return lista;
    }
}
