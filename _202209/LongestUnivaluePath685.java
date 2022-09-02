package _202209;

public class LongestUnivaluePath685 {
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

    int res;

    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        longestUnivaluePathDfs(root);
        return res;
    }

    int longestUnivaluePathDfs(TreeNode node) {
        if (node == null) return 0;
        int left = longestUnivaluePathDfs(node.left);
        int right = longestUnivaluePathDfs(node.right);
        int l = 0, r = 0;
        if (node.left != null && node.left.val == node.val) l = left + 1;
        if (node.right != null && node.right.val == node.val) r = right + 1;
        res = Math.max(res, l + r);
        return Math.max(l, r);
    }
}
