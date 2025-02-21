package it.unife.lp.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {
    
    public StringProperty name;
    public StringProperty surname;
    public StringProperty address;
    public StringProperty phone;
    public StringProperty mail;

    public Client(String name, String surname, String address, String phone, String mail) {
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.address = new SimpleStringProperty(address);
        this.phone = new SimpleStringProperty(phone);
        this.mail = new SimpleStringProperty(mail);
    }

}
