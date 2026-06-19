package com.nexhale.api.dto;

/**
 * DayStatItem DTO
 * Path: src/main/java/com/nexhale/api/dto/DayStatItem.java
 *
 * One item in the daily/monthly stats arrays.
 * Mirrors Node.js getDailyStats() and getMonthlyStats() item:
 * { "name": "Mon", "nicotine": 1.23, "tar": 4.56 }
 */
public class DayStatItem {

    private String name;
    private double nicotine;
    private double tar;

    public DayStatItem(String name, double nicotine, double tar) {
        this.name = name;
        this.nicotine = nicotine;
        this.tar = tar;
    }

    public String getName() { return name; }
    public double getNicotine() { return nicotine; }
    public double getTar() { return tar; }
}
