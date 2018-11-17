package com.yellow.photoshare.controller;

import com.yellow.photoshare.entity.UserEntity;
import com.yellow.photoshare.model.UserModel;
import com.yellow.photoshare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    private UserService userService;

    @Autowired(required=true)
    @Qualifier(value="userService")
    public void setPersonService(UserService userService){
        this.userService = userService;
    }


    @PostMapping("/registration")
    public String registrationController (
            @RequestBody UserEntity userEntity) {
        String name = userEntity.getName();

//        if(userEntity.getId() == 0){
            //new person, add it
            this.userService.addPerson(userEntity);
//        }else{
//            //existing person, call update
//            this.userService.updatePerson(userEntity);
//        }
        return "Hello, " + name;
    }

    @PostMapping("/registration1")
    public String addPerson(@RequestBody UserEntity userEntity){

        if(userEntity.getId() == 0){
            //new person, add it
            this.userService.addPerson(userEntity);
        }else{
            //existing person, call update
            this.userService.updatePerson(userEntity);
        }

        return "OK!";

    }

}
