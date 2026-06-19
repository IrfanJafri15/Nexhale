package com.nexhale.api.dto;

/**
 * WeekStatItem DTO
 * Path: src/main/java/com/nexhale/api/dto/WeekStatItem.java
 *
 * One item in the weekly stats array.
 * Mirrors Node.js getWeeklyStats() item:
 * { "name": "Week 1", "nicotine": 1.23, "tar": 4.56, "chemical": 9.01 }
 */
public class WeekStatItem {

    private String name;
    private double nicotine;
    private double tar;
    private double chemical;

    public WeekStatItem(String name, double nicotine, double tar, double chemical) {
        this.name = name;
        this.nicotine = nicotine;
        this.tar = tar;
        this.chemical = chemical;
    }

    public String getName() { return name; }
    public double getNicotine() { return nicotine; }
    public double getTar() { return tar; }
    public double getChemical() { return chemical; }
}
