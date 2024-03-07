package com.example.flowerShop.service;

import com.example.flowerShop.constants.UserConstants;
import com.example.flowerShop.dto.UserGetDTO;
import com.example.flowerShop.dto.UserPostDTO;
import com.example.flowerShop.dto.mappers.UserMapper;
import com.example.flowerShop.entity.User;
import com.example.flowerShop.repository.UserRepo;
import com.example.flowerShop.utils.user.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private UserMapper userMapper;

    public ResponseEntity<List<UserGetDTO>> getAllUsers() {

        try {
            List<User> users = userRepo.findAll();
            return new ResponseEntity<>(userMapper.convertListToDTO(users), HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<UserGetDTO> getUserById(Long id) {

        try {
            Optional<User> userOptional = userRepo.findById(id);
            if (userOptional.isPresent()) {
                User userExisting = userOptional.get();
                return new ResponseEntity<>(userMapper.convertToDTO(userExisting), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addUser(UserPostDTO user) {

        try {
            if (this.userUtils.validateSignUpMap(user)) {
                Optional<User> userOptional = userRepo.findByEmail(user.getEmail());
                if (userOptional.isEmpty()) {
                    userRepo.save(userMapper.convertToEntity(user));
                    return UserUtils.getResponseEntity(UserConstants.USER_CREATED, HttpStatus.CREATED);
                } else {
                    return UserUtils.getResponseEntity(UserConstants.USER_EXISTS, HttpStatus.BAD_REQUEST);
                }
            } else {
                return UserUtils.getResponseEntity(UserConstants.INVALID_DATA_AT_CREATING_USER, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return UserUtils.getResponseEntity(UserConstants.SOMETHING_WENT_WRONG_AT_CREATING_USER, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public ResponseEntity<String> updateUserById(Long id, UserPostDTO user) {

        try {
            Optional<User> userOptional = userRepo.findById(id);
            if (userOptional.isPresent()) {
                User userExisting = userOptional.get();
                userExisting.setName(user.getName());
                userExisting.setAddress(user.getAddress());
                userExisting.setContactNumber(user.getContactNumber());
                userRepo.save(userExisting);
                return UserUtils.getResponseEntity(UserConstants.DATA_MODIFIED, HttpStatus.OK);
            } else {
                return UserUtils.getResponseEntity(UserConstants.INVALID_USER, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return UserUtils.getResponseEntity(UserConstants.SOMETHING_WENT_WRONG_AT_UPDATING_USER, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<String> deleteUserById(Long id) {

        try {
            Optional<User> userOptional = userRepo.findById(id);
            if (userOptional.isPresent()) {
                userRepo.deleteById(id);
                return UserUtils.getResponseEntity(UserConstants.USER_DELETED, HttpStatus.OK);
            } else {
                return UserUtils.getResponseEntity(UserConstants.INVALID_USER, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return UserUtils.getResponseEntity(UserConstants.SOMETHING_WENT_WRONG_AT_DELETING_USER, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
