import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainExpress {
public static void main(String[] args) {
    try {
            ServerSocket serverSocket = new ServerSocket(54321); // Puerto para la comunicación con MainRestaurante
            System.out.println("Esperando órdenes desde el restaurante...");

            while (true) {
                Socket socket = serverSocket.accept(); // Esperar a que el restaurante envíe una orden
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

                // Recibe la orden desde el restaurante
                Orden orden = (Orden) inputStream.readObject();

                // Procesa la orden
                System.out.println("Orden recibida desde el restaurante: " + orden);


                // Cierra la conexión con el restaurante           -------> LUIS, VALIDE USTED SI HACE FALTA CERRARLO YA DEPENDE DE SU CODIGO
                socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
}
}
