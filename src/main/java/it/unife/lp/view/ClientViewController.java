package it.unife.lp.view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.IOException;

import it.unife.lp.App;
import it.unife.lp.Data;
import it.unife.lp.model.*;

public class ClientViewController {
    
    @FXML
    private TableView<Client> clientTable;

    @FXML
    private TableColumn<Client, String> nameColumn;

    @FXML
    private TableColumn<Client, String> surnameColumn;

    @FXML
    private TableColumn<Client, String> addressColumn;

    @FXML
    private TableColumn<Client, String> phoneColumn;

    @FXML
    private TableColumn<Client, String> emailColumn;

    public ClientViewController() {}

    @FXML
    private void initialize() {

        Data.loadClientDataFromFile();

        nameColumn.setCellValueFactory(cellData -> cellData.getValue().name);
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit(event -> {
            Client p = event.getRowValue();
            p.name.set(event.getNewValue());
        });
        
        surnameColumn.setCellValueFactory(cellData -> cellData.getValue().surname);
        surnameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        surnameColumn.setOnEditCommit(event -> {
            Client p = event.getRowValue();
            p.surname.set(event.getNewValue());
        });

        addressColumn.setCellValueFactory(cellData -> cellData.getValue().address);
        addressColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        addressColumn.setOnEditCommit(event -> {
            Client p = event.getRowValue();
            p.address.set(event.getNewValue());
        });

        phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phone);
        phoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneColumn.setOnEditCommit(event -> {
            Client p = event.getRowValue();
            p.phone.set(event.getNewValue());
        });

        emailColumn.setCellValueFactory(cellData -> cellData.getValue().mail);
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        emailColumn.setOnEditCommit(event -> {
            Client p = event.getRowValue();
            p.mail.set(event.getNewValue());
        });

        clientTable.setItems(Data.clientData);
        clientTable.setEditable(true);
    }
 
    @FXML
    private void addClientScene() throws IOException {
        App.showAddClientStage();
    }

    @FXML
    private void removeClient() {
        ObservableList<Client> selectedClients = clientTable.getSelectionModel().getSelectedItems();
        Data.clientData.removeAll(selectedClients);
    }
    @FXML
    private void saveClient() {
        Data.saveClientDataToFile();
    }
}
