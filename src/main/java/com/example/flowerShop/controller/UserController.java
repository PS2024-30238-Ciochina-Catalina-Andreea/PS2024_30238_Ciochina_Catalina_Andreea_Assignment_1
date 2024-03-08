package com.example.flowerShop.controller;

import com.example.flowerShop.dto.user.UserGetDTO;
import com.example.flowerShop.dto.user.UserPostDTO;
import com.example.flowerShop.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<UserGetDTO>> getAllUsers() {
        return userServiceImpl.getAllUsers();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserGetDTO> getUserById(@PathVariable UUID id) {
        return userServiceImpl.getUserById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserPostDTO user) {
        return userServiceImpl.addUser(user);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUserById(@PathVariable UUID id, @RequestBody UserPostDTO user) {
        return userServiceImpl.updateUserById(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable UUID id) {
        return userServiceImpl.deleteUserById(id);
    }

}
