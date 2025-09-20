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
        
        String sqlClientes = """
        		CREATE TABLE IF NOT EXISTS clientes (
        		cliente_id TEXT PRIMARY KEY,
        		nombre_cliente TEXT,
        		apellido_cliente TEXT,
        		empresa TEXT,
        		telefono TEXT
        		);
        		""";
        
        String sqlTecnicos = """
        		CREATE TABLE IF NOT EXISTS tecnicos (
        		tecnico_id TEXT PRIMARY KEY,
        		nombre_tecnico TEXT,
        		apellido_tecnico TEXT,
        		especialidad TEXT
        		);
        		""";
        
        String sqlPresupuestos = """
        		CREATE TABLE IF NOT EXISTS presupuestos (
        		presupuesto_id TEXT PRIMARY KEY,
        		detalle_presupuesto_id TEXT,
        		costo_mano_de_obra REAL, 
        		total_sin_factura REAL, 
        		total_con_factura REAL,
        		FOREIGN KEY (detalle_presupuesto_id) REFERENCES detalles_presupuesto(id)
        		);
        		""";
        String sqlDetalles_presupuesto = """
        		CREATE TABLE IF NOT EXISTS detalles_presupuesto (
        		id TEXT PRIMARY KEY,
        		repuesto_id TEXT,
        		FOREIGN KEY (repuesto_id) REFERENCES repuestos(id)
        		);
        		""";
        
        String sqlRepuestos = """
        		CREATE TABLE IF NOT EXISTS repuestos (
        		id TEXT PRIMARY KEY,
        		nombre_repuesto TEXT,
        		precio REAL
        		);
        		""";

        try (Connection conn = SQLiteConnector.connect();
             var stmt = conn.createStatement()) {
            stmt.execute(sql);
            stmt.execute(sqlClientes);
            stmt.execute(sqlTecnicos);
            stmt.execute(sqlPresupuestos);
            stmt.execute(sqlDetalles_presupuesto);
            stmt.execute(sqlRepuestos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
