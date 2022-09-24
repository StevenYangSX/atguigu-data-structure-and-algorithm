package com.steven.learning.graph;

public class GraphDemo {
    public static void main(String[] args) {


        String[] vertexValue = {"A", "B", "C", "D", "E","F"};
        int n = vertexValue.length;
        Graph graph = new Graph(n);

        // 添加顶点
        for (String value : vertexValue) {
            graph.insertVertex(value);
        }
        // 添加边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(0, 4, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(2, 3, 1);
        graph.insertEdge(3, 4, 1);


        graph.showGraph();
        //graph.dfsBetter(4);
        graph.bfs();



    }
}
