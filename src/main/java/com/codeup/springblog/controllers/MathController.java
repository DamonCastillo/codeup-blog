package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{num}/and{num2}")
    @ResponseBody

    public String addMath( @PathVariable int num, int num2){
        String addNums = String.format("The outcome of %d and %d is %d", num,num2,num + num2);
        return String.format("%s",addNums);
    }
    @GetMapping("/subtract/{num}/from/{num2}")
    @ResponseBody
    public String subMath( @PathVariable int num, int num2){
        String subNums = String.format("The outcome of %d and %d is %d", num,num2,num - num2);
        return String.format("%s",subNums);
    }
    @GetMapping("/multiply/{num}/and/{num2}")
    @ResponseBody
    public String multiMath( @PathVariable int num, int num2){
        String multiNums = String.format("The outcome of %d and %d is %d", num,num2,num * num2);
        return String.format("%s",multiNums);
    }
    @GetMapping("/divide/{num}/from/{num2}")
    @ResponseBody
    public String divMath( @PathVariable int num, int num2){
        String divNums = String.format("The outcome of %d and %d is %d", num,num2,num % num2);
        return String.format("%s",divNums);
    }


}
