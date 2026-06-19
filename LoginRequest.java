package com.nexhale.api.dto;

/**
 * LoginRequest DTO
 * Path: src/main/java/com/nexhale/api/dto/LoginRequest.java
 *
 * Request body for POST /api/auth/login
 */
public class LoginRequest {

    private String email;
    private String password;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
