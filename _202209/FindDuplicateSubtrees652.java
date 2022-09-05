package _202209;

import java.util.*;

public class FindDuplicateSubtrees652 {
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

    Set<TreeNode> ans;
    Map<String, TreeNode> hash;
    Map<String, Integer> nodeIdx;
    int idx;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ans = new HashSet<>();
        hash = new HashMap<>();
        nodeIdx = new HashMap<>();
        idx = 0;
        findDuplicateSubtreesDfs(root);
        return new ArrayList<>(ans);
    }

    int findDuplicateSubtreesDfs(TreeNode node) {
        if (node == null) return 0;
        //对每一种结构形成独特的hash值 [root.val,left.idx,right.idx]
        int[] val = {node.val, findDuplicateSubtreesDfs(node.left), findDuplicateSubtreesDfs(node.right)};
        String valString = Arrays.toString(val);

        if (hash.containsKey(valString)) {
            ans.add(hash.get(valString));
            return nodeIdx.get(valString);
        } else {
            hash.put(valString, node);
            nodeIdx.put(valString, ++idx);
            return idx;
        }
    }
}
