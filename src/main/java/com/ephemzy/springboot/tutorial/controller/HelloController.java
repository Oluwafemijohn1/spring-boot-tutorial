package com.ephemzy.springboot.tutorial.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String helloWorld(){
//        return "Welcome to daily code buffer";
//    }

    @GetMapping( "/")
    public String helloWorld(){
        return "Welcome to daily code buffer ";
    }

}
