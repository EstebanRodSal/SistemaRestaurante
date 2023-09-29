import java.util.ArrayList;
import java.util.List;


public class Empleados {

    // Atributos de la clase Empleados

    /**
     * El nombre del empleado.
     */
    private String nombre;

    /**
     * La categoría o cargo del empleado.
     */
    private String categoria;

    /**
     * Lista de detalles relacionados con este empleado.
     */
    private List<Detalles> detalles = new ArrayList<Detalles>();

    /**
     * Lista de órdenes relacionadas con este empleado.
     */
    private List<Orden> ordenes = new ArrayList<Orden>();

    // Constructores

    /**
     * Constructor de la clase `Empleados`.
     * @param nombre El nombre del empleado.
     * @param categoria La categoría o cargo del empleado.
     * @param detalles Lista de detalles relacionados con este empleado.
     * @param ordenes Lista de órdenes relacionadas con este empleado.
     */
    public Empleados(String nombre, String categoria, List<Detalles> detalles, List<Orden> ordenes) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.detalles = detalles;
        this.ordenes = ordenes;
    }

    // Métodos de acceso (Getters y Setters)

    /**
     * Obtiene el nombre del empleado.
     * @return El nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     * @param nombre El nombre del empleado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la categoría o cargo del empleado.
     * @return La categoría o cargo del empleado.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría o cargo del empleado.
     * @param categoria La categoría o cargo del empleado.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtiene la lista de detalles relacionados con este empleado.
     * @return Lista de detalles relacionados con este empleado.
     */
    public List<Detalles> getDetalles() {
        return detalles;
    }

    /**
     * Establece la lista de detalles relacionados con este empleado.
     * @param detalles Lista de detalles relacionados con este empleado.
     */
    public void setDetalles(List<Detalles> detalles) {
        this.detalles = detalles;
    }

    /**
     * Obtiene la lista de órdenes relacionadas con este empleado.
     * @return Lista de órdenes relacionadas con este empleado.
     */
    public List<Orden> getOrdenes() {
        return ordenes;
    }

    /**
     * Establece la lista de órdenes relacionadas con este empleado.
     * @param ordenes Lista de órdenes relacionadas con este empleado.
     */
    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    // Métodos específicos de la clase Empleados

    /**
     * Método que permite asociar una orden al empleado.
     * Debes implementar la lógica específica para asociar órdenes a empleados según tus requisitos.
     */
    public void asociarOrden() {
        // Implementa la lógica de asociación de órdenes aquí.
    }
}
