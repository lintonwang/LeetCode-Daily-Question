package _202208;

public class InsertIntoMaxTree {
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

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (val > root.val) {
            node.left = root;
            root = node;
        } else {
            TreeNode parent = root;
            TreeNode curr = root.right;
            while (curr != null && curr.val > val) {
                parent = curr;
                curr = curr.right;
            }
            parent.right = node;
            node.left = curr;
        }
        return root;
    }
}
