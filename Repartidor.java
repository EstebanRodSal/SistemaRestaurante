import java.util.ArrayList;
import java.util.List;


public class Repartidor {

    // Atributos de la clase Repartidor

    /**
     * El nombre del repartidor.
     */
    private String nombre;

    /**
     * La placa del vehículo del repartidor.
     */
    private String placa;

    /**
     * El tipo de vehículo que utiliza el repartidor.
     */
    private String tipoVehiculo;

    /**
     * Lista de pedidos express que el repartidor debe entregar.
     */
    private List<PedidosExpres> pedidosExpres = new ArrayList<PedidosExpres>();

    private int entregas;

    // Constructores

    /**
     * Constructor de la clase `Repartidor`.
     * Crea una instancia de Repartidor con información sobre el nombre, placa del vehículo,
     * tipo de vehículo y una lista de pedidos express que debe entregar.
     * @param nombre El nombre del repartidor.
     * @param placa La placa del vehículo del repartidor.
     * @param tipoVehiculo El tipo de vehículo que utiliza el repartidor.
     * @param pedidosExpres Lista de pedidos express que el repartidor debe entregar.
     */
    public Repartidor(String nombre, String placa, String tipoVehiculo, List<PedidosExpres> pedidosExpres, int entregas) {
        this.nombre = nombre;
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.pedidosExpres = pedidosExpres;
        this.entregas = entregas;
    }

    // Métodos de acceso (Getters y Setters)

    /**
     * Obtiene el nombre del repartidor.
     * @return El nombre del repartidor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del repartidor.
     * @param nombre El nombre del repartidor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la placa del vehículo del repartidor.
     * @return La placa del vehículo del repartidor.
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Establece la placa del vehículo del repartidor.
     * @param placa La placa del vehículo del repartidor.
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * Obtiene el tipo de vehículo que utiliza el repartidor.
     * @return El tipo de vehículo del repartidor.
     */
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * Establece el tipo de vehículo que utiliza el repartidor.
     * @param tipoVehiculo El tipo de vehículo del repartidor.
     */
    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * Obtiene la lista de pedidos express que el repartidor debe entregar.
     * @return Lista de pedidos express que el repartidor debe entregar.
     */
    public List<PedidosExpres> getPedidosExpres() {
        return pedidosExpres;
    }

    /**
     * Establece la lista de pedidos express que el repartidor debe entregar.
     * @param pedidosExpres Lista de pedidos express que el repartidor debe entregar.
     */
    public void setPedidosExpres(List<PedidosExpres> pedidosExpres) {
        this.pedidosExpres = pedidosExpres;
    }

    // Métodos específicos de la clase Repartidor

    /**
     * Método que permite al repartidor entregar los pedidos express.
     * Debes implementar la lógica específica para la entrega de pedidos aquí.
     */
    public void entregarPedidos() {
        System.out.println("El repartidor " + this.nombre + " llevará a cabo la entrega");
        this.entregas += 1;
    }

    public int getEntregas() {
        return entregas;
    }

    public void setEntregas(int entregas) {
        this.entregas = entregas;
    }

    public void cantidadDeEntregasPorRepartidor(ArrayList<Repartidor> repartidores) {
        System.out.println("Lista de entregas por cada repartidor \n");
        ArrayList<Repartidor> listaAux = new ArrayList<>();

        while (!repartidores.isEmpty()) {
            int mayorEntregas = -1;
            Repartidor repartidorAux = null;

            for (Repartidor repartidor : repartidores) {
                int entregasActuales = repartidor.getEntregas();
                if (entregasActuales > mayorEntregas) {
                    mayorEntregas = entregasActuales;
                    repartidorAux = repartidor;
                }
            }

            if (repartidorAux != null) {
                listaAux.add(repartidorAux);
                repartidores.remove(repartidorAux);
            }
        }

        // Imprimir los nombres de los repartidores en listaAux
        for (Repartidor repartidor : listaAux) {
            System.out.println(repartidor.getNombre()+" - Entregas: "+repartidor.getEntregas());
        }
    }
}