package org.promotion.engine.repository;

import org.promotion.engine.dto.Promotions;
import org.promotion.engine.model.Sku;
import org.promotion.engine.utils.Constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PromotionCodesRepo {

    private static Map<Character, Promotions> nItemsActivePromotions;
    private static Map<Character, Sku> comboActivePromotions;
    private static List<Character> comboPromotionsList;
    static {
        nItemsActivePromotions = new HashMap<>();
        nItemsActivePromotions.put(Constants.SKU_A, new Promotions(3, 130));
        nItemsActivePromotions.put(Constants.SKU_B, new Promotions(2, 45));

        comboActivePromotions = new HashMap<>();
        Map<Character,Integer> combo = new HashMap<>();
        combo.put(Constants.SKU_D, 30);
        comboActivePromotions.put(Constants.SKU_C, new Sku('D', 30));
    }

    public Map<Character, Promotions>  nItemsPromotions(){
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

    public void updateNItemsPromotionCode(char skuId, Promotions promotions){
        nItemsActivePromotions.put(skuId, promotions);
    }

    public void updateComboPromotions(char skuId, Sku comboPromotion){
        comboActivePromotions.put(skuId, comboPromotion);
    }

    public boolean isCombo(char skuId){
        return Constants.combosList.contains(skuId);
    }
}
