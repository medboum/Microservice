package com.example.security.web;

import com.example.security.entities.AppUser;
import com.example.security.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestContoller {
    private AccountService accountService;

    public RestContoller(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping("/users")
    public List<AppUser> getAllUser(){
        return  accountService.listUsers();
    }
}
