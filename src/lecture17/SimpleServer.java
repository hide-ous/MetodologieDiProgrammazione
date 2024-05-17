package lecture17;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server in ascolto sulla porta 12345...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connessione accettata da " + clientSocket.getInetAddress());

            try (OutputStream outputStream = clientSocket.getOutputStream()) {
                String message = "Ciao dal server!";
                outputStream.write(message.getBytes());
                outputStream.flush();
                System.out.println("Messaggio inviato al client.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
