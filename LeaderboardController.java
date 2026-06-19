package com.nexhale.api.controller;

import com.nexhale.api.dto.LeaderboardEntryResponse;
import com.nexhale.api.service.LeaderboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * LeaderboardController
 * Path: src/main/java/com/nexhale/api/controller/LeaderboardController.java
 *
 * PUBLIC endpoint — no JWT required (matches Node.js leaderboard.routes.js
 * which has no 'protect' middleware).
 * Must be added to SecurityConfig permitAll() list.
 *
 * Route: GET /api/leaderboard/?type=tar|nicotine&period=daily|monthly
 *
 * Response: [{ id, name, value, hasSubmittedToday, logCount, rank, medal? }, ...]
 */
@RestController
@RequestMapping("/api/leaderboard")
public class LeaderboardController {

    private final LeaderboardService leaderboardService;

    public LeaderboardController(LeaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

    /**
     * GET /api/leaderboard/?type=tar&period=daily
     *
     * Query params (both optional, match Node.js defaults):
     *   type   = "tar" (default) | "nicotine"
     *   period = "daily" (default) | "monthly"
     */
    @GetMapping
    public ResponseEntity<List<LeaderboardEntryResponse>> getLeaderboard(
            @RequestParam(defaultValue = "tar")   String type,
            @RequestParam(defaultValue = "daily") String period) {
        return ResponseEntity.ok(leaderboardService.getLeaderboard(type, period));
    }
}
