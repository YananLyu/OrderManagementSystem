package com.astronet.order_sys;


import com.astronet.order_sys.entity.OmsSku;
import com.astronet.order_sys.repository.OmsSkuRepository;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class SkuTest {

    @Autowired
    private OmsSkuRepository omsSkuRepository;

    /**
     * GET Methods
     */
    @Test
    public void testFindAll() {
        List<OmsSku> sku = omsSkuRepository.findAll();
        System.out.println(sku);
    }

    @Test
    public void testFindById() {
        Optional<OmsSku> sku = omsSkuRepository.findById(1L);
        System.out.println(sku);
    }

    @Test
    public void testFindAllById() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<OmsSku> sku = omsSkuRepository.findAllById(ids);
        System.out.println(sku);
    }

    /**
     * Create and Update methods
     */
    @Test
    public void testSave() {
        OmsSku sku = new OmsSku();
        sku.setCommissionId(2L);
        sku.setCreateUser(121L);
        sku.setDiscountPrice(20.02);
        sku.setLink("https://blog.csdn.net/hbtj_1216/article/details/79773839");
        sku.setQuantity(26L);
        sku.setProductName("CSDN会员");
        sku.setUnitPrice(200.02);
        omsSkuRepository.save(sku);
    }

    /**
     * 保存提供的所有实体。
     */
    @Test
    public void testSaveAll() {
        ArrayList<OmsSku> entites = new ArrayList<>();

        OmsSku sku = new OmsSku();
        sku.setCommissionId(2L);
        sku.setCreateUser(121L);
        sku.setDiscountPrice(20.02);
        sku.setLink("https://blog.csdn.net/hbtj_1216/article/details/79773839");
        sku.setQuantity(26L);
        sku.setProductName("CSDN会员");
        sku.setUnitPrice(200.02);

        OmsSku sku2 = new OmsSku();
        sku2.setCommissionId(3L);
        sku2.setCreateUser(121L);
        sku2.setDiscountPrice(20.02);
        sku2.setLink("https://blog.csdn.net/hbtj_1216/article/details/79773839");
        sku2.setQuantity(26L);
        sku2.setProductName("CSDN会员");
        sku2.setUnitPrice(200.02);

        entites.add(sku);
        entites.add(sku2);

        omsSkuRepository.saveAll(entites);
    }



    /**
     * Delete Methods
     */
    @Test
    public void testDeleteById() {
        Long id = 4L;
        omsSkuRepository.deleteById(id);
    }

    /**
     * 删除给定的实体。
     */
    @Test
    public void testDelete() {
        OmsSku sku = new OmsSku();
        sku.setCommissionId(2L);
        sku.setCreateUser(121L);
        sku.setDiscountPrice(20.02);
        sku.setLink("https://blog.csdn.net/hbtj_1216/article/details/79773839");
        sku.setQuantity(26L);
        sku.setProductName("CSDN会员");
        sku.setUnitPrice(200.02);
        sku.setId(3L);

        omsSkuRepository.delete(sku);
    }

    /**
     * util Methods
     */
    @Test
    public void testCount() {
        // 统计现存实体的个数
        System.out.println(omsSkuRepository.count());
    }
}
