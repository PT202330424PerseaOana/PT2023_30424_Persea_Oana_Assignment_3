package presentation;
import connection.ConnectionFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * This class represents ViewClientsView.
 */
public class ViewClientsView extends JFrame {
    private JPanel panel1;
    private JTable table1;
    public JButton backButton;
    public JFrame frame;

    /**
     * Constructs a new ViewClientsView object.
     */
    public ViewClientsView() {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = null;
            resultSet = null;

            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            resultSet = statement.executeQuery("SELECT * FROM client");
            DefaultTableModel tableModel = new DefaultTableModel();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                tableModel.addColumn(metaData.getColumnName(column));
            }

            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int column = 1; column <= columnCount; column++) {
                    row[column - 1] = resultSet.getObject(column);
                }
                tableModel.addRow(row);
            }

            JTable table = new JTable(tableModel);

            backButton = new JButton("Back");
            backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Handle back button click
                    hideFrame();
                }
            });

            frame = new JFrame();
            frame.setPreferredSize(new Dimension(800, 300));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(new JScrollPane(table), BorderLayout.CENTER);
            panel.add(backButton, BorderLayout.NORTH);

            frame.setContentPane(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
        } catch (SQLException e) {

        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
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
