package com.example.authentication_service.controller;
import com.example.authentication_service.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import com.example.authentication_service.dto.AuthResponse;
import com.example.authentication_service.dto.LoginRequest;
import com.example.authentication_service.dto.RegisterRequest;
import com.example.authentication_service.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private AuthService authService;

    @GetMapping("/hello")
    public String hello() {
        return "Authentication Service Running!";
    }

    @PostMapping("/auth/register")
    public ResponseEntity<ApiResponse<String>> register(
            @RequestBody RegisterRequest request) {

        authService.register(
                request.getUsername(),
                request.getPassword(),
                request.getRole()
        );

        return ResponseEntity
                .status(201)
                .body(new ApiResponse<>(
                        true,
                        "User registered successfully",
                        null
                ));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(
            @RequestBody LoginRequest request) {

        String token = authService.login(
                request.getUsername(),
                request.getPassword()
        );

        AuthResponse authResponse =
                new AuthResponse(token, "Login Successful");

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Authentication successful",
                        authResponse
                )
        );
    }

    @GetMapping("/secure")
    public String secure() {
        return "Secure API accessed successfully!";
    }

    @GetMapping("/user/profile")
    public String userProfile() {
        return "User profile accessed successfully!";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "Admin dashboard accessed successfully!";
    }
}
