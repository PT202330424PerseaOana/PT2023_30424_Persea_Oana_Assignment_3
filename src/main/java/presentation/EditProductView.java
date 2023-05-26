package presentation;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * This class represents the EditProductView.
 */

public class EditProductView {
    private JPanel panel1;
    public JTextField textField1;
    public JButton backButton;
    public JTextField textField2;
    public JTextField textField3;
    public JTextField textField4;
    public JLabel message;
    public JButton updateButton;
    public JFrame editProduct;

    /**
     * Constructs a new EditProductView object.
     */
    public EditProductView() {
        editProduct = new JFrame("");
        editProduct.setDefaultCloseOperation(EXIT_ON_CLOSE);
        editProduct.setPreferredSize(new Dimension(1000, 800));
        editProduct.setResizable(false);
        editProduct.add(panel1);
        editProduct.pack();
        editProduct.setLocationRelativeTo(null);
    }

    /**
     * Hides the frame.
     */
    public void hideFrame() {
        editProduct.setVisible(false);
    }
    /**
     * Shows the frame.
     */


    public void showFrame() {
        editProduct.setVisible(true);
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
