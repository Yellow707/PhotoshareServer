package com.yellow.photoshare.controller;

import com.yellow.photoshare.entity.UserEntity;
import com.yellow.photoshare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserEntity> listPersons() {
        List<UserEntity> userEntityList = this.userService.listPersons();
        return userEntityList;
    }

    @RequestMapping("/search")
    public UserEntity search (@RequestParam("username") String username) {
        UserEntity userEntity = this.userService.getPersonByUsername(username);
        return userEntity;
    }

    @RequestMapping("/delete")
    public void delete (@RequestParam("id") Long id) {
        this.userService.removePerson(id);
    }

    @RequestMapping("/update")
    public void update (@RequestParam("id") Long id) {
        this.userService.removePerson(id);
    }

    @RequestMapping(value = "/secure")
    public String secure() {
        return "You are authorize to access this page. This is secure page. ";
    }
    @RequestMapping(value = "/home")
    public String home() {
        return "This is public page. No need of authentication";
    }




}
