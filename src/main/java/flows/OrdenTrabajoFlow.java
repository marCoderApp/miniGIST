package flows;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

import mgist.app.models.EstadoOrden;
import mgist.app.models.OrdenTrabajo;
import persistence.daos.OrdenTrabajoDAO;
import services.OrdenTrabajoService;

public class OrdenTrabajoFlow {
	private static final OrdenTrabajoService servicio = new OrdenTrabajoService();

    public static void crearOrden(Scanner scanner) {
        System.out.println("\n📋 Nueva orden de trabajo");
        
        
        System.out.print("Cliente id: ");
        String cliente_id = scanner.nextLine();
        
        System.out.print("Nombre cliente: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido cliente: ");
        String apellido = scanner.nextLine();

        System.out.print("Tipo de máquina: ");
        String tipoDeMaquina = scanner.nextLine();

        System.out.print("Descripción del problema: ");
        String problema = scanner.nextLine();
        
        System.out.print("Observaciones: ");
        String observaciones = scanner.nextLine();
       

        OrdenTrabajo orden = new OrdenTrabajo(
        	     UUID.randomUUID().toString(),
        	     	cliente_id,
	                nombre,
	                apellido,
	                tipoDeMaquina,
	                problema,
	                LocalDateTime.now(),
	                null,
	                " ",
	                observaciones, 
	                EstadoOrden.PENDIENTE
        );

        servicio.agregarOrden(orden);

        System.out.println("\n✅ Orden registrada:");
        System.out.println("ID: " + orden.getId());
        System.out.println("Cliente: " + orden.getNombreCliente());
        System.out.println("Cliente: " + orden.getApellidoCliente());
        System.out.println("Tipo de máquina: " + orden.getTipoDeMaquina());
        System.out.println("Problema: " + orden.getDescripcionProblema());
        
        OrdenTrabajoDAO dao = new OrdenTrabajoDAO();
        dao.guardar(orden);
    }
    



    public static void listarOrdenes() {
        System.out.println("\n📦 Órdenes registradas:");
        servicio.listarOrdenes();
    }

    public static void marcarComoRetirada(Scanner scanner) {
        System.out.print("\n🔄 Ingresá el ID de la orden a marcar como retirada: ");
        String id = scanner.nextLine();

        OrdenTrabajo orden = servicio.buscarPorId(id);
        if (orden != null) {
            orden.setFechaRetiro(LocalDateTime.now());
            orden.setEstado(EstadoOrden.COMPLETADA);
            System.out.println("✅ Orden marcada como retirada.");
        } else {
            System.out.println("❌ Orden no encontrada.");
        }
    }

    public static void consultarEstado(Scanner scanner) {
        System.out.print("\n🔍 Ingresá el ID de la orden: ");
        String id = scanner.nextLine();

        OrdenTrabajo orden = servicio.buscarPorId(id);
        if (orden != null) {
            System.out.println("📄 Estado actual: " + orden.getEstado());
            if (orden.getFechaRetiro() != null) {
                System.out.println("📦 Retirada el: " + orden.getFechaRetiro());
            } else {
                System.out.println("⏳ Aún no fue retirada.");
            }
        } else {
            System.out.println("❌ Orden no encontrada.");
        }
    }

}
