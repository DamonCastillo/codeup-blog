package com.codeup.springblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloController {

//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello From Spring!";
//    }

    @RequestMapping(path = "hello/{name}", method = RequestMethod.GET)

    public String helloToYou(@PathVariable String name , Model model){
        model.addAttribute("name",name);
        return "hello";
    }

    String fizzBuzzEvaluation(int num){
        if (num % 3 == 0 && num % 5==0){
            return " fizzbuzz";
        }else if (num % 3 == 0 ){
            return "fizz";
        }else if (num % 5 == 0 ){
            return "buzz";
        }else{
            return String.format("%d", num);
        }

    }

    @GetMapping("/number/{num}")
    @ResponseBody
    public String reportNumber(@PathVariable int num){
        String intro =  String.format("Here are some truths of the number %d.", num);
        String isEven = String.format("The number %d is even: %b." , num , num % 2== 0);
        String numSquared = String.format("The number %d squared is %d", num ,(int)(Math.pow(num,2)));
        String fizzBuzzEval = String.format("The number %d when running fizzbuzz would print %s",num,fizzBuzzEvaluation(num));
        return String.format("%s%n%s%n%s%n%s", intro,isEven,numSquared,fizzBuzzEval);
    }
}