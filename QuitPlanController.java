package com.nexhale.api.controller;

import com.nexhale.api.dto.*;
import com.nexhale.api.service.QuitPlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * QuitPlanController
 * Path: src/main/java/com/nexhale/api/controller/QuitPlanController.java
 *
 * All routes require JWT authentication (matches Node.js protect middleware).
 * Routes exactly match Node.js quitPlan.routes.js:
 *   GET  /api/quit-plan/          → getQuitPlanProgress
 *   POST /api/quit-plan/          → updateQuitPlan
 *   POST /api/quit-plan/log       → logProgress
 *   POST /api/quit-plan/log-vape  → logVapeProgress
 *
 * FIX: userId() helper returns Integer (not Long).
 *      Integer.parseInt() replaces Long.parseLong().
 */
@RestController
@RequestMapping("/api/quit-plan")
public class QuitPlanController {

    private final QuitPlanService quitPlanService;

    public QuitPlanController(QuitPlanService quitPlanService) {
        this.quitPlanService = quitPlanService;
    }

    /**
     * GET /api/quit-plan/
     * Response: { plan: { nicotine_limit }, totalConsumed, weeklyProgress: [...] }
     */
    @GetMapping
    public ResponseEntity<QuitPlanProgressResponse> getQuitPlanProgress(
            @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(quitPlanService.getQuitPlanProgress(userId(userDetails)));
    }

    /**
     * POST /api/quit-plan/
     * Request:  { nicotineLimit: 500 }
     * Response 201: { message: "Quit plan updated", nicotineLimit: 500 }
     */
    @PostMapping
    public ResponseEntity<Map<String, Object>> updateQuitPlan(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody UpdateQuitPlanRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(quitPlanService.updateQuitPlan(userId(userDetails), request));
    }

    /**
     * POST /api/quit-plan/log
     * Request:  { cigaretteCount, brandId, cost?, mood? }
     * Response: { message: "Smoking progress logged successfully" }
     */
    @PostMapping("/log")
    public ResponseEntity<MessageResponse> logProgress(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody LogProgressRequest request) {
        return ResponseEntity.ok(quitPlanService.logProgress(userId(userDetails), request));
    }

    /**
     * POST /api/quit-plan/log-vape
     * Request:  { puffs, liquidAmount, flavor, pgPercentage?, nicotineAmount?, mood? }
     * Response: { message: "Vape session logged successfully" }
     */
    @PostMapping("/log-vape")
    public ResponseEntity<MessageResponse> logVapeProgress(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody LogVapeProgressRequest request) {
        return ResponseEntity.ok(quitPlanService.logVapeProgress(userId(userDetails), request));
    }

    /**
     * Extracts numeric user ID from the JWT principal.
     * Returns Integer — matches User.userId type in Phase 1.
     */
    private Integer userId(UserDetails ud) {
        return Integer.parseInt(ud.getUsername());
    }
}
