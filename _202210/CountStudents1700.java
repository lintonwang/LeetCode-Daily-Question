package _202210;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class CountStudents1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        for (int student : students) {
            count[student]++;
        }
        for (int i = 0; i < sandwiches.length; i++) {
            count[sandwiches[i]]--;
            if (count[sandwiches[i]] == -1) {
                return sandwiches.length - i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CountStudents1700 countStudents1700 = new CountStudents1700();
        countStudents1700.countStudents(new int[]{1,1,1,0,0,1},new int[]{1,0,0,0,1,1});
    }
}
