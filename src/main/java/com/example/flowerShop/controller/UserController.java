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

    /**
     * Injected constructor
     * @param userServiceImpl
     */
    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    /**
     * Gets list of users
     * @return
     */
    @GetMapping("/get/all")
    public ResponseEntity<List<UserGetDTO>> getAllUsers() {
        return this.userServiceImpl.getAllUsers();
    }

    /**
     * Gets user by id
     * @param id
     * @return ResponseEntity<UserGetDTO>
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<UserGetDTO> getUserById(@PathVariable UUID id) {
        return this.userServiceImpl.getUserById(id);
    }

    /**
     * Creates a new user
     * @param user
     * @return ResponseEntity<String>
     */
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserPostDTO user) {
        return this.userServiceImpl.addUser(user);
    }

    /**
     * Updates user by given id and request body
     * @param id
     * @param user
     * @return ResponseEntity<String>
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUserById(@PathVariable UUID id, @RequestBody UserPostDTO user) {
        return this.userServiceImpl.updateUserById(id, user);
    }

    /**
     * Deletes user by given id
     * @param id
     * @return ResponseEntity<String>
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable UUID id) {
        return this.userServiceImpl.deleteUserById(id);
    }

}
