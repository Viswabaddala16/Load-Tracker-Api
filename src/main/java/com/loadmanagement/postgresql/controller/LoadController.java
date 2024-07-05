package com.loadmanagement.postgresql.controller;

import com.loadmanagement.postgresql.entity.Load;
import com.loadmanagement.postgresql.repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private LoadRepository loadRepository;

    @GetMapping
    public ResponseEntity<List<Load>> getLoadsByShipperId(@RequestParam UUID shipperId) {
        List<Load> loads = loadRepository.findByShipperId(shipperId);
        return ResponseEntity.ok(loads); // Return list of loads for the given shipperId
    }

    @GetMapping("/{id}")
    public ResponseEntity<Load> getLoadById(@PathVariable Long id, @RequestParam(required = false) UUID shipperId) {
        if (shipperId != null) {
            Optional<Load> load = loadRepository.findByIdAndShipperId(id, shipperId);
            return load.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } else {
            Optional<Load> load = loadRepository.findById(id);
            return load.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateLoad(@PathVariable Long id, @RequestBody Load loadDetails) {
        return loadRepository.findById(id).map(load -> {
            load.setShipperId(loadDetails.getShipperId());
            load.setDetails(loadDetails.getDetails());
            load.setLoadingPoint(loadDetails.getLoadingPoint());
            load.setUnloadingPoint(loadDetails.getUnloadingPoint());
            load.setProductType(loadDetails.getProductType());
            load.setTruckType(loadDetails.getTruckType());
            load.setNoOfTrucks(loadDetails.getNoOfTrucks());
            load.setWeight(loadDetails.getWeight());
            load.setComment(loadDetails.getComment());
            load.setDate(loadDetails.getDate());
            loadRepository.save(load);
            return ResponseEntity.ok("Load updated successfully");
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLoad(@PathVariable Long id) {
        return loadRepository.findById(id).map(load -> {
            loadRepository.delete(load);
            return ResponseEntity.ok("Load deleted successfully");
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/")
    public ResponseEntity<List<Load>> getLoadsByShipperIdQueryParam(@RequestParam UUID shipperId) {
        List<Load> loads = loadRepository.findByShipperId(shipperId);
        return ResponseEntity.ok(loads); // Return list of loads for the given shipperId
    }
    
    @PostMapping
    public ResponseEntity<String> createLoad(@RequestBody Load load) {
        try {
            Load savedLoad = loadRepository.save(load);
            return ResponseEntity.ok("Load added successfully with ID: " + savedLoad.getId());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to add load: " + e.getMessage());
        }
    }
}
