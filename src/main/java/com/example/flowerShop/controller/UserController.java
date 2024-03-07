package com.example.flowerShop.controller;

import com.example.flowerShop.dto.UserGetDTO;
import com.example.flowerShop.dto.UserPostDTO;
import com.example.flowerShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/get/all")
    public ResponseEntity<List<UserGetDTO>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserGetDTO> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserPostDTO user) {
        return userService.addUser(user);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUserById(@PathVariable Long id, @RequestBody UserPostDTO user) {
        return userService.updateUserById(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }

}
