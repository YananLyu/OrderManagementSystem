package com.astronet.oms.controller;

import com.astronet.oms.dtos.OmsExpressTrackingDto;
import com.astronet.oms.service.OmsExpressTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zhubo Deng
 * @date 03/28/2021 3:35 AM
 */

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class OmsExpressTrackingController {

    @Autowired
    OmsExpressTrackingService service;

    /**
     * C - Create
     * @param dto
     * @return
     */
    @PostMapping("/tracking")
    public OmsExpressTrackingDto createTracking(@RequestBody OmsExpressTrackingDto dto) {
        return service.createTracking(dto);
    }

    /**
     * R - Read all
     * @return
     */
    @GetMapping("/tracking")
    public List<OmsExpressTrackingDto> readAllTracking() {
        return service.readAllTracking();
    }

    /**
     * R - Read One
     * @param id
     * @return
     */
    @GetMapping("/tracking/{id}")
    public ResponseEntity<OmsExpressTrackingDto> readOneTracking(@PathVariable Long id) {
        return ResponseEntity.ok(service.readOneTracking(id));
    }

    /**
     * R - Retrieval all the pending express tracking
     * @return
     */
    @GetMapping("/tracking/pending")
    public List<OmsExpressTrackingDto> pendingTracking() {
        return service.pendingTracking();
    }

    /**
     * R - Retrieval all the received express tracking
     * @return
     */
    @GetMapping("/tracking/received")
    public List<OmsExpressTrackingDto> receivedTracking() {
        return service.receivedTracking();
    }

    /**
     * R - Retrieval all the issued express tracking
     * @return
     */
    @GetMapping("/tracking/issued")
    public List<OmsExpressTrackingDto> issuedTracking() {
        return service.issuedTracking();
    }

    /**
     * U - Update
     * @param dto
     * @param id
     * @return
     */
    @PutMapping("/tracking/{id}")
    public OmsExpressTrackingDto updateTracking(@RequestBody OmsExpressTrackingDto dto, @PathVariable Long id) {
        return service.updateTracking(dto, id);
    }

    /**
     * D - Delete
     * @param id
     */
    @DeleteMapping("/tracking/{id}")
    public void deleteTracking(@PathVariable Long id) {
        service.deleteTracking(id);
    }

}
