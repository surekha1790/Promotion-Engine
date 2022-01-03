package org.promotion.enging.test.repository;

import org.promotion.enging.test.model.Sku;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkuPricesRepo {

    private static Map<Character, Integer> skusUnitPrices;
   static {
       skusUnitPrices = new HashMap<>();
       skusUnitPrices.put('A', 50);
       skusUnitPrices.put('B', 30);
       skusUnitPrices.put('C', 20);
       skusUnitPrices.put('D', 15);

   }

    public Map<Character, Integer> getSkusUnitPrices(){
        return skusUnitPrices;
    }

    public void updateSingleSkuUnitPrice(char skuId, int price){
       skusUnitPrices.put(skuId, price);
    }
    public void updateMultipleSkuUnitPrices(List<Sku> skusToUpdate){
       skusToUpdate.forEach(sku-> skusUnitPrices.put(sku.getSkuId(),sku.getPrice()));
    }
}
