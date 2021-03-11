package com.astronet.oms.controller;

import com.astronet.oms.entity.PmsSpu;
import com.astronet.oms.exception.SpuNotFoundException;
import com.astronet.oms.repository.PmsSpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yanan Lyu
 * @date 3/10/21 9:42 PM
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/admin")
public class SpuController {

    /**
     * @RestController indicates that the data returned by each method will be written straight into the response
     * body instead of rendering a template.
     *
     * An EmployeeRepository is injected by constructor into the controller.
     *
     * We have routes for each operation (@GetMapping, @PostMapping, @PutMapping and @DeleteMapping, corresponding to
     * HTTP GET, POST, PUT, and DELETE calls). (NOTE: It’s useful to read each method and understand what they do.)
     *
     * EmployeeNotFoundException is an exception used to indicate when an employee is looked up but not found.
     */

    @Autowired
    private PmsSpuRepository repository;

    /**
     * 增 C
     * @return pmsSpu 即新增加的产品
     */
    @PostMapping("/products")
    public PmsSpu newProduct(@RequestBody  PmsSpu pmsSpu) {
        return repository.save(pmsSpu);
    }

    /**
     * 查 R
     * 查多条记录
     * @return List<PmsSpu>  即products列表，按照ID倒序排
     */
    @GetMapping("/products")
    public List<PmsSpu> all() {
        return repository.findAllByOrderByIdDesc();
    }

    /**
     * 查 R
     * 根据ID查单条记录
     * @param id
     * @return ResponseEntity<PmsSpu>
     */
    @GetMapping("/products/{id}")
    public ResponseEntity<PmsSpu> one(@PathVariable Long id) {
        PmsSpu item = repository.findById(id)
                .orElseThrow(() -> new SpuNotFoundException(id));

        return ResponseEntity.ok(item);
    }

    /**
     * 改 U
     * @param newPmsSpu
     * @param id
     * @return
     */
    @PutMapping("/products/{id}")
    public PmsSpu replaceProduct(@RequestBody PmsSpu newPmsSpu, @PathVariable Long id) {

        return repository.findById(id)
                .map(spu -> {
                    spu.setPlatformSeller(newPmsSpu.getPlatformSeller());
                    spu.setProductName(newPmsSpu.getProductName());
                    return repository.save(spu);
                })
                .orElseGet(() -> {
                    newPmsSpu.setId(id);
                    return repository.save(newPmsSpu);
                });
    }

    /**
     * 删 D
     * 根据ID删除记录
     * @param id
     */
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
    }


}
