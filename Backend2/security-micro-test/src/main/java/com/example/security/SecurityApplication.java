package com.example.security;

import com.example.security.auth.AdminAuthenticationService;
import com.example.security.user.Role;
import com.example.security.user.User;
import com.example.security.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecurityApplication {



	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Bean
	public CommandLineRunner customers(UserRepository userRepository) {
		AdminAuthenticationService authenticationService = new AdminAuthenticationService();
		return (args) -> {
			User user1 = new User();
			user1.setFirstname("MarcusH");
			user1.setUsername("Admin");
			user1.setPassword("admin");
			user1.setRole(Role.ADMIN);
			authenticationService.registerAdmin(user1, userRepository);
		};
	}
}
