package it.unife.lp.view;


import it.unife.lp.model.Product;
import it.unife.lp.model.Sale;

import java.time.LocalDate;

import it.unife.lp.App;
import it.unife.lp.Data;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AddSaleController {

    @FXML
    private TextField clientField;

    @FXML
    private TextField productField;

    @FXML
    private TextField quantityField;

    @FXML
    private TextField paymentMethodField;

    @FXML
    private void addSale() {
        String client = clientField.getText();
        String product = productField.getText();

        Boolean productExists = false;
        for(Product p: Data.productData) {
            if(p.name.get().equals(product)) {
                productExists = true;
                break;
            }
        }

        if(!productExists) {
            Alert nonExistingProduct = new Alert(AlertType.ERROR);
            nonExistingProduct.setHeaderText("Prodotto inserito non valido");
            nonExistingProduct.setContentText("Prodotto non presente nell'inventario...");
            nonExistingProduct.show();
            return;
        }

        int quantity = Integer.parseInt(quantityField.getText());

        if(quantity <= 0) {
            Alert invalidQuantity = new Alert(AlertType.ERROR);
            invalidQuantity.setHeaderText("Quantità inserita non valida");
            invalidQuantity.setContentText("Quantità inserita minore o uguale a zero...");
            invalidQuantity.show();
            return;
        }

        for(Product p: Data.productData) {
            if(p.name.get().equals(product)) {
                if(p.quantity.get() < quantity) {
                    Alert invalidQuantity = new Alert(AlertType.ERROR);
                    invalidQuantity.setHeaderText("Quantità inserita non valida");
                    invalidQuantity.setContentText("Quantità inserita superiore ai pezzi disponibili...");
                    invalidQuantity.show();
                    return;
                }

                p.quantity.set(p.quantity.get() - quantity);
                break;
            }
        }

        String paymentMethod = paymentMethodField.getText();
        Sale s = new Sale(client, product, quantity, paymentMethod, LocalDate.now());
        Data.saleData.add(s);
        exitAddSale();
    }

    @FXML
    private void exitAddSale() {
        App.addSaleStage.close();
    }
    
}
