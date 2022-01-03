package org.promotion.enging.test.model;

public class Order {
    Sku sku;
    int quantity;

    public Order(){}

    public Order(Sku sku, int quantity) {
        this.sku = sku;
        this.quantity = quantity;
    }

    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
