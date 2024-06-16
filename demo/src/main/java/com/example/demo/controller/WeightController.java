package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

import com.example.demo.model.Weight;
import com.example.demo.service.WeightService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/weight")
public class WeightController {

    @Autowired
    private WeightService weightService;

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAllWeight() {
        return weightService.getAllWeights();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Map<String, Object>> getAllWeightOfUser(@PathVariable Long id) {
        return weightService.getAllWeightsOfUser(id);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getWeightById(@PathVariable Long id) {
        return weightService.getWeightById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> createWeight(@RequestBody Weight weight) {
        return weightService.saveWeight(weight);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteWeight(@PathVariable Long id) {
       return weightService.deleteWeight(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> putMethodName(@PathVariable Long id, @RequestBody Weight weight) {
        return weightService.updateWeight(weight,id);
    }
    
}
