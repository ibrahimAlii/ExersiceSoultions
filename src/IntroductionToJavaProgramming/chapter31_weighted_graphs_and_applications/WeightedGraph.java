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

    /* Display edges from the wighted graph */
    public void printWeightedEdges() {
        for (int i = 0; i < queues.size(); i++) {
            System.out.print(getVertex(i) + " (" + i + "): ");
            for (WeightedEdge edge : queues.get(i)) {
                System.out.print("(" + edge.u + ", " + edge.v + ", " + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    /* Get the edges from the weighted graph */
    public List<PriorityQueue<WeightedEdge>> getWeightedEdges() {
        return queues;
    }

    @Override
    public void clear() {
        vertices.clear();
        neighbors.clear();
        queues.clear();
    }

    @Override
    public void addVertex(V vertex) {
        super.addVertex(vertex);
        queues.add(new PriorityQueue<>());
    }


    public void addEdge(int u, int v, int weight) {
        super.addEdge(u, v);
        queues.get(u).add(new WeightedEdge(u, v, weight));
        queues.get(v).add(new WeightedEdge(v, u, weight));
    }

    public MST getMinimumSpanningTree() {
        return getMinimumSpanningTree(0);
    }

    /* Get a minimum spanning tree rooted at specified vertex */
    private MST getMinimumSpanningTree(int startingVertex) {
        List<Integer> T = new ArrayList<>();
        // T initially contains the startingVertex
        T.add(startingVertex);

        int numberOfVertices = vertices.size(); // Number of vertices
        int[] parent = new int[numberOfVertices]; // Parent of vertex
        // Initially set the parent of all vertices to -1
        for (int i = 0; i < parent.length; i++)
            parent[i] = -1;
        double totalWeight = 0; // Total weight of the tree thus far

        // Clone the priority queue, so to keep the original queue intact
        List<PriorityQueue<WeightedEdge>> queues = deepClone(this.queues);


        // All vertices are found?
        while (T.size() < numberOfVertices) {
            // Search for the vertex with the smallest edge adjacent to
            // a vertex in T
            int v = -1;
            double smallestWeight = Double.MAX_VALUE;
            for (int u : T) {
                while (!queues.get(u).isEmpty() && T.contains(queues.get(u).peek().v)) {
                    // Remove the edge from queues[u] if the adjacent
                    // vertex of u is already in T
                    queues.get(u).remove();
                }

                if (queues.get(u).isEmpty()) {
                    continue; // Consider the next vertex in T
                }

                // Current smallest weight on an edge adjacent to u
                WeightedEdge edge = queues.get(u).peek();
                if (edge.weight < smallestWeight) {
                    v = edge.v;
                    smallestWeight = edge.weight;
                    // if v is added to the tree, u will be it's parent
                    parent[v] = u;
                }
            }

            if (v != -1)
                T.add(v);
            else break;

            totalWeight += smallestWeight;
        }

        return new MST(startingVertex, parent, T, totalWeight);
    }

    /* Clone an array of queues */
    private List<PriorityQueue<WeightedEdge>> deepClone(List<PriorityQueue<WeightedEdge>> queues) {
        List<PriorityQueue<WeightedEdge>> copiedQueues = new ArrayList<>();

        for (int i = 0; i < queues.size(); i++) {
            copiedQueues.add(new PriorityQueue<>());
            for (WeightedEdge edge : queues.get(i)) {
                copiedQueues.get(i).add(edge);
            }
        }
        return copiedQueues;
    }

    private class MST extends Tree {
        private double totalWeight;

        public MST(int root, int[] parent, List<Integer> searchOrder, double totalWeight) {
            super(root, parent, searchOrder);
            this.totalWeight = totalWeight;
        }

        public double getTotalWeight() {
            return totalWeight;
        }
    }

    /* Find single-source shortest paths */
    public ShortestPath getShortestPath(int sourceVertex) {
        // T store the vertices of paths found so far
        List<Integer> T = new ArrayList<>();
        // T initially contains the sourceVertex
        T.add(sourceVertex);

        // vertices is defined in AbstractGraph
        int numberOfVertices = vertices.size();

        // parent[v] stores the previous vertex of v in the path
        int[] parent = new int[numberOfVertices];
        parent[sourceVertex] = -1; // the parent of source is set to -1

        // cost[v] stores the cost of the path from v to the source
        double[] cost = new double[numberOfVertices];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = Double.MAX_VALUE;
        }
        cost[sourceVertex] = 0;

        // Get a copy of queues
        List<PriorityQueue<WeightedEdge>> queues = deepClone(this.queues);

        // Expand T
        while (T.size() < numberOfVertices) {
            int v = -1;
            double smallestCost = Double.MAX_VALUE;
            for (int u : T) {
                while (!queues.get(u).isEmpty() && T.contains(queues.get(u).peek().v)) {
                    queues.get(u).remove(); // Remove the vertex in queue for u
                }

                if (queues.get(u).isEmpty()) {
                    // All vertices adjacent to u are in T
                    continue;
                }

                WeightedEdge e = queues.get(u).peek();
                if (cost[u] + e.weight < smallestCost) {
                    v = e.v;
                    smallestCost = cost[u] + e.weight;
                    // If v is added to the tree. u will be it's parent
                    parent[v] = u;
                }
            } // End of for loop

            T.add(v);
            cost[v] = smallestCost;
        } // End of while loop

        return new ShortestPath(sourceVertex, parent, T, cost);
    }


    public class ShortestPath extends Tree {
        private double[] cost; // cost[v] is the cost from v to source

        public ShortestPath(int root, int[] parent, List<Integer> searchOrder, double[] cost) {
            super(root, parent, searchOrder);
            this.cost = cost;
        }

        /* Return the cost for a path from the root to vertex v */
        public double getCost(int v) {
            return cost[v];
        }

        /* Print paths from all vertices to the source */
        public void printAllPaths() {
            System.out.println("All shortest paths from " + vertices.get(getRoot()) + " are:");
            for (int i = 0; i < cost.length; i++) {
                printPath(i);
                System.out.println("(cost: " + cost[i] + ")");
            }
        }
    }
}
