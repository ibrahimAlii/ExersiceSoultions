package IntroductionToJavaProgramming.chapter30_graphs_and_applications;

import IntroductionToJavaProgramming.chapter27_binary_search_tree.AbstractTree;

import java.util.List;

public interface Graph<V> {

    /* Return the number of vertices in the graph */
    int getSize();

    /* Return the vertices in the graph */
    List<V> getVertices();

    /* Return the object for the specified vertex object */
    V getVertex(int index);

    /* Return the index for the specified vertex */
    int getIndex(V v);

    /* Return the neighbours of vertex with the specified index */
    List<Integer> getNeighbours(int index);

    /* Return the degree for the specified vertex */
    int getDegree(int v);

    /* Print the edges */
    void printEdges();

    /* clear this graph */
    void clear();

    /* Add a vertex to the graph */
    void addVertex(V vertex);

    /* Add an edge to the graph */
    void addEdge(int u, int v);

    /* Obtain a depth-first search tree starting from v */
    AbstractGraph.Tree dfs(int v);

    /* Obtain a breadth-first search tree starting from v */
    AbstractGraph.Tree bfs(int v);

}
