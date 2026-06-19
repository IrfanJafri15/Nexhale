package com.nexhale.api.controller;

import com.nexhale.api.dto.*;
import com.nexhale.api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * UserController
 * Path: src/main/java/com/nexhale/api/controller/UserController.java
 *
 * Handles user profile endpoints. All routes require JWT authentication.
 * Routes exactly match Node.js:
 *   GET    /api/user/profile
 *   PATCH  /api/user/profile
 *   POST   /api/user/change-password
 *   POST   /api/user/change-email
 *
 * FIX: extractUserId() now returns Integer (not Long) to match
 *      User.userId type in Phase 1 and UserService method signatures.
 *      Integer.parseInt() is used instead of Long.parseLong().
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * GET /api/user/profile
     * Protected — requires Bearer token
     *
     * Response: { id, username, email, preferredBrand, preferredVapeFlavor,
     *             preferredVapeLiquidAmount, registrationDate }
     */
    @GetMapping("/profile")
    public ResponseEntity<UserProfileResponse> getProfile(
            @AuthenticationPrincipal UserDetails userDetails) {
        Integer userId = extractUserId(userDetails);
        return ResponseEntity.ok(userService.getProfile(userId));
    }

    /**
     * PATCH /api/user/profile
     * Protected — requires Bearer token
     *
     * Request:  { username, preferredBrand, preferredVapeFlavor, preferredVapeLiquidAmount }
     * Response: { message: "Profile updated" }
     */
    @PatchMapping("/profile")
    public ResponseEntity<MessageResponse> updateProfile(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody UpdateProfileRequest request) {
        Integer userId = extractUserId(userDetails);
        return ResponseEntity.ok(userService.updateProfile(userId, request));
    }

    /**
     * POST /api/user/change-password
     * Protected — requires Bearer token
     *
     * Request:  { currentPassword, newPassword }
     * Response 200: { message: "Password updated successfully" }
     * Response 400: { message: "Incorrect current password" }
     */
    @PostMapping("/change-password")
    public ResponseEntity<MessageResponse> changePassword(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody ChangePasswordRequest request) {
        Integer userId = extractUserId(userDetails);
        return ResponseEntity.ok(userService.changePassword(userId, request));
    }

    /**
     * POST /api/user/change-email
     * Protected — requires Bearer token
     *
     * Request:  { newEmail, password }
     * Response 200: { message: "Email updated successfully" }
     * Response 400: { message: "Incorrect password" } or { message: "Email already in use" }
     */
    @PostMapping("/change-email")
    public ResponseEntity<MessageResponse> changeEmail(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody ChangeEmailRequest request) {
        Integer userId = extractUserId(userDetails);
        return ResponseEntity.ok(userService.changeEmail(userId, request));
    }

    /**
     * Extracts the numeric user ID from the Spring Security principal.
     * The principal username is the user_id stored as String by CustomUserDetailsService.
     * Returns Integer — matching User.userId type in Phase 1.
     */
    private Integer extractUserId(UserDetails userDetails) {
        return Integer.parseInt(userDetails.getUsername());
    }
}
