package com.dbc.leecode.Algorithm.Solution131_140;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-25 10:11
 **/
public class Solution131 {
    public void solveS1(char[][] board){
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isEdge && board[i][j] == 'O'){
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j){
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#'){
            return;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i ,j - 1);
        dfs(board, i, j + 1);
    }

    class UnionFind{
        int[] parents;

        public UnionFind(int totalNodes){
            parents = new int[totalNodes];
            for (int i = 0; i < totalNodes; i++){
                parents[i] = i;
            }
        }

        public void union(int node1, int node2){
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2){
                parents[root2] = root1;
            }
        }

        public int find(int node){
            while (parents[node] != node){
                parents[node] = parents[parents[node]];
                node = parents[node];
            }
            return node;
        }

        public boolean isConnected(int node1, int node2){
            return find(node1) == find(node2);
        }
    }
}
