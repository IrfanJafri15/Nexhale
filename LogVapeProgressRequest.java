package com.nexhale.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 * LogVapeProgressRequest DTO
 * Path: src/main/java/com/nexhale/api/dto/LogVapeProgressRequest.java
 *
 * Request body for POST /api/quit-plan/log-vape  (vape log entry)
 *
 * FIXES:
 *   - liquidAmount Double → BigDecimal  (VapeLog.liquidAmount is DECIMAL in Phase 1)
 *   - nicotineAmount Double → BigDecimal  (VapeLog.nicotineAmount is DECIMAL in Phase 1)
 *   - brandId kept as Integer  (VapeBrand.brandId is Integer)
 *
 * cost field kept as Double — VapeLog has no cost column; this maps to
 * a nullable cost field. If Phase 1 VapeLog has no cost, QuitPlanService
 * simply won't set it. The DTO keeps it so the JSON contract is unchanged.
 *
 * JSON shape is identical to Node.js — React frontend sends the same payload:
 * {
 *   "brandId": 1,
 *   "puffs": 20,
 *   "liquidAmount": 1.5,
 *   "flavor": "mint",
 *   "pgPercentage": 50,
 *   "mood": "calm",
 *   "nicotineAmount": 2.5
 * }
 */
public class LogVapeProgressRequest {

    @JsonProperty("brandId")
    private Integer brandId;

    private Integer puffs;

    @JsonProperty("liquidAmount")
    private BigDecimal liquidAmount;

    private String flavor;

    @JsonProperty("pgPercentage")
    private Integer pgPercentage;

    private String mood;

    @JsonProperty("nicotineAmount")
    private BigDecimal nicotineAmount;

    public Integer getBrandId() { return brandId; }
    public void setBrandId(Integer brandId) { this.brandId = brandId; }

    public Integer getPuffs() { return puffs; }
    public void setPuffs(Integer puffs) { this.puffs = puffs; }

    public BigDecimal getLiquidAmount() { return liquidAmount; }
    public void setLiquidAmount(BigDecimal liquidAmount) { this.liquidAmount = liquidAmount; }

    public String getFlavor() { return flavor; }
    public void setFlavor(String flavor) { this.flavor = flavor; }

    public Integer getPgPercentage() { return pgPercentage; }
    public void setPgPercentage(Integer pgPercentage) { this.pgPercentage = pgPercentage; }

    public String getMood() { return mood; }
    public void setMood(String mood) { this.mood = mood; }

    public BigDecimal getNicotineAmount() { return nicotineAmount; }
    public void setNicotineAmount(BigDecimal nicotineAmount) { this.nicotineAmount = nicotineAmount; }
}
