package it.unife.lp.model;

import java.io.Serializable;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product implements Serializable {
    
    public StringProperty name;
    public StringProperty code;
    public StringProperty description;
    public FloatProperty price;
    public IntegerProperty quantity;
    public StringProperty category;

    public Product(String name, String code, String description, float price, int quantity, String category) {
        this.name = new SimpleStringProperty(name);
        this.code = new SimpleStringProperty(code);
        this.description = new SimpleStringProperty(description);
        this.price = new SimpleFloatProperty(price);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.category = new SimpleStringProperty(category);
    }

    public Product() {}

}
