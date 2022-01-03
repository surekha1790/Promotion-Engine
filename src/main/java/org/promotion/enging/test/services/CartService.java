package org.promotion.enging.test.services;

import org.promotion.enging.test.model.Order;
import org.promotion.enging.test.model.Sku;
import org.promotion.enging.test.repository.SkuPricesRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public  class CartService {

    List<Order> orders = new ArrayList<>();
    SkuPricesRepo skuPricesRepo = new SkuPricesRepo();

    public void addItemsToCart(char skuId, int quantity){

        Map<Character,Integer> skuUnitPrices = skuPricesRepo.getSkusUnitPrices();
        Sku sku = new Sku(skuId,skuUnitPrices.get(skuId));
        Order order = new Order(sku, quantity);
        orders.add(order);

    }

    public static void main(String[] args) {
        CartService cartService = new CartService();
        cartService.addItemsToCart('A', 3);
        cartService.addItemsToCart('B', 5);
        cartService.addItemsToCart('C', 1);
        cartService.addItemsToCart('D', 1);

    }
}