package com.nexhale.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * HealthImpactResponse DTO
 * Path: src/main/java/com/nexhale/api/dto/HealthImpactResponse.java
 *
 * Response for GET /api/stats/health
 * Mirrors Node.js getHealthImpact() response:
 * {
 *   "riskTier": "Low",
 *   "riskPercentage": 10,
 *   "nicotineIntake": "12.3",
 *   "tarIntake": "45.6",     (omitted in fallback path)
 *   "ceiIntake": "78.9",
 *   "details": [{ "type": "Behavioral", "description": "..." }]
 * }
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HealthImpactResponse {

    @JsonProperty("riskTier")
    private String riskTier;

    @JsonProperty("riskPercentage")
    private Integer riskPercentage;

    @JsonProperty("nicotineIntake")
    private String nicotineIntake;

    @JsonProperty("tarIntake")
    private String tarIntake;          // null in fallback path — excluded via @JsonInclude

    @JsonProperty("ceiIntake")
    private String ceiIntake;

    @JsonProperty("details")
    private List<ImpactDetail> details;

    public HealthImpactResponse(String riskTier, Integer riskPercentage,
                                String nicotineIntake, String tarIntake,
                                String ceiIntake, List<ImpactDetail> details) {
        this.riskTier = riskTier;
        this.riskPercentage = riskPercentage;
        this.nicotineIntake = nicotineIntake;
        this.tarIntake = tarIntake;
        this.ceiIntake = ceiIntake;
        this.details = details;
    }

    public String getRiskTier() { return riskTier; }
    public Integer getRiskPercentage() { return riskPercentage; }
    public String getNicotineIntake() { return nicotineIntake; }
    public String getTarIntake() { return tarIntake; }
    public String getCeiIntake() { return ceiIntake; }
    public List<ImpactDetail> getDetails() { return details; }

    public static class ImpactDetail {
        private String type;
        private String description;

        public ImpactDetail(String type, String description) {
            this.type = type;
            this.description = description;
        }

        public String getType() { return type; }
        public String getDescription() { return description; }
    }
}
