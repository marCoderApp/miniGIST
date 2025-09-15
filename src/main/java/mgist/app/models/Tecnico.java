package mgist.app.models;

public class Tecnico {
private String tecnico_id;
private String nombre;
private Especialidad especialidad;

public Tecnico(String id, String nombre, Especialidad especialidad) {
	this.tecnico_id = id;
	this.nombre = nombre;
	this.especialidad = especialidad;
}

public String getTecnico_id() {
	return tecnico_id;
}
public void setTecnico_id(String tecnico_id) {
	this.tecnico_id = tecnico_id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public Especialidad getEspecialidad() {
	return especialidad;
}
public void setEspecialidad(Especialidad especialidad) {
	this.especialidad = especialidad;
}
}
