package lecture16.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SocialMediaDiscussionApp extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6421785127080761374L;
	private JTextArea discussionTextArea;
    private JTextField messageTextField;
    private JButton sendButton;

    private ArrayList<String> discussionMessages;

    public SocialMediaDiscussionApp() {
        setTitle("Social Media Discussion");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        discussionMessages = new ArrayList<>();

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
                    addMessage("You: " + message);
                    messageTextField.setText("");
                }
            }
        });
    }

    private void addMessage(String message) {
        discussionMessages.add(message);
        updateDiscussion();
    }

    private void updateDiscussion() {
        discussionTextArea.setText("");
        for (String message : discussionMessages) {
            discussionTextArea.append(message + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SocialMediaDiscussionApp().setVisible(true);
            }
        });
    }
}
