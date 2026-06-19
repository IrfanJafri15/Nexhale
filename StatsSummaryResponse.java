package com.nexhale.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * StatsSummaryResponse DTO
 * Path: src/main/java/com/nexhale/api/dto/StatsSummaryResponse.java
 *
 * Response for GET /api/stats/summary
 * Mirrors Node.js getSummary() combined response exactly:
 * {
 *   "totalNicotine": "12.34",
 *   "totalTar": "56.78",
 *   "totalCost": "9.99",
 *   "totalCigarettes": 10,
 *   "totalVapeCEI": "34.56",
 *   "totalChemical": "91.34",
 *   "ytdCost": "99.99",
 *   "dailyZone": "Green",
 *   "dailyCigarettes": 2,
 *   "dailyTar": "5.67",
 *   "totalPuffs": 150,
 *   "totalLiquid": 3.5
 * }
 */
public class StatsSummaryResponse {

    @JsonProperty("totalNicotine")
    private String totalNicotine;

    @JsonProperty("totalTar")
    private String totalTar;

    @JsonProperty("totalCost")
    private String totalCost;

    @JsonProperty("totalCigarettes")
    private int totalCigarettes;

    @JsonProperty("totalVapeCEI")
    private String totalVapeCEI;

    @JsonProperty("totalChemical")
    private String totalChemical;

    @JsonProperty("ytdCost")
    private String ytdCost;

    @JsonProperty("dailyZone")
    private String dailyZone;

    @JsonProperty("dailyCigarettes")
    private int dailyCigarettes;

    @JsonProperty("dailyTar")
    private String dailyTar;

    @JsonProperty("totalPuffs")
    private int totalPuffs;

    @JsonProperty("totalLiquid")
    private double totalLiquid;

    public StatsSummaryResponse(String totalNicotine, String totalTar, String totalCost,
                                int totalCigarettes, String totalVapeCEI, String totalChemical,
                                String ytdCost, String dailyZone, int dailyCigarettes,
                                String dailyTar, int totalPuffs, double totalLiquid) {
        this.totalNicotine = totalNicotine;
        this.totalTar = totalTar;
        this.totalCost = totalCost;
        this.totalCigarettes = totalCigarettes;
        this.totalVapeCEI = totalVapeCEI;
        this.totalChemical = totalChemical;
        this.ytdCost = ytdCost;
        this.dailyZone = dailyZone;
        this.dailyCigarettes = dailyCigarettes;
        this.dailyTar = dailyTar;
        this.totalPuffs = totalPuffs;
        this.totalLiquid = totalLiquid;
    }

    public String getTotalNicotine() { return totalNicotine; }
    public String getTotalTar() { return totalTar; }
    public String getTotalCost() { return totalCost; }
    public int getTotalCigarettes() { return totalCigarettes; }
    public String getTotalVapeCEI() { return totalVapeCEI; }
    public String getTotalChemical() { return totalChemical; }
    public String getYtdCost() { return ytdCost; }
    public String getDailyZone() { return dailyZone; }
    public int getDailyCigarettes() { return dailyCigarettes; }
    public String getDailyTar() { return dailyTar; }
    public int getTotalPuffs() { return totalPuffs; }
    public double getTotalLiquid() { return totalLiquid; }
}
