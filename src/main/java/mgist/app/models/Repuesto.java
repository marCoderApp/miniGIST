package mgist.app.models;

public class Repuesto {
	
	private String nombre;
	private String codigo;
	private double precio;
	private int cantidad;
	
	public Repuesto(String nombre, String codigo, double precio, int cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.codigo = codigo;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public int getCantidad() {
		return this.cantidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getCodigo() {
		return this.codigo;
	}

	
}
