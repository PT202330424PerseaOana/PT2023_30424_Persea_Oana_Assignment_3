package presentation;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * This class represents the ProductView.
 */

public class ProductView {
    private JPanel panel1;
    public JButton addButton;
    public JButton deleteButton;
    public JButton editButton;
    public JButton viewAllButton;

    public JButton backButton;
    private JPanel panel;

    private JFrame productView;

    /**
     * Constructs a new ProductView object.
     */

    public ProductView(){
        productView = new JFrame("");
        productView.setDefaultCloseOperation(EXIT_ON_CLOSE);
        productView.setPreferredSize(new Dimension(1000, 800));
        productView.setResizable(false);
        productView.add(panel);
        productView.pack();
        productView.setLocationRelativeTo(null);
//        clientView.setVisible(true);
    }

    /**
     * Hides the frame.
     */

    public void hideFrame() {
        productView.setVisible(false);
    }

    /**
     * Shows the frame.
     */

    public void showFrame() {
        productView.setVisible(true);
    }

}
