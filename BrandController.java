package com.nexhale.api.controller;

import com.nexhale.api.dto.CigaretteBrandResponse;
import com.nexhale.api.dto.VapeBrandResponse;
import com.nexhale.api.service.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * BrandController
 * Path: src/main/java/com/nexhale/api/controller/BrandController.java
 *
 * Handles brand lookup endpoints.
 * Both routes are PUBLIC (no JWT required) — mirrors Node.js where neither
 * getBrands nor getVapeBrands uses the protect() middleware.
 * SecurityConfig permits GET /api/brands/** without authentication.
 *
 * Routes exactly match Node.js:
 *   GET /api/brands/        → getBrands()      → Cigarette_Brand table
 *   GET /api/brands/vape    → getVapeBrands()  → Vape_Brand table
 *
 * Response shapes are identical to the Node.js JSON so the React frontend
 * requires no modification.
 *
 * Cigarette brand response:
 * [
 *   {
 *     "id": 1,
 *     "brand": "Marlboro",
 *     "variant": "Red",
 *     "category": "Full Flavour",
 *     "nicotineMg": 1.20,
 *     "tarMg": 12.00,
 *     "displayName": "Marlboro - Red - Full Flavour"
 *   },
 *   ...
 * ]
 *
 * Vape brand response:
 * [
 *   {
 *     "id": 1,
 *     "brand": "JUUL",
 *     "nicotineMg": 59.00,
 *     "displayName": "JUUL"
 *   },
 *   ...
 * ]
 */
@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    /**
     * GET /api/brands/
     *
     * Returns all cigarette brands from the Cigarette_Brand table.
     * Public endpoint — no authentication required.
     * Mirrors Node.js: router.get("/", getBrands)
     */
    @GetMapping
    public ResponseEntity<List<CigaretteBrandResponse>> getBrands() {
        return ResponseEntity.ok(brandService.getCigaretteBrands());
    }

    /**
     * GET /api/brands/vape
     *
     * Returns all vape brands from the Vape_Brand table.
     * Public endpoint — no authentication required.
     * Mirrors Node.js: router.get("/vape", getVapeBrands)
     */
    @GetMapping("/vape")
    public ResponseEntity<List<VapeBrandResponse>> getVapeBrands() {
        return ResponseEntity.ok(brandService.getVapeBrands());
    }
}
