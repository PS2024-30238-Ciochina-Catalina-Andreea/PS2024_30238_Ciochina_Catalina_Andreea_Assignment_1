package com.example.flowerShop.utils.user;

import com.example.flowerShop.dto.user.UserPostDTO;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@NoArgsConstructor
public class UserUtils {

    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
        return new ResponseEntity<String>("{\"message\":\""+responseMessage+"\"}",httpStatus);
    }

    public boolean validateSignUpMap(UserPostDTO user) {
        return !Objects.equals(user.getName(), "")
                && !Objects.equals(user.getContactNumber(), "")
                && !Objects.equals(user.getAddress(), "")
                && !Objects.equals(user.getRole(), "")
                && !Objects.equals(user.getPassword(), "")
                && !Objects.equals(user.getEmail(), "");
    }
}
