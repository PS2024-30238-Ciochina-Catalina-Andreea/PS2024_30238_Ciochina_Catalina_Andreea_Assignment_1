package com.example.flowerShop.dto;

import com.example.flowerShop.utils.user.UserRole;
import lombok.Data;

@Data
public class UserPostDTO {

    private Long id;
    private String name;
    private String contactNumber;
    private String email;
    private String password;
    private String address;
    private UserRole role;
}
