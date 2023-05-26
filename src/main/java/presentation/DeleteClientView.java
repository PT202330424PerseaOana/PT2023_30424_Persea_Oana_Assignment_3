package presentation;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * This class represents the DeleteClientView.
 */
public class DeleteClientView {
    private JPanel panel1;
    public JTextField textField1;
    public JTextField textField2;
    public JTextField textField3;
    public JTextField textField4;
    public JTextField textField5;
    public JButton deleteButton;
    public JLabel message;
    public JButton backButton;

    public JFrame deleteClientView;

    /**
     * This class represents the DeleteClientView.
     */
    public DeleteClientView() {

            deleteClientView = new JFrame("");
            deleteClientView.setDefaultCloseOperation(EXIT_ON_CLOSE);
            deleteClientView.setPreferredSize(new Dimension(1000, 800));
            deleteClientView.setResizable(false);
            deleteClientView.add(panel1);
            deleteClientView.pack();
            deleteClientView.setLocationRelativeTo(null);

    }

    /**
     * Shows the frame.
     */

    public void showFrame() {
        deleteClientView.setVisible(true);
    }

    /**
     * Hides the frame.
     */

    public void hideFrame() {
        deleteClientView.setVisible(false);
    }

    /**
     * Displays a message indicating all fields are empty.
     */
    public void emptyField() {
        message.setText("All fields are empty");
    }

    /**
     * Clears the message indicating all fields are empty.
     */

    public void notEmptyField() {
        message.setText("");
    }

}
