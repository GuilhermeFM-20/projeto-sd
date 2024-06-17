package com.example.demo.controller;

import com.example.demo.model.Activity;
import com.example.demo.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAllActivities() {
        return activityService.getAllActivities();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Map<String, Object>> getAllActivityOfUser(@PathVariable Long id) {
        return activityService.getAllActivityOfUser(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getActivityById(@PathVariable Long id) {
        return activityService.getActivityById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> createActivity(@RequestBody Activity activity) {
        return activityService.saveActivity(activity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteActivity(@PathVariable Long id) {
        return activityService.deleteActivity(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateActivity(@PathVariable Long id, @RequestBody Activity activity) {
        return activityService.updateActivity(activity, id);
    }

}
