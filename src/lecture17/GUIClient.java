package lecture17;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class GUIClient {
    private JTextArea chatArea;
    private Socket socket;

    public GUIClient() {
        // Creazione dell'interfaccia grafica
        JFrame frame = new JFrame("Client Chat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        JButton connectButton = new JButton("Connetti al Server");
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToServer();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(connectButton);

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void connectToServer() {
        try {
            socket = new Socket("localhost", 12345);
            chatArea.append("Connesso al server.\n");

            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String message = new String(buffer, 0, bytesRead);

            chatArea.append("Messaggio ricevuto dal server: " + message + "\n");
        } catch (IOException e) {
            chatArea.append("Errore nella connessione al server.\n");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUIClient());
    }
}

