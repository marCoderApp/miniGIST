package mgist.app.models;

import java.time.LocalDateTime;
import java.util.List;

public class OrdenTrabajo {
    private String id;
    private String cliente_id;
    private String nombre;
    private String apellido;
    private String tipoDeMaquina;
    private String descripcionProblema;
    private String reparacion;
    private String observaciones;
    private LocalDateTime fechaRetiro;
    private LocalDateTime fechaIngreso;
    private EstadoOrden estado;
    private List<Repuesto> repuestos;
    
   

    public OrdenTrabajo(String id, String cliente_id, String nombre,
    		String apellido,
    		String tipoDeMaquina,
    		String descripcionProblema,
                        LocalDateTime fechaIngreso,
                        LocalDateTime fechaRetiro,
                        String reparacion,
                        String observaciones,
                        EstadoOrden estado) {
        this.id = id;
        this.setCliente_id("");
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDeMaquina = tipoDeMaquina;
        this.descripcionProblema = descripcionProblema;
        this.reparacion = reparacion;
        this.observaciones = observaciones;
        this.fechaIngreso = fechaIngreso;
        this.fechaRetiro = null;
        this.estado = estado;
    }

    public double calcularTotal() {
        double totalRepuestos = repuestos.stream()
            .mapToDouble(r -> r.getPrecio() * r.getCantidad())
            .sum();
        
        double totalConFactura = (totalRepuestos + 30000) * 1.06 * 1.21;
        return totalConFactura;
    }
    
    
    public String getNombreCliente(){
    	return this.nombre;
    }
    
    public String getApellidoCliente()
    {
    	return this.apellido;
    }    
    
    public String getTipoDeMaquina(){
    	return this.tipoDeMaquina;
    }
    
	public String getDescripcionProblema() {
	
		return this.descripcionProblema;
	}

	public LocalDateTime getFechaIngreso() {
		
		return this.fechaIngreso;
	}

	public EstadoOrden getEstado() {
		
		return this.estado;
	}

	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public List<Repuesto> getRepuestos() {
		return null;
	}
    // Getters y setters omitidos por brevedad

	public String getReparacion() {
		return reparacion;
	}

	public void setReparacion(String reparacion) {
		this.reparacion = reparacion;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public LocalDateTime getFechaRetiro() {
		return fechaRetiro;
	}

	public void setFechaRetiro(LocalDateTime fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public void setEstado(EstadoOrden estado) {
		this.estado = estado;
	}

	public String getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(String cliente_id) {
		this.cliente_id = cliente_id;
	}

	public void setApellido(String apellido) {
		// TODO Auto-generated method stub
		this.apellido = apellido;
	}

	public void setTipoMaquina(String tipoDeMaquina) {
		// TODO Auto-generated method stub
		this.tipoDeMaquina = tipoDeMaquina;
	}

	public void setProblema(String descripcionProblema) {
		// TODO Auto-generated method stub
		this.descripcionProblema = descripcionProblema;
	}

	public void setFechaIngreso(LocalDateTime fechaIngreso2) {
		
		this.fechaIngreso = fechaIngreso2;
		
	}

}

