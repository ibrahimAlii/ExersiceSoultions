package IntroductionToJavaProgramming.chapter30_graphs_and_applications;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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

    protected AbstractGraph(List<Edge> edges, List<V> vertices) {
        this.vertices.addAll(vertices);

        createAdjacencyLists(edges, vertices.size());
    }

    protected AbstractGraph(List<Edge> edges, int numberOfVertices) {
        for (int i = 0; i < numberOfVertices; i++)
            vertices.add((V) (Integer.valueOf(i)));

        createAdjacencyLists(edges, numberOfVertices);
    }

    protected AbstractGraph(int[][] edges, int numberOfVertices) {
        for (int i = 0; i < numberOfVertices; i++)
            vertices.add((V) (Integer.valueOf(i)));

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

    /**
     * Obtain a DFS (Depth-First-Search) tree starting from vertex v
     */
    @Override
    public Tree dfs(int v) {
        List<Integer> searchOrder = new ArrayList<>();
        int[] parent = new int[vertices.size()];

        for (int i = 0; i < parent.length; i++)
            parent[i] = -1; // Initialize to -1

        // Mark visited vertices
        boolean[] isVisited = new boolean[vertices.size()];

        // Recursively search
        dfs(v, parent, searchOrder, isVisited);

        // Return a search tree
        return new Tree(v, parent, searchOrder);
    }

    /* Recursive method for DFS search */
    private void dfs(int v, int[] parent, List<Integer> searchOrder, boolean[] isVisited) {
        // Store the visited vertex
        searchOrder.add(v);
        isVisited[v] = true;

        for (int i :
                neighbors.get(v)) {
            if (isVisited[i]) {
                parent[i] = v; // The parent of vertex i is v
                dfs(i, parent, searchOrder, isVisited); // Recursive search
            }
        }
    }


    /* Starting BFS (Breadth-first-search) search from vertex v */
    @Override
    public Tree bfs(int v) {
        List<Integer> searchOrder = new ArrayList<>();
        int[] parent = new int[vertices.size()];
        for (int i = 0; i < parent.length; i++)
            parent[i] = -1; // Initialize parent[i] to -1

        LinkedList<Integer> queue = new LinkedList<>(); // list used as a queue
        boolean[] isVisited = new boolean[vertices.size()];
        queue.offer(v); // Enqueue v
        isVisited[v] = true; // Mark it visited

        while (!queue.isEmpty()) {
            int u = queue.poll(); // Dequeue to u
            searchOrder.add(u);
            for (int w : neighbors.get(u)) {
                if (!isVisited[w]) {
                    queue.offer(w); // Enqueue w
                    parent[w] = u; // The parent of w is u
                    isVisited[w] = true; // Mark it visited
                }
            }
        }

        return new Tree(v, parent, searchOrder);
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

        public int getNumberOfVerticesFound() {
            return searchOrder.size();
        }

        /* Return the path of vertices from a vertex to the root */
        public List<V> getPath(int index) {
            ArrayList<V> path = new ArrayList<>();

            do {
                path.add(vertices.get(index));
                index = parent[index];
            } while (index != -1);

            return path;
        }

        /* Print a path from the root to vertex v */
        public void printPath(int index) {
            List<V> path = getPath(index);
            System.out.print("A path from " + vertices.get(root) + " to "
                    + vertices.get(index) + ": ");
            for (int i = path.size() - 1; i >= 0; i--)
                System.out.print(path.get(i) + " ");
        }

        /* Print the whole tree */
        public void printTree() {
            System.out.println("Root is: " + vertices.get(root));
            System.out.print("Edges: ");
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] != -1) {
                    System.out.print("(" + vertices.get(parent[i]) + ", "
                            + vertices.get(i) + ") ");
                }
            }
            System.out.println();
        }
    }
}
