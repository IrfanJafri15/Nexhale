package com.nexhale.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 * AuthResponse DTO
 * Path: src/main/java/com/nexhale/api/dto/AuthResponse.java
 *
 * Response JSON for both POST /api/auth/register and POST /api/auth/login.
 *
 * FIXES:
 *   - id: Long → Integer  (User.userId is Integer in Phase 1)
 *   - preferredBrand: Long → String  (User.preferredBrand is VARCHAR(100))
 *   - preferredVapeLiquidAmount: Double → BigDecimal  (User field is DECIMAL(5,2))
 *
 * JSON output is identical to the Node.js response — Jackson serialises
 * Integer and BigDecimal to plain JSON numbers, so the React frontend
 * receives exactly the same payload as before.
 *
 * Must match Node.js response exactly:
 * {
 *   "id": 1,
 *   "username": "...",
 *   "email": "...",
 *   "preferredBrand": "Marlboro",   ← string, not a number
 *   "preferredVapeFlavor": null,
 *   "preferredVapeLiquidAmount": null,
 *   "token": "..."
 * }
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
public class AuthResponse {

    private Integer id;
    private String username;
    private String email;

    @JsonProperty("preferredBrand")
    private String preferredBrand;

    @JsonProperty("preferredVapeFlavor")
    private String preferredVapeFlavor;

    @JsonProperty("preferredVapeLiquidAmount")
    private BigDecimal preferredVapeLiquidAmount;

    private String token;

    public AuthResponse(Integer id, String username, String email,
                        String preferredBrand, String preferredVapeFlavor,
                        BigDecimal preferredVapeLiquidAmount, String token) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.preferredBrand = preferredBrand;
        this.preferredVapeFlavor = preferredVapeFlavor;
        this.preferredVapeLiquidAmount = preferredVapeLiquidAmount;
        this.token = token;
    }

    public Integer getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPreferredBrand() { return preferredBrand; }
    public String getPreferredVapeFlavor() { return preferredVapeFlavor; }
    public BigDecimal getPreferredVapeLiquidAmount() { return preferredVapeLiquidAmount; }
    public String getToken() { return token; }
}
