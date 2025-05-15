package com.Chese.KACM_Recommendation.Algorithm;

import java.util.*;

public class SwipeFeedbackManager {
    private Map<Long, Integer> preferenceScores;

    public SwipeFeedbackManager() {
        preferenceScores = new HashMap<>();
    }

    // Call when user swipes right (like) with a given score value
    public void swipeRight(Long userId, int score) {
        preferenceScores.put(userId, preferenceScores.getOrDefault(userId, 0) + score);
    }

    // Call when user swipes left (dislike) with a given score penalty
    public void swipeLeft(Long userId, int penalty) {
        preferenceScores.put(userId, preferenceScores.getOrDefault(userId, 0) - penalty);
    }

    // Retrieve the accumulated score for a user
    public int getUserScore(Long userId) {
        return preferenceScores.getOrDefault(userId, 0);
    }

    // Reset a user's score (e.g., upon onboarding reset)
    public void resetUserScore(Long userId) {
        preferenceScores.remove(userId);
    }
}
