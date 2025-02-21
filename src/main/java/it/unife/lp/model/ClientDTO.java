package it.unife.lp.model;

public class ClientDTO {
    
    public String name;
    public String surname;
    public String address;
    public String phone;
    public String mail;

    public ClientDTO(String name, String surname, String address, String phone, String mail) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
    }

    public ClientDTO() {}

}
