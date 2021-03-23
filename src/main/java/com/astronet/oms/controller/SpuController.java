package com.astronet.oms.controller;

import com.astronet.oms.convertors.dtoconverter.PmsSpuConverter;
import com.astronet.oms.dtos.PmsSpuDto;
import com.astronet.oms.entity.PmsSpu;
import com.astronet.oms.exception.SpuNotFoundException;
import com.astronet.oms.repository.PmsSpuRepository;
import com.astronet.oms.service.PmsSpuService;
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
    private PmsSpuService service;

    /**
     * 增 C
     * @param pmsSpuDto
     * @return
     */
    @PostMapping("/products")
    public PmsSpuDto createProduct(@RequestBody PmsSpuDto pmsSpuDto) {
        return service.createProduct(pmsSpuDto);
    }

    /**
     * 查 R
     * 查多条记录
     * @return List<PmsSpu>  即products列表，按照ID倒序排
     */
//    @GetMapping("/products")
//    public List<PmsSpuDto> readAllProduct() {
//        List<PmsSpu> findAll = repository.findAllByOrderByIdDesc();
//        return converter.entityToDto(findAll);
//    }

    /**
     * 查 R
     * 根据ID查单条记录
     * @param id
     * @return ResponseEntity<PmsSpu>
     */
    @GetMapping("/products/{id}")
    public ResponseEntity<PmsSpuDto> readOneProduct(@PathVariable Long id) {
        return ResponseEntity.ok(service.readOneProduct(id));
    }

    /**
     * 改 U
     * @param newPmsSpuDto
     * @param id
     * @return
     */
    @PutMapping("/products/{id}")
    public PmsSpuDto updateProduct(@RequestBody PmsSpuDto newPmsSpuDto, @PathVariable Long id) {
        return service.updateProduct(newPmsSpuDto, id);
    }

    /**
     * 删 D
     * 根据ID删除记录
     * @param id
     */
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
    }

}
