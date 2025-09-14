package com.example.springtutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
     @GetMapping("/todo")
     public String first() {
         return "firstView";
     }
}