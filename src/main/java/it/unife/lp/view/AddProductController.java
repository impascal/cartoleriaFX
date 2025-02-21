package it.unife.lp.view;

import it.unife.lp.model.Product;

import it.unife.lp.App;
import it.unife.lp.Data;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddProductController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField codeField;

    @FXML
    private TextField descriptionField;

    @FXML
    private TextField priceField;

    @FXML
    private TextField quantitytField;

    @FXML
    private TextField categoryField;

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

    @FXML
    private void addProductFinal() {
        String name = nameField.getText();
        String code = codeField.getText();
        String description = descriptionField.getText();
        float price = Float.parseFloat(priceField.getText());
        int quantity = Integer.parseInt(quantitytField.getText());
        String category = categoryField.getText();

        Product p = new Product(name, code, description, price, quantity, category);
        Data.productData.add(p);
        exitAddProduct();
    }

    @FXML
    private void exitAddProduct() {
        App.addProductStage.close();
    }
    
}
