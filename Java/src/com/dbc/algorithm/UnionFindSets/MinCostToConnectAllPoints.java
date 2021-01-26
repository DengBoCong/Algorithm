package com.dbc.algorithm.UnionFindSets;

import java.util.*;

public class MinCostToConnectAllPoints {
    private int[] parent;
    private int[] rank;

    public int minCostConnectPoints_union_find(int[][] points) {
        int length = points.length;
        this.parent = new int[length];
        this.rank = new int[length];
        for (int i = 0; i < length; i++)
            parent[i] = i;

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int weight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                Edge edge = new Edge(weight, i, j);
                edges.add(edge);
            }
        }

        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        int result = 0, num = 1;
        for (Edge edge : edges) {
            if (union(edge.start, edge.end)) {
                result += edge.weight;
                num++;
                if (num == length)
                    break;
            }
        }

        return result;
    }

    public int find(int index) {
        if (index != this.parent[index]) {
            this.parent[index] = find(this.parent[index]);
        }
        return this.parent[index];
    }

    public boolean union(int index1, int index2) {
        int rootX = find(index1);
        int rootY = find(index2);
        if (rootX == rootY) {
            return false;
        }

        if (this.rank[rootX] < this.rank[rootY]) {
            int temp = rootX;
            rootX = rootY;
            rootY = temp;
        }
        this.rank[rootX] += this.rank[rootY];
        this.parent[rootY] = rootX;
        return true;
    }

    class Edge {
        private int weight;
        private int start;
        private int end;

        public Edge(int weight, int start, int end) {
            this.weight = weight;
            this.start = start;
            this.end = end;
        }
    }
}
