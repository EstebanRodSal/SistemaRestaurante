import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainRestaurante {

    public static void limpiarTerminal() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (final Exception e) {
            // Manejo de excepciones
            System.out.println("Error al limpiar la terminal.");
        }
    }

    public static void GenerarReporte() {
        limpiarTerminal();
        // Verificar si es una orden para servicio a domicilio
        // Reporte: Total de ventas diarias
        System.out.println("Reporte de Total de Ventas Diarias:");
        List<Orden> ventasDiarias = new ArrayList<>(registroPedidosTotal);
        Collections.sort(ventasDiarias, new Comparator<Orden>() {
            @Override
            public int compare(Orden o1, Orden o2) {
                // Comparar por la cantidad de opciones de menú vendidas de forma descendente
                int cantidadOpcionesO1 = o1.getComida().size();
                int cantidadOpcionesO2 = o2.getComida().size();
                return Integer.compare(cantidadOpcionesO2, cantidadOpcionesO1);
            }
        });

        for (Orden orden : ventasDiarias) {
            List<Producto> comidaOrdenada = orden.getComida();
            StringBuilder detallesVenta = new StringBuilder();
            for (Producto producto : comidaOrdenada) {
                detallesVenta.append(producto.getNombre()).append(", ");
            }
            detallesVenta.delete(detallesVenta.length() - 2, detallesVenta.length()); // Eliminar la última coma y espacio
            System.out.println("Orden: " + detallesVenta.toString() + " - Cantidad de Opciones Vendidas: " + comidaOrdenada.size());
        }

        // Reporte: Reporte de servicio a domicilio
        System.out.println("\nReporte de Servicio a Domicilio:");
        List<Orden> ordenesExpress = new ArrayList<>(registroPedidosExpress);
        Map<String, Integer> entregasPorEntidad = new HashMap<>();

        for (Orden orden : ordenesExpress) {
            String entidadServicio = orden.getCliente().getNombre();
            entregasPorEntidad.put(entidadServicio, entregasPorEntidad.getOrDefault(entidadServicio, 0) + 1);
        }

        entregasPorEntidad.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> {
                    System.out.println("Entidad de Servicio: " + entry.getKey() + " - Cantidad de Entregas: " + entry.getValue());
                });
        
    }









    

    private static List<Orden> registroPedidosTotal = new ArrayList<Orden>(); //Esta lista contiene todos los pedidos totales
    private static List<Orden> registroPedidosExpress = new ArrayList<Orden>(); //Esta lista contiene todos los pedidos express solamente


    public static void main(String[] args) {

        limpiarTerminal();

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

        //Creación de los empleados
        Empleados empleado1 = new Empleados("Juan Daniel", "Chef");
        Empleados empleado2 = new Empleados("Marta", "Chef");



    

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

                    registroPedidosTotal.add(elección); //Agrega el pedido a la lista de pedidos para mantener un registro de todos


                    
                        // Envía una confirmación al cliente de que se recibió su producto
                        System.out.println("Orden recibida del cliente: " + elección.getComida());
                        outputStream.writeObject("Orden recibida por el Restaurante con éxito: " + elección.getComida());
                        System.out.println(elección.getCliente().getNombre());


                        System.out.println("Asocie la orden recibida a algún empleado");
                        System.out.println("Digite 1 para Juan Daniel");
                        System.out.println("Digite 2 para Marta");

                        Scanner scanner = new Scanner(System.in);
                        byte userInput = scanner.nextByte();
                        scanner.nextLine();  
                        boolean salida = false;

                        while (!salida){
                            if (userInput == 1){//Juan Daniel
                                System.out.println("Productos asociados al empleado Juan Daniel" );
                                for (Producto producto : elección.getComida()){
                                    
                                    empleado1.addOrdenes(producto);
                                    salida = true;
                                }

                            }else if (userInput == 2){
                                System.out.println("Productos asociados al empleado Marta" );
                                for (Producto producto : elección.getComida()){
                                    empleado2.addOrdenes(producto);
                                    salida = true;

                                }

                            }else{
                                System.out.println("Empleado no encontrado");
                            }
                        }




                        if (userInput == 1){
                            boolean todosCompletados = false;
                            while (!todosCompletados) {
                                limpiarTerminal();
                                todosCompletados = true;  
                                
                                System.out.println("Productos asociados al empleado:");
                                for (int i = 0; i < empleado1.getOrdenes().size(); i++) {
                                    Producto producto = empleado1.getOrdenes().get(i);
                                    System.out.println(i + 1 + ". " + producto.getNombre() + " - Completado: " + producto.getCompletado());
                                    if (!producto.getCompletado()) {
                                        todosCompletados = false;  // Si encuentra un producto no completado, establece todosCompletados en false
                                    }
                                }

                                if (todosCompletados) {
                                    System.out.println("¡Todos los productos asociados al empleado " + empleado1.getNombre() + " han sido marcados como completados!");
                                    break;  // Sale del bucle si todos los productos están completados
                                }

                                // Solicita al usuario que marque los productos como completados
                                System.out.println("Ingrese el número del producto que desea marcar como completado (o 0 para continuar):");

                                int selectedProduct = scanner.nextInt();

                                if (selectedProduct > 0 && selectedProduct <= empleado1.getOrdenes().size()) {
                                    Producto productoSeleccionado = empleado1.getOrdenes().get(selectedProduct - 1);
                                    productoSeleccionado.setCompletado(true);
                                    System.out.println("El producto " + productoSeleccionado.getNombre() + " ha sido marcado como completado.");
                                }
                            }
                        }else{
                            boolean todosCompletados = false;
                            while (!todosCompletados) {
                                limpiarTerminal();
                                todosCompletados = true;  
                                
                                System.out.println("Productos asociados al empleado:");
                                for (int i = 0; i < empleado2.getOrdenes().size(); i++) {
                                    Producto producto = empleado2.getOrdenes().get(i);
                                    System.out.println(i + 1 + ". " + producto.getNombre() + " - Completado: " + producto.getCompletado());
                                    if (!producto.getCompletado()) {
                                        todosCompletados = false;  // Si encuentra un producto no completado, establece todosCompletados en false
                                    }
                                }

                                if (todosCompletados) {
                                    System.out.println("¡Todos los productos asociados al empleado " + empleado2.getNombre() + " han sido marcados como completados!");
                                    break;  // Sale del bucle si todos los productos están completados
                                }

                                // Solicita al usuario que marque los productos como completados
                                System.out.println("Ingrese el número del producto que desea marcar como completado (o 0 para continuar):");

                                int selectedProduct = scanner.nextInt();

                                if (selectedProduct > 0 && selectedProduct <= empleado2.getOrdenes().size()) {
                                    Producto productoSeleccionado = empleado2.getOrdenes().get(selectedProduct - 1);
                                    productoSeleccionado.setCompletado(true);
                                    System.out.println("El producto " + productoSeleccionado.getNombre() + " ha sido marcado como completado.");
                                }
                            }
                        
                        }
                        

                        

                       

                    if (elección.getExpress()){//Si la orden es express se manda a mainExpress
                        // Enviar la orden recibida por sockets a MainExpress
                        registroPedidosExpress.add(elección);
                        try {
                            // Abre una conexión al servidor de MainExpress
                            Socket expressSocket = new Socket("localhost", 54321); //Se tiene que colocar la IP del express


                            // Envia la orden a MainExpress
                            ObjectOutputStream expressOutputStream = new ObjectOutputStream(expressSocket.getOutputStream());
                            expressOutputStream.writeObject(elección);
                            System.out.println("Orden enviada al repartidor");


                        } catch (IOException e) {
                            e.printStackTrace();
                        } break;
                    }else {
                        // Enviar la orden recibida por sockets a MainCliente
                        try {
                            // Abre una conexión al servidor de MainExpress
                            Socket expressSocket = new Socket("localhost", 123); //Se tiene que colocar la IP del cliente

                            // Envia la orden a MainExpress
                            ObjectOutputStream expressOutputStream = new ObjectOutputStream(expressSocket.getOutputStream());
                            expressOutputStream.writeObject(elección);
                            System.out.println("Orden entregada al cliente: " + elección.getCliente().getNombre());
                        }catch (IOException e) {
                            e.printStackTrace();
                        } break;
                    }
                    
                    

                }
                

                

                GenerarReporte();

                // Cierra la conexión con el cliente
                //socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }
}
