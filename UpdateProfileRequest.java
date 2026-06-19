package com.nexhale.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 * UpdateProfileRequest DTO
 * Path: src/main/java/com/nexhale/api/dto/UpdateProfileRequest.java
 *
 * Request body for PATCH /api/user/profile
 *
 * FIXES:
 *   - preferredBrand: Long → String  (User.preferredBrand is VARCHAR(100) in Phase 1)
 *   - preferredVapeLiquidAmount: Double → BigDecimal  (User field is DECIMAL(5,2))
 */
public class UpdateProfileRequest {

    private String username;

    @JsonProperty("preferredBrand")
    private String preferredBrand;

    @JsonProperty("preferredVapeFlavor")
    private String preferredVapeFlavor;

    @JsonProperty("preferredVapeLiquidAmount")
    private BigDecimal preferredVapeLiquidAmount;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPreferredBrand() { return preferredBrand; }
    public void setPreferredBrand(String preferredBrand) { this.preferredBrand = preferredBrand; }

    public String getPreferredVapeFlavor() { return preferredVapeFlavor; }
    public void setPreferredVapeFlavor(String preferredVapeFlavor) { this.preferredVapeFlavor = preferredVapeFlavor; }

    public BigDecimal getPreferredVapeLiquidAmount() { return preferredVapeLiquidAmount; }
    public void setPreferredVapeLiquidAmount(BigDecimal preferredVapeLiquidAmount) { this.preferredVapeLiquidAmount = preferredVapeLiquidAmount; }
}
