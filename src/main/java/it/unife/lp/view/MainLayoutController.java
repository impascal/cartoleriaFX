package it.unife.lp.view;

import java.io.IOException;

import it.unife.lp.App;
import javafx.fxml.FXML;

public class MainLayoutController {

    @FXML
    private void goHome() throws IOException {
        App.showMainView();
    }

    @FXML
    private void goProduct() throws IOException {
        App.showProductView();
    }

    @FXML
    private void goClient() throws IOException {
        App.showClientView();
    }

    @FXML
    private void goSale() throws IOException {
        App.showSaleView();
    }
}