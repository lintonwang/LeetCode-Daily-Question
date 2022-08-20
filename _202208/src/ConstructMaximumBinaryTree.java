package _202208.src;

public class ConstructMaximumBinaryTree {
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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) return null;
        int max = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[max]) max = i;
        }
        TreeNode node = new TreeNode(nums[max]);
        node.left = constructMaximumBinaryTree(nums, start, max - 1);
        node.right = constructMaximumBinaryTree(nums, max + 1, end);
        return node;
    }
}
