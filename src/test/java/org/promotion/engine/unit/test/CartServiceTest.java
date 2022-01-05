package org.promotion.engine.unit.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.promotion.engine.model.Order;
import org.promotion.engine.services.CartService;

import java.util.List;

public class CartServiceTest {

    CartService cartService;

    @Before
    public void createCartService(){
        cartService = new CartService();
    }

    @Test
    public void testAddItemsToCart_itemShouldBeAdded(){
        cartService.addItemsToCart('A', 3);
        List<Order> orderList = cartService.getCartItems();
        assertNotNull(orderList);
        assertNotNull(orderList.stream()
                .filter(order -> order.getSku().getSkuId() == 'A')
                .findFirst()
                .orElse(null));
    }

    @Test
    public void testCalculateCartTotal_returnCheckoutTotalAmount(){
        cartService.addItemsToCart('A', 3);
        cartService.addItemsToCart('B', 5);
        cartService.addItemsToCart('C', 1);
        cartService.addItemsToCart('D', 1);

        int totalPrice = cartService.calculateCartTotal();
        assertEquals(280, totalPrice);
    }
}
