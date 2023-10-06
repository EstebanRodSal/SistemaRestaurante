import java.io.*;
import java.net.*;

public class MainRestaurante {

    public static void main(String[] args) {
        // Creación del menú
        Producto empanada = new Producto("Empanada", 2500, "Comida Rápida", true);
        Producto sandwich = new Producto("Sandwich", 3000, "Comida Rápida", true);
        Producto tortaChilena = new Producto("Torta Chilena", 3500, "Repostería", true);
        Producto pastel = new Producto("Pastel", 2500, "Repostería", true);
        Producto café = new Producto("Cafe", 1500, "Bebidas Calientes", true);
        Producto téFrio = new Producto("Te Frío", 1000, "Bebidas Frías", true);
        
        // Agregacion de los productos al menú
        Menú menú = new Menú();
        menú.agregarProducto(empanada);
        menú.agregarProducto(sandwich);
        menú.agregarProducto(tortaChilena);
        menú.agregarProducto(pastel);
        menú.agregarProducto(café);
        menú.agregarProducto(téFrio);
    

        // Apertura del servidor
        try {
            ServerSocket serverSocket = new ServerSocket(12345); // Puerto para la comunicación
            System.out.println("Esperando a clientes...");

            while (true) {
                Socket socket = serverSocket.accept(); // Esperar a que un cliente se conecte
                //Conexión con un cliente
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(menú); // Envia el menú al cliente
                System.out.println("Un cliente se ha conectado al sistema");

                while (true){
                



                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

                System.out.println("ESPERANDO ORDEN");
                // Recibe la elección del cliente (Comida)
                Orden elección = (Orden) inputStream.readObject();



                
                // Envía una confirmación al cliente de que se recibió su producto
                System.out.println("Orden recibida del cliente: " + elección);
                outputStream.writeObject("Orden recibida con éxito: " + elección);
                System.out.println(elección.getCliente().getNombre());
                }
                

                


            
                    


                // Cierra la conexión con el cliente
                //socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }
}
