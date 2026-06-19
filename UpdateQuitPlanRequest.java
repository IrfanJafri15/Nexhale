package com.nexhale.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 * UpdateQuitPlanRequest DTO
 * Path: src/main/java/com/nexhale/api/dto/UpdateQuitPlanRequest.java
 *
 * Request body for POST /api/quit-plan/  (create or update quit plan)
 *
 * FIX: nicotineLimit Double → BigDecimal  (QuitPlan.targetNicotineAmount is DECIMAL)
 *
 * JSON field name is unchanged — React frontend sends the same payload:
 * {
 *   "nicotineLimit": 5.0,
 *   "type": "cigarette"
 * }
 */
public class UpdateQuitPlanRequest {

    @JsonProperty("nicotineLimit")
    private BigDecimal nicotineLimit;

    private String type;

    public BigDecimal getNicotineLimit() { return nicotineLimit; }
    public void setNicotineLimit(BigDecimal nicotineLimit) { this.nicotineLimit = nicotineLimit; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
