package com.dbc;

public class ReachingPoints {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy && tx != ty) {
            if (tx > ty) tx %= ty;
            else ty %= tx;
        }
        if (tx == sx && ty == sy) return true;
        else if (tx > sx && ty == sy) return (tx - sx) % ty == 0;
        else if (ty > sy && tx == sx) return (ty - sy) % tx == 0;
        else return false;
    }
}
