package com.example.jwt;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.jwt.domain.Role;
import com.example.jwt.domain.User;
import com.example.jwt.service.UserService;

@SpringBootApplication
public class SpringBootJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
		userService.saveRole(new Role(null, "ROLE_ADMIN"));
		userService.saveRole(new Role(null, "ROLE_SUPPER_ADMIN"));

			userService.saveUser(new User(null, "rama", "rama", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "bhavi", "bhavi", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "aadhya", "aadhya", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "dhane", "dhane", "1234", new ArrayList<>()));

			userService.addRoleToUser("rama", "ROLE_USER");
			userService.addRoleToUser("rama", "ROLE_MANAGER");
			userService.addRoleToUser("bhavi", "ROLE_MANAGER");
			userService.addRoleToUser("aadhya", "ROLE_ADMIN");
			userService.addRoleToUser("dhane", "ROLE_USER");
			userService.addRoleToUser("dhane", "ROLE_MANAGER");
			userService.addRoleToUser("dhane", "ROLE_SUPPER_ADMIN");
		};
	}

}
