package com.nexhale.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 * CigaretteBrandResponse DTO
 * Path: src/main/java/com/nexhale/api/dto/CigaretteBrandResponse.java
 *
 * Response item for GET /api/brands/
 *
 * FIXES:
 *   - id: Long → Integer  (CigaretteBrand.brandId is Integer in Phase 1)
 *   - nicotineMg: Double → BigDecimal  (CigaretteBrand.nicotinePerCigarette is DECIMAL(5,2))
 *   - tarMg: Double → BigDecimal  (CigaretteBrand.tarPerCigarette is DECIMAL(6,2))
 *
 * JSON output is identical to the Node.js response — Jackson serialises
 * BigDecimal to a plain JSON number (e.g. 1.20), matching what the
 * React frontend already consumes.
 *
 * Mirrors Node.js:
 * {
 *   "id": 1,
 *   "brand": "Marlboro",
 *   "variant": "Red",
 *   "category": "Full Flavour",
 *   "nicotineMg": 1.20,
 *   "tarMg": 12.00,
 *   "displayName": "Marlboro - Red - Full Flavour"
 * }
 */
public class CigaretteBrandResponse {

    private Integer id;
    private String brand;
    private String variant;
    private String category;

    @JsonProperty("nicotineMg")
    private BigDecimal nicotineMg;

    @JsonProperty("tarMg")
    private BigDecimal tarMg;

    @JsonProperty("displayName")
    private String displayName;

    public CigaretteBrandResponse(Integer id, String brand, String variant, String category,
                                  BigDecimal nicotineMg, BigDecimal tarMg, String displayName) {
        this.id = id;
        this.brand = brand;
        this.variant = variant;
        this.category = category;
        this.nicotineMg = nicotineMg;
        this.tarMg = tarMg;
        this.displayName = displayName;
    }

    public Integer getId() { return id; }
    public String getBrand() { return brand; }
    public String getVariant() { return variant; }
    public String getCategory() { return category; }
    public BigDecimal getNicotineMg() { return nicotineMg; }
    public BigDecimal getTarMg() { return tarMg; }
    public String getDisplayName() { return displayName; }
}
