// Enum TipoVehiculo
// -----------------
// Representa los tipos de vehículos disponibles.
enum TipoVehiculo {
    AUTO, MOTO, CAMIONETA
}

// Clase Conductor
// ---------------
// Representa un conductor de la empresa.
class Conductor {
    // Atributos
    private String nombre;
    private String licencia;
    private int aniosExperiencia;

    // Constructor
    public Conductor(String nombre, String licencia, int aniosExperiencia) {
        this.nombre = nombre;
        this.licencia = licencia;
        this.aniosExperiencia = aniosExperiencia;
    }

    // Métodos (getters)
    public String getNombre() { return nombre; }
    public String getLicencia() { return licencia; }
    public int getAniosExperiencia() { return aniosExperiencia; }

    // Método toString para mostrar información del conductor
    @Override
    public String toString() {
        return nombre + " (Licencia: " + licencia + ", Experiencia: " + aniosExperiencia + " años)";
    }
}

// Clase Vehiculo
// --------------
// Representa un vehículo de la empresa.
class Vehiculo {
    // Atributos
    private String placa;
    private String modelo;
    private int capacidadPasajeros;
    private TipoVehiculo tipo;
    private Conductor conductor;

    // Constructor
    public Vehiculo(String placa, String modelo, int capacidadPasajeros, TipoVehiculo tipo, Conductor conductor) {
        this.placa = placa;
        this.modelo = modelo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.tipo = tipo;
        this.conductor = conductor;
    }

    // Métodos (getters)
    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public int getCapacidadPasajeros() { return capacidadPasajeros; }
    public TipoVehiculo getTipo() { return tipo; }
    public Conductor getConductor() { return conductor; }

    // Método toString para mostrar información del vehículo
    @Override
    public String toString() {
        return tipo + " - " + modelo + " (" + placa + "), Capacidad: " + capacidadPasajeros + ", Conductor: " + conductor.getNombre();
    }
}

// Clase Cliente
// -------------
// Representa un cliente de la empresa.
class Cliente {
    // Atributos
    private String nombre;
    private String telefono;
    private String email;

    // Constructor
    public Cliente(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    // Métodos (getters)
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }

    // Método toString para mostrar información del cliente
    @Override
    public String toString() {
        return nombre + " (Tel: " + telefono + ", Email: " + email + ")";
    }
}

// Clase Viaje
// -----------
// Representa un viaje realizado por un cliente en un vehículo.
class Viaje {
    // Atributos
    private String origen;
    private String destino;
    private double costo;
    private Cliente cliente;
    private Vehiculo vehiculo;

    // Constructor
    public Viaje(String origen, String destino, double costo, Cliente cliente, Vehiculo vehiculo) {
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
    }

    // Método toString para mostrar información del viaje
    @Override
    public String toString() {
        return "Viaje de " + origen + " a " + destino + " | Costo: $" + costo +
                " | Cliente: " + cliente.getNombre() +
                " | Vehículo: " + vehiculo.getModelo() + " (" + vehiculo.getPlaca() + ")";
    }
}