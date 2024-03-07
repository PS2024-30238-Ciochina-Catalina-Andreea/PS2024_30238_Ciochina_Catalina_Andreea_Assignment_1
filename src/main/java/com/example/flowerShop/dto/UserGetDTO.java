package com.example.flowerShop.dto;

import com.example.flowerShop.utils.user.UserRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserGetDTO {

    private Long id;
    private String name;
    private String contactNumber;
    private String email;
    private String address;
    private UserRole role;
}

