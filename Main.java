import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Registrar conductor");
            System.out.println("2. Registrar vehículo");
            System.out.println("3. Registrar cliente");
            System.out.println("4. Asignar viaje");
            System.out.println("5. Mostrar viajes");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            int op = sc.nextInt();
            sc.nextLine();

            if (op == 0) break;

            switch (op) {
                case 1:
                    System.out.print("Nombre del conductor: ");
                    String nombreC = sc.nextLine();
                    System.out.print("Licencia: ");
                    String licencia = sc.nextLine();
                    System.out.print("Años de experiencia: ");
                    int anios = sc.nextInt();
                    sc.nextLine();
                    empresa.registrarConductor(new Conductor(nombreC, licencia, anios));
                    System.out.println("Conductor registrado.");
                    break;
                case 2:
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Capacidad de pasajeros: ");
                    int cap = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Tipo (AUTO, MOTO, CAMIONETA): ");
                    String tipoStr = sc.nextLine();
                    TipoVehiculo tipo = TipoVehiculo.valueOf(tipoStr.toUpperCase());
                    System.out.print("Nombre del conductor asignado: ");
                    String nombreCond = sc.nextLine();
                    Conductor conductor = null;
                    for (Conductor c : empresa.getConductores()) {
                        if (c.getNombre().equalsIgnoreCase(nombreCond)) {
                            conductor = c;
                            break;
                        }
                    }
                    if (conductor == null) {
                        System.out.println("Conductor no encontrado. Registre el conductor primero.");
                    } else {
                        empresa.registrarVehiculo(new Vehiculo(placa, modelo, cap, tipo, conductor));
                        System.out.println("Vehículo registrado.");
                    }
                    break;
                case 3:
                    System.out.print("Nombre del cliente: ");
                    String nombreCli = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String tel = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    empresa.registrarCliente(new Cliente(nombreCli, tel, email));
                    System.out.println("Cliente registrado.");
                    break;
                case 4:
                    System.out.print("Nombre del cliente: ");
                    String nombreCliente = sc.nextLine();
                    Cliente cliente = null;
                    for (Cliente cli : empresa.getClientes()) {
                        if (cli.getNombre().equalsIgnoreCase(nombreCliente)) {
                            cliente = cli;
                            break;
                        }
                    }
                    if (cliente == null) {
                        System.out.println("Cliente no encontrado. Registre el cliente primero.");
                        break;
                    }
                    System.out.print("Origen: ");
                    String origen = sc.nextLine();
                    System.out.print("Destino: ");
                    String destino = sc.nextLine();
                    System.out.print("Costo: ");
                    double costo = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Tipo de vehículo (AUTO, MOTO, CAMIONETA): ");
                    String tipoV = sc.nextLine();
                    TipoVehiculo tipoVehiculo = TipoVehiculo.valueOf(tipoV.toUpperCase());
                    empresa.asignarViaje(origen, destino, costo, cliente, tipoVehiculo);
                    break;
                case 5:
                    empresa.mostrarViajes();
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }
}