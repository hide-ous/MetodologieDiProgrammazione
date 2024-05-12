package lecture16.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class ObservableSocialMediaDiscussionApp extends JFrame {

    private JTextArea discussionTextArea;
    private JTextField messageTextField;
    private JButton sendButton;

    private Discussion discussion;

    public ObservableSocialMediaDiscussionApp() {
    	System.out.println("here");
        setTitle("Social Media Discussion");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        discussion = new Discussion();

        discussionTextArea = new JTextArea();
        discussionTextArea.setEditable(false);
        JScrollPane discussionScrollPane = new JScrollPane(discussionTextArea);
        add(discussionScrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        messageTextField = new JTextField();
        sendButton = new JButton("Send");
        bottomPanel.add(messageTextField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);
        

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageTextField.getText();
                if (!message.isEmpty()) {
                    discussion.addMessage("You: " + message);
                    messageTextField.setText("");
                }
            }
        });

        discussion.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                updateDiscussion();
            }
        });

        // Start the automated user thread
        AutomatedUser automatedUser = new AutomatedUser();
        automatedUser.start();
    }

    private void updateDiscussion() {
        discussionTextArea.setText("");
        for (String message : discussion.getMessages()) {
            discussionTextArea.append(message + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ObservableSocialMediaDiscussionApp().setVisible(true);
            }
        });
    }

    class AutomatedUser extends Thread {
        private Random random;

        public AutomatedUser() {
            random = new Random();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    // Sleep for random interval (between 3 to 10 seconds)
                    int sleepTime = random.nextInt(8) + 3;
                    Thread.sleep(sleepTime * 1000);

                    // Add automated message to discussion
                    discussion.addMessage("AutomatedUser: This is an automated message.");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Discussion extends Observable {
    private ArrayList<String> messages;

    public Discussion() {
        messages = new ArrayList<>();
    }

    public void addMessage(String message) {
        messages.add(message);
        setChanged();
        notifyObservers();
    }

    public ArrayList<String> getMessages() {
        return messages;
    }
}
