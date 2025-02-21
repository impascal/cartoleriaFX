package it.unife.lp.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.IOException;

import it.unife.lp.App;
import it.unife.lp.Data;
import it.unife.lp.model.*;

public class ProductViewController {
    
    @FXML
    private TableView<Product> productTable;

    @FXML
    private TableColumn<Product, String> nameColumn;

    @FXML
    private TableColumn<Product, String> codeColumn;

    @FXML
    private TableColumn<Product, String> descriptionColumn;

    @FXML
    private TableColumn<Product, String> priceColumn;

    @FXML
    private TableColumn<Product, String> quantityColumn;

    @FXML
    private TableColumn<Product, String> categoryColumn;

    @FXML
    private TextField search;

    public ProductViewController() {}

    @FXML
    private void initialize() {

        Data.loadProductDataFromFile();

        for(Product p: Data.productData) {
            if(p.quantity.get() < 5) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setHeaderText("Avvertimento: inventario.");
                alert.setContentText("Attenzione, uno o più prodotti a meno di 5 unità.");
                alert.show();
                break;
            }
        }

        nameColumn.setCellValueFactory(cellData -> cellData.getValue().name);
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit(event -> {
            Product p = event.getRowValue();
            p.name.set(event.getNewValue());
        });
        
        codeColumn.setCellValueFactory(cellData -> cellData.getValue().code);
        codeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        codeColumn.setOnEditCommit(event -> {
            Product p = event.getRowValue();
            p.code.set(event.getNewValue());
        });

        descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().description);
        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionColumn.setOnEditCommit(event -> {
            Product p = event.getRowValue();
            p.description.set(event.getNewValue());
        });

        priceColumn.setCellValueFactory(cellData -> cellData.getValue().price.asString());
        priceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        priceColumn.setOnEditCommit(event -> {
            Product p = event.getRowValue();
            p.price.set(Float.parseFloat(event.getNewValue()));
        });

        quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantity.asString());
        quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        quantityColumn.setOnEditCommit(event -> {
            Product p = event.getRowValue();
            p.quantity.set(Integer.parseInt(event.getNewValue()));
        });

        categoryColumn.setCellValueFactory(cellData -> cellData.getValue().category);
        categoryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        categoryColumn.setOnEditCommit(event -> {
            Product p = event.getRowValue();
            p.category.set(event.getNewValue());
        });

        productTable.setItems(Data.productData);
        productTable.setEditable(true);
    }

    @FXML
    private void addProductScene() throws IOException {
        App.showAddProductStage();
    }

    @FXML
    private void removeProduct() {
        ObservableList<Product> selectedProducts = productTable.getSelectionModel().getSelectedItems();
        Data.productData.removeAll(selectedProducts);
    }

    @FXML
    private void saveProduct() {
        Data.saveProductDataToFile();
    }

    @FXML
    private void showReport() throws IOException {
        App.showInventoryReport();
    }

    @FXML
    private void search() {
        String researched = search.getText();

        if(researched.equals("")) {
            productTable.setItems(Data.productData);
        }else{

            ObservableList<Product> filteredProductData = FXCollections.observableArrayList();
            for(Product p: Data.productData) {
                if(p.category.get().equals(researched) || p.code.get().equals(researched) || p.name.get().equals(researched)) {
                    filteredProductData.add(p);
                } 
            }

            productTable.setItems(filteredProductData);

        }
    }
}
