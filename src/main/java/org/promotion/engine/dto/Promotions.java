package org.promotion.engine.dto;

public class Promotions {
    int promotionQuantity;
    int promotionPrice;

    public Promotions(int promotionQuantity, int promotionPrice) {
        this.promotionQuantity = promotionQuantity;
        this.promotionPrice = promotionPrice;
    }

    public int getPromotionQuantity() {
        return promotionQuantity;
    }

    public void setPromotionQuantity(int promotionQuantity) {
        this.promotionQuantity = promotionQuantity;
    }

    public int getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(int promotionPrice) {
        this.promotionPrice = promotionPrice;
    }
}
