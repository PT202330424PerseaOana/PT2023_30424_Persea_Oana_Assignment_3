package presentation;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * This class represents the EditClientView.
 */

public class EditClientView {
    private JPanel panel1;
    public JTextField textField1;
    public JTextField textField2;
    public JTextField textField3;
    public JTextField textField4;
    public JTextField textField5;
    public JButton updateButton;
    private JLabel message;
    public JButton backButton;

    public JFrame editClient;


    /**
     * Constructs a new EditClientView object.
     */
    public EditClientView() {
        editClient = new JFrame("");
        editClient.setDefaultCloseOperation(EXIT_ON_CLOSE);
        editClient.setPreferredSize(new Dimension(1000, 800));
        editClient.setResizable(false);
        editClient.add(panel1);
        editClient.pack();
        editClient.setLocationRelativeTo(null);
    }
    /**
     * Hides the frame.
     */

    public void hideFrame() {
        editClient.setVisible(false);
    }

    /**
     * Shows the frame.
     */

    public void showFrame() {
        editClient.setVisible(true);
    }

    /**
     * Displays a message requesting client's ID.
     */

    public void showMessage() {
        message.setText("Please enter client's ID");
    }

    /**
     * Hides the message requesting client's ID.
     */

    public void hideMessage() {
        message.setText("");
    }

}
