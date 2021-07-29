package com.dbc.algorithm.Array;

public class DesignParkingSystem {
    private int[] remain;
    public DesignParkingSystem(int big, int medium, int small) {
        remain = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        if (remain[carType - 1] > 0) {
            remain[carType - 1] -= 1;
            return true;
        } else {
            return false;
        }
    }
}
