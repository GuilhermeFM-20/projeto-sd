package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

import com.example.demo.model.Meals;
import com.example.demo.service.MealsService;

@RestController
@RequestMapping("/api/meals")
public class MealsController {

    @Autowired
    private MealsService mealsService;

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAllMeals() {
        return mealsService.getAllMeals();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Map<String, Object>> getAllMealsOfUser(@PathVariable Long id) {
        return mealsService.getAllMealsOfUser(id);
    } 

    @PutMapping("/user/search/{id}")
    public ResponseEntity<Map<String, Object>> getAllMealsSerarch(@PathVariable Long id, @RequestBody Meals meals) {
        return mealsService.getAllMealsSearch(id,meals);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getMealsById(@PathVariable Long id) {
        return mealsService.getMealsById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> createMeals(@RequestBody Meals meals) {
        return mealsService.saveMeals(meals);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteMeals(@PathVariable Long id) {
       return mealsService.deleteMeals(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> putMethodName(@PathVariable Long id, @RequestBody Meals meals) {
        return mealsService.updateMeals(meals,id);
    }
    
}
