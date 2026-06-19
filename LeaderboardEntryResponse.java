package com.nexhale.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * LeaderboardEntryResponse DTO
 * Path: src/main/java/com/nexhale/api/dto/LeaderboardEntryResponse.java
 *
 * One entry in the leaderboard array.
 * Mirrors Node.js getLeaderboard() ranked item:
 * {
 *   "id": 1,
 *   "name": "user-1",
 *   "value": 12.34,
 *   "hasSubmittedToday": true,
 *   "logCount": 5,
 *   "rank": 1,
 *   "medal": "gold"    ← null for rank > 3, excluded from JSON
 * }
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LeaderboardEntryResponse {

    private Long id;
    private String name;
    private double value;
    private boolean hasSubmittedToday;
    private long logCount;
    private int rank;
    private String medal;  // "gold", "silver", "bronze", or null

    public LeaderboardEntryResponse(Long id, String name, double value,
                                    boolean hasSubmittedToday, long logCount,
                                    int rank, String medal) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.hasSubmittedToday = hasSubmittedToday;
        this.logCount = logCount;
        this.rank = rank;
        this.medal = medal;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getValue() { return value; }
    public boolean isHasSubmittedToday() { return hasSubmittedToday; }
    public long getLogCount() { return logCount; }
    public int getRank() { return rank; }
    public String getMedal() { return medal; }
}
