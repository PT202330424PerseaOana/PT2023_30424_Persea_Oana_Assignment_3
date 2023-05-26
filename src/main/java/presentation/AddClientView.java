package presentation;

import javax.swing.*;
import java.awt.*;

/**
 * The AddClientView class represents the graphical user interface for adding a new client.
 * It provides methods to show, hide, and interact with the add client frame, as well as display
 * error messages and handle user input.
 */
public class AddClientView extends JFrame{
    private JPanel panel1;
    public JTextField textField1;
    public JTextField textField2;
    public JTextField textField3;
    public JTextField textField4;
    public JButton addClientButton;
    public JLabel textField5;
    public JButton backButton;

    public JFrame addClientFrame;

    public AddClientView() {
        addClientFrame = new JFrame("");
        addClientFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        addClientFrame.setPreferredSize(new Dimension(1000, 800));
        addClientFrame.setResizable(false);
        addClientFrame.add(panel1);
        addClientFrame.pack();
        addClientFrame.setLocationRelativeTo(null);
    }

    /**
     * Hides the add client frame.
     */
    public void hideFrame() {
    addClientFrame.setVisible(false);
    }

    /**
     * Shows the add client frame.
     */

    public void showFrame() {
        addClientFrame.setVisible(true);
    }

    /**
     * Displays a message indicating that a required field is empty.
     */


    public void showMessage() {
        textField5.setVisible(true);
    }

    /**
     * Disables the add client button.
     */

    public void disableButton() {
        addClientButton.setEnabled(false);
    }

    /**
     * Enables the add client button.
     */

    public void enableButton() {
        addClientButton.setEnabled(true);
    }

    /**
     * Displays an error message indicating that some fields are empty.
     */

    public void fieldsEmpty() {
        textField5.setText("Please enter all necessary data");
    }

    /**
     * Clears the error message indicating empty fields.
     */

    public void fieldsNotEmpty() {
        textField5.setText("");
    }
}
