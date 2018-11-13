package com.yellow.photoshare.controller;

import com.yellow.photoshare.model.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {


    @PostMapping("/registration")
    public String registrationController (
            @RequestBody UserModel userModel) {
        String name = userModel.getName();
        return "Hello, " + name;
    }

}
