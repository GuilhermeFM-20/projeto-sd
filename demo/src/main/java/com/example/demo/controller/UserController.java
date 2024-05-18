package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable Long id) {
       return userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> putMethodName(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(user,id);
    }

}
