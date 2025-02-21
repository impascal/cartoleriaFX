package it.unife.lp.model;

import java.time.LocalDate;

public class SaleDTO {

    public String client;
    public String product;
    public int quantity;
    public String paymentMethod;
    public LocalDate date;

    public SaleDTO(String client, String product, int quantity, String paymentMethod, LocalDate date) {
        this.client = client;
        this.product = product;
        this.quantity = quantity;
        this.paymentMethod = paymentMethod;
        this.date = date;
    }

    public SaleDTO() {}

}
