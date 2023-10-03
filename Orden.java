import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Orden implements Serializable{

    // Atributos de la clase Orden

    /**
     * La comida solicitada en la orden.
     */
    private ArrayList<Producto> comida;

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
    private boolean express;

    /**
     * Indica si la orden se retirará en el local.
     */
    private boolean retirarLocal;

    /**
     * Indica si la orden se consumirá en el local.
     */
    private boolean comerLocal;

    /**
     * Lista de clientes asociados a la orden.
     */
    private Cliente cliente;

     /**
     * id de la orden.
     */
    private int idComanda = 1;

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
    public Orden(ArrayList<Producto> comida, String fecha, String descripcion, boolean express, boolean retirarLocal,
            boolean comerLocal, Cliente cliente) {
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
    public ArrayList<Producto> getComida() {
        return comida;
    }



    public int getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }



    /**
     * Establece la comida solicitada en la orden.
     * @param comida La comida solicitada en la orden.
     */
    public void setComida(ArrayList<Producto> comida) {
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
    public boolean getExpress() {
        return express;
    }

    /**
     * Establece si la orden es express.
     * @param express Indica si la orden es express.
     */
    public void setExpress(boolean express) {
        this.express = express;
    }

    /**
     * Indica si la orden se retirará en el local.
     * @return `true` si la orden se retirará en el local, `false` en caso contrario.
     */
    public boolean getRetirarLocal() {
        return retirarLocal;
    }

    /**
     * Establece si la orden se retirará en el local.
     * @param retirarLocal Indica si la orden se retirará en el local.
     */
    public void setRetirarLocal(boolean retirarLocal) {
        this.retirarLocal = retirarLocal;
    }

    /**
     * Indica si la orden se consumirá en el local.
     * @return `true` si la orden se consumirá en el local, `false` en caso contrario.
     */
    public boolean getComerLocal() {
        return comerLocal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Establece si la orden se consumirá en el local.
     * @param comerLocal Indica si la orden se consumirá en el local.
     */
    public void setComerLocal(boolean comerLocal) {
        this.comerLocal = comerLocal;
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
