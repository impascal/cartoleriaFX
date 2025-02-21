package it.unife.lp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import it.unife.lp.model.Client;
import it.unife.lp.model.ClientDTO;
import it.unife.lp.model.Product;
import it.unife.lp.model.ProductDTO;
import it.unife.lp.model.Sale;
import it.unife.lp.model.SaleDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Data {
    
    public static ObservableList<Product> productData = FXCollections.observableArrayList();
    public static File productFile = new File("data/product.json");

    public static ObservableList<Client> clientData = FXCollections.observableArrayList();
    public static File clientFile = new File("data/client.json");

    public static ObservableList<Sale> saleData = FXCollections.observableArrayList();
    public static File saleFile = new File("data/sale.json");

    public static void saveProductDataToFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            mapper.registerModule(new JavaTimeModule());

            List<ProductDTO> plist = new ArrayList<>();
            for(Product p: productData) {
                plist.add(new ProductDTO(p.name.get(), p.code.get(), p.description.get(), p.price.get(), p.quantity.get(), p.category.get()));
            }

            mapper.writeValue(productFile, plist);
        }catch(Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file.\n");
        }
    }

    public static void loadProductDataFromFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<ProductDTO> plist = mapper.readValue(productFile, new TypeReference<List<ProductDTO>>(){});

            productData.removeAll(productData);
            for(ProductDTO pr: plist) {
                productData.add(new Product(pr.name, pr.code, pr.description, pr.price, pr.quantity, pr.category));
            }

        } catch (Exception e) { // catches ANY exception
            e.printStackTrace();
        }
    }

    public static void saveClientDataToFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            mapper.registerModule(new JavaTimeModule());

            List<ClientDTO> DTOlist = new ArrayList<>();
            for(Client c: clientData) {
                DTOlist.add(new ClientDTO(c.name.get(), c.surname.get(), c.address.get(), c.phone.get(), c.mail.get()));
            }

            mapper.writeValue(clientFile, DTOlist);
        }catch(Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file.\n");
        }
    }

    public static void loadClientDataFromFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<ClientDTO> plist = mapper.readValue(clientFile, new TypeReference<List<ClientDTO>>(){});

            clientData.removeAll(clientData);
            for(ClientDTO pr: plist) {
                clientData.add(new Client(pr.name, pr.surname, pr.address, pr.phone, pr.mail));
            }

        } catch (Exception e) { // catches ANY exception
            e.printStackTrace();
        }
    }

    public static void saveSaleDataToFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            mapper.registerModule(new JavaTimeModule());

            List<SaleDTO> DTOlist = new ArrayList<>();
            for(Sale s: saleData) {
                DTOlist.add(new SaleDTO(s.client.get(), s.product.get(), s.quantity.get(), s.paymentMethod.get(), s.date.get()));
            }

            mapper.writeValue(saleFile, DTOlist);
        }catch(Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file.\n");
        }
    }

    public static void loadSaleDataFromFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<SaleDTO> plist = mapper.readValue(saleFile, new TypeReference<List<SaleDTO>>(){});

            saleData.removeAll(saleData);
            for(SaleDTO pr: plist) {
                saleData.add(new Sale(pr.client, pr.product, pr.quantity, pr.paymentMethod, pr.date));
            }

        } catch (Exception e) { // catches ANY exception
            e.printStackTrace();
        }
    }

}
