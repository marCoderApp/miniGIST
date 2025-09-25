package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import mgist.app.models.Clientes;

public class ClientesService {
	
	private final static List<Clientes> clientes = new ArrayList<>();

	public static Clientes crearClienteDesdeInput(Scanner scanner) {
		
		System.out.println("\n--- Crear nuevo cliente ---");

	    System.out.print("Nombre: ");
	    String nombre = scanner.nextLine();

	    System.out.print("Apellido: ");
	    String apellido = scanner.nextLine();

	    System.out.print("Teléfono: ");
	    String telefono = scanner.nextLine();
	    
	    System.out.print("Empresa: ");
	    String empresa = scanner.nextLine();
	    

		return new Clientes( UUID.randomUUID().toString(), nombre, apellido, telefono, empresa);
	}

	public static void agregarCliente(Clientes nuevo) {
		
		clientes.add(nuevo);
		
		
		
	}

}
