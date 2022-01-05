package org.promotion.engine.unit.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.promotion.engine.model.Sku;
import org.promotion.engine.repository.SkuPricesRepo;
import org.promotion.engine.services.CartService;
import org.promotion.engine.utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SkuPricesRepoTest {

    SkuPricesRepo skuPricesRepo;

    @Before
    public void createInstance(){
         skuPricesRepo = new SkuPricesRepo();
    }

    @Test
    public void testAddOrUpdateSingleSkuUnitPrice_operationShouldSuccess(){

        char skuId = 'N';
        skuPricesRepo.addOrUpdateSingleSkuUnitPrice(skuId, 10);
        Map<Character, Integer> skuPrices = skuPricesRepo.getSkusUnitPrices();
        assertNotNull(skuPrices.get(skuId));
        skuPricesRepo.addOrUpdateSingleSkuUnitPrice(skuId, 20);
        assertEquals(20, (int)skuPricesRepo.getSkusUnitPrices().get(skuId));
    }

    @Test
    public void testAddOrUpdateMultipleSkuUnitPrices_updateShouldSuccess(){
        char newSku = 'E';
        List<Sku> skusToAddOrUpdate = new ArrayList<>();
        Sku sku = new Sku(newSku, 20);
        skusToAddOrUpdate.add(sku);
        Sku sku2 = new Sku(Constants.SKU_B, 35);
        skusToAddOrUpdate.add(sku2);

        skuPricesRepo.addOrUpdateMultipleSkuUnitPrices(skusToAddOrUpdate);
        Map<Character, Integer> skuPrices = skuPricesRepo.getSkusUnitPrices();
        assertNotNull(skuPrices.get(newSku));
        assertEquals(35, (int)skuPricesRepo.getSkusUnitPrices().get(Constants.SKU_B));
    }

    @Test
    public void testDeleteSkuUnitPrice_deleteShouldSuccess(){
        char skuId = 'N';
        skuPricesRepo.addOrUpdateSingleSkuUnitPrice(skuId, 10);
        Map<Character, Integer> skuPrices = skuPricesRepo.getSkusUnitPrices();
        assertNotNull(skuPrices.get(skuId));

        skuPricesRepo.deleteSkuUnitPrice(skuId);
        assertNull(skuPrices.get(skuId));
    }
}
