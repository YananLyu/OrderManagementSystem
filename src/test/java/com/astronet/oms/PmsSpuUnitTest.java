package com.astronet.oms;

import com.astronet.oms.convertors.dtoconverter.PmsSpuConverter;
import com.astronet.oms.entity.PmsSpu;
import com.astronet.oms.repository.PmsSpuRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class PmsSpuUnitTest {

    @Autowired
    private PmsSpuRepository repository;

    /**
     * Test C - Create
     */
    @Test
    public void testSpuSaveNewProduct() {
        PmsSpu pmsSpu = PmsSpu.builder()
                .productName("Dell笔记本")
                .productLink("https://www.Dell.com/us/computing/buy/?CID=afl-ecomm-cjn-cha-092118-53026&cjevent=5d303c707c8411eb80c0016e0a1c0e11&utm_source=11557370&utm_medium=100334236&utm_campaign=0FOF63161473724829234&AID=11557370&PID=100334236&SID=0FOF63161473724829234")
                .platformSeller("Dell官网")
                .build();
        PmsSpu savedPmsSpu = repository.save(pmsSpu);
        assertThat(savedPmsSpu.getId()).isGreaterThan(0);
    }

    /**
     * Test R - Read All
     */
    @Test
    public void testSpuFindAll() {
        List<PmsSpu> res = repository.findAll();
        assertThat(res).size().isGreaterThanOrEqualTo(0);
    }

    /**
     * Test R - Read One
     */
    @Test
    public void testSpuFindById() {
        Optional<PmsSpu> res = repository.findById(1L);
        assertThat(res.get().getId()).isEqualTo(1L);
    }

    /**
     * Test U - Update
     */
    @Test
    public void testSpuUpdate() {
        PmsSpu newPmsSpu = PmsSpu.builder()
                .productName("Lenovo笔记本")
                .productLink("https://deals.Lenovo.com/en-us/mpp/productdetail/7tog?AID=889052&cjevent=c955b4fa7d5e11eb83ec00340a1c0e14&cjdata=MXxOfDB8WXww&gacd=9614781-23761182-5750457-265988609-127889515&dgc=af&VEN1=12578053-889052-11000_1692869_0-PricePP%20LLC-https://deals.dell.com/en-us/mpp/productdetail/7tog&dclid=COTVm6uUmO8CFUeuAQodFAUMbw")
                .platformSeller("Lenovo官网")
                .build();
        Optional<PmsSpu> res = repository.findById(5L);

        res.map(spu -> {
            spu.setProductName(newPmsSpu.getProductName());
            spu.setProductLink(newPmsSpu.getProductLink());
            spu.setPlatformSeller(newPmsSpu.getPlatformSeller());
            return repository.save(spu);
        }).orElseGet(() -> {
            newPmsSpu.setId(5L);
            return repository.save(newPmsSpu);
        });

        Optional<PmsSpu> updatedPmsSpu = repository.findById(5L);
        assertThat(updatedPmsSpu.get().getProductName()).isEqualTo(newPmsSpu.getProductName());
        assertThat(updatedPmsSpu.get().getProductLink()).isEqualTo(newPmsSpu.getProductLink());
        assertThat(updatedPmsSpu.get().getPlatformSeller()).isEqualTo(newPmsSpu.getPlatformSeller());
    }

    /**
     * Test D - Delete
     */
    @Test
    public void testSpuDelete() {
        Optional<PmsSpu> res = repository.findById(3L);
        repository.deleteById(res.get().getId());
        Optional<PmsSpu> deletedPmsSpu = repository.findById(3L);
        assertThat(deletedPmsSpu.isPresent()).isFalse();
    }

}
