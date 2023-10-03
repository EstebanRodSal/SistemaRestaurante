import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainCliente {

    

    public static Orden generarPedido(ArrayList<Producto> productos, Cliente cliente) {
        System.out.println("Digite 1 si es para comer en el local");
        System.out.println("Digite 2 si es para retirar en el autoServicio");
        System.out.println("Digite 3 si es para servicio express");
        
        Scanner scanner = new Scanner(System.in);
        byte userInput = scanner.nextByte();
        scanner.close();
    
        Orden pedido = null; // Inicializamos a null
    
        if (userInput == 1) {
            pedido = new PedidoRestaurante(productos, "3/10/23", "Descripción", false, false, true, cliente, 5);
        } else if (userInput == 2) {
            pedido = new AutoServicio(productos, "3/10/23", "Descripción", false, true, false, cliente, "10:50:00");
        } else if (userInput == 3) {
            pedido = new PedidosExpres(productos, "3/10/23", "Descripción", true, false, false, cliente, cliente.getDireccion());
        }
    
        return pedido;
    }
    



    public static void main(String[] args) {
        ArrayList<Producto> ordenFinal = new ArrayList<>(); //Esta lista contiene la orden final del cliente, que va a ser enviada al restaurante


        Cliente cliente = new Cliente("Juan", 88784596, "La llanada", "Tarjeta");
        // Recibir el menú mediante sockets
        try {

            //Establecimiento de conexión mediante sockets entre el cliente y el restaurante
            Socket socket = new Socket("localhost", 12345); // Conectar al servidor en localhost
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Menú menúRecibido = (Menú) inputStream.readObject(); // Se recibe el menú

            // Se imprime el menú
            System.out.println("Menú Recibido:");
            System.out.println(menúRecibido);

            // Permitir al cliente seleccionar un producto del menú
            Scanner scanner = new Scanner(System.in);
            System.out.print("Escriba 'Enviar' para enviar la orden");
            System.out.print("Elige un producto del menú: ");


        
        
            String eleccion = "";
            while (!eleccion.equalsIgnoreCase("Enviar")){
                eleccion= scanner.nextLine();

                //Contempla que la elección sea escrito o no en mayuscula
                if (eleccion.equalsIgnoreCase("Empanada")) {
                    ordenFinal.add(menúRecibido.getProducto("Empanada"));
                    System.out.println("Producto Registrado");


                } else if (eleccion.equalsIgnoreCase("Sandwich")) {
                    ordenFinal.add(menúRecibido.getProducto("Sandwich"));
                    System.out.println("Producto Registrado");


                } else if (eleccion.equalsIgnoreCase("Torta Chilena")) {
                    ordenFinal.add(menúRecibido.getProducto("Torta Chilena"));
                    System.out.println("Producto Registrado");


                } else if (eleccion.equalsIgnoreCase("Pastel")) {
                    ordenFinal.add(menúRecibido.getProducto("Pastel"));
                    System.out.println("Producto Registrado");


                } else if (eleccion.equalsIgnoreCase("Café")) {
                    ordenFinal.add(menúRecibido.getProducto("Café"));
                    System.out.println("Producto Registrado");


                } else if (eleccion.equalsIgnoreCase("Te frío")) {
                    ordenFinal.add(menúRecibido.getProducto("Te frío"));
                    System.out.println("Producto Registrado");


                } else {
                    System.out.println("Producto no encontrado");
                }
            }
            

            
            




            // Envia la elección al servidor del restaurante
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(generarPedido(ordenFinal, cliente));


            // Recibe la confirmación del servidor de que se recibió la orden
            String confirmacion = (String) inputStream.readObject();
            System.out.println("Servidor: " + confirmacion);



            /**---------------LEER Y BORRAR-------------------
             * Debería de usarse scanner's, no quemar el dato con está a continuación      
             * En este momento ya se envia el pedido mediante sockets al mainRestaurnte
             * Lo que queda lo dejo a criterio suyo para que el input de los datos y la estetica quede bien linda    
             */

            

            //socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
