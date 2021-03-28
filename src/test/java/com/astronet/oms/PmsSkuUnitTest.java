package com.astronet.oms;

import com.astronet.oms.entity.PmsSku;
import com.astronet.oms.entity.PmsSpu;
import com.astronet.oms.enums.OfferStatusEnum;
import com.astronet.oms.repository.PmsSkuRepository;
import com.astronet.oms.repository.PmsSpuRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class PmsSkuUnitTest {

    @Autowired
    private PmsSkuRepository repository;

    @Autowired
    private PmsSpuRepository pmsSpuRepository;

    /**
     * TODO： save new Offer时候，如果没有对应的SPU则不可以save。
     * Test C - Create
     */
    @Test
    public void testSkuSaveNewOffer() {
        PmsSku pmsSku = PmsSku.builder()
                .pmsSpu(pmsSpuRepository.findById(4L).get())
                .unitPrice(BigDecimal.valueOf(999.0))
                .adminPrice(BigDecimal.valueOf(333.0))
                .modPrice(BigDecimal.valueOf(111.0))
                .quantity(10L)
                .quantityLeft(10L)
                .offerStatus(OfferStatusEnum.ACTIVE)
                .offerNote("New Offer")
                .build();
        PmsSku savedPmsSku = repository.save(pmsSku);
        assertThat(savedPmsSku.getId()).isGreaterThan(0);
    }

//    public void testSkuSaveNewOffer1() {
//        PmsSpu newPmsSpu = PmsSpu pmsSpu = PmsSpu.builder();
//                .productName("Dell笔记本")
//                .productLink("https://www.Dell.com/us/computing/buy/?CID=afl-ecomm-cjn-cha-092118-53026&cjevent=5d303c707c8411eb80c0016e0a1c0e11&utm_source=11557370&utm_medium=100334236&utm_campaign=0FOF63161473724829234&AID=11557370&PID=100334236&SID=0FOF63161473724829234")
//                .platformSeller("Dell官网")
//                .build();
//        PmsSku pmsSku = PmsSku.builder()
//                .pmsSpu(pmsSpuRepository.findById(4L).get())
//                .unitPrice(BigDecimal.valueOf(999.0))
//                .adminPrice(BigDecimal.valueOf(333.0))
//                .modPrice(BigDecimal.valueOf(111.0))
//                .quantity(10L)
//                .quantityLeft(10L)
//                .offerStatus(OfferStatusEnum.ACTIVE)
//                .offerNote("New Offer")
//                .build();
//        PmsSku savedPmsSku = repository.save(pmsSku);
//        assertThat(savedPmsSku.getId()).isGreaterThan(0);
//    }

    /**
     * Test R - Read All
     */
    @Test
    public void testSkuFindAll() {
        List<PmsSku> res = repository.findAll();
        assertThat(res).size().isGreaterThanOrEqualTo(0);
    }

    /**
     * Test R - Read One
     */
    @Test
    public void testSkuFindById() {
        Optional<PmsSku> res = repository.findById(5L);
        System.out.println("**************");
        System.out.println(res.get().getOfferStatus());
        System.out.println(res.get().getPmsSpu().getPlatformSeller());
        System.out.println(res.get().getPmsSpu().getProductName());
        assertThat(res.get().getId()).isEqualTo(5L);
    }

    @Test
    public void testSkuActive() {
        List<PmsSku> res = repository.findByOfferStatus(OfferStatusEnum.ACTIVE);
        System.out.println("------------------------");
        System.out.println(res.size());
        System.out.println(res.get(0).toString());
        System.out.println(res.get(0).getUnitPrice());
        System.out.println(res.get(0).getPmsSpu().toString());
        System.out.println("------------------------");

        assertThat(res).size().isGreaterThanOrEqualTo(0);
    }

    @Test
    public void testSkuInactive() {
        List<PmsSku> res = repository.findByOfferStatus(OfferStatusEnum.INACTIVE);
        System.out.println(res.size());
        assertThat(res).size().isGreaterThanOrEqualTo(0);
    }

    /**
     * Test U - Update
     */
    @Test
    public void testSkuUpdate() {
        PmsSku newPmsSku = PmsSku.builder()
                .unitPrice(BigDecimal.valueOf(777.0))
                .adminPrice(BigDecimal.valueOf(999.0))
                .modPrice(BigDecimal.valueOf(222.0))
                .quantity(8L)
                .quantityLeft(8L)
                .offerStatus(OfferStatusEnum.INACTIVE)
                .offerNote("New Offer")
                .build();
        Optional<PmsSku> res = repository.findById(4L);

        res.map(sku -> {
            sku.setUnitPrice(newPmsSku.getUnitPrice());
            sku.setAdminPrice(newPmsSku.getAdminPrice());
            sku.setModPrice(newPmsSku.getModPrice());
            sku.setQuantity(newPmsSku.getQuantity());
            sku.setQuantityLeft(newPmsSku.getQuantityLeft());
            sku.setOfferStatus(newPmsSku.getOfferStatus());
            sku.setOfferNote(newPmsSku.getOfferNote());
            return repository.save(sku);
        }).orElseGet(() -> {
            newPmsSku.setId(4L);
            return repository.save(newPmsSku);
        });

        Optional<PmsSku> updatedPmsSku = repository.findById(4L);
        assertThat(updatedPmsSku.get().getUnitPrice()).isEqualByComparingTo(newPmsSku.getUnitPrice());
        assertThat(updatedPmsSku.get().getAdminPrice()).isEqualByComparingTo(newPmsSku.getAdminPrice());
        assertThat(updatedPmsSku.get().getModPrice()).isEqualByComparingTo(newPmsSku.getModPrice());
        assertThat(updatedPmsSku.get().getQuantity()).isEqualTo(newPmsSku.getQuantity());
        assertThat(updatedPmsSku.get().getQuantityLeft()).isEqualTo(newPmsSku.getQuantityLeft());
        assertThat(updatedPmsSku.get().getOfferStatus()).isEqualTo(newPmsSku.getOfferStatus());
        assertThat(updatedPmsSku.get().getOfferNote()).isEqualTo(newPmsSku.getOfferNote());
    }

    /**
     * Test D - Delete
     */
    @Test
    public void testSkuDelete() {
        Optional<PmsSku> res = repository.findById(3L);
        repository.deleteById(res.get().getId());
        Optional<PmsSku> deletedPmsSpu = repository.findById(3L);
        assertThat(deletedPmsSpu.isPresent()).isFalse();
    }

}
