import java.util.ArrayList;
import java.util.List;

public class Producto {

    // Atributos de la clase Producto

    /**
     * El nombre del producto.
     */
    private String nombre;

    /**
     * El precio del producto.
     */
    private int precio;

    /**
     * La categoría a la que pertenece el producto.
     */
    private String categoria;

    /**
     * Indica si el producto está disponible.
     */
    private String disponible;

    /**
     * Lista de detalles relacionados con este producto.
     */
    private List<Detalles> ordenes = new ArrayList<Detalles>();

    /**
     * Lista de menús a los que pertenece el producto.
     */
    private List<Menú> menú = new ArrayList<Menú>();

    // Constructores

    /**
     * Constructor de la clase `Producto`.
     * Crea una instancia de Producto con información sobre el nombre, precio, categoría,
     * disponibilidad, órdenes relacionadas y menús a los que pertenece.
     * @param nombre El nombre del producto.
     * @param precio El precio del producto.
     * @param categoria La categoría a la que pertenece el producto.
     * @param disponible Indica si el producto está disponible.
     * @param ordenes Lista de detalles relacionados con este producto.
     * @param menú Lista de menús a los que pertenece el producto.
     */
    public Producto(String nombre, int precio, String categoria, String disponible, List<Detalles> ordenes,
            List<Menú> menú) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.disponible = disponible;
        this.ordenes = ordenes;
        this.menú = menú;
    }

    // Métodos de acceso (Getters y Setters)

    /**
     * Obtiene el nombre del producto.
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     * @param nombre El nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto.
     * @return El precio del producto.
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     * @param precio El precio del producto.
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la categoría a la que pertenece el producto.
     * @return La categoría del producto.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría del producto.
     * @param categoria La categoría del producto.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtiene la disponibilidad del producto.
     * @return La disponibilidad del producto.
     */
    public String getDisponible() {
        return disponible;
    }

    /**
     * Establece la disponibilidad del producto.
     * @param disponible La disponibilidad del producto.
     */
    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    /**
     * Obtiene la lista de detalles relacionados con este producto.
     * @return Lista de detalles relacionados con este producto.
     */
    public List<Detalles> getOrdenes() {
        return ordenes;
    }

    /**
     * Establece la lista de detalles relacionados con este producto.
     * @param ordenes Lista de detalles relacionados con este producto.
     */
    public void setOrdenes(List<Detalles> ordenes) {
        this.ordenes = ordenes;
    }

    /**
     * Obtiene la lista de menús a los que pertenece el producto.
     * @return Lista de menús a los que pertenece el producto.
     */
    public List<Menú> getMenú() {
        return menú;
    }

    /**
     * Establece la lista de menús a los que pertenece el producto.
     * @param menú Lista de menús a los que pertenece el producto.
     */
    public void setMenú(List<Menú> menú) {
        this.menú = menú;
    }
}
