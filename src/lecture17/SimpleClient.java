package lecture17;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("Connesso al server.");

            try (InputStream inputStream = socket.getInputStream()) {
                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Messaggio ricevuto dal server: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
