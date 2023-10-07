import java.util.ArrayList;
import java.util.List;


/**
 * Esta clase es la encargada de detallar cada pedio que se realiza
 */
public class Detalles {

    // Atributos de la clase Detalles



    /**
     * El estado de la entidad.
     */
    private Boolean entregado;

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
    public Detalles(Boolean estado, List<Orden> ordenes) {
        this.entregado = estado;
        this.ordenes = ordenes;
    }

    // Métodos de acceso (Getters y Setters)

    

    /**
     * Obtiene el estado de la entidad.
     * @return El estado de la entidad.
     */
    public Boolean getEstado() {
        return entregado;
    }

    /**
     * Establece el estado de la entidad.
     * @param estado El estado de la entidad.
     */
    public void setEntregado(Boolean estado) {
        this.entregado = estado;
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

    public void Entregar(){
        this.entregado = true;
    }
}
