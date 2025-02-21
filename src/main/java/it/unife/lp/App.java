package it.unife.lp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Stage primaryStage;
    private static BorderPane mainLayout;

    public static Stage addProductStage;
    public static Stage addClientStage;
    public static Stage addSaleStage;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Cartoleria");

        showMainView();
    }

    public static void showMainView() {
        try {

            // Load root layout from fxml file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("view/MainLayout.fxml"));
            mainLayout = loader.load();

            // Show the scene containing the root layout
            Scene scene = new Scene(mainLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showProductView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("view/ProductView.fxml"));
        BorderPane productView = loader.load();
        mainLayout.setCenter(productView);
    }

    public static void showAddProductStage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("view/AddProduct.fxml"));
        AnchorPane addProduct = (AnchorPane) loader.load();
        
        addProductStage = new Stage();
        addProductStage.setTitle("Aggiungi nuovo prodotto");
        addProductStage.initModality(Modality.WINDOW_MODAL);
        addProductStage.initOwner(primaryStage);

        Scene scene = new Scene(addProduct);
        addProductStage.setScene(scene);
        addProductStage.show();
    }

    public static void showClientView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("view/ClientView.fxml"));
        BorderPane clientView = loader.load();
        mainLayout.setCenter(clientView);
    }

    public static void showAddClientStage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("view/AddClient.fxml"));
        AnchorPane addClient = (AnchorPane) loader.load();
        
        addClientStage = new Stage();
        addClientStage.setTitle("Aggiungi un nuovo cliente");
        addClientStage.initModality(Modality.WINDOW_MODAL);
        addClientStage.initOwner(primaryStage);

        Scene scene = new Scene(addClient);
        addClientStage.setScene(scene);
        addClientStage.show();
    }

    public static void showSaleView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("view/SaleView.fxml"));
        BorderPane saleView = loader.load();
        mainLayout.setCenter(saleView);
    }

    public static void showAddSaleStage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("view/AddSale.fxml"));
        AnchorPane addSale = (AnchorPane) loader.load();
        
        addSaleStage = new Stage();
        addSaleStage.setTitle("Aggiungi un nuovo cliente");
        addSaleStage.initModality(Modality.WINDOW_MODAL);
        addSaleStage.initOwner(primaryStage);

        Scene scene = new Scene(addSale);
        addSaleStage.setScene(scene);
        addSaleStage.show();
    }

    public static void showSaleReport() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("view/SaleReport.fxml"));
        BorderPane page = loader.load();

        Stage reportStage = new Stage();
        reportStage.setTitle("Report Vendite per mese");
        reportStage.initModality(Modality.WINDOW_MODAL);
        reportStage.initOwner(primaryStage);

        Scene scene = new Scene(page);
        reportStage.setScene(scene);

        reportStage.show();
    }

    public static void showInventoryReport() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("view/InventoryReport.fxml"));
        BorderPane page = loader.load();

        Stage reportStage = new Stage();
        reportStage.setTitle("Report Inventario");
        reportStage.initModality(Modality.WINDOW_MODAL);
        reportStage.initOwner(primaryStage);

        Scene scene = new Scene(page);
        reportStage.setScene(scene);

        reportStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}