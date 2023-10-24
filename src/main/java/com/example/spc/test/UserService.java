package com.example.spc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test2")
@Component
class UserService {
    private UserRepository userRepository;

    // 构造函数注入 UserRepository 依赖
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/tt")
    public void createUser(@RequestParam(name="username") String username) {
        userRepository.saveUser(username);
        System.out.println("User created: " + username);
    }
}
