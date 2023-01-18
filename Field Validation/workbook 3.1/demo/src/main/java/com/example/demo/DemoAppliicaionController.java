package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;


public class DemoAppliicaionController {
    
    @GetMapping("/sign-up")
    public String getForm(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }
    
    @PostMapping("/submitItem")
    public String handleSubmit(@Valid User user, BindingResult result) {
        if(result.hasErrors()) return "sign-up";
        return "redirect:/result";
    }


    @GetMapping("/result")
    public String getResult(){
        return "result";
    }

}