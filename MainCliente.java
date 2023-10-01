import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MainCliente {

    public static void main(String[] args) {
        // Recibir el menú mediante sockets
        try {

            //Establecimiento de conexión mediante sockets entre el cliente y el restaurante
            Socket socket = new Socket("localhost", 12345); // Conectar al servidor en localhost
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Menú menúRecibido = (Menú) inputStream.readObject(); // Variable que almacena el menú del Restaurante

            // Se imprime el menú
            System.out.println("Menú Recibido:");
            System.out.println(menúRecibido);

            // Permitir al cliente seleccionar un producto del menú
            Scanner scanner = new Scanner(System.in);
            System.out.print("Elige un producto del menú: ");
            String eleccion = scanner.nextLine();

            // Envia la elección al servidor del restaurante
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(eleccion);

            // Recibe la confirmación del servidor
            String confirmacion = (String) inputStream.readObject();
            System.out.println("Servidor: " + confirmacion);

            //socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
