package com.dbc;

public class ImageSmoother {
    public int[][] imageSmoother(int[][] img) {
        int[][] res = new int[img.length][img[0].length];
        for (int row = 0; row < img.length; row++) {
            for (int col = 0; col < img[0].length; col++) {
                int total = 0, count = 0;
                for (int i = row - 1; i < row + 2; i++) {
                    for (int j = col - 1; j < col + 2; j++) {
                        if (i >= 0 && i < img.length && j >=0 && j < img[0].length) {
                            total += img[i][j];
                            count++;
                        }
                    }
                }
                res[row][col] = total / count;
            }
        }
        return res;
    }
}
