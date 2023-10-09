import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Producto implements Serializable{

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
    private boolean disponible;



    /**
     * Lista de menús a los que pertenece el producto.
     */
    private List<Menú> menú = new ArrayList<Menú>();

    private Boolean completado = false;

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
    public Producto(String nombre, int precio, String categoria, boolean disponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.disponible = disponible;
    }

    // Métodos de acceso (Getters y Setters)

    @Override
    public String toString() {
        return  nombre + ", precio=" + precio + ", categoria=" + categoria + ", disponible="
                + disponible + " \n";
    }

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
    public boolean getDisponible() {
        return disponible;
    }

    /**
     * Establece la disponibilidad del producto.
     * @param disponible La disponibilidad del producto.
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
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

    /**
     * Obtinene si el producto ya fue completado por el chef.
     * @return true o false en caso de estar cocinado o no.
     */
    public Boolean getCompletado() {
        return completado;
    }

    /**
     * Establece un producto como completado o no.
     * @param completado estado del producto.
     */
    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }
}
