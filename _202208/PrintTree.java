package _202208;

import java.util.ArrayList;
import java.util.List;

public class PrintTree {
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

    public List<List<String>> printTree(TreeNode root) {
        int height = computeHeight(root);
        int m = height;
        int n = (1 << height) - 1;
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add("");
            }
            ans.add(list);
        }
        dfs(ans, root, 0, (n - 1) / 2, height - 1);
        return ans;
    }

    int computeHeight(TreeNode node) {
        if (node == null) return 0;
        int left = computeHeight(node.left);
        int right = computeHeight(node.right);
        return Math.max(left, right) + 1;
    }

    //对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2^(height-r-1)] ，右子节点放置在 res[r+1][c+2^(height-r-1)] 。
    void dfs(List<List<String>> ans, TreeNode node, int row, int col, int height) {
        ans.get(row).set(col, String.valueOf(node.val));
        if (node.left != null)
            dfs(ans, node.left, row + 1, col - (1 << (height - row - 1)), height);
        if (node.right != null)
            dfs(ans, node.right, row + 1, col + (1 << (height - row - 1)), height);
    }

    public static void main(String[] args) {
        PrintTree pr = new PrintTree();
        TreeNode root = new PrintTree().new TreeNode(1);
        TreeNode node = new PrintTree().new TreeNode(2);
        root.left = node;
        pr.printTree(root);
    }

}
