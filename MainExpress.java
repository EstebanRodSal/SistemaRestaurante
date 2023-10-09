import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal que representa el sistema de entrega de pedidos.
 */
public class MainExpress {

    /**
     * Método principal que inicia el sistema de entrega de pedidos.
     * @param args Argumentos de línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        // Creación de repartidores
        Repartidor repartidor1 = new Repartidor("Luis", "n3j2n4o2n34u", "Pick Up", null,0);
        Repartidor repartidor2 = new Repartidor("Andrés", "j32n4jo2n4", "Motocicleta", null,0);
        Repartidor repartidor3 = new Repartidor("Esteban", "3jn432kjn5kn", "caudraciclo", null,0);

        ArrayList<Repartidor> listaRepartidores = new ArrayList<Repartidor>();
        listaRepartidores.add(repartidor1);
        listaRepartidores.add(repartidor2);
        listaRepartidores.add(repartidor3);


        while (true) {
            try {
                ServerSocket serverSocket = new ServerSocket(54321);
                System.out.println("Esperando órdenes desde el restaurante...");
                while (true) {
                    Socket socket = serverSocket.accept();
                    ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

                    // Recibe la orden desde el restaurante
                    Orden orden = (Orden) inputStream.readObject();

                    // Procesa la orden
                    System.out.println("----------------------------------------------");
                    System.out.println("Orden recibida desde el restaurante: " + orden.getComida());
                    System.out.println("Seleccione el número del repartidor para realizar la siguiente entrega:");
                    System.out.println("1 - Luis");
                    System.out.println("2 - Andrés");
                    System.out.println("3 - Esteban");

                    Scanner scanner3 = new Scanner(System.in);

                    int repartidorNumero = scanner3.nextInt();

                    switch (repartidorNumero) {
                        case 1:
                            repartidor1.entregarPedidos();
                            break;
                        case 2:
                            repartidor2.entregarPedidos();
                            break;
                        case 3:
                            repartidor3.entregarPedidos();
                            break;
                        default:
                            System.out.println("Repartidor Luis seleccionado por defecto");
                            repartidor1.entregarPedidos();
                            break;
                    }
                    System.out.println("----------------------------------------------");

                    System.out.println("Digite 'mostrar' para ver dirección del cliente");

                    Scanner scanner2 = new Scanner(System.in);
                    boolean mostrarDireccion = false;
                    
                    while (!mostrarDireccion) {
                        String input2 = scanner2.nextLine();
                    
                        if (input2.trim().equalsIgnoreCase("mostrar")) {
                             System.out.println("----------------------------------------------");

                            System.out.println("Dirección del cliente: " + orden.getCliente().getDireccion());
                            System.out.println("Recorrido iniciado");
                            mostrarDireccion = true;  // Sal del bucle ya que se ha mostrado la dirección
                        } else {
                            System.out.println("Comando no reconocido. Digite 'mostrar' para ver la dirección del cliente.");
                        }
                    }
                    boolean recorridoIniciado = false;

                    // Bucle para pedir 'iniciar' hasta que se ingrese correctamente
                    while (!recorridoIniciado) {
                        System.out.println("----------------------------------------------");

                        System.out.println("Escribe 'entregada' cuando se realice la entrega:");
                        Scanner scanner = new Scanner(System.in);
                        String input = scanner.nextLine();
                
                        if (input.trim().equalsIgnoreCase("entregada")) {
                            recorridoIniciado = true;
                        } else {
                            System.out.println("Comando incorrecto. Por favor, escribe 'entregada' si ya se realizó la entrega del pedido.");
                        }
                    }
                    if (recorridoIniciado) {
                        System.out.println("----------------------------------------------");
                        try {
                            // Abre una conexión al servidor de MainExpress
                            Socket expressSocket2 = new Socket("localhost", 123);

                            // Envia la orden a MainExpress
                            ObjectOutputStream expressOutputStream = new ObjectOutputStream(expressSocket2.getOutputStream());
                            expressOutputStream.writeObject(orden);
                            System.out.println("Entrega finalizada");
                            socket.close();
                        } catch (IOException e) {
                            // Maneja la excepción de entrada/salida aquí
                            e.printStackTrace(); // O puedes manejarla de otra manera según tus necesidades
                        }
                    }

                    // Cierra la conexión con el restaurante
                    socket.close();
                    serverSocket.close();
                    break;
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            Scanner scannerFinal = new Scanner(System.in);
            System.out.println("----------------------------------------------");

            System.out.println("Digite ´S´ para continuar o cualquier otra tecla para salir del sistema");
            String input = scannerFinal.nextLine();
            if (!input.equalsIgnoreCase("S")) {
                System.out.println("Saliendo del sistema...");
                break;
            } else {
                continue;
            }
        }
        try {
            Socket socketFinal =  new Socket("localHost",124);
            ObjectOutputStream outputStream = new ObjectOutputStream(socketFinal.getOutputStream());
            outputStream.writeObject(repartidor1);
            outputStream.writeObject(listaRepartidores);
        } catch (IOException e) {
            // En caso de una excepción de tipo IOException (error de E/S)
            e.printStackTrace(); // Imprime la traza del error en la consola
            System.err.println("Ocurrió un error de E/S: " + e.getMessage()); // Mensaje personalizado
        }
    }
}