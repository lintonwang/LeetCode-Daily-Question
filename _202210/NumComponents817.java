package _202210;

import java.util.HashSet;
import java.util.Set;

public class NumComponents817 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int count = 0;
        boolean flag = false;
        while (head != null) {
            if (set.contains(head.val)) {
                if (!flag) count++;
                flag = true;
            } else
                flag = false;
            head = head.next;
        }
        return count;
    }
}
