package org.promotion.engine.unit.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.promotion.engine.dto.Promotions;
import org.promotion.engine.model.Sku;
import org.promotion.engine.repository.PromotionCodesRepo;

import java.util.Map;

public class PromotionCodesRepoTest {

    private static final  char skuId = 'E';
    PromotionCodesRepo promotionCodesRepo;
    @Before
    public void createPromotionCodesRepo(){
       promotionCodesRepo = new PromotionCodesRepo();
    }

    @Test
    public void testAddOrUpdateComboActivePromotions_operationShouldSuccess(){
            Sku comboSku = new Sku('F', 10);
            promotionCodesRepo.addOrUpdateComboPromotions(skuId, comboSku);
            Map<Character, Sku> activeComboPromotions = promotionCodesRepo.getComboActivePromotions();
            assertNotNull(activeComboPromotions);
            assertTrue(activeComboPromotions.containsKey(skuId));
            assertEquals(comboSku.getSkuId(), activeComboPromotions.get(skuId).getSkuId());
    }

    @Test
    public void testAddOrUpdateNItemsPromotionCode_operationShouldSuccess(){
        Promotions promotions = new Promotions(2, 100);
        promotionCodesRepo.addOrUpdateNItemsPromotionCode(skuId, promotions);
        Map<Character, Promotions> nItemsPromotions = promotionCodesRepo.getNItemsPromotions();
        assertNotNull(nItemsPromotions);
        assertNotNull(nItemsPromotions.get(skuId));
        assertEquals(promotions.getPromotionQuantity(), nItemsPromotions.get(skuId).getPromotionQuantity());
        assertEquals(promotions.getPromotionPrice(), nItemsPromotions.get(skuId).getPromotionPrice());
    }

    @Test
    public void testDeleteNItemPromotions_operationShouldSuccess(){
        Promotions promotions = new Promotions(2, 100);
        promotionCodesRepo.addOrUpdateNItemsPromotionCode(skuId, promotions);
        assertNotNull(promotionCodesRepo.getNItemsPromotions().get(skuId));
        promotionCodesRepo.deleteNItemsPromotions(skuId);
        assertNull(promotionCodesRepo.getNItemsPromotions().get(skuId));
    }

    @Test
    public void testDeleteComboPromotions_operationShouldSuccess(){
        Sku comboSku = new Sku('F', 10);
        promotionCodesRepo.addOrUpdateComboPromotions(skuId, comboSku);
        assertNotNull(promotionCodesRepo.getComboPromotionsById(skuId));
        promotionCodesRepo.deleteComboPromotions(skuId);

        assertNull(promotionCodesRepo.getComboPromotionsById(skuId));
    }
}
