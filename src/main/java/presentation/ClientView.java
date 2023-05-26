package presentation;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents the ClientView.
 */
public class ClientView extends JFrame{
    private JPanel panel1;
    public JButton addButton;
    public JButton deleteButton;
    public JButton editButton;
    public JButton viewAllButton;
    public JButton backButton;
    private JFrame clientView;

    /**
     * Constructs a new ClientView object.
     */

    public ClientView(){
        clientView = new JFrame("");
        clientView.setDefaultCloseOperation(EXIT_ON_CLOSE);
        clientView.setPreferredSize(new Dimension(1000, 800));
        clientView.setResizable(false);
        clientView.add(panel1);
        clientView.pack();
        clientView.setLocationRelativeTo(null);
//        clientView.setVisible(true);
    }

    /**
     * Hides the frame.
     */

    public void hideFrame() {
        clientView.setVisible(false);
    }

    /**
     * Shows the frame.
     */

    public void showFrame() {
        clientView.setVisible(true);
    }

}
