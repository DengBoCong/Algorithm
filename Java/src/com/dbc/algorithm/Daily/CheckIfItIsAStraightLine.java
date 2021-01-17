package com.dbc.algorithm.Daily;

public class CheckIfItIsAStraightLine {
    public static boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) {
            return true;
        }

        int deltaX = coordinates[0][0], deltaY = coordinates[0][1];
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i][0] -= deltaX;
            coordinates[i][1] -= deltaY;
        }

        int A = -coordinates[1][1], B = coordinates[1][0];
        for (int i = 2; i < coordinates.length; i++) {
            if (A * coordinates[i][0] + B * coordinates[i][1] != 0) {
                return false;
            }
        }
        return true;
    }
}
