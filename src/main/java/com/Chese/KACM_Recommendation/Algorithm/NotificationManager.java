package com.Chese.KACM_Recommendation.Algorithm;

import java.util.*;

public class NotificationManager {

    private PriorityQueue<NotificationItem> notificationQueue;

    public NotificationManager() {
        notificationQueue = new PriorityQueue<>(Comparator.comparingInt(NotificationItem::getPriority).reversed());
    }

    // Add a new notification to the queue
    public void addNotification(String message, int priority) {
        notificationQueue.add(new NotificationItem(message, priority));
    }

    // Retrieve the next notification based on priority
    public NotificationItem getNextNotification() {
        return notificationQueue.poll();
    }

    // Check if the notification queue is empty
    public boolean isEmpty() {
        return notificationQueue.isEmpty();
    }

    // Display all notifications in the queue
    public void displayAllNotifications() {
        for (NotificationItem item : notificationQueue) {
            System.out.println("Notification: " + item.getMessage() + " | Priority: " + item.getPriority());
        }
    }
}

class NotificationItem {
    private String message;
    private int priority;

    public NotificationItem(String message, int priority) {
        this.message = message;
        this.priority = priority;
    }

    public String getMessage() {
        return message;
    }

    public int getPriority() {
        return priority;
    }
}
