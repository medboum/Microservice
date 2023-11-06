package com.example.security;

import com.example.security.entities.AppRole;
import com.example.security.entities.AppUser;
import com.example.security.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner start(AccountService accountService){
		return args -> {
			accountService.addNewRole(new AppRole(null,"USER"));
			accountService.addNewRole(new AppRole(null,"ADMIN"));
			accountService.addNewRole(new AppRole(null,"SUPER_ADMIN"));

			accountService.addNewUser(new AppUser(null,"user","1234",new ArrayList<>()));
			accountService.addNewUser(new AppUser(null,"admin","1234",new ArrayList<>()));

			accountService.addRoleToUser("user","USER");
			accountService.addRoleToUser("user","ADMIN");
			accountService.addRoleToUser("admin","ADMIN");
			accountService.addRoleToUser("admin","SUPER_ADMIN");



		};
	}
}
