package IntroductionToJavaProgramming.chapter30_graphs_and_applications.graph_visualization;

import IntroductionToJavaProgramming.chapter30_graphs_and_applications.Graph;
import IntroductionToJavaProgramming.chapter30_graphs_and_applications.UnweightedGraph;

import javax.swing.*;

public class DisplayEgyptMap extends JFrame {

    // TODO: 24/10/2018 put a real destinations
    private City[] vertices = {new City("Cairo", 200, 200),
            new City("Mansoura", 300, 150),
            new City("Monofuia", 150, 150),
            new City("Alexandria", 50, 50),
            new City("Dumiatt", 50, 150),
            new City("Sina", 70, 250)
    };

    // Edge array for graph
    private int[][] edges = {
            {0, 1}, {0, 3}, {0, 5}, {0, 4}, {0, 2},
            {1, 5}, {1, 4}, {1, 2}, {1, 3}, {1, 0},
            {2, 5}, {2, 4}, {2, 1}, {2, 3}, {2, 0},
            {3, 5}, {3, 4}, {3, 2}, {3, 1}, {3, 0},
            {4, 5}, {4, 1}, {4, 2}, {4, 3}, {4, 0},
            {1, 5}, {5, 4}, {5, 2}, {5, 3}, {5, 0},
    };

    public DisplayEgyptMap(){
        Graph<City> graph = new UnweightedGraph<>(edges, vertices);
        add(new GraphView(graph));
    }


    public static void main(String[] args){
        JFrame frame = new DisplayEgyptMap();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    static class City implements Displayable {

        int x, y;
        String name;

        City(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        @Override
        public int getX() {
            return x;
        }

        @Override
        public int getY() {
            return y;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
