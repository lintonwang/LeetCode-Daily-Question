package _202208;

import java.util.List;

public class MyCircularDeque {

    class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    ListNode head;
    ListNode tail;
    int size;
    int capacity;

    public MyCircularDeque(int k) {
        this.capacity = k;
        this.size = 0;
        this.head = new ListNode(-1);
        this.tail = new ListNode(-1);
        this.head.next = tail;
        this.tail.prev = head;
    }

    public boolean insertFront(int value) {
        if (size == capacity) return false;
        ListNode node = new ListNode(value);
        node.next = this.head.next;
        this.head.next.prev = node;
        this.head.next = node;
        node.prev = head;
        this.size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (this.size == this.capacity) return false;
        ListNode node = new ListNode(value);
        node.prev = this.tail.prev;
        this.tail.prev.next = node;
        this.tail.prev = node;
        node.next = tail;
        this.size++;
        return true;
    }

    public boolean deleteFront() {
        if (head.next == tail) return false;
        head.next.next.prev = head;
        head.next = head.next.next;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (head.next == tail) return false;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        size--;
        return true;
    }

    public int getFront() {
        return head.next == tail ? -1 : head.next.val;
    }

    public int getRear() {
        return head.next == tail ? -1 : tail.prev.val;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }

    public boolean isFull() {
        return size == capacity;
    }
}