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
     * Lista de órdenes relacionadas con este empleado.
     */
    private List<Producto> producto = new ArrayList<Producto>();

    // Constructores

    /**
     * Constructor de la clase `Empleados`.
     * @param nombre El nombre del empleado.
     * @param categoria La categoría o cargo del empleado.
     * @param detalles Lista de detalles relacionados con este empleado.
     * @param ordenes Lista de órdenes relacionadas con este empleado.
     */
    public Empleados(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
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
     * Obtiene la lista de órdenes relacionadas con este empleado.
     * @return Lista de órdenes relacionadas con este empleado.
     */
    public List<Producto> getOrdenes() {
        return producto;
    }

    /**
     * Establece la lista de órdenes relacionadas con este empleado.
     * @param ordenes Lista de órdenes relacionadas con este empleado.
     */
    public void addOrdenes(Producto orden) {
        this.producto.add(orden);
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
