package com.astronet.oms;

import com.astronet.oms.entity.PmsSku;
import com.astronet.oms.repository.PmsSkuRepository;
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
    private PmsSkuRepository pmsSkuRepository;

    /**
     * Test C - Create
     */
    @Test
    public void testSkuSaveNewOffer() {
        PmsSku pmsSku = PmsSku.builder()
                .unitPrice(BigDecimal.valueOf(222.0))
                .adminPrice(BigDecimal.valueOf(333.0))
                .modPrice(BigDecimal.valueOf(111.0))
                .quantity(5L)
                .quantityLeft(5L)
                .offerStatus(1)
                .offerNote("New Offer")
                .build();
        PmsSku savedPmsSku = pmsSkuRepository.save(pmsSku);
        assertThat(savedPmsSku.getId()).isGreaterThan(0);
    }

    /**
     * Test R - Read All
     */
    @Test
    public void testSkuFindAll() {
        List<PmsSku> res = pmsSkuRepository.findAll();
        assertThat(res).size().isGreaterThan(0);
    }

    /**
     * Test R - Read One
     */
    @Test
    public void testSkuFindById() {
        Optional<PmsSku> res = pmsSkuRepository.findById(2L);
        assertThat(res.get().getId()).isEqualTo(2L);
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
                .offerStatus(1)
                .offerNote("New Offer")
                .build();
        Optional<PmsSku> res = pmsSkuRepository.findById(4L);

        res.map(sku -> {
            sku.setUnitPrice(newPmsSku.getUnitPrice());
            sku.setAdminPrice(newPmsSku.getAdminPrice());
            sku.setModPrice(newPmsSku.getModPrice());
            sku.setQuantity(newPmsSku.getQuantity());
            sku.setQuantityLeft(newPmsSku.getQuantityLeft());
            sku.setOfferStatus(newPmsSku.getOfferStatus());
            sku.setOfferNote(newPmsSku.getOfferNote());
            return pmsSkuRepository.save(sku);
        }).orElseGet(() -> {
            newPmsSku.setId(4L);
            return pmsSkuRepository.save(newPmsSku);
        });

        Optional<PmsSku> updatedPmsSku = pmsSkuRepository.findById(4L);
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
        Optional<PmsSku> res = pmsSkuRepository.findById(3L);
        pmsSkuRepository.deleteById(res.get().getId());
        Optional<PmsSku> deletedPmsSpu = pmsSkuRepository.findById(3L);
        assertThat(deletedPmsSpu.isPresent()).isFalse();
    }

}
