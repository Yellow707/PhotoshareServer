package com.yellow.photoshare.controller;

import com.yellow.photoshare.model.UserModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @RequestMapping("/registration")
    public UserModel registration(@RequestParam String name, String surname, String username, Integer age, String email ) {
        return new UserModel(name, surname, username, age, email);
    }
}
