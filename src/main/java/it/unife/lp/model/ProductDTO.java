package it.unife.lp.model;

import java.io.Serializable;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class ProductDTO implements Serializable {
    
    public String name;
    public String code;
    public String description;
    public float price;
    public int quantity;
    public String category;

    public ProductDTO(String name, String code, String description, float price, int quantity, String category) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public ProductDTO() {}

}
