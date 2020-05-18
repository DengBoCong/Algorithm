package com.dbc.leecode.Algorithm.Solution81_90;

import java.util.Stack;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-10 10:46
 **/
public class Solution85 {
    public int largestRectangleAreaS1(int[] heights){
        int maxarea = 0;
        for (int i = 0; i < heights.length; i++){
            for (int j = i; j < heights.length; j++){
                int minheight = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++)
                    minheight = Math.min(minheight, heights[k]);
                maxarea = Math.max(maxarea, minheight * (j - i + 1));
            }
        }
        return maxarea;
    }

    public int largestRectangleAreaS2(int[] heights){
        int maxarea = 0;
        for (int i = 0; i < heights.length; i++){
            int minheight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++){
                minheight = Math.min(minheight, heights[j]);
                maxarea = Math.max(maxarea, minheight * (j - i + 1));
            }
        }
        return maxarea;
    }

    public int calculateArea(int[] heights, int start, int end){
        if (start > end)
            return 0;
        int minindex = start;
        for (int i = start; i <= end; i++){
            if (heights[minindex] > heights[i])
                minindex = i;
        }
        return Math.max(heights[minindex] * (end - start + 1), Math.max(calculateArea(heights, start, minindex - 1), calculateArea(heights, minindex + 1, end)));
    }

    public int largestRectangleAreaS3(int[] heights){
        return calculateArea(heights, 0, heights.length - 1);
    }

    public int largestRectangleArea(int[] heights){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; i++){
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        return maxarea;
    }
}
