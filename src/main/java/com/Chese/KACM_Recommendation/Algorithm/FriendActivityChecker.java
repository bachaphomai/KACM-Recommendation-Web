package com.Chese.KACM_Recommendation.Algorithm;

import java.util.*;

public class FriendActivityChecker {

    private Set<Long> friendIds;
    private Map<Long, String> activityLog;

    public FriendActivityChecker() {
        friendIds = new HashSet<>();
        activityLog = new HashMap<>();
    }

    // Add a friend to the monitoring list
    public void addFriend(Long userId) {
        friendIds.add(userId);
    }

    // Log a friend's activity
    public void logActivity(Long userId, String activity) {
        if (friendIds.contains(userId)) {
            activityLog.put(userId, activity);
        }
    }

    // Get the most recent activity of a friend
    public String getFriendActivity(Long userId) {
        return activityLog.getOrDefault(userId, "No recent activity");
    }

    // Get all friend activities
    public Map<Long, String> getAllActivities() {
        return new HashMap<>(activityLog);
    }

    // Remove a friend from monitoring list
    public void removeFriend(Long userId) {
        friendIds.remove(userId);
        activityLog.remove(userId);
    }
}
