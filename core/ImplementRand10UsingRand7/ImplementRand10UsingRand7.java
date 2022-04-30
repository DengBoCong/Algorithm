package com.dbc;

public class ImplementRand10UsingRand7 {
    public int rand7() {
        return 0;
    }

    public int rand10() {
        while (true) {
            int row = rand7(), col = rand7();
            int idx = (row - 1) * 7 + col;
            if (idx <= 40) return 1 + (idx - 1) % 10;
        }
    }
}
