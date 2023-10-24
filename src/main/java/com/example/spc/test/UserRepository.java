package com.example.spc.test;

import org.springframework.stereotype.Component;

@Component
class UserRepository {
    public void saveUser(String username) {
        System.out.println("Saving user: " + username);
    }
}


