package com.steven.learning.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {


    private ArrayList<String> vertexList;  //存储 vertex 的集合
    private int[][] edges;  //  存储 图的对应的临接矩阵
    private int numberOfEdges;  // 边的个数

    // 定义一个数组  记录某个节点是否被访问过   用于遍历算法
    private boolean[] isVisited;

    // constructor
    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>();
        numberOfEdges = 0;
        isVisited = new boolean[n];
    }

    // 插入vertex
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    // 添加 edges

    /**
     * @param v1     表示点的下标：第几个顶点
     * @param v2     表示点的下标：第几个顶点
     * @param weight edge的权重
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numberOfEdges++;
    }

    // 图 常用的方法

    // 1.返回节点个数
    public int getNumberOfVertex() {
        return vertexList.size();
    }

    // 2. 获取edges的数目
    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    // 3. 返回节点 i 对应的数据
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    // 4. 返回 v1 v2 的 weight
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    // 5. 显示图对应的矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }


    /*
    遍历算法部分
     */

    // 得到第一个邻接节点的下标 w
    public int getFirstNeighboor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    // 根据前一个邻接节点的下标，获取下一个邻接节点
    public int getNextNeighboor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    // DFS
    public void dfs(boolean[] isVisited, int index) {

        System.out.println("遍历了---->" + getValueByIndex(index));
        isVisited[index] = true;

        int w = getFirstNeighboor(index);
        System.out.println("获取到了 " + index + "的第一个邻接节点: " + w);

        while (w != -1) {
            if (!isVisited[w]) {
                System.out.println("带着新的参数去递归dfs---->" + Arrays.toString(isVisited));
                System.out.println("带着新的参数去递归dfs---->" + w);
                dfs(isVisited, w);
            } else {
                System.out.println("查找 " + index + " 位置的(V)" + "的 " + w + " 邻接点的下一个邻接点");
                w = getNextNeighboor(index, w);
                System.out.println("获取到了 " + index + "的第一个邻接点的下一个邻接节点: " + w);
            }

        }
    }

    // 对DFS进行一个重载  ：  这里的loop其实就是cover没有任何edge的独立的节点
    public void dfs() {
        for (int i = 0; i < getNumberOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }


    // 更好的实现
    public void dfsBetter(int start) {
        dfsRecursive(start, isVisited);
    }

    public void dfsRecursive(int current, boolean[] isVisited) {
        isVisited[current] = true;
        System.out.println("Visit " + current + " index的值：" + getValueByIndex(current));
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i])
                dfsRecursive(i, isVisited);
        }
    }


    // BSF
    public void bfs(boolean[] isVisited, int index) {
        int u;  // 队列的头结点的对应下标
        int w;  // 邻接节点的下标
        LinkedList queue = new LinkedList(); //  一个队列 记录节点的访问顺序

        // 访问节点
        System.out.println("访问----->" + getValueByIndex(index));
        //  标记为  已访问
        isVisited[index] = true;
        //  将节点加入队列
        queue.addLast(index);
        while (!queue.isEmpty()) {
            u = (Integer) queue.removeFirst();
            w = getFirstNeighboor(u);
            while (w != -1) {
                //是否访问过 : 是
                if (!isVisited[w]) {
                    System.out.println("访问----->" + getValueByIndex(w));
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                //是否访问过：否
                w = getNextNeighboor(u, w);
            }
        }
    }

    // 对所有的节点  进行 BSF
    public void bfs() {
        for (int i = 0; i < getNumberOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }


}
