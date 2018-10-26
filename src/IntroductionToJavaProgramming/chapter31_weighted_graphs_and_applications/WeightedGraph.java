package IntroductionToJavaProgramming.chapter31_weighted_graphs_and_applications;

import IntroductionToJavaProgramming.chapter30_graphs_and_applications.AbstractGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class WeightedGraph<V> extends AbstractGraph<V> {
    // Priority adjacency lists
    private List<PriorityQueue<WeightedEdge>> queues = new ArrayList<>();

    public WeightedGraph() {
    }

    public WeightedGraph(int[][] edges, V[] vertices) {
        super(edges, vertices);
        createQueues(edges, vertices.length);
    }

    public WeightedGraph(int[][] edges, int numberOfVertices) {
        super(edges, numberOfVertices);
        createQueues(edges, numberOfVertices);
    }

    public WeightedGraph(List<WeightedEdge> edges, List<V> vertices) {
        super((List) edges, vertices);
        createQueues(edges, vertices.size());
    }

    private void createQueues(int[][] edges, int numberOfVertices) {
        for (int i = 0; i < numberOfVertices; i++)
            queues.add(new PriorityQueue<WeightedEdge>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            // Insert an edge into the queue
            queues.get(u).offer(new WeightedEdge(u, v, weight));
        }
    }

    private void createQueues(List<WeightedEdge> edges, int numberOfVertices) {
        for (int i = 0; i < numberOfVertices; i++)
            queues.add(new PriorityQueue<>());

        for (WeightedEdge edge : edges)
            queues.get(edge.u).offer(edge);
    }

}
