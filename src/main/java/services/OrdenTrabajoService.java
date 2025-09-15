package services;

import mgist.app.models.*;
import java.util.ArrayList;
import java.util.List;

public class OrdenTrabajoService {

    private final List<OrdenTrabajo> ordenes = new ArrayList<>();

    public void agregarOrden(OrdenTrabajo orden) {
        ordenes.add(orden);
    }

    public List<OrdenTrabajo> listarOrdenes() {
        return ordenes;
    }
    
    public void mostrarOrdenesDetalladas() {
        if (ordenes.isEmpty()) {
            System.out.println("⚠️ No hay órdenes registradas.");
            return;
        }

        for (OrdenTrabajo orden : ordenes) {
            System.out.println("\n🧾 Orden ID: " + orden.getId());
            System.out.println("Nombre cliente: " + orden.getNombreCliente());
            System.out.println("Apellido cliente: " + orden.getApellidoCliente());
            System.out.println("Máquina: " + orden.getTipoDeMaquina());
            System.out.println("Problema: " + orden.getDescripcionProblema());
            System.out.println("Fecha de ingreso: " + orden.getFechaIngreso());
            System.out.println("Estado: " + orden.getEstado());

            if (orden.getRepuestos() == null || orden.getRepuestos().isEmpty()) {
                System.out.println("Repuestos: (ninguno agregado)");
            } else {
                System.out.println("Repuestos:");
                for (Repuesto r : orden.getRepuestos()) {
                    System.out.println("  - " + r.getNombre() + " (" + r.getCodigo() + ") x" + r.getCantidad() + " → $" + r.getPrecio());
                }
            }

           /* System.out.println("Total estimado: $" + orden.calcularTotal());*/
        }
    }

    public OrdenTrabajo buscarPorId(String id) {
    	for(OrdenTrabajo orden : ordenes) {
    		if(orden.getId() == id) {
    			return orden;
    		}
    	}
    	return null;
    }
    
    //Podés agregar métodos como buscarPorCliente(), actualizarEstado(), etc.
}

