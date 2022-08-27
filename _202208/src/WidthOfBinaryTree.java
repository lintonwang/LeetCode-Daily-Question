package _202208.src;

import java.util.HashMap;
import java.util.Map;

public class WidthOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        return dfs(root, map, 0, 0);
    }

    int dfs(TreeNode node, Map<Integer, Integer> map, int level, int idx) {
        if (node == null) return 0;
        map.putIfAbsent(level, idx);
        return Math.max(idx - map.get(level) + 1, Math.max(dfs(node.left, map, level + 1, idx * 2), dfs(node.right, map, level + 1, idx * 2 + 1)));
    }

}

