package com.nexhale.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * UserProfileResponse DTO
 * Path: src/main/java/com/nexhale/api/dto/UserProfileResponse.java
 *
 * Response JSON for GET /api/user/profile.
 *
 * FIXES:
 *   - id: Long → Integer  (User.userId is Integer in Phase 1)
 *   - preferredBrand: Long → String  (User.preferredBrand is VARCHAR(100))
 *   - preferredVapeLiquidAmount: Double → BigDecimal  (User field is DECIMAL(5,2))
 *
 * Mirrors Node.js response:
 * {
 *   "id": 1,
 *   "username": "...",
 *   "email": "...",
 *   "preferredBrand": "Marlboro",
 *   "preferredVapeFlavor": null,
 *   "preferredVapeLiquidAmount": null,
 *   "registrationDate": "2024-01-01"
 * }
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
public class UserProfileResponse {

    private Integer id;
    private String username;
    private String email;

    @JsonProperty("preferredBrand")
    private String preferredBrand;

    @JsonProperty("preferredVapeFlavor")
    private String preferredVapeFlavor;

    @JsonProperty("preferredVapeLiquidAmount")
    private BigDecimal preferredVapeLiquidAmount;

    @JsonProperty("registrationDate")
    private LocalDate registrationDate;

    public UserProfileResponse(Integer id, String username, String email,
                               String preferredBrand, String preferredVapeFlavor,
                               BigDecimal preferredVapeLiquidAmount, LocalDate registrationDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.preferredBrand = preferredBrand;
        this.preferredVapeFlavor = preferredVapeFlavor;
        this.preferredVapeLiquidAmount = preferredVapeLiquidAmount;
        this.registrationDate = registrationDate;
    }

    public Integer getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPreferredBrand() { return preferredBrand; }
    public String getPreferredVapeFlavor() { return preferredVapeFlavor; }
    public BigDecimal getPreferredVapeLiquidAmount() { return preferredVapeLiquidAmount; }
    public LocalDate getRegistrationDate() { return registrationDate; }
}
