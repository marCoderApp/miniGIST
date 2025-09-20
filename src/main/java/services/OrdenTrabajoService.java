package services;

import mgist.app.models.*;
import persistence.daos.OrdenTrabajoDAO;

import java.util.ArrayList;
import java.util.List;

public class OrdenTrabajoService {

    private final List<OrdenTrabajo> ordenes = new ArrayList<>();

    public void agregarOrden(OrdenTrabajo orden) {
        ordenes.add(orden);
    }

    public void listarOrdenes() {
    	List<OrdenTrabajo> ordenesDB = new ArrayList<>();
       try {
		ordenesDB = OrdenTrabajoDAO.listarOrdenesDB();
		
		for(OrdenTrabajo orden : ordenesDB) {
		    System.out.println("🆔 ID: " + orden.getId());
		    System.out.println("👤 Cliente: " + orden.getNombreCliente() + " " + orden.getApellidoCliente());
		    System.out.println("🔧 Máquina: " + orden.getTipoDeMaquina());
		    System.out.println("📅 Ingreso: " + (orden.getFechaIngreso() != null ? orden.getFechaIngreso().toString() : "Sin fecha"));
		    System.out.println("📅 Retiro: " + (orden.getFechaRetiro() != null ? orden.getFechaRetiro().toString() : "Pendiente"));
		    System.out.println("📋 Problema: " + orden.getDescripcionProblema());
		    System.out.println("🛠️ Repar)ación: " + orden.getReparacion());
		    System.out.println("🗒️ Observaciones: " + orden.getObservaciones());
		    System.out.println("📌 Estado: " + orden.getEstado());
		    System.out.println("──────────────────────────────────────────────");
		}
		
	   } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
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

