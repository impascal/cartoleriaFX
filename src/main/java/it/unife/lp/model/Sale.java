package it.unife.lp.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sale {

    public StringProperty client;
    public StringProperty product;
    public IntegerProperty quantity;
    public StringProperty paymentMethod;
    public ObjectProperty<LocalDate> date;

    public Sale(String client, String product, int quantity, String paymentMethod, LocalDate date) {
        this.client = new SimpleStringProperty(client);
        this.product = new SimpleStringProperty(product);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.paymentMethod = new SimpleStringProperty(paymentMethod);
        this.date = new SimpleObjectProperty<LocalDate>(date);
    }

}
