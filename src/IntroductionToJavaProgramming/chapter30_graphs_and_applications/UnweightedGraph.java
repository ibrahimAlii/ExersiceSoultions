package IntroductionToJavaProgramming.chapter30_graphs_and_applications;

import java.util.List;

public class UnweightedGraph<V> extends AbstractGraph<V> {

    /* Construct an empty graph */
    public UnweightedGraph(){
    }

    /* Construct a graph from edges and vertices stored in arrays */
    public UnweightedGraph(int[][] edges, V[] vertices){
        super(edges, vertices);
    }

    /* Construct a graph from edges and vertices stored in list */
    public UnweightedGraph(List<Edge> edges, List<V> vertices){
        super(edges, vertices);
    }

    /* Construct a graph for integer vertices 0, 1, 2 and edge list */
    public UnweightedGraph(List<Edge> edges, int numberOfVertices){
        super(edges, numberOfVertices);
    }

    /* Construct a graph from integer vertices 0, 1, and edge array */
    public UnweightedGraph(int[][] edges, int numberOfVertices){
        super(edges, numberOfVertices);
    }

}