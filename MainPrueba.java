import java.util.Scanner;

public class MainPrueba {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();

        // Datos de prueba cargados al inicio
        Conductor c1 = new Conductor("Juan Perez", "ABC123", 5);
        Conductor c2 = new Conductor("Maria Lopez", "XYZ789", 8);
        empresa.registrarConductor(c1);
        empresa.registrarConductor(c2);

        Vehiculo v1 = new Vehiculo("AAA111", "Toyota Corolla", 4, TipoVehiculo.AUTO, c1);
        Vehiculo v2 = new Vehiculo("BBB222", "Honda CBR", 2, TipoVehiculo.MOTO, c2);
        empresa.registrarVehiculo(v1);
        empresa.registrarVehiculo(v2);

        Cliente cli1 = new Cliente("Carlos Ruiz", "555-1234", "carlos@email.com");
        Cliente cli2 = new Cliente("Ana Torres", "555-5678", "ana@email.com");
        empresa.registrarCliente(cli1);
        empresa.registrarCliente(cli2);

        empresa.asignarViaje("Centro", "Aeropuerto", 150.0, cli1, TipoVehiculo.AUTO);
        empresa.asignarViaje("Plaza", "Estadio", 80.0, cli2, TipoVehiculo.MOTO);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENÚ DE PRUEBA ---");
            System.out.println("1. Mostrar conductores");
            System.out.println("2. Mostrar vehículos");
            System.out.println("3. Mostrar clientes");
            System.out.println("4. Mostrar viajes");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            int op = sc.nextInt();
            sc.nextLine();

            if (op == 0) break;

            switch (op) {
                case 1:
                    System.out.println("\nConductores registrados:");
                    for (Conductor c : empresa.getConductores()) {
                        System.out.println(c);
                    }
                    break;
                case 2:
                    System.out.println("\nOpción no disponible: la empresa no expone la lista de vehículos.");
                    break;
                case 3:
                    System.out.println("\nClientes registrados:");
                    for (Cliente cli : empresa.getClientes()) {
                        System.out.println(cli);
                    }
                    break;
                case 4:
                    System.out.println("\nViajes realizados:");
                    empresa.mostrarViajes();
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }
}