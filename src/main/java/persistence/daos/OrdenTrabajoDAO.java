package persistence.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import mgist.app.models.EstadoOrden;
import mgist.app.models.OrdenTrabajo;
import persistence.SQLiteConnector;

public class OrdenTrabajoDAO {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public void guardar(OrdenTrabajo orden) {
        String sql = """
            INSERT INTO ordenes_trabajo (
                id, cliente_id, nombre_cliente, apellido_cliente, tipo_maquina, problema, reparacion, observaciones,
                fecha_ingreso, fecha_retiro, estado
            ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
        """;

        try (Connection conn = SQLiteConnector.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, orden.getId());
            stmt.setString(2, orden.getClienteId());
            stmt.setString(3, orden.getNombreCliente());
            stmt.setString(4, orden.getApellidoCliente());
            stmt.setString(5, orden.getTipoDeMaquina());
            stmt.setString(6, orden.getDescripcionProblema());
            stmt.setString(7, orden.getReparacion());
            stmt.setString(8, orden.getObservaciones());
            stmt.setString(9, orden.getFechaIngreso().format(formatter));
            stmt.setString(10, orden.getFechaRetiro() != null ? orden.getFechaRetiro().format(formatter) : null);
            stmt.setString(11, orden.getEstado().name());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public OrdenTrabajo buscarPorId(String id) {
        String sql = "SELECT * FROM ordenes_trabajo WHERE id = ?";

        try (Connection conn = SQLiteConnector.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new OrdenTrabajo(
                    rs.getString("id"),
                    rs.getString("cliente_id"),
                    rs.getString("nombre_cliente"),
                    rs.getString("apellido_cliente"),
                    rs.getString("tipo_maquina"),
                    rs.getString("problema"),
                    LocalDateTime.parse(rs.getString("fecha_ingreso"), formatter),
                    LocalDateTime.parse(rs.getString("fecha_retiro"), formatter),
                    rs.getString("reparacion"),
                    rs.getString("observaciones"),
                    EstadoOrden.valueOf(rs.getString("estado"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
