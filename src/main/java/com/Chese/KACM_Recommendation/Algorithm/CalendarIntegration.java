package com.Chese.KACM_Recommendation.Algorithm;

import java.util.*;

public class CalendarIntegration {
    private TreeMap<String, String> eventMap;
    private List<String> mealSlots;

    public CalendarIntegration() {
        eventMap = new TreeMap<>();
        mealSlots = Arrays.asList("08:00", "12:00", "18:00");
    }

    // Add Event to Time Slot
    public void addEvent(String timeSlot, String event) {
        eventMap.put(timeSlot, event);
    }

    // Remove Event from Time Slot
    public void removeEvent(String timeSlot) {
        eventMap.remove(timeSlot);
    }

    // Get Event at a Time Slot
    public String getEvent(String timeSlot) {
        return eventMap.getOrDefault(timeSlot, "No event scheduled");
    }

    // Gap Detection - Check for Free Time Slots
    public List<String> getAvailableSlots() {
        List<String> availableSlots = new ArrayList<>();
        for (String slot : mealSlots) {
            if (!eventMap.containsKey(slot)) {
                availableSlots.add(slot);
            }
        }
        return availableSlots;
    }

    // Keyword Parsing - Suggest Meal Slot Based on Event Content
    public String suggestMealSlot(String eventContent) {
        if (eventContent.toLowerCase().contains("lunch")) {
            return "12:00";
        } else if (eventContent.toLowerCase().contains("dinner")) {
            return "18:00";
        } else if (eventContent.toLowerCase().contains("breakfast")) {
            return "08:00";
        }
        return "No suggestion available";
    }

    // Display All Events
    public void displayAllEvents() {
        for (Map.Entry<String, String> entry : eventMap.entrySet()) {
            System.out.println("Time Slot: " + entry.getKey() + " - Event: " + entry.getValue());
        }
    }
}
