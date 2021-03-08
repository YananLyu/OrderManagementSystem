package com.astronet.oms;

import com.astronet.oms.entity.PmsInventory;
import com.astronet.oms.entity.PmsSku;
import com.astronet.oms.entity.PmsSpu;
import com.astronet.oms.enums.OfferStatus;
import com.astronet.oms.repository.PmsInventoryRepository;
import com.astronet.oms.repository.PmsSkuRepository;
import com.astronet.oms.repository.PmsSpuRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author: Yanan Lyu
 * @date 3/3/21 9:38 PM
 */

@SpringBootTest
public class PmsSpuTest {

    @Autowired
    private PmsSpuRepository spuRepository;

    @Autowired
    private PmsSkuRepository skuRepository;

    @Autowired
    private PmsInventoryRepository pmsInventoryRepository;

    /**
     * GET Methods
     */
    @Test
    public void testSpuFindAll() {
        List<PmsSpu> res = spuRepository.findAll();
        System.out.println(res);
    }

    @Test
    public void testSpuFindById2() {
        Optional<PmsSpu> res = spuRepository.findById(2L);
        System.out.println(res.get());
    }

    @Test
    public void testSpuFindById1() {
        Optional<PmsSpu> res = spuRepository.findById(1L);
        System.out.println("************************");
        System.out.println(res.get());
        PmsSpu spu = res.get();
        System.out.println(spu.getId());
        System.out.println(spu.getProductLink());
        System.out.println(spu.getProductName());
        System.out.println(spu.getPmsSkuSet());
        System.out.println("************************");

    }

    /**
     * Create and Update
     */
    @Test
    public void testSpuSave() {
        PmsSpu entity = new PmsSpu();
        entity.setProductName("Dell笔记本");
        entity.setProductLink("https://www.Dell.com/us/computing/buy/?CID=afl-ecomm-cjn-cha-092118-53026&cjevent=5d303c707c8411eb80c0016e0a1c0e11&utm_source=11557370&utm_medium=100334236&utm_campaign=0FOF63161473724829234&AID=11557370&PID=100334236&SID=0FOF63161473724829234");
        entity.setPlatformSeller("Dell官网");

        spuRepository.save(entity);

    }

    /**
     * Create and Update
     */
    @Test
    public void testInventorySave() {
        PmsInventory pmsInventory = new PmsInventory();
        pmsInventory = PmsInventory
                .builder()
                .addrCountry("US")
                .addrCity("lakewood")
                .addrLine1("11738 lake ave")
                .addrLine2("apt 301")
                .addrState("ohio")
                .addrZipcode("44107")
                .build();

        pmsInventoryRepository.save(pmsInventory);

    }

    /**
     * GET Methods
     */
    @Test
    public void testSkuFindAll() {
        List<PmsSku> res = skuRepository.findAll();
        System.out.println(res);
    }

    /**
     * Create and Update
     * 存入sku时候也存入spu
     */
    @Test
    public void testSkuSave1() {

        PmsSpu spu = new PmsSpu();
        spu.setProductName("Lenovo笔记本");
        spu.setProductLink("https://deals.Lenovo.com/en-us/mpp/productdetail/7tog?AID=889052&cjevent=c955b4fa7d5e11eb83ec00340a1c0e14&cjdata=MXxOfDB8WXww&gacd=9614781-23761182-5750457-265988609-127889515&dgc=af&VEN1=12578053-889052-11000_1692869_0-PricePP%20LLC-https://deals.dell.com/en-us/mpp/productdetail/7tog&dclid=COTVm6uUmO8CFUeuAQodFAUMbw");
        spu.setPlatformSeller("Lenovo官网");

        PmsSku sku = new PmsSku();
        sku.setAdminPrice(BigDecimal.valueOf(15));
        sku.setQuantity(99L);
        sku.setQuantityLeft(99L);
        sku.setOfferNote("两种颜色都要。");
        sku.setUnitPrice(BigDecimal.valueOf(538.99));
        sku.setAdminPrice(BigDecimal.valueOf(550L));
        Set<PmsInventory> inventories = new HashSet<>();
        inventories.add(pmsInventoryRepository.getOne(1L));
        sku.setPmsInventories(inventories);
        sku.setOfferStatus(1);

        sku.setPmsSpu(spu);

        skuRepository.save(sku);

    }

    /**
     * Create and Update
     * spu中已有该产品，取出来当外键，并存入sku.
     */
    @Test
    public void testSkuSave2() {

        PmsSku sku = new PmsSku();
        sku.setAdminPrice(BigDecimal.valueOf(11.01));
        sku.setQuantity(66L);
        sku.setQuantityLeft(66L);
        sku.setOfferNote("两种颜色都要。");
        sku.setUnitPrice(BigDecimal.valueOf(538.99));
        sku.setOfferStatus(1);

        Optional<PmsSpu> spu = spuRepository.findById(1L);
        sku.setPmsSpu(spu.get());


        skuRepository.save(sku);

    }

    /**
     * GET Methods
     */
    @Test
    public void testSkuFindById() {
        Optional<PmsSku> res = skuRepository.findById(2L);
        System.out.println("********************");
        System.out.println(res);
    }





    /**
     * Delete
     * 删除一个spu
     */
    @Test
    public void testSpuDelete() {
        Long id = 4L;
        spuRepository.deleteById(id);
    }

    /**
     * Delete
     * 删除一个spu 和其对应的sku们
     */
    @Test
    public void testSpuDelete2() {
        Long id = 3L;
        Optional<PmsSpu> spu = spuRepository.findById(id);
        spuRepository.delete(spu.get());
    }

    @Test
    private void testOfferStatus() {
        OfferStatus[] res = OfferStatus.values();
        for (OfferStatus os : res) {
            System.out.println(os);
        }

    }


}
