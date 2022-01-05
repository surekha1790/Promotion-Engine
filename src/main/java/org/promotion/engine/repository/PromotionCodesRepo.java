package org.promotion.engine.repository;

import org.promotion.engine.dto.Promotions;
import org.promotion.engine.model.Sku;
import org.promotion.engine.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class PromotionCodesRepo {

    private static Map<Character, Promotions> nItemsActivePromotions;
    private static Map<Character, Sku> comboActivePromotions;
    static {
        nItemsActivePromotions = new HashMap<>();
        nItemsActivePromotions.put(Constants.SKU_A, new Promotions(3, 130));
        nItemsActivePromotions.put(Constants.SKU_B, new Promotions(2, 45));

        comboActivePromotions = new HashMap<>();
        comboActivePromotions.put(Constants.SKU_C, new Sku('D', 30));
    }

    public Map<Character, Promotions> getNItemsPromotions(){
        return nItemsActivePromotions;
    }

    public Sku getComboPromotionsById(char skuId){
        return comboActivePromotions.get(skuId);
    }

    public Map<Character, Sku> getComboActivePromotions(){
        return  comboActivePromotions;
    }
    public  Promotions getNItemsPromotions(char skuId){
       return nItemsActivePromotions.get(skuId);
    }

    public void addOrUpdateNItemsPromotionCode(char skuId, Promotions promotions){
        if(nItemsActivePromotions == null){
            nItemsActivePromotions = new HashMap<>();
        }
        nItemsActivePromotions.put(skuId, promotions);
    }

    public void addOrUpdateComboPromotions(char skuId, Sku comboPromotion){
        if(comboActivePromotions == null){
            comboActivePromotions = new HashMap<>();
        }
        comboActivePromotions.put(skuId, comboPromotion);
    }

    public boolean isCombo(char skuId){
        return Constants.combosList.contains(skuId);
    }

    public void deleteNItemsPromotions(char skuId){
        if(nItemsActivePromotions != null){
            nItemsActivePromotions.remove(skuId);
        }
    }

    public void deleteComboPromotions(char skuId){
        if(comboActivePromotions != null){
            comboActivePromotions.remove(skuId);
        }
    }
}
