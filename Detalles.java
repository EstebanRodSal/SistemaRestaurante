import java.util.ArrayList;
import java.util.List;


public class Detalles {

    // Atributos de la clase Detalles

    /**
     * La cantidad de la entidad.
     */
    private String cantidad;

    /**
     * El estado de la entidad.
     */
    private String estado;

    /**
     * El descuento aplicado a la entidad (en bytes).
     */
    private byte descuento;

    /**
     * Lista de órdenes relacionadas con esta entidad.
     */
    private List<Orden> ordenes = new ArrayList<Orden>();

    // Constructores

    /**
     * Constructor de la clase `Detalles`.
     * @param cantidad La cantidad de la entidad.
     * @param estado El estado de la entidad.
     * @param descuento El descuento aplicado a la entidad (en bytes).
     * @param ordenes Lista de órdenes relacionadas con esta entidad.
     */
    public Detalles(String cantidad, String estado, byte descuento, List<Orden> ordenes) {
        this.cantidad = cantidad;
        this.estado = estado;
        this.descuento = descuento;
        this.ordenes = ordenes;
    }

    // Métodos de acceso (Getters y Setters)

    /**
     * Obtiene la cantidad de la entidad.
     * @return La cantidad de la entidad.
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de la entidad.
     * @param cantidad La cantidad de la entidad.
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el estado de la entidad.
     * @return El estado de la entidad.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la entidad.
     * @param estado El estado de la entidad.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el descuento aplicado a la entidad.
     * @return El descuento aplicado a la entidad (en bytes).
     */
    public byte getDescuento() {
        return descuento;
    }

    /**
     * Establece el descuento aplicado a la entidad.
     * @param descuento El descuento aplicado a la entidad (en bytes).
     */
    public void setDescuento(byte descuento) {
        this.descuento = descuento;
    }

    /**
     * Obtiene la lista de órdenes relacionadas con esta entidad.
     * @return Lista de órdenes relacionadas con esta entidad.
     */
    public List<Orden> getOrdenes() {
        return ordenes;
    }

    /**
     * Establece la lista de órdenes relacionadas con esta entidad.
     * @param ordenes Lista de órdenes relacionadas con esta entidad.
     */
    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }
}
