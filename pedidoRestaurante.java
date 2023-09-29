import java.util.List;


public class pedidoRestaurante extends Orden {

    // Atributos de la clase pedidoRestaurante

    /**
     * El número de mesa donde se realizará el pedido.
     */
    private byte numMesa;

    // Constructores

    /**
     * Constructor de la clase `pedidoRestaurante`.
     * Crea una instancia de pedidoRestaurante con información sobre la comida, fecha, descripción,
     * si es una orden express, si se retirará en el local, si se consumirá en el local, la lista de clientes y el número de mesa.
     * @param comida La comida solicitada en la orden.
     * @param fecha La fecha en que se realizó la orden.
     * @param descripcion Descripción de la orden o detalles adicionales.
     * @param express Indica si la orden es express.
     * @param retirarLocal Indica si la orden se retirará en el local.
     * @param comerLocal Indica si la orden se consumirá en el local.
     * @param cliente Lista de clientes asociados a la orden.
     * @param numMesa El número de mesa donde se realizará el pedido.
     */
    public pedidoRestaurante(String comida, String fecha, String descripcion, String express, String retirarLocal,
            String comerLocal, List<Cliente> cliente, byte numMesa) {
        super(comida, fecha, descripcion, express, retirarLocal, comerLocal, cliente);
        this.numMesa = numMesa;
    }

    // Métodos de acceso (Getters y Setters)

    /**
     * Obtiene el número de mesa donde se realizará el pedido.
     * @return El número de mesa donde se realizará el pedido.
     */
    public byte getNumMesa() {
        return numMesa;
    }

    /**
     * Establece el número de mesa donde se realizará el pedido.
     * @param numMesa El número de mesa donde se realizará el pedido.
     */
    public void setNumMesa(byte numMesa) {
        this.numMesa = numMesa;
    }
}
