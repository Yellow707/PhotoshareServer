package com.yellow.photoshare.controller;

import com.yellow.photoshare.entity.UserEntity;
import com.yellow.photoshare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    private UserService userService;

    @Autowired
    @Qualifier(value="userService")
    public void setPersonService(UserService userService){
        this.userService = userService;
    }


    @PostMapping("/registration")
    public String registrationController (@RequestBody UserEntity userEntity) {
        String name = userEntity.getName();
            this.userService.addPerson(userEntity);
        return "Hello, " + name;
    }


}
