package com.nexhale.api.controller;

import com.nexhale.api.dto.AuthResponse;
import com.nexhale.api.dto.LoginRequest;
import com.nexhale.api.dto.RegisterRequest;
import com.nexhale.api.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * AuthController
 * Path: src/main/java/com/nexhale/api/controller/AuthController.java
 *
 * Handles authentication endpoints.
 * Routes exactly match Node.js:
 *   POST /api/auth/register
 *   POST /api/auth/login
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * POST /api/auth/register
     *
     * Request:  { username, email, password, preferredBrand?, preferredVapeFlavor?, preferredVapeLiquidAmount? }
     * Response 201: { id, username, email, preferredBrand, preferredVapeFlavor, preferredVapeLiquidAmount, token }
     * Response 400: { message: "User already exists" }
     */
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        AuthResponse response = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * POST /api/auth/login
     *
     * Request:  { email, password }
     * Response 200: { id, username, email, preferredBrand, preferredVapeFlavor, preferredVapeLiquidAmount, token }
     * Response 400: { message: "Invalid credentials" }
     */
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }
}
