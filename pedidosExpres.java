import java.util.ArrayList;

public class PedidosExpres extends Orden {

    // Atributos de la clase pedidosExpres

    /**
     * La dirección de entrega de la orden express.
     */
    private String dirección;

    // Constructores

    /**
     * Constructor de la clase `pedidosExpres`.
     * Crea una instancia de pedidosExpres con información sobre la comida, fecha, descripción,
     * si es una orden express, si se retirará en el local, si se consumirá en el local, la lista de clientes y la dirección de entrega.
     * @param comida La comida solicitada en la orden.
     * @param fecha La fecha en que se realizó la orden.
     * @param descripcion Descripción de la orden o detalles adicionales.
     * @param express Indica si la orden es express.
     * @param retirarLocal Indica si la orden se retirará en el local.
     * @param comerLocal Indica si la orden se consumirá en el local.
     * @param cliente Cliente asociado a la orden.
     * @param dirección La dirección de entrega de la orden express.
     */
    public PedidosExpres(ArrayList<Producto> comida, String fecha, String descripcion, boolean express, boolean retirarLocal,
    boolean comerLocal, Cliente cliente, String dirección) {
        super(comida, fecha, descripcion, express, retirarLocal, comerLocal, cliente);
        this.dirección = dirección;
    }

    // Métodos de acceso (Getters y Setters)

    /**
     * Obtiene la dirección de entrega de la orden express.
     * @return La dirección de entrega de la orden express.
     */
    public String getDirección() {
        return dirección;
    }

    /**
     * Establece la dirección de entrega de la orden express.
     * @param dirección La dirección de entrega de la orden express.
     */
    public void setDirección(String dirección) {
        this.dirección = dirección;
    }
}
