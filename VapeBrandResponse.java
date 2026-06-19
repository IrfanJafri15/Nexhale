package com.nexhale.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 * VapeBrandResponse DTO
 * Path: src/main/java/com/nexhale/api/dto/VapeBrandResponse.java
 *
 * Response item for GET /api/brands/vape
 *
 * FIXES:
 *   - id: Long → Integer  (VapeBrand.brandId is Integer in Phase 1)
 *   - nicotineMg: Double → BigDecimal  (VapeBrand.nicotinePerMl is DECIMAL(5,2))
 *
 * Mirrors Node.js:
 * {
 *   "id": 1,
 *   "brand": "JUUL",
 *   "nicotineMg": 59.00,
 *   "displayName": "JUUL"
 * }
 */
public class VapeBrandResponse {

    private Integer id;
    private String brand;

    @JsonProperty("nicotineMg")
    private BigDecimal nicotineMg;

    @JsonProperty("displayName")
    private String displayName;

    public VapeBrandResponse(Integer id, String brand, BigDecimal nicotineMg, String displayName) {
        this.id = id;
        this.brand = brand;
        this.nicotineMg = nicotineMg;
        this.displayName = displayName;
    }

    public Integer getId() { return id; }
    public String getBrand() { return brand; }
    public BigDecimal getNicotineMg() { return nicotineMg; }
    public String getDisplayName() { return displayName; }
}
