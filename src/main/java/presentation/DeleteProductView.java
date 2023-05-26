package presentation;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * This class represents the DeleteProductView.
 */
public class DeleteProductView {
    private JPanel panel1;
    public JButton backButton;
    public JTextField textField1;
    public JTextField textField2;
    public JTextField textField3;
    public JTextField textField4;
    public JLabel message;
    public JButton deleteButton;

    public JFrame deleteProductView;

    /**
     * Constructs a new DeleteProductView object.
     */

    public DeleteProductView() {

        deleteProductView = new JFrame("");
        deleteProductView.setDefaultCloseOperation(EXIT_ON_CLOSE);
        deleteProductView.setPreferredSize(new Dimension(1000, 800));
        deleteProductView.setResizable(false);
        deleteProductView.add(panel1);
        deleteProductView.pack();
        deleteProductView.setLocationRelativeTo(null);

    }

    /**
     * Shows the frame.
     */

    public void showFrame() {
        deleteProductView.setVisible(true);
    }

    /**
     * Hides the frame.
     */

    public void hideFrame() {
        deleteProductView.setVisible(false);
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
