import java.util.ArrayList;
import java.util.List;

public class Orden {

    // Atributos de la clase Orden

    /**
     * La comida solicitada en la orden.
     */
    private String comida;

    /**
     * La fecha en que se realizó la orden.
     */
    private String fecha;

    /**
     * Descripción de la orden o detalles adicionales.
     */
    private String descripcion;

    /**
     * Indica si la orden es express.
     */
    private String express;

    /**
     * Indica si la orden se retirará en el local.
     */
    private String retirarLocal;

    /**
     * Indica si la orden se consumirá en el local.
     */
    private String comerLocal;

    /**
     * Lista de clientes asociados a la orden.
     */
    private List<Cliente> cliente = new ArrayList<Cliente>();

    // Constructores

    /**
     * Constructor de la clase `Orden`.
     * @param comida La comida solicitada en la orden.
     * @param fecha La fecha en que se realizó la orden.
     * @param descripcion Descripción de la orden o detalles adicionales.
     * @param express Indica si la orden es express.
     * @param retirarLocal Indica si la orden se retirará en el local.
     * @param comerLocal Indica si la orden se consumirá en el local.
     * @param cliente Lista de clientes asociados a la orden.
     */
    public Orden(String comida, String fecha, String descripcion, String express, String retirarLocal,
            String comerLocal, List<Cliente> cliente) {
        this.comida = comida;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.express = express;
        this.retirarLocal = retirarLocal;
        this.comerLocal = comerLocal;
        this.cliente = cliente;
    }

    // Métodos de acceso (Getters y Setters)

    /**
     * Obtiene la comida solicitada en la orden.
     * @return La comida solicitada en la orden.
     */
    public String getComida() {
        return comida;
    }

    /**
     * Establece la comida solicitada en la orden.
     * @param comida La comida solicitada en la orden.
     */
    public void setComida(String comida) {
        this.comida = comida;
    }

    /**
     * Obtiene la fecha en que se realizó la orden.
     * @return La fecha en que se realizó la orden.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha en que se realizó la orden.
     * @param fecha La fecha en que se realizó la orden.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la descripción de la orden o detalles adicionales.
     * @return Descripción de la orden o detalles adicionales.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la orden o detalles adicionales.
     * @param descripcion Descripción de la orden o detalles adicionales.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Indica si la orden es express.
     * @return `true` si la orden es express, `false` en caso contrario.
     */
    public String getExpress() {
        return express;
    }

    /**
     * Establece si la orden es express.
     * @param express Indica si la orden es express.
     */
    public void setExpress(String express) {
        this.express = express;
    }

    /**
     * Indica si la orden se retirará en el local.
     * @return `true` si la orden se retirará en el local, `false` en caso contrario.
     */
    public String getRetirarLocal() {
        return retirarLocal;
    }

    /**
     * Establece si la orden se retirará en el local.
     * @param retirarLocal Indica si la orden se retirará en el local.
     */
    public void setRetirarLocal(String retirarLocal) {
        this.retirarLocal = retirarLocal;
    }

    /**
     * Indica si la orden se consumirá en el local.
     * @return `true` si la orden se consumirá en el local, `false` en caso contrario.
     */
    public String getComerLocal() {
        return comerLocal;
    }

    /**
     * Establece si la orden se consumirá en el local.
     * @param comerLocal Indica si la orden se consumirá en el local.
     */
    public void setComerLocal(String comerLocal) {
        this.comerLocal = comerLocal;
    }

    /**
     * Obtiene la lista de clientes asociados a la orden.
     * @return Lista de clientes asociados a la orden.
     */
    public List<Cliente> getCliente() {
        return cliente;
    }

    /**
     * Establece la lista de clientes asociados a la orden.
     * @param cliente Lista de clientes asociados a la orden.
     */
    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }

    // Métodos específicos de la clase Orden

    /**
     * Método que permite generar un reporte o realizar acciones específicas relacionadas con la orden.
     * Debes implementar la lógica específica para generar el reporte o realizar las acciones necesarias.
     */
    public void GenerarReporte() {
        // Implementa la lógica de generación de reporte aquí.
    }
}
