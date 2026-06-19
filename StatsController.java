package com.nexhale.api.controller;

import com.nexhale.api.dto.*;
import com.nexhale.api.service.StatsService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * StatsController
 * Path: src/main/java/com/nexhale/api/controller/StatsController.java
 *
 * All routes require JWT authentication.
 * Routes exactly match Node.js stats.routes.js:
 *   GET /api/stats/summary    → getSummary(?month=&year=)
 *   GET /api/stats/daily      → getDailyStats
 *   GET /api/stats/weekly     → getWeeklyStats(?month=&year=)
 *   GET /api/stats/monthly    → getMonthlyStats
 *   GET /api/stats/moods      → getMoodStats
 *   GET /api/stats/health     → getHealthImpact
 *
 * FIX: userId() helper changed from Long.parseLong() → Integer.parseInt()
 *      Return type Long → Integer to match User.userId (Integer in Phase 1).
 */
@RestController
@RequestMapping("/api/stats")
public class StatsController {

    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    /**
     * GET /api/stats/summary?month=&year=
     * Response: { totalNicotine, totalTar, totalCost, totalCigarettes,
     *             totalVapeCEI, totalChemical, ytdCost, dailyZone,
     *             dailyCigarettes, dailyTar, totalPuffs, totalLiquid }
     */
    @GetMapping("/summary")
    public ResponseEntity<StatsSummaryResponse> getSummary(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer year) {
        return ResponseEntity.ok(statsService.getSummary(userId(userDetails), month, year));
    }

    /**
     * GET /api/stats/daily
     * Response: [{ name: "Sat", nicotine: 1.23, tar: 4.56 }, ...]  — 7 items
     */
    @GetMapping("/daily")
    public ResponseEntity<List<DayStatItem>> getDailyStats(
            @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(statsService.getDailyStats(userId(userDetails)));
    }

    /**
     * GET /api/stats/weekly?month=&year=
     * Response: [{ name: "Week 1", nicotine, tar, chemical }, ...]  — 4 items
     */
    @GetMapping("/weekly")
    public ResponseEntity<List<WeekStatItem>> getWeeklyStats(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer year) {
        return ResponseEntity.ok(statsService.getWeeklyStats(userId(userDetails), month, year));
    }

    /**
     * GET /api/stats/monthly
     * Response: [{ name: "Jan", nicotine, tar }, ...]  — 12 items
     */
    @GetMapping("/monthly")
    public ResponseEntity<List<DayStatItem>> getMonthlyStats(
            @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(statsService.getMonthlyStats(userId(userDetails)));
    }

    /**
     * GET /api/stats/moods
     * Response: [{ mood: "Happy", count: 5 }, ...]
     */
    @GetMapping("/moods")
    public ResponseEntity<List<MoodStatItem>> getMoodStats(
            @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(statsService.getMoodStats(userId(userDetails)));
    }

    /**
     * GET /api/stats/health
     * Response: { riskTier, riskPercentage, nicotineIntake, tarIntake?, ceiIntake, details: [...] }
     */
    @GetMapping("/health")
    public ResponseEntity<HealthImpactResponse> getHealthImpact(
            @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(statsService.getHealthImpact(userId(userDetails)));
    }

    /** Returns Integer — matches User.userId (Integer) in Phase 1. */
    private Integer userId(UserDetails ud) {
        return Integer.parseInt(ud.getUsername());
    }
}
