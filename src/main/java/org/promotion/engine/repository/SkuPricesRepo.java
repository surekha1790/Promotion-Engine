package org.promotion.engine.repository;

import org.promotion.engine.model.Sku;
import org.promotion.engine.utils.Constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkuPricesRepo {

    private static Map<Character, Integer> skusUnitPrices;
   static {
       skusUnitPrices = new HashMap<>();
       skusUnitPrices.put(Constants.SKU_A, 50);
       skusUnitPrices.put(Constants.SKU_B, 30);
       skusUnitPrices.put(Constants.SKU_C, 20);
       skusUnitPrices.put(Constants.SKU_D, 15);

   }
    public int getSkuUnitPrice(char skuId){
        return skusUnitPrices.get(skuId);
    }
    public Map<Character, Integer> getSkusUnitPrices(){
        return skusUnitPrices;
    }

    public void addOrUpdateSingleSkuUnitPrice(char skuId, int price){
       if(skusUnitPrices == null){
           skusUnitPrices = new HashMap<>();
       }
       skusUnitPrices.put(skuId, price);
    }
    public void addOrUpdateMultipleSkuUnitPrices(List<Sku> skusToUpdate){
        if(skusUnitPrices == null){
            skusUnitPrices = new HashMap<>();
        }
       skusToUpdate.forEach(sku-> skusUnitPrices.put(sku.getSkuId(), sku.getPrice()));

    }

    public void deleteSkuUnitPrice(char skuId){
       if(skusUnitPrices != null){
           skusUnitPrices.remove(skuId);
       }
    }
}
