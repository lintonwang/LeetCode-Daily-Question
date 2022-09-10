package _202209;

public class TrimBST669 {
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

    public TreeNode trimBST(TreeNode root, int low, int high) {
        while (root != null && (root.val < low || root.val > high)) {
            if (root.val < low) root = root.right;
            if (root.val > high) root = root.left;
        }
        if (root == null) return root;
        TreeNode node = root;
        while (node.left != null) {
            if (node.left.val < low) node.left = node.left.right;
            else node = node.left;
        }
        node = root;
        while (node.right != null) {
            if (node.right.val > high) node.right = node.right.left;
            else node = node.right;
        }
        return root;
    }
}
