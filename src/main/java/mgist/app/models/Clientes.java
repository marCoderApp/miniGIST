package mgist.app.models;

public class Clientes {
	
	private String cliente_id;
	private String nombre_cliente;
	private String apellido_cliente;
	private String empresa;
	private String telefono;
	
	public Clientes(String cliente_id, String nombre_cliente, String apellido_cliente, 
			String empresa, String telefono)
	{
		this.setCliente_id(cliente_id);
		this.setNombre_cliente(nombre_cliente);
		this.setApellido_cliente(apellido_cliente);
		this.setTelefono(telefono);
		this.setEmpresa(empresa);
	}

	public String getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(String cliente_id) {
		this.cliente_id = cliente_id;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getApellido_cliente() {
		return apellido_cliente;
	}

	public void setApellido_cliente(String apellido_cliente) {
		this.apellido_cliente = apellido_cliente;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return cliente_id;
	}
	
	
	
}
