package com.nexhale.api.dto;

/**
 * MessageResponse DTO
 * Path: src/main/java/com/nexhale/api/dto/MessageResponse.java
 *
 * Generic response for operations that return only a message, e.g.:
 *   { "message": "Profile updated" }
 *   { "message": "Password updated successfully" }
 *   { "message": "Email updated successfully" }
 * Matches the exact Node.js response format.
 */
public class MessageResponse {

    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
