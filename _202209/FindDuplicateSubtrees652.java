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

    class Pair<K, V> {
        TreeNode key;
        Integer value;

        public Pair(K node, V i) {
            key = (TreeNode) node;
            value = (Integer) i;
        }

        public TreeNode getKey() {
            return key;
        }

        public void setKey(TreeNode key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }

    Set<TreeNode> ans;
    Map<String, Pair<TreeNode, Integer>> seen;
    int idx;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ans = new HashSet<>();
        seen = new HashMap<>();
        idx = 0;
        findDuplicateSubtreesDfs(root);
        return new ArrayList<>(ans);
    }

    int findDuplicateSubtreesDfs(TreeNode node) {
        if (node == null) return 0;
        int[] val = {node.val, findDuplicateSubtreesDfs(node.left), findDuplicateSubtreesDfs(node.right)};
        String valString = Arrays.toString(val);
        if (seen.containsKey(valString)) {
            Pair<TreeNode,Integer> pair = seen.get(valString);
            ans.add(pair.getKey());
            return pair.getValue();
        } else {
            seen.put(valString, new Pair<TreeNode, Integer>(node, ++idx));
            return idx;
        }
    }
}
