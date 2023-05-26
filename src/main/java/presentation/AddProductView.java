package presentation;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 * The AddProductView class represents the graphical user interface for adding a new product.
 * It provides methods to show, hide, and interact with the add product frame, as well as display
 * error messages and handle user input.
 */
public class AddProductView {
    private JPanel panel1;
    public JButton backButton;
    public JTextField textField1;
    public JTextField textField2;
    public JTextField textField3;
    public JButton addProductButton;
    public JLabel textField5;

    public JFrame addProductFrame;

    /**
     * Constructs an instance of the AddProductView class.
     * Initializes the add product frame and sets its properties.
     */
    public AddProductView() {
        addProductFrame = new JFrame("");
        addProductFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        addProductFrame.setPreferredSize(new Dimension(1000, 800));
        addProductFrame.setResizable(false);
        addProductFrame.add(panel1);
        addProductFrame.pack();
        addProductFrame.setLocationRelativeTo(null);
    }

    /**
     * Hides the add product frame.
     */
    public void hideFrame() {
        addProductFrame.setVisible(false);
    }

    /**
     * Shows the add product frame.
     */

    public void showFrame() {
        addProductFrame.setVisible(true);
    }

    /**
     * Displays the error message label.
     */


    public void showMessage() {
        textField5.setVisible(true);
    }

    /**
     * Disables the add product button.
     */

    public void disableButton() {
        addProductFrame.setEnabled(false);
    }

    /**
     * Sets the error message label to indicate that fields are empty.
     */


    public void fieldsEmpty() {
        textField5.setText("Please enter all necessary data");
    }

    /**
     * Clears the error message label.
     */

    public void fieldsNotEmpty() {
        textField5.setText("");
    }
}
