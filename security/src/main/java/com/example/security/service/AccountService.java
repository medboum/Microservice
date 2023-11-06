package com.example.security.service;

import com.example.security.entities.AppRole;
import com.example.security.entities.AppUser;

import java.util.List;

public interface AccountService  {
    AppUser  addNewUser(AppUser appUser);
    AppRole  addNewRole(AppRole appRole);
    void  addRoleToUser(String username,String role);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();


}
