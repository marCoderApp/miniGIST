package mgist.app;


import java.util.Scanner;
import flows.ClienteFlow;
import flows.OrdenTrabajoFlow;
import flows.PresupuestoFlow;
import flows.RepuestoFlow;
import flows.TecnicoFlow;
import persistence.DBInitializer;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        DBInitializer.inicializar();

        while (!salir) {
            System.out.println("\n╔═══════════════════════════════════════╗");
            System.out.println("║     🛠️ MINI-GIST CRM - MENÚ             ║");
            System.out.println("╠════════════════════════════════════════=╣");
            System.out.println("║ 1. Registrar nueva orden de trabajo     ║");
            System.out.println("║ 2. Listar órdenes de trabajo            ║");
            System.out.println("║ 3. Marcar orden como retirada           ║");
            System.out.println("║ 4. Gestionar clientes                   ║");
            System.out.println("║ 5. Gestionar técnicos                   ║");
            System.out.println("║ 6. Gestionar repuestos                  ║");
            System.out.println("║ 7. Generar presupuesto                  ║");
            System.out.println("║ 8. Consultar estado de una orden        ║");
            System.out.println("║ 9. Salir                                ║");
            System.out.println("╚═════════════════════════════════════════╝");
            System.out.print("Seleccioná una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    OrdenTrabajoFlow.crearOrden(scanner);
                    break;
                case "2":
                    OrdenTrabajoFlow.listarOrdenes();
                    break;
                case "3":
                    OrdenTrabajoFlow.marcarComoRetirada(scanner);
                    break;
                case "4":
                    ClienteFlow.gestionarClientes(scanner);
                    break;
                case "5":
                    TecnicoFlow.gestionarTecnicos(scanner);
                    break;
                case "6":
                    RepuestoFlow.gestionarRepuestos(scanner);
                    break;
                case "7":
                    PresupuestoFlow.generarPresupuesto(scanner);
                    break;
                case "8":
                    OrdenTrabajoFlow.consultarEstado(scanner);
                    break;
                case "9":
                    salir = true;
                    System.out.println("👋 Cerrando MiniGist CRM. ¡Hasta la próxima!");
                    break;
                default:
                    System.out.println("❌ Opción inválida. Intentá nuevamente.");
            }
        }

        scanner.close();
    }
}


