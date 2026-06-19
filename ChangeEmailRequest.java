package com.nexhale.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ChangeEmailRequest DTO
 * Path: src/main/java/com/nexhale/api/dto/ChangeEmailRequest.java
 *
 * Request body for POST /api/user/change-email
 */
public class ChangeEmailRequest {

    @JsonProperty("newEmail")
    private String newEmail;

    private String password;

    public String getNewEmail() { return newEmail; }
    public void setNewEmail(String newEmail) { this.newEmail = newEmail; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
