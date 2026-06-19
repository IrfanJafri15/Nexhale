package com.nexhale.api.dto;

/**
 * MoodStatItem DTO
 * Path: src/main/java/com/nexhale/api/dto/MoodStatItem.java
 *
 * One item in the mood stats array.
 * Mirrors Node.js getMoodStats() item:
 * { "mood": "Happy", "count": 5 }
 */
public class MoodStatItem {

    private String mood;
    private long count;

    public MoodStatItem(String mood, long count) {
        this.mood = mood;
        this.count = count;
    }

    public String getMood() { return mood; }
    public long getCount() { return count; }
}
