package codlity.test;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.HashSet;
import java.util.Set;

class Solution {
    private static final int MAX_HEIGHT = 3500;
    private boolean hasFoundMaxHeight = false;

    public int solution(Tree T) {

        return inorderTraversal(T, 0, new HashSet<>());
    }

    private int inorderTraversal(Tree node, int level, Set<Integer> nodeValueSet) {
        if (hasFoundMaxHeight || node == null || nodeValueSet.contains(node.x)) {
            return level;
        }

        nodeValueSet.add(node.x);
        int leftPathLength = inorderTraversal(node.l, level + 1, nodeValueSet);
        int rightPathLength = inorderTraversal(node.r, level + 1, nodeValueSet);
        nodeValueSet.remove(node.x);

        int pathLength = Math.max(leftPathLength, rightPathLength);
        if (pathLength >= MAX_HEIGHT) hasFoundMaxHeight = true;

        return pathLength;
    }

    private static class Tree {
        public int x;
        public Tree l;
        public Tree r;
    }
}

