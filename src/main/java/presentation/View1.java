package presentation;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents View1.
 */
public class View1 extends JFrame {
    private JPanel panel1;
    public JButton clientButton;
    public JButton productButton;
    public JButton orderButton;

    public JFrame frame;

    /**
     * Constructs a new View1 object.
     */
    public View1() {
        frame = new JFrame("");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000, 800));
        frame.setResizable(false);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        clientButton.setPreferredSize(new Dimension(20,20));
//        frame.setVisible(true);


    }

    /**
     * Hides the frame.
     */

    public void hideFrame() {
        frame.setVisible(false);
    }

    /**
     * Shows the frame.
     */

    public void showFrame() {
        frame.setVisible(true);
    }
}
