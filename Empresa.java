// =======================================
// Clase: Empresa
// Descripción: Representa una empresa de transporte que gestiona conductores, 
// vehículos, clientes y viajes.
// =======================================
import java.util.*;

public class Empresa {

    // =======================================
    // Atributos
    // =======================================
    // Lista de conductores registrados en la empresa
    private List<Conductor> conductores = new ArrayList<>();
    
    // Lista de vehículos registrados en la empresa
    private List<Vehiculo> vehiculos = new ArrayList<>();
    
    // Lista de clientes registrados en la empresa
    private List<Cliente> clientes = new ArrayList<>();
    
    // Lista de viajes realizados o asignados
    private List<Viaje> viajes = new ArrayList<>();

    // =======================================
    // Métodos
    // =======================================

    // Devuelve la lista de conductores
    public List<Conductor> getConductores() {
        return conductores;
    }

    // Devuelve la lista de clientes
    public List<Cliente> getClientes() {
        return clientes;
    }

    // Registra un nuevo conductor en la lista de conductores
    public void registrarConductor(Conductor conductor) {
        conductores.add(conductor);
    }

    // Registra un nuevo vehículo en la lista de vehículos
    public void registrarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    // Registra un nuevo cliente en la lista de clientes
    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    /* 
       Asigna un viaje a un vehículo disponible de un tipo específico.
       - origen: lugar de inicio del viaje
       - destino: lugar de llegada
       - costo: costo del viaje
       - cliente: cliente que solicita el viaje
       - tipoVehiculo: tipo de vehículo requerido para el viaje
    */
    public void asignarViaje(String origen, String destino, double costo, Cliente cliente, TipoVehiculo tipoVehiculo) {
        Vehiculo vehiculoDisponible = null;

        // Buscar un vehículo del tipo solicitado
        for (Vehiculo v : vehiculos) {
            if (v.getTipo() == tipoVehiculo) {
                vehiculoDisponible = v;
                break;
            }
        }

        // Si se encuentra un vehículo, se crea y agrega el viaje
        if (vehiculoDisponible != null) {
            Viaje viaje = new Viaje(origen, destino, costo, cliente, vehiculoDisponible);
            viajes.add(viaje);
            System.out.println("Viaje asignado exitosamente.");
        } else {
            System.out.println("No hay vehículos disponibles de tipo " + tipoVehiculo);
        }
    }

    // Muestra todos los viajes registrados en la empresa
    public void mostrarViajes() {
        if (viajes.isEmpty()) {
            System.out.println("No hay viajes registrados.");
        } else {
            for (Viaje v : viajes) {
                System.out.println(v);
            }
        }
    }
}
