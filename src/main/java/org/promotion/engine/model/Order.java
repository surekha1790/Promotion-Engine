package org.promotion.engine.model;

public class Order {
    Sku sku;
    int quantity;
    boolean isCombo;
    boolean isRead;

    public Order(){}

    public Order(Sku sku, int quantity, boolean isCombo) {
        this.sku = sku;
        this.quantity = quantity;
        this.isCombo = isCombo;
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

    public boolean isCombo() {
        return isCombo;
    }

    public void setCombo(boolean combo) {
        isCombo = combo;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
