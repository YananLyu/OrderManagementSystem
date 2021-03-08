package com.astronet.oms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TestExample {

    @Autowired
    private OmsSkuRepository omsSkuRepository;

    /**
     * Sort
     */
    @org.junit.jupiter.api.Test
    public void testFindAllASC() {
        List<OmsSku> sku = omsSkuRepository.findAllByOrderByCreateTimeDesc();
        System.out.println(sku);
    }

    /**
     * GET Methods
     */
    @org.junit.jupiter.api.Test
    public void testFindAll() {
        List<OmsSku> sku = omsSkuRepository.findAll();
        System.out.println(sku);
    }

    @org.junit.jupiter.api.Test
    public void testFindById() {
        Optional<OmsSku> sku = omsSkuRepository.findById(1L);
        System.out.println(sku);
    }

    @org.junit.jupiter.api.Test
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
    @org.junit.jupiter.api.Test
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
    @org.junit.jupiter.api.Test
    public void testSaveAll() {
        ArrayList<OmsSku> entities = new ArrayList<>();

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

        entities.add(sku);
        entities.add(sku2);

        omsSkuRepository.saveAll(entities);
    }



    /**
     * Delete Methods
     */
    @org.junit.jupiter.api.Test
    public void testDeleteById() {
        Long id = 4L;
        omsSkuRepository.deleteById(id);
    }

    /**
     * 删除给定的实体。
     */
    @org.junit.jupiter.api.Test
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
    @org.junit.jupiter.api.Test
    public void testCount() {
        // 统计现存实体的个数
        System.out.println(omsSkuRepository.count());
    }
}
