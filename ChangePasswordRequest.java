package com.nexhale.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ChangePasswordRequest DTO
 * Path: src/main/java/com/nexhale/api/dto/ChangePasswordRequest.java
 *
 * Request body for POST /api/user/change-password
 */
public class ChangePasswordRequest {

    @JsonProperty("currentPassword")
    private String currentPassword;

    @JsonProperty("newPassword")
    private String newPassword;

    public String getCurrentPassword() { return currentPassword; }
    public void setCurrentPassword(String currentPassword) { this.currentPassword = currentPassword; }

    public String getNewPassword() { return newPassword; }
    public void setNewPassword(String newPassword) { this.newPassword = newPassword; }
}
