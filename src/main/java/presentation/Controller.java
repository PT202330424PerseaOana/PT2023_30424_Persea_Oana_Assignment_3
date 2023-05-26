package presentation;
//import com.sun.java.swing.action.NewAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import presentation.EditClientView;
import presentation.View1;


/**
 * The Controller class represents the main controller of the application.
 * It manages the interaction between the views and the business logic layer (BLL).
 * It controls the flow of the application and handles user actions.
 */

public class Controller extends JFrame {

    View1 view1;
    ClientView clientView;
    ProductView productView;
    OrderView orderView;
    ClientBLL clientBLL;
    ProductBLL productBLL;
    OrderBLL orderBLL;

    AddClientView addClientView;
    AddProductView addProductView;
    DeleteClientView deleteClientView;
    DeleteProductView deleteProductView;
    EditClientView editClientView;
    EditProductView editProductView;
    ViewClientsView viewClientsView;
    ViewProductView viewProductView;

    /**
     * Constructs a new instance of the Controller class.
     * Initializes the views, BLL components, and sets up event listeners.
     */
    public Controller() {
        view1 = new View1();
        clientView = new ClientView();
        productView=new ProductView();
        orderView=new OrderView();
        addClientView = new AddClientView();
        addProductView=new AddProductView();
        deleteClientView=new DeleteClientView();
        deleteProductView=new DeleteProductView();
        editClientView=new EditClientView();
        editProductView=new EditProductView();
        viewClientsView=new ViewClientsView();
        viewProductView=new ViewProductView();
        clientBLL = new ClientBLL();
        productBLL=new ProductBLL();
        orderBLL=new OrderBLL();
        view1.showFrame();
        view1.clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view1.hideFrame();
                clientView.showFrame();

            }
        });

        clientView.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientView.hideFrame();
                view1.showFrame();
            }
        });

        clientView.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientView.hideFrame();
                addClientView.showFrame();
                addClientView.fieldsNotEmpty();
            }
        });

        clientView.deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientView.hideFrame();
                deleteClientView.showFrame();
            }
        });

        deleteClientView.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteClientView.hideFrame();
                clientView.showFrame();
            }
        });

        clientView.editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientView.hideFrame();
                editClientView.showFrame();
            }
        });

        clientView.viewAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientView.hideFrame();
                viewClientsView.showFrame();

            }
        });

        viewClientsView.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewClientsView.hideFrame();
                clientView.showFrame();
            }
        });

        addClientView.addClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(addClientView.textField1.getText().toString());
                if (!addClientView.textField1.getText().isEmpty() && !addClientView.textField2.getText().isEmpty() && !addClientView.textField3.getText().toString().isEmpty() && !addClientView.textField4.getText().toString().isEmpty()) {
                    System.out.println(addClientView.textField1.getText() + addClientView.textField2.getText() + addClientView.textField3.getText() + addClientView.textField4.getText());
                    clientBLL.insertNewClient(addClientView.textField2.getText().toString(), addClientView.textField4.getText().toString(), addClientView.textField1.getText().toString(), Integer.parseInt(addClientView.textField3.getText().toString()));
                    addClientView.fieldsNotEmpty();
                }
                else {
                    addClientView.fieldsEmpty();

                }
            }
        });

        addClientView.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClientView.hideFrame();
                clientView.showFrame();
            }
        });


        deleteClientView.deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!deleteClientView.textField1.getText().isEmpty()) {
                    deleteClientView.notEmptyField();
                    clientBLL.deleteClientByID(Integer.parseInt(deleteClientView.textField1.getText().toString()));
                }
                else  if(!deleteClientView.textField2.getText().isEmpty()) {
                    deleteClientView.notEmptyField();
                    clientBLL.deleteClientByName(deleteClientView.textField2.getText().toString());
                }
                else  if(!deleteClientView.textField3.getText().isEmpty()) {
                    deleteClientView.notEmptyField();
                    clientBLL.deleteClientByEmail(deleteClientView.textField3.getText().toString());
                }
                else  if(!deleteClientView.textField4.getText().isEmpty()) {
                    deleteClientView.notEmptyField();
                    clientBLL.deleteClientByAddress(deleteClientView.textField4.getText().toString());
                }
                else  if(!deleteClientView.textField5.getText().isEmpty()) {
                    deleteClientView.notEmptyField();
                    clientBLL.deleteClientByAge(Integer.parseInt(deleteClientView.textField5.getText().toString()));
                }
                else {
                    deleteClientView.emptyField();
                }

            }
        });

        editClientView.updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!editClientView.textField1.getText().toString().isEmpty()) {
                    editClientView.hideMessage();
                    if (!editClientView.textField2.getText().toString().isEmpty()) {
                        clientBLL.updateClientName(Integer.parseInt(editClientView.textField1.getText().toString()), editClientView.textField2.getText().toString());
                    }
                    if (!editClientView.textField3.getText().isEmpty()) {

                        clientBLL.updateClientEmail(Integer.parseInt(editClientView.textField1.getText().toString()), editClientView.textField3.getText().toString());
                    }
                    if (!editClientView.textField4.getText().isEmpty()) {

                        clientBLL.updateClientAge(Integer.parseInt(editClientView.textField1.getText().toString()), Integer.parseInt(editClientView.textField4.getText().toString()));
                    }
                    if (!editClientView.textField5.getText().isEmpty()) {
                        clientBLL.updateClientAddress(Integer.parseInt(editClientView.textField1.getText().toString()), editClientView.textField5.getText().toString());
                    }
                }
                else {

                    editClientView.showMessage();


                }
            }
        });

        editClientView.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editClientView.hideFrame();
                clientView.showFrame();
            }
        });


        view1.productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view1.hideFrame();
                productView.showFrame();

            }
        });

        productView.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productView.hideFrame();
                view1.showFrame();
            }
        });

        productView.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productView.hideFrame();
                addProductView.showFrame();
                addProductView.fieldsNotEmpty();
            }
        });

        productView.deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productView.hideFrame();
                deleteProductView.showFrame();
            }
        });

        deleteProductView.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteProductView.hideFrame();
                productView.showFrame();
            }
        });

        productView.editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productView.hideFrame();
                editProductView.showFrame();
            }
        });

        productView.viewAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productView.hideFrame();
                viewProductView.showFrame();

            }
        });

        viewProductView.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewProductView.hideFrame();
                productView.showFrame();
            }
        });

        addProductView.addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(addProductView.textField1.getText().toString());
                if (!addProductView.textField1.getText().isEmpty() && !addProductView.textField2.getText().isEmpty() && !addProductView.textField3.getText().toString().isEmpty()) {
                    productBLL.insertNewProduct(addProductView.textField1.getText().toString(), Integer.parseInt(addProductView.textField2.getText().toString()), Integer.parseInt(addProductView.textField3.getText().toString()));
                    addProductView.fieldsNotEmpty();
                }
                else {
                    addProductView.fieldsEmpty();

                }
            }
        });

        addProductView.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProductView.hideFrame();
                productView.showFrame();
            }
        });


        deleteProductView.deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!deleteProductView.textField1.getText().isEmpty()) {
                    deleteProductView.notEmptyField();
                    productBLL.deleteProductByID(Integer.parseInt(deleteProductView.textField1.getText().toString()));
                }
                else  if(!deleteProductView.textField2.getText().isEmpty()) {
                    deleteProductView.notEmptyField();
                    productBLL.deleteProductByName(deleteProductView.textField2.getText().toString());
                }
                else  if(!deleteProductView.textField3.getText().isEmpty()) {
                    deleteProductView.notEmptyField();
                    productBLL.deleteClientByPrice(Integer.parseInt(deleteProductView.textField3.getText().toString()));
                }
                else  if(!deleteProductView.textField4.getText().isEmpty()) {
                    deleteProductView.notEmptyField();
                    productBLL.deleteClientByStock(Integer.parseInt(deleteProductView.textField4.getText().toString()));
                }
                else {
                    deleteProductView.emptyField();
                }

            }
        });

        editProductView.updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!editProductView.textField1.getText().toString().isEmpty()) {
                    editProductView.hideMessage();
                    if (!editProductView.textField2.getText().toString().isEmpty()) {
                        productBLL.updateProductName(Integer.parseInt(editProductView.textField1.getText().toString()), editProductView.textField2.getText().toString());
                    }
                    if (!editProductView.textField3.getText().isEmpty()) {

                        productBLL.updateProductPrice(Integer.parseInt(editProductView.textField1.getText().toString()), Integer.parseInt(editProductView.textField3.getText().toString()));
                    }
                    if (!editProductView.textField4.getText().isEmpty()) {

                        productBLL.updateProductStock(Integer.parseInt(editProductView.textField1.getText().toString()), Integer.parseInt(editProductView.textField4.getText().toString()));
                    }
                }
                else {

                    editProductView.showMessage();


                }
            }
        });

        editProductView.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editProductView.hideFrame();
                productView.showFrame();
            }
        });

        view1.orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view1.hideFrame();
                orderView.showFrame();

            }
        });

        orderView.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderView.hideFrame();
                view1.showFrame();
            }
        });

        orderView.addOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!orderView.textField1.getText().isEmpty() && !orderView.textField2.getText().isEmpty() && !orderView.textField3.getText().isEmpty()) {
                    orderView.hideMessage();
                    orderBLL.insertNewOrder(Integer.parseInt(orderView.textField1.getText().toString()), Integer.parseInt(orderView.textField2.getText().toString()), Integer.parseInt(orderView.textField3.getText().toString()));
                }
                else {
                    orderView.showMessage();
                }
            }
        });




    }

//TODO:...


}
