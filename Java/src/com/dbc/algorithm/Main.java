package com.dbc.algorithm;

import com.dbc.algorithm.Array.*;
import com.dbc.algorithm.Pointer.*;
import com.dbc.algorithm.UnionFindSets.*;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        List<Integer> result = FindAllAnagramsInAString.findAnagrams("abaacbabc", "abc");
        System.out.println(result.toString());
    }
}