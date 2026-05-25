package com.example.authentication_service.service;

import com.example.authentication_service.entity.User;
import com.example.authentication_service.repository.UserRepository;
import com.example.authentication_service.security.JwtUtil;
import com.example.authentication_service.exception.UserAlreadyExistsException;
import com.example.authentication_service.exception.InvalidCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // REGISTER USER
    public boolean register(String username, String password, String role) {

        Optional<User> existingUser =
                userRepository.findByUsername(username);

        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("User already exists");
        }

        String finalRole = "USER";

        if (role != null && role.equalsIgnoreCase("ADMIN")) {
            finalRole = "ADMIN";
        }

        String encodedPassword =
                passwordEncoder.encode(password);

        User user =
                new User(username, encodedPassword, finalRole);

        userRepository.save(user);

        return true;
    }

    // LOGIN USER
    public String login(String username, String password) {

        Optional<User> userOptional =
                userRepository.findByUsername(username);

        if (userOptional.isPresent()) {

            User user = userOptional.get();

            if (passwordEncoder.matches(
                    password,
                    user.getPassword())) {

                return JwtUtil.generateToken(
                        username,
                        user.getRole()
                );
            }
        }

        throw new InvalidCredentialsException("Invalid username or password");
    }
}