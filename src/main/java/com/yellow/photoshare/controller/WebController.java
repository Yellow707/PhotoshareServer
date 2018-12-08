package com.yellow.photoshare.controller;

import com.yellow.photoshare.entity.UserEntity;
import com.yellow.photoshare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class WebController {

    @Autowired
    private UserService userService;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/registration")
    public String registration() {

        return "registration";
    }

    @GetMapping("/auth")
    public String authentification() {

        return "authentification";
    }

    @PostMapping("/registration/done")
    public @ResponseBody String registrationRequest(@Valid UserEntity userEntity) {
        String name = userEntity.getName();
        this.userService.addPerson(userEntity);
        System.out.println("Hello, " + name);
        return "registration";
    }

    @PostMapping("/auth/done")
    public @ResponseBody String authRequest(String email, String password) {
        System.out.println(email);
        System.out.println(password);
        if (this.userService.authUser(email, password)) {
            return "Auth done";
        } else {
            return "Try again";
        }
//        String name = userEntity.getName();
//        this.userService.addPerson(userEntity);
//        System.out.println("Hello, " + name);
//        return "registration";
    }

}
