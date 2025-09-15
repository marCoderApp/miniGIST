package persistence;

import java.sql.Connection;
import java.sql.SQLException;

public class DBInitializer {
    public static void inicializar() {
        String sql = """
            CREATE TABLE IF NOT EXISTS ordenes_trabajo (
                id TEXT PRIMARY KEY,
                cliente_id TEXT,
                nombre_cliente TEXT,
                apellido_cliente TEXT,
                tipo_maquina TEXT,
                problema TEXT,
                reparacion TEXT,
                observaciones TEXT,
                fecha_ingreso TEXT,
                fecha_retiro TEXT,
                estado TEXT
            );
        """;

        try (Connection conn = SQLiteConnector.connect();
             var stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
