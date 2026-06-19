package com.nexhale.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 * RegisterRequest DTO
 * Path: src/main/java/com/nexhale/api/dto/RegisterRequest.java
 *
 * Request body for POST /api/auth/register
 *
 * FIXES:
 *   - preferredBrand: Long → String  (User.preferredBrand is VARCHAR(100) in Phase 1)
 *   - preferredVapeLiquidAmount: Double → BigDecimal  (User field is DECIMAL(5,2))
 *
 * The React frontend sends preferredBrand as a brand name string, not an ID.
 * preferredVapeLiquidAmount is serialised from JSON number → BigDecimal safely.
 */
public class RegisterRequest {

    private String username;
    private String email;
    private String password;

    @JsonProperty("preferredBrand")
    private String preferredBrand;

    @JsonProperty("preferredVapeFlavor")
    private String preferredVapeFlavor;

    @JsonProperty("preferredVapeLiquidAmount")
    private BigDecimal preferredVapeLiquidAmount;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPreferredBrand() { return preferredBrand; }
    public void setPreferredBrand(String preferredBrand) { this.preferredBrand = preferredBrand; }

    public String getPreferredVapeFlavor() { return preferredVapeFlavor; }
    public void setPreferredVapeFlavor(String preferredVapeFlavor) { this.preferredVapeFlavor = preferredVapeFlavor; }

    public BigDecimal getPreferredVapeLiquidAmount() { return preferredVapeLiquidAmount; }
    public void setPreferredVapeLiquidAmount(BigDecimal preferredVapeLiquidAmount) { this.preferredVapeLiquidAmount = preferredVapeLiquidAmount; }
}
