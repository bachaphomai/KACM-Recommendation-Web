package com.Chese.KACM_Recommendation.Algorithm;

import java.util.*;

public class UserPreferenceManager {
    private Map<Long, Map<String, Integer>> userPreferences;

    public UserPreferenceManager() {
        userPreferences = new HashMap<>();
    }

    // Initialize preference map for a new user
    public void initUser(Long userId) {
        userPreferences.putIfAbsent(userId, new HashMap<>());
    }

    // Update a specific preference score for a user
    public void updatePreference(Long userId, String preference, int score) {
        initUser(userId);
        Map<String, Integer> prefs = userPreferences.get(userId);
        prefs.put(preference, prefs.getOrDefault(preference, 0) + score);
    }

    // Retrieve all preferences for a user
    public Map<String, Integer> getUserPreferences(Long userId) {
        return userPreferences.getOrDefault(userId, new HashMap<>());
    }

    // Remove all preferences for a user (e.g., on reset)
    public void removeUserPreferences(Long userId) {
        userPreferences.remove(userId);
    }
}
