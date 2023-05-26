package presentation;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * This class represents the OrderView.
 */
public class OrderView {
    public JPanel panel1;
    public JButton backButton;
    public JTextField textField1;
    public JTextField textField2;
    public JTextField textField3;
    public JButton addOrderButton;
    public JLabel textField5;
    public JPanel panel;

    public JFrame orderView;

    /**
     * Constructs a new OrderView object.
     */
    public OrderView() {
        orderView = new JFrame("");
        orderView.setDefaultCloseOperation(EXIT_ON_CLOSE);
        orderView.setPreferredSize(new Dimension(1000, 800));
        orderView.setResizable(false);
        orderView.add(panel1);
        orderView.pack();
        orderView.setLocationRelativeTo(null);
    }

    /**
     * Shows the frame.
     */

    public void showFrame() {
        orderView.setVisible(true);
    }

    /**
     * Hides the frame.
     */

    public void hideFrame() {
        orderView.setVisible(false);
    }

    /**
     * Displays a message requesting necessary details.
     */

    public void showMessage() {
        textField5.setText("Please provide all necessary details");
    }

    /**
     * Hides the message requesting necessary details.
     */

    public void hideMessage() {
        textField5.setText("");
    }

    /**
     * Displays a message indicating not enough stock.
     */

    public void notEnoughStock() {
        textField5.setText("There isnt enough stock for the product you have chosen");

    }
}
