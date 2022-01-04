package org.promotion.engine.services;

import org.promotion.engine.model.Order;
import org.promotion.engine.dto.Promotions;
import org.promotion.engine.model.Sku;
import org.promotion.engine.repository.PromotionCodesRepo;
import org.promotion.engine.repository.SkuPricesRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class CartService {

    List<Order> orders = new ArrayList<>();
    SkuPricesRepo skuPricesRepo = new SkuPricesRepo();
    PromotionCodesRepo promotionCodesRepo = new PromotionCodesRepo();

    public int calculateCartTotal(){

        int totalPrice = 0;
        for(Order order: orders){

            Promotions promotions = promotionCodesRepo.getNItemsPromotions(order.getSku().getSkuId());
            int orderQuantity = order.getQuantity();

            if (promotions != null ) {
                int promotionAppliedQuantity = promotions.getPromotionQuantity();
                do {
                    totalPrice += (orderQuantity / promotionAppliedQuantity) * promotions.getPromotionPrice();
                    orderQuantity = orderQuantity % promotionAppliedQuantity;
                } while (orderQuantity >= promotionAppliedQuantity);
                totalPrice += orderQuantity * order.getSku().getPrice();

            } else if(!order.isRead()){
                if(order.isCombo()) {
                   totalPrice += calculateComboOrder(order);
                }
            }
        }
        return totalPrice;
    }

    public int calculateComboOrder(Order order){
        int totalPrice = 0;
        Sku comboPromotion = promotionCodesRepo.getComboPromotionsById(order.getSku().getSkuId());
        if (comboPromotion != null) {
            Order comboOrder = orders.stream().filter(order1 -> order1.getSku().getSkuId() == comboPromotion.getSkuId())
                                            .findFirst()
                                            .orElse(null);
            if(comboOrder != null) {
                comboOrder.setRead(true);
                int comboQuantity = comboOrder.getQuantity();
                if(order.getQuantity() < comboQuantity){
                    totalPrice += order.getQuantity() * comboPromotion.getPrice();
                    totalPrice += (comboQuantity - order.getQuantity()) * comboOrder.getSku().getPrice();
                }else if(order.getQuantity() > comboQuantity){
                    totalPrice += comboQuantity * comboPromotion.getPrice();
                    totalPrice += (order.getQuantity() - comboQuantity) * order.getSku().getPrice();
                }else{
                    totalPrice += order.getQuantity() * comboPromotion.getPrice();
                }
            }else{
                totalPrice += order.getQuantity() * order.getSku().getPrice();
            }
        }
        return totalPrice;
    }
    public void addItemsToCart(char skuId, int quantity){

        Order order = orders.stream().filter(order1 -> order1.getSku().getSkuId() == skuId)
                                    .findFirst()
                                    .orElse(null);
        if(order!=null) {
            order.setQuantity(order.getQuantity() + quantity);
        }else {
            int price = skuPricesRepo.getSkuUnitPrice(skuId);
            Sku sku = new Sku(skuId, price);
            if(promotionCodesRepo.isCombo(skuId)) {
                order = new Order(sku, quantity, true);
            }else{
                order = new Order(sku, quantity, false);
            }
            orders.add(order);
        }
    }

    public static void main(String[] args) {
        CartService cartService = new CartService();
        //Scenario A
       /* cartService.addItemsToCart('A', 1);
        cartService.addItemsToCart('B', 1);
        cartService.addItemsToCart('C', 1);*/
        //Scenario B
       /* cartService.addItemsToCart('A', 5);
        cartService.addItemsToCart('B', 5);
        cartService.addItemsToCart('C', 1);*/
        //Scenario C
        cartService.addItemsToCart('A', 3);
        cartService.addItemsToCart('B', 5);
        cartService.addItemsToCart('C', 1);
        cartService.addItemsToCart('D', 3);

        System.out.println(cartService.calculateCartTotal());

    }
}