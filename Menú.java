import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Menú implements Serializable{

    // Atributos de la clase Menú

    /**
     * Lista de productos en el menú.
     */
    private ArrayList<Producto> productos = new ArrayList<>();

    // Constructores

    /**
     * Constructor de la clase `Menú`.
     * Crea una instancia de Menú con un producto inicialmente.
     * @param producto El primer producto que se va a agregar al menú.
     */
    public Menú(Producto producto) {
        agregarProducto(producto);
    }

        /**
     * Constructor de la clase `Menú`.
     * Crea una instancia de Menú con un producto inicialmente.
     */
    public Menú() {

    }

    // Métodos de la clase Menú

    /**
     * Agrega un producto al menú.
     * @param producto El producto que se va a agregar al menú.
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    /**
     * Elimina un producto del menú.
     * @param producto El producto que se va a eliminar del menú.
     */
    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    /**
     * Obtiene la lista de productos disponibles en el menú.
     * @return Lista de productos disponibles en el menú.
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * Genera una representación en forma de cadena de un objeto de la clase.
     * Este método sobrescribe el método toString estándar y devuelve una cadena
     * que muestra el menú del restaurante en el formato "-> producto1, producto2, ...".
     *
     * @return Una cadena que representa el menú del restaurante.
     */
    @Override
    public String toString() {
        System.out.println("-----Menú Restaurante-----");
        return String.format("-> %s", productos);
    }

    /**
     * Establece la lista de productos del restaurante.
     *
     * @param productos La lista de productos a establecer.
     */
    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    /**
     * Busca un producto en la lista de productos del restaurante por su nombre.
     *
     * @param nombreProducto El nombre del producto que se desea buscar.
     * @return El producto si se encuentra en la lista, o null si no se encuentra.
     */
    public Producto getProducto(String nombreProducto) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombreProducto)) {
                return producto; // Devuelve el producto si se encuentra por nombre
            }
        }
        return null; // Si no se encuentra el producto, devuelve null
    }

    


}
