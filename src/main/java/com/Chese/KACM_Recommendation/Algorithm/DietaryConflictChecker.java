package com.Chese.KACM_Recommendation.Algorithm;

import java.util.*;

public class DietaryConflictChecker {

    // Check for dietary conflicts between user restrictions and dish ingredients
    public boolean hasConflict(Set<String> userRestrictions, Set<String> dishIngredients) {
        for (String ingredient : dishIngredients) {
            if (userRestrictions.contains(ingredient)) {
                return true; // Conflict found
            }
        }
        return false; // No conflict
    }

    // Display conflicting ingredients
    public Set<String> getConflictingIngredients(Set<String> userRestrictions, Set<String> dishIngredients) {
        Set<String> conflicts = new HashSet<>();
        for (String ingredient : dishIngredients) {
            if (userRestrictions.contains(ingredient)) {
                conflicts.add(ingredient);
            }
        }
        return conflicts;
    }

    // Check if dish is safe for user based on restrictions
    public boolean isDishSafe(Set<String> userRestrictions, Set<String> dishIngredients) {
        return !hasConflict(userRestrictions, dishIngredients);
    }
}
