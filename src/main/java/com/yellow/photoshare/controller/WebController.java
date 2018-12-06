package com.yellow.photoshare.controller;

import com.yellow.photoshare.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class WebController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/registration")
    public String registration() {

        return "registration";
    }

    @PostMapping("/registration/done")
    public @ResponseBody String registrationRequest(@Valid UserEntity userEntity) {
        String name = userEntity.getName();
//        this.userService.addPerson(userEntity);
        System.out.println("Hello, " + name);
        return "registration";
    }

}
