import java.util.ArrayList;

public class AutoServicio extends Orden {

    // Atributos de la clase retirarPedido

    /**
     * La hora programada para el retiro del pedido.
     */
    private String horaRetiro;

    // Constructores

    /**
     * Constructor de la clase `retirarPedido`.
     * Crea una instancia de retirarPedido con información sobre la comida, fecha, descripción,
     * si es una orden express, si se retirará en el local, si se consumirá en el local,
     * la lista de clientes asociados y la hora programada para el retiro.
     * @param comida La comida solicitada en la orden.
     * @param fecha La fecha en que se realizó la orden.
     * @param descripcion Descripción de la orden o detalles adicionales.
     * @param express Indica si la orden es express.
     * @param retirarLocal Indica si la orden se retirará en el local.
     * @param comerLocal Indica si la orden se consumirá en el local.
     * @param cliente Cliente asociados a la orden.
     * @param horaRetiro La hora programada para el retiro del pedido.
     */
    public AutoServicio(ArrayList<Producto> comida, String fecha, String descripcion, boolean express, boolean retirarLocal,
    boolean comerLocal, Cliente cliente, String horaRetiro) {
        super(comida, fecha, descripcion, express, retirarLocal, comerLocal, cliente);
        this.horaRetiro = horaRetiro;
    }

    // Métodos de acceso (Getters y Setters)

    /**
     * Obtiene la hora programada para el retiro del pedido.
     * @return La hora programada para el retiro del pedido.
     */
    public String getHoraRetiro() {
        return horaRetiro;
    }

    /**
     * Establece la hora programada para el retiro del pedido.
     * @param horaRetiro La hora programada para el retiro del pedido.
     */
    public void setHoraRetiro(String horaRetiro) {
        this.horaRetiro = horaRetiro;
    }
}
