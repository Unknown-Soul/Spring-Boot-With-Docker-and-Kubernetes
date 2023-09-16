package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "hello World";
    }


    @RequestMapping(value= "/user",method = RequestMethod.GET)
    public User user(){
        User user = new User();
        user.setName("Ashutosh");
        user.setEmail("ashutoshGupta1231");
        user.setId("1");
        return user;
    }

    // path variables
    @RequestMapping(value= "/user/{id}/{name}",method = RequestMethod.GET)
    public String getUser(@PathVariable String id, @PathVariable String name){
        return id+"  "+name;
    }


    // request parameter
    //http://localhost:8080/userRequestParam?id=1&name=Ashutosh
    @RequestMapping(value= "/userRequestParam",method = RequestMethod.GET)
    public String getUserRequestParam(@RequestParam(name="id", required = false, defaultValue = "") String id, @RequestParam String name){
        return id+"  "+name;
    }


}
