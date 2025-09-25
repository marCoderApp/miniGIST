package persistence.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mgist.app.models.Clientes;
import persistence.SQLiteConnector;

public class ClientesDAO {
	
	public void guardarCliente(Clientes cliente) {
		
		String sql = """
				
				INSERT INTO clientes(
				cliente_id, nombre_cliente, apellido_cliente, telefono, empresa
				) VALUES (?, ?, ?, ?, ?);
				
				""";
		
		try(Connection conn = SQLiteConnector.connect();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			
			stmt.setString(1, cliente.getId());
			stmt.setString(2, cliente.getNombre_cliente());
			stmt.setString(3, cliente.getApellido_cliente());
			stmt.setString(5, cliente.getTelefono());
			stmt.setString(4, cliente.getEmpresa());
			
			stmt.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
