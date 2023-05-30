package com.example.security.auth;

import com.example.security.config.JwtService;
import com.example.security.user.User;
import com.example.security.user.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class AdminAuthenticationService {

    public UserRepository repository;
    public PasswordEncoder passwordEncoder;
    public JwtService jwtService;
    private AuthenticationManager authenticationManager;

    public AuthenticationResponse registerAdmin(User user, UserRepository userRepository) {

        passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        jwtService = new JwtService();
        String token = jwtService.generateToken(user);

        userRepository.save(user);
        return AuthenticationResponse.builder().token(token).build();

    }
}