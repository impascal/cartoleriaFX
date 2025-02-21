package it.unife.lp.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.IOException;
import java.time.LocalDate;

import it.unife.lp.App;
import it.unife.lp.Data;
import it.unife.lp.model.*;

public class SaleViewController {
    
    @FXML
    private TableView<Sale> saleTable;

    @FXML
    private TableColumn<Sale, String> clientColumn;

    @FXML
    private TableColumn<Sale, String> productColumn;

    @FXML
    private TableColumn<Sale, String> quantityColumn;

    @FXML
    private TableColumn<Sale, String> paymentMethodColumn;

    @FXML
    private TableColumn<Sale, LocalDate> dateColumn;

    @FXML
    private TextField search;

    public SaleViewController() {}

    @FXML
    private void initialize() {

        Data.loadSaleDataFromFile();

        clientColumn.setCellValueFactory(cellData -> cellData.getValue().client);
        clientColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        productColumn.setCellValueFactory(cellData -> cellData.getValue().product);
        productColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantity.asString());
        quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        paymentMethodColumn.setCellValueFactory(cellData -> cellData.getValue().paymentMethod);
        paymentMethodColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        dateColumn.setCellValueFactory(cellData -> cellData.getValue().date);

        saleTable.setItems(Data.saleData);
    }
 
    @FXML
    private void addSaleScene() throws IOException {
        App.showAddSaleStage();
    }

    @FXML
    private void removeSale() {
        ObservableList<Sale> selectedSales = saleTable.getSelectionModel().getSelectedItems();
        Data.saleData.removeAll(selectedSales);
    }
    @FXML
    private void saveSale() {
        Data.saveSaleDataToFile();
        Data.saveProductDataToFile();
    }

    @FXML
    private void saleReport() throws IOException {
        App.showSaleReport();
    }

    @FXML
    private void search() {
        String searched = search.getText();

        if(searched.equals("")) {
            saleTable.setItems(Data.saleData);
        }else{

            ObservableList<Sale> fileteredSaleData = FXCollections.observableArrayList();
            for(Sale s: Data.saleData) {
                if(s.date.get().toString().equals(searched) || s.client.get().equals(searched) || s.product.get().equals(searched)) {
                    fileteredSaleData.add(s);
                }
            }

            saleTable.setItems(fileteredSaleData);
        }
    }
}
