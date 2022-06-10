package com.dbc;

public class WordSearch {
    private boolean dfs(int row, int col, int point, char[][] board, String word) {
        if (point == word.length() - 1 && word.charAt(point) == board[row][col]) return true;
        if (word.charAt(point) != board[row][col]) return false;
        board[row][col] = '*';
        int[][] dir = new int[][]{{row, col + 1}, {row, col - 1}, {row + 1, col}, {row - 1, col}};
        for (int[] newDir : dir) {
            if (newDir[0] >= 0 && newDir[0] < board.length && newDir[1] >= 0 && newDir[1] < board[0].length && dfs(newDir[0], newDir[1], point + 1, board, word)) return true;
        }
        board[row][col] = word.charAt(point);
        return false;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(i, j, 0, board, word)) return true;
            }
        }
        return false;
    }
}
