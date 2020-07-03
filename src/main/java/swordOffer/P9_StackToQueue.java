package swordOffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 通过栈实现队列
 *
 * @author Wendell
 * @Date 2020-6-30  11:43:13
 */
public class P9_StackToQueue {

    public static void main(String[] args) {
        CQueue q = new CQueue();
        q.appendTail(3);
        //q.appendTail(3);
        //q.appendTail(3);
        System.out.println(q.deleteHead());
        System.out.println(q.deleteHead());
        System.out.println(q.deleteHead());
    }

    static class CQueue {
        Node head;
        Node now;

        public CQueue() {
            head = new Node();
        }

        public void appendTail(int value) {
            Node node = new Node(value);
            if (head.next == null) {
                head.next = node;
                now = head.next;
                return;
            }
            now.next = node;
            now = now.next;
        }

        public int deleteHead() {
            if (head.next == null) return -1;
            int val = head.next.val;
            head.next = head.next.next;
            return val;
        }

        class Node {
            int val;
            Node next;

            public Node(int val) {
                this.val = val;
            }

            public Node() {

            }
        }
    }

    static class StackToQueue {
        Stack<Integer> insert;
        Stack<Integer> delete;

        public StackToQueue() {
            insert = new Stack<>();
            delete = new Stack<>();
        }

        public void appendTail(int value) {
            insert.push(value);
        }

        public int deleteHead() {
            if (delete.empty()) {
                if (insert.empty()) {
                    return -1;
                }
                while (!insert.empty()) {
                    delete.push(insert.pop());
                }
            }
            return delete.pop();
        }
    }

    static class DequeToQueue {
        Deque<Integer> insert;
        Deque<Integer> delete;

        public DequeToQueue() {
            this.insert = new LinkedList<>();
            this.delete = new LinkedList<>();
        }

        public void appendTail(int value) {
            insert.addFirst(value);
        }

        public int deleteHead() {
            if (delete.isEmpty()) {
                if (insert.isEmpty()) {
                    return -1;
                }
                while (!insert.isEmpty()) {
                    delete.addFirst(insert.pollLast());
                }
            }
            return delete.pollLast();
        }
    }


/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
}
