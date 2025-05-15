package com.Chese.KACM_Recommendation.Algorithm;

import java.util.*;

public class DijkstraAlgorithm {

    public Map<String, Integer> calculateShortestPath(Map<String, Map<String, Integer>> graph, String startNode) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(Map.Entry.comparingByValue());

        for (String node : graph.keySet()) {
            if (node.equals(startNode)) {
                distances.put(node, 0);
                priorityQueue.add(new AbstractMap.SimpleEntry<>(node, 0));
            } else {
                distances.put(node, Integer.MAX_VALUE);
            }
        }

        while (!priorityQueue.isEmpty()) {
            Map.Entry<String, Integer> current = priorityQueue.poll();
            String currentNode = current.getKey();
            int currentDistance = current.getValue();

            Map<String, Integer> neighbors = graph.get(currentNode);
            if (neighbors != null) {
                for (Map.Entry<String, Integer> neighbor : neighbors.entrySet()) {
                    String neighborNode = neighbor.getKey();
                    int newDist = currentDistance + neighbor.getValue();
                    if (newDist < distances.get(neighborNode)) {
                        distances.put(neighborNode, newDist);
                        priorityQueue.add(new AbstractMap.SimpleEntry<>(neighborNode, newDist));
                    }
                }
            }
        }

        return distances;
    }

    public void displayShortestPath(Map<String, Integer> distances) {
        for (Map.Entry<String, Integer> entry : distances.entrySet()) {
            System.out.println("Node: " + entry.getKey() + " - Distance: " + entry.getValue());
        }
    }
}
