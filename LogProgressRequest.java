package com.nexhale.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * LogProgressRequest DTO
 * Path: src/main/java/com/nexhale/api/dto/LogProgressRequest.java
 *
 * Request body for POST /api/quit-plan/log  (smoking log entry)
 *
 * FIX: brandId Long → Integer  (CigaretteBrand.brandId is Integer in Phase 1)
 *
 * JSON field names are unchanged — React frontend sends the same payload.
 * {
 *   "brandId": 1,
 *   "cigaretteCount": 5,
 *   "mood": "calm",
 *   "cost": 2.50
 * }
 */
public class LogProgressRequest {

    @JsonProperty("brandId")
    private Integer brandId;

    @JsonProperty("cigaretteCount")
    private Integer cigaretteCount;

    private String mood;

    private Double cost;

    public Integer getBrandId() { return brandId; }
    public void setBrandId(Integer brandId) { this.brandId = brandId; }

    public Integer getCigaretteCount() { return cigaretteCount; }
    public void setCigaretteCount(Integer cigaretteCount) { this.cigaretteCount = cigaretteCount; }

    public String getMood() { return mood; }
    public void setMood(String mood) { this.mood = mood; }

    public Double getCost() { return cost; }
    public void setCost(Double cost) { this.cost = cost; }
}
