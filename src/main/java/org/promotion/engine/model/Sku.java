package org.promotion.engine.model;


public class Sku {
    char skuId;
    int price;

    public Sku(){}

    public Sku(char skuId, int price) {
        this.skuId = skuId;
        this.price = price;
    }

    public char getSkuId() {
        return skuId;
    }

    public void setSkuId(char skuId) {
        this.skuId = skuId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
