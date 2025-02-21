package it.unife.lp.view;

import it.unife.lp.model.Client;

import it.unife.lp.App;
import it.unife.lp.Data;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddClientController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField mailField;

    @FXML
    private void addClient() {
        String name = nameField.getText();
        String surname = surnameField.getText();
        String address = addressField.getText();
        String phone = phoneField.getText();
        String mail = mailField.getText();

        Client c = new Client(name, surname, address, phone, mail);
        Data.clientData.add(c);
        exitAddClient();
    }

    @FXML
    private void exitAddClient() {
        App.addClientStage.close();
    }
    
}
