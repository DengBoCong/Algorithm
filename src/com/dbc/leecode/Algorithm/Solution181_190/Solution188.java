package com.dbc.leecode.Algorithm.Solution181_190;

<<<<<<< HEAD
public class Solution188 {
//    select a.ID, a.date
//    from weather as a cross join weather as b
//    on timestampdiff(day, a.date, b.date) = -1
//    where a.temp > b.temp;
=======
import com.dbc.leecode.Algorithm.Reclass.TreeNode;

import java.util.*;

public class Solution188 {
    public List<Integer> rightSideView(TreeNode root){
        Map<Integer, Integer> rightMostValueAtDepth = new HashMap<>();
        int max_depth = -1;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        nodeQueue.add(root);
        depthQueue.add(0);

        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.remove();
            int depth = depthQueue.remove();

            if (node != null){
                max_depth = Math.max(max_depth, depth);
                rightMostValueAtDepth.put(depth, node.val);

                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                depthQueue.add(depth + 1);
                depthQueue.add(depth + 1);
            }
        }

        List<Integer> rightView = new ArrayList<>();
        for (int depth = 0; depth <= max_depth; depth++){
            rightView.add(rightMostValueAtDepth.get(depth));
        }
        return rightView;
    }
>>>>>>> local
}
