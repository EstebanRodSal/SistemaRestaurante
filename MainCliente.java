import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * MainCliente es una clase que permite a los clientes interactuar con un sistema de pedidos.
 * Los clientes pueden generar pedidos, proporcionar sus datos y comunicarse con un servidor para realizar pedidos.
 */
public class MainCliente {
    //Limpiar terminal
    public static void limpiarTerminal() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (final Exception e) {
            // Manejo de excepciones
            System.out.println("Error al limpiar la terminal.");
        }
    }

    /**
     * Genera un pedido basado en la elección del usuario y los productos disponibles.
     *
     * @param productos ArrayList de productos disponibles para ordenar.
     * @param cliente   El cliente que está realizando el pedido.
     * @return Orden    Un objeto de tipo Orden que contiene los detalles del pedido.
     */
    public static Orden generarPedido(ArrayList<Producto> productos, Cliente cliente) {
        // Código de escape ANSI para color Verde Agua
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_RESET = "\u001B[0m";
        
        System.out.println();
        System.out.println(ANSI_CYAN + "Digite 1 si es para comer en el local" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "Digite 2 si es para retirar en el autoServicio" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "Digite 3 si es para servicio express" + ANSI_RESET);

        Scanner scanner = new Scanner(System.in);
        byte userInput = scanner.nextByte();
        scanner.nextLine();  // Consumir el carácter de nueva línea

        Orden pedido = null; 

        // Crear el pedido basado en la elección del usuario
        if (userInput == 1) {
            pedido = new PedidoRestaurante(productos, "3/10/23", "Descripción", false, false, true, cliente, 5);
        } else if (userInput == 2) {
            pedido = new AutoServicio(productos, "3/10/23", "Descripción", false, true, false, cliente, "10:50:00");
        } else if (userInput == 3) {
            pedido = new PedidosExpres(productos, "3/10/23", "Descripción", true, false, false, cliente, cliente.getDireccion());
        }

        return pedido;
    }

    /**
     * Obtiene los datos del cliente a través de la entrada del usuario.
     *
     * @return Cliente Un objeto Cliente que contiene los datos del cliente.
     */
    public static Cliente obtenerDatosCliente() {
        Scanner scanner = new Scanner(System.in);
        String nombre, direccion, metodoPago = "";
        int identificacion;
    
        // Código de escape ANSI para color Rojo
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";
        // Código de escape ANSI para color Azul
        final String ANSI_BLUE = "\u001B[34m";
        // Código de escape ANSI para color Verde Agua
        final String ANSI_CYAN = "\u001B[36m";

    
        // Validación para el nombre
        do {
            System.out.print(ANSI_BLUE + "Introduce el nombre del cliente: " + ANSI_RESET);
            nombre = scanner.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println(ANSI_RED + "El nombre no puede estar en blanco. Por favor, introduce un nombre válido." + ANSI_RESET);
            }
        } while (nombre.isEmpty());
    
        // Validación para el número de identificación
        do {
            System.out.print(ANSI_BLUE + "Introduce el número de telefono del cliente: " + ANSI_RESET);
            while (!scanner.hasNextInt()) { // Verifica si el usuario ingresó un número
                System.out.println(ANSI_RED + "Eso no es un número válido. Por favor, introduce un número válido." + ANSI_RESET);
                scanner.next(); // Descarta la entrada incorrecta
            }
            identificacion = scanner.nextInt();
            scanner.nextLine();  // Consumir el carácter de nueva línea
        } while (identificacion <= 0); // Asume que el telefono debe ser un número positivo
    
        // Validación para la dirección
        do {
            System.out.print(ANSI_BLUE + "Introduce la dirección del cliente: " + ANSI_RESET);
            direccion = scanner.nextLine().trim();
            if (direccion.isEmpty()) {
                System.out.println(ANSI_RED + "La dirección no puede estar en blanco. Por favor, introduce una dirección válida." + ANSI_RESET);
            }
        } while (direccion.isEmpty());
    
        // Validación para el método de pago
        do {
            System.out.println(ANSI_BLUE + "Selecciona el método de pago del cliente:" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "1. Tarjeta" + ANSI_RESET);
            System.out.println(ANSI_CYAN +"2. Efectivo" + ANSI_RESET);
            System.out.println(ANSI_CYAN +"3. Sinpe Móvil" + ANSI_RESET);
            System.out.print(ANSI_CYAN +"Opcion: " + ANSI_RESET);
            int opcionPago = scanner.nextInt();
            scanner.nextLine();  // Consumir el carácter de nueva línea
    
            switch (opcionPago) {
                case 1:
                    metodoPago = "Tarjeta";
                    break;
                case 2:
                    metodoPago = "Efectivo";
                    break;
                case 3:
                    metodoPago = "Sinpe Móvil";
                    break;
                default:
                    System.out.println(ANSI_RED + "Opción no válida. Por favor, selecciona una opción válida." + ANSI_RESET);
            }
        } while (metodoPago.isEmpty());
    
        return new Cliente(nombre, identificacion, direccion, metodoPago);
    }
    
    

    /**
     * Método principal que permite al cliente interactuar con el sistema de pedidos.
     * El cliente puede seleccionar productos del menú, generar un pedido, y enviarlo al servidor.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en este contexto).
     */
    public static void main(String[] args) {
        // Códigos de escape ANSI para color verde
        final String ANSI_GREEN = "\u001B[32m";// Códigos de escape ANSI para color verde
        // Códigos de escape ANSI para color rojo
        final String ANSI_RED = "\u001B[31m";
        // Códigos de escape ANSI para color Amarillo
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_RESET = "\u001B[0m";

        System.out.println(ANSI_GREEN + "¡Bienvenido al sistema de pedidos!" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "----------------------------------"+ ANSI_RESET);

        ArrayList<Producto> ordenFinal = new ArrayList<>(); // Esta lista contiene la orden final del cliente

        Cliente cliente = obtenerDatosCliente();  // Solicitar datos del cliente inicialmente

        try {
            // Establecer conexión con el servidor
            Socket socket = new Socket("LocalHost", 12345);
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Menú menúRecibido = (Menú) inputStream.readObject(); // Recibir el menú del servidor

            Scanner scanner = new Scanner(System.in);
            String eleccion = "";
            boolean continuarPedido = true;

            // Bucle para permitir al usuario hacer múltiples pedidos
            while (continuarPedido) {
                System.out.println();
                System.out.println(ANSI_YELLOW + "Menú Recibido:" + ANSI_RESET);
                System.out.println(menúRecibido);
                System.out.println();
                System.out.println("Elige un producto del menú o escribe 'Enviar' para enviar la orden: ");
                System.out.println();
                eleccion = scanner.nextLine();

                if (eleccion.equalsIgnoreCase("Enviar")) {
                    // Validación para asegurarse de que la orden no esté vacía
                    if (ordenFinal.isEmpty()) {
                        System.out.println(ANSI_RED + "No puedes enviar un pedido vacío. Por favor, selecciona al menos un producto." + ANSI_RESET);
                        continue; // Vuelve al inicio del bucle
                    }

                    // Enviar el pedido al servidor
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeObject(generarPedido(ordenFinal, cliente));

                    // Recibir confirmación del servidor
                    String confirmacion = (String) inputStream.readObject();
                    System.out.println("Servidor: " + confirmacion);
                    try {
                        ServerSocket serverSocket = new ServerSocket(123); // Puerto para la comunicación con MainRestaurante
                        System.out.println("Esperando orden");
                        
                        while (true) {
                            System.out.println("----");
                            Socket socket2 = serverSocket.accept(); // Esperar a que el restaurante envíe una orden
                            System.out.println("----");
                            ObjectInputStream inputStream2 = new ObjectInputStream(socket2.getInputStream());

                            // Recibe la orden desde el restaurante
                            Orden orden = (Orden) inputStream2.readObject();

                            
                            System.out.println("¡Su orden de " + orden.getComida() + " ha sido entregada!");
                            System.out.println("-------------------------------------------");
                            System.out.println("¡Gracias por utilizar nuestro sistema de pedidos! ¡Hasta pronto!");
                            //Se cierra el socket
                            socket.close();
                            break;
                        }
                    } catch (IOException e) {
                        // Maneja la excepción de entrada/salida aquí
                        e.printStackTrace(); // O puedes manejarla de otra manera según tus necesidades
                    }
                    System.out.println("¿Deseas realizar otro pedido? (Sí/No)");
                    String respuesta = scanner.nextLine();
                    if (respuesta.equalsIgnoreCase("No")) {
                        continuarPedido = false;
                    } else {
                        
                        limpiarTerminal(); // Limpia la terminal
                        ordenFinal.clear(); // Limpiar la lista para el siguiente pedido
                        cliente = obtenerDatosCliente();  // Solicitar datos del nuevo cliente
                    }
                } else {
                    // Aquí se mantiene el código original para agregar productos al pedido
                    if (eleccion.equalsIgnoreCase("Empanada")) {
                        ordenFinal.add(menúRecibido.getProducto("Empanada"));
                        System.out.println(ANSI_GREEN + "Producto Registrado" + ANSI_RESET);
                    } else if (eleccion.equalsIgnoreCase("Sandwich")) {
                        ordenFinal.add(menúRecibido.getProducto("Sandwich"));
                        System.out.println(ANSI_GREEN + "Producto Registrado" + ANSI_RESET);
                    } else if (eleccion.equalsIgnoreCase("Torta Chilena")) {
                        ordenFinal.add(menúRecibido.getProducto("Torta Chilena"));
                        System.out.println(ANSI_GREEN + "Producto Registrado" + ANSI_RESET);
                    } else if (eleccion.equalsIgnoreCase("Pastel")) {
                        ordenFinal.add(menúRecibido.getProducto("Pastel"));
                        System.out.println(ANSI_GREEN + "Producto Registrado" + ANSI_RESET);
                    } else if (eleccion.equalsIgnoreCase("Cafe")) {
                        ordenFinal.add(menúRecibido.getProducto("Cafe"));
                        System.out.println(ANSI_GREEN + "Producto Registrado" + ANSI_RESET);
                    } else if (eleccion.equalsIgnoreCase("Te frio")) {
                        ordenFinal.add(menúRecibido.getProducto("Te frio"));
                        System.out.println(ANSI_GREEN + "Producto Registrado" + ANSI_RESET);
                    } else {
                        System.out.println();
                        System.out.println(ANSI_RED + "Producto no encontrado" + ANSI_RESET);
                    }
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
