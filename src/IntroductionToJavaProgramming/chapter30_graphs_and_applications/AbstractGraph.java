package IntroductionToJavaProgramming.chapter30_graphs_and_applications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractGraph<V> implements Graph<V> {
    protected List<V> vertices = new ArrayList<>(); // Store vertices
    protected List<List<Integer>> neighbors = new ArrayList<>(); // Adjacency lists

    protected AbstractGraph() {
    }


    protected AbstractGraph(int[][] edges, V[] vertices) {
        this.vertices.addAll(Arrays.asList(vertices));

        createAdjacencyLists(edges, vertices.length);
    }

    protected AbstractGraph(List<Edge> edges, List<V> vertices){
        this.vertices.addAll(vertices);

        createAdjacencyLists(edges, vertices.size());
    }

    protected AbstractGraph(List<Edge> edges, int numberOfVertices){
        for (int i = 0; i < numberOfVertices; i++)
            vertices.add((V)(Integer.valueOf(i)));

        createAdjacencyLists(edges, numberOfVertices);
    }


    /* Create adjacency lists for each vertex */
    private void createAdjacencyLists(int[][] edges, int numberOfVertices) {
        // Create a linked list
        for (int i = 0; i < numberOfVertices; i++)
            neighbors.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            neighbors.get(u).add(v);
        }
    }

    /* Create adjacency lists for each vertex */
    private void createAdjacencyLists(List<Edge> edges, int numberOfVertices) {
        // Create a linked list
        for (int i = 0; i < numberOfVertices; i++)
            neighbors.add(new ArrayList<>());

        for (Edge edge : edges) {
            neighbors.get(edge.u).add(edge.v);
        }
    }

    @Override
    public int getSize() {
        return vertices.size();
    }

    @Override
    public List<V> getVertices() {
        return vertices;
    }

    @Override
    public V getVertex(int index) {
        return vertices.get(index);
    }

    @Override
    public int getIndex(V v) {
        return vertices.indexOf(v);
    }

    @Override
    public List<Integer> getNeighbours(int index) {
        return neighbors.get(index);
    }

    @Override
    public int getDegree(int v) {
        return neighbors.get(v).size();
    }

    @Override
    public void printEdges() {
        for (int u = 0; u < neighbors.size(); u++) {
            System.out.print(getVertex(u) + " (" + u + "): ");
            for (int j = 0; j < neighbors.get(u).size(); j++) {
                System.out.print("(" + u + ", " + neighbors.get(u).get(j) + ") ");
            }
            System.out.println();
        }
    }

    @Override
    public void clear() {
        vertices.clear();
        neighbors.clear();
    }

    @Override
    public void addVertex(V vertex) {
        vertices.add(vertex);
        neighbors.add(new ArrayList<>());
    }

    @Override
    public void addEdge(int u, int v) {
        neighbors.get(u).add(v);
        neighbors.get(v).add(u);
    }

    /* Edge inner class inside $AbstractGraph  class */
    public static class Edge {
        public int u; // Starting vertex of the edge
        public int v; // Ending vertex of the edge

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    @Override
    public Tree dfs(int v) {
        return null;
    }


    @Override
    public Tree bfs(int v) {
        return null;
    }

    /* Tree inner class inside $AbstractGraph  class */
    public class Tree {
        private int root; // The root of the tree
        private int[] parent; // Store the parent of each vertex
        private List<Integer> searchOrder; // Store the search order

        public Tree(int root, int[] parent, List<Integer> searchOrder) {
            this.root = root;
            this.parent = parent;
            this.searchOrder = searchOrder;
        }

        public int getRoot() {
            return root;
        }

        public int getParent(int v) {
            return parent[v];
        }

        public List<Integer> getSearchOrder() {
            return searchOrder;
        }
    }
}
