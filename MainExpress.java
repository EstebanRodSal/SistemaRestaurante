import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;;

public class MainExpress {


    public static void main(String[] args) {

    Repartidor repartidor1 = new Repartidor("Luis", "n3j2n4o2n34u", "Pick Up", null,1);
    Repartidor repartidor2 = new Repartidor("Andrés", "j32n4jo2n4", "Motocicleta", null,1);
    Repartidor repartidor3 = new Repartidor("Esteban", "3jn432kjn5kn", "caudraciclo", null,2);

    ArrayList<Repartidor> listaRepartidores = new ArrayList<Repartidor>();
    listaRepartidores.add(repartidor1);
    listaRepartidores.add(repartidor2);
    listaRepartidores.add(repartidor3);

    repartidor1.cantidadDeEntregasPorRepartidor(listaRepartidores);
    while (true) {
        System.out.println("Seleccione el número del repartidor para realizar la siguiente entrega:");
        System.out.println("1 - Luis");
        System.out.println("2 - Andrés");
        System.out.println("3 - Esteban");
        
        Scanner scanner3 = new Scanner(System.in);
        
        int repartidorNumero = scanner3.nextInt();

        switch (repartidorNumero) {
            case 1:
                System.out.println(repartidor1.getNombre() + " realizará la entrega");
                repartidor1.entregarPedidos();
                break;
            case 2:
                System.out.println(repartidor2.getNombre() + " realizará la entrega");
                repartidor2.entregarPedidos();
                break;
            case 3:
                System.out.println(repartidor3.getNombre() + " realizará la entrega");
                repartidor3.entregarPedidos();
                break;
            default:
                System.out.println("Repartidor Luis seleccionado por defecto");
                repartidor1.getNombre();
                break;
        }

        try {
                ServerSocket serverSocket = new ServerSocket(54321); // Puerto para la comunicación con MainRestaurante
                System.out.println("Esperando órdenes desde el restaurante...");
                while (true) {
                    Socket socket = serverSocket.accept(); // Esperar a que el restaurante envíe una orden
                    ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

                    // Recibe la orden desde el restaurante
                    Orden orden = (Orden) inputStream.readObject();

                    // Procesa la orden
                    System.out.println("Orden recibida desde el restaurante: " + orden.getComida());

            System.out.println("Digite 'mostrar' para ver dirección del cliente");
            Scanner scanner2 = new Scanner(System.in);
            String input2 = scanner2.nextLine();
            if (input2.trim().equalsIgnoreCase("mostrar")) {
                System.out.println("Dirección del cliente: " + orden.getCliente().getDireccion());
            }
            System.out.println("Escribe 'iniciar' cuando comiences recorrido:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            // Verificar si el usuario ha ingresado 'iniciar'
            if (input.trim().equalsIgnoreCase("iniciar")) {
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


                    // Cierra la conexión con el restaurante           -------> LUIS, VALIDE USTED SI HACE FALTA CERRARLO YA DEPENDE DE SU CODIGO
                    socket.close();
                    serverSocket.close();
                    break;
                }
            
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            Scanner scannerFinal = new Scanner(System.in);
            System.out.println("Digite ´S´ para continuar o cualquier otra tecla para salir del sistema");
            String input = scannerFinal.nextLine();
            if (!input.equalsIgnoreCase("S")) {
                System.out.println("Saliendo del sistema...");
                break;
            } else {
                continue;
            }
        }

    }
}

