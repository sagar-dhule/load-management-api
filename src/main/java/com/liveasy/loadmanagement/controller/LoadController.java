package com.liveasy.loadmanagement.controller;

import com.liveasy.loadmanagement.entity.Load;
import com.liveasy.loadmanagement.service.LoadService;
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
    private LoadService loadService;

    @PostMapping
    public ResponseEntity<String> addLoad(@RequestBody Load load) {
        loadService.saveLoad(load);
        return ResponseEntity.ok("Load details added successfully");
    }

    @GetMapping
    public List<Load> getLoads(@RequestParam UUID shipperId) {
        return loadService.getLoadsByShipperId(shipperId);
    }

    @GetMapping("/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable UUID loadId) {
        Optional<Load> load = loadService.getLoadById(loadId);
        return load.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{loadId}")
    public ResponseEntity<Load> updateLoad(@PathVariable UUID loadId, @RequestBody Load loadDetails) {
        Load updatedLoad = loadService.updateLoad(loadId, loadDetails);
        return ResponseEntity.ok(updatedLoad);
    }

    @DeleteMapping("/{loadId}")
    public ResponseEntity<Void> deleteLoad(@PathVariable UUID loadId) {
        loadService.deleteLoad(loadId);
        return ResponseEntity.noContent().build();
    }
}
