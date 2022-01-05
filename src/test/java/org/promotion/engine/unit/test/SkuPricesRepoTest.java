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


}
