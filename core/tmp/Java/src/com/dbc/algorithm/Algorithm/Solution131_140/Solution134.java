package com.dbc.leecode.Algorithm.Solution131_140;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-26 16:50
 **/
public class Solution134 {
    public Node cloneGraph(Node node){
        if (node == null){
            return node;
        }

        HashMap<Node, Node> visited = new HashMap<>();

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()){
            Node n = queue.remove();
            for (Node neighbor : n.neighbors){
                if (!visited.containsKey(neighbor)){
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}
