package lecture17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class GUIServer {
    private static String messageToSend = "";

    public static void main(String[] args) {
        // Creazione dell'interfaccia grafica
        JFrame frame = new JFrame("Server");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        
        JTextField messageField = new JTextField(20);
        JButton sendButton = new JButton("Invia Messaggio");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageToSend = messageField.getText();
                new Thread(() -> startServer()).start(); // Avvia il server in un thread separato
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Messaggio:"));
        panel.add(messageField);
        panel.add(sendButton);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server in ascolto sulla porta 12345...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connessione accettata da " + clientSocket.getInetAddress());

            try (OutputStream outputStream = clientSocket.getOutputStream()) {
                outputStream.write(messageToSend.getBytes());
                outputStream.flush();
                System.out.println("Messaggio inviato al client: " + messageToSend);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
