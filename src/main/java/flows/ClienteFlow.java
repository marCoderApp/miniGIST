package flows;

import java.util.Scanner;

import mgist.app.models.Clientes;
import persistence.daos.ClientesDAO;
import services.ClientesService;

public class ClienteFlow {

	public static void gestionarClientes(Scanner scanner) {
		// TODO Auto-generated method stub
		int opcion;

        do {
            System.out.println("\n=== MENÚ DE CLIENTES ===");
            System.out.println("1. Listar todos los clientes");
            System.out.println("2. Buscar cliente por ID");
            System.out.println("3. Agregar nuevo cliente");
            System.out.println("4. Actualizar cliente existente");
            System.out.println("5. Eliminar cliente");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    //ClientesService.listarClientes();
                    break;
                case 2:
                    System.out.print("Ingrese ID del cliente: ");
                    int idBuscar = scanner.nextInt();
                    //ClientesService.buscarClientePorId(idBuscar);
                    break;
                case 3:
                    Clientes nuevo = ClientesService.crearClienteDesdeInput(scanner);
                    ClientesService.agregarCliente(nuevo);
                    ClientesDAO dao = new ClientesDAO();
                    dao.guardarCliente(nuevo);
                    break;
                case 4:
                    System.out.print("Ingrese ID del cliente a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();
                    Clientes actualizado = ClientesService.crearClienteDesdeInput(scanner);
                    //ClientesService.actualizarCliente(idActualizar, actualizado);
                    break;
                case 5:
                    System.out.print("Ingrese ID del cliente a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    //ClientesService.eliminarCliente(idEliminar);
                    break;
                case 0:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 0);

	}

}
