package com.example.spc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test1")
public class TController {
    @Autowired
    private UserService userService;

    @GetMapping("/tt")
    public void tt(){
        userService.createUser("popopo");
    }
}
