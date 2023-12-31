import java.io.Serializable;

public class Cliente implements Serializable{
    // Atributos privados de la clase Cliente
    private String nombre;       // Nombre del cliente
    private int numero;       // Número de cliente
    private String direccion;    // Dirección de entrega
    private String metodoDePago; // Método de pago preferido

    /**
     * Constructor de la clase Cliente.
     * @param nombre       Nombre del cliente.
     * @param numero       Número de cliente.
     * @param direccion    Dirección de entrega.
     * @param metodoDePago Método de pago preferido.
     * @param retirarLocal Preferencia de retiro local.
     */
    public Cliente(String nombre, int numero, String direccion, String metodoDePago) {
        this.nombre = nombre;
        this.numero = numero;
        this.direccion = direccion;
        this.metodoDePago = metodoDePago;
    }

    /**
     * Método para obtener el nombre del cliente.
     *
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre del cliente.
     *
     * @param nombre El nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener el número de cliente.
     *
     * @return El número de cliente.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Método para establecer el número de cliente.
     *
     * @param numero El nuevo número de cliente.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Método para obtener la dirección de entrega del cliente.
     *
     * @return La dirección de entrega del cliente.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Método para establecer la dirección de entrega del cliente.
     *
     * @param direccion La nueva dirección de entrega del cliente.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Método para obtener el método de pago preferido del cliente.
     *
     * @return El método de pago preferido del cliente.
     */
    public String getMetodoDePago() {
        return metodoDePago;
    }

    /**
     * Método para establecer el método de pago preferido del cliente.
     *
     * @param metodoDePago El nuevo método de pago preferido del cliente.
     */
    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    /**
     * Método que permite al cliente realizar un pedido.
     */
    public void RealizarPedido() {
        // Implementación del proceso para realizar un pedido
    }

    /**
     * Método que permite al cliente ver el menú disponible.
     */
    public void VerMenu() {
        // Implementación del proceso para ver el menú
    }
}
