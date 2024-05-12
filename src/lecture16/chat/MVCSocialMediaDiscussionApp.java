package lecture16.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class MVCSocialMediaDiscussionApp {

    public static void main(String[] args) {
        DiscussionModel model = new DiscussionModel();
        DiscussionView view = new DiscussionView();
        DiscussionController controller = new DiscussionController(model, view);

        view.setController(controller);
        model.addObserver(view);

        JFrame frame = new JFrame("Social Media Discussion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(view);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        AutomatedUser automatedUser = new AutomatedUser(model);
        automatedUser.start();
    }
}

class DiscussionModel extends Observable {
    private ArrayList<String> messages;

    public DiscussionModel() {
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

class DiscussionView extends JPanel implements Observer {
    private JTextArea discussionTextArea;
    private JTextField messageTextField;
    private JButton sendButton;
    private DiscussionController controller;

    public DiscussionView() {
        setLayout(new BorderLayout());

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
                    controller.sendMessage("You: " + message);
                    messageTextField.setText("");
                }
            }
        });
    }

    public void setController(DiscussionController controller) {
        this.controller = controller;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof DiscussionModel) {
            DiscussionModel model = (DiscussionModel) o;
            discussionTextArea.setText("");
            for (String message : model.getMessages()) {
                discussionTextArea.append(message + "\n");
            }
        }
    }
}

class DiscussionController {
    private DiscussionModel model;
    private DiscussionView view;

    public DiscussionController(DiscussionModel model, DiscussionView view) {
        this.model = model;
        this.view = view;
    }

    public void sendMessage(String message) {
        model.addMessage(message);
    }
}

class AutomatedUser extends Thread {
    private Random random;
    private DiscussionModel model;

    public AutomatedUser(DiscussionModel model) {
        this.model = model;
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
                model.addMessage("AutomatedUser: This is an automated message.");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
