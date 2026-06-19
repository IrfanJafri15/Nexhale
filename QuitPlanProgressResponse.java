package com.nexhale.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * QuitPlanProgressResponse DTO
 * Path: src/main/java/com/nexhale/api/dto/QuitPlanProgressResponse.java
 *
 * Response for GET /api/quit-plan/
 * Mirrors Node.js getQuitPlanProgress() response exactly:
 * {
 *   "plan": { "nicotine_limit": 500 },
 *   "totalConsumed": 123.45,
 *   "weeklyProgress": [
 *     { "week_num": 22, "week_total": 45.2 }, ...
 *   ]
 * }
 */
public class QuitPlanProgressResponse {

    private PlanInfo plan;

    @JsonProperty("totalConsumed")
    private double totalConsumed;

    @JsonProperty("weeklyProgress")
    private List<WeeklyProgress> weeklyProgress;

    public QuitPlanProgressResponse(PlanInfo plan, double totalConsumed,
                                    List<WeeklyProgress> weeklyProgress) {
        this.plan = plan;
        this.totalConsumed = totalConsumed;
        this.weeklyProgress = weeklyProgress;
    }

    public PlanInfo getPlan() { return plan; }
    public double getTotalConsumed() { return totalConsumed; }
    public List<WeeklyProgress> getWeeklyProgress() { return weeklyProgress; }

    public static class PlanInfo {
        @JsonProperty("nicotine_limit")
        private double nicotineLimit;

        public PlanInfo(double nicotineLimit) {
            this.nicotineLimit = nicotineLimit;
        }

        public double getNicotineLimit() { return nicotineLimit; }
    }

    public static class WeeklyProgress {
        @JsonProperty("week_num")
        private int weekNum;

        @JsonProperty("week_total")
        private double weekTotal;

        public WeeklyProgress(int weekNum, double weekTotal) {
            this.weekNum = weekNum;
            this.weekTotal = weekTotal;
        }

        public int getWeekNum() { return weekNum; }
        public double getWeekTotal() { return weekTotal; }
    }
}
