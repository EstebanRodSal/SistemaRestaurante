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

    @Override
    public String toString() {
        System.out.println("-----Menú Restaurante-----");
        return String.format("-> %s", productos);
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public Producto getProducto(String nombreProducto) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombreProducto)) {
                return producto; // Devuelve el producto si se encuentra por nombre
            }
        }
        return null; // Si no se encuentra el producto, devuelve null
    }
    


}
