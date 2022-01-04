package org.promotion.engine.repository;

import org.promotion.engine.model.Sku;

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
    public int getSkuUnitPrice(char skuId){
        return skusUnitPrices.get(skuId);
    }
    public Map<Character, Integer> getSkusUnitPrices(){
        return skusUnitPrices;
    }

    public void addOrUpdateSingleSkuUnitPrice(char skuId, int price){
       skusUnitPrices.put(skuId, price);
    }
    public void addOrUpdateMultipleSkuUnitPrices(List<Sku> skusToUpdate){
       skusToUpdate.forEach(sku-> skusUnitPrices.put(sku.getSkuId(), sku.getPrice()));

    }
}
