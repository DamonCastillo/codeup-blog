package com.codeup.springblog.controllers;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@Controller
public class HomeController {

    @GetMapping("/")
    public String hello() {
        return "home";
    }

}

