package sn;

import java.util.HashMap;
import java.util.Map;

public class P146 {

    class LRUCache {

        private int capacity;
        private final Map<Integer, Node> nodeMap;

        private final DoubleLinkedList list;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.nodeMap = new HashMap<>(capacity);
            this.list = new DoubleLinkedList();
        }

        //添加缓存
        public void put(int key, int val) {
            Node node = new Node();
            node.key = key;
            node.val = val;
            if (nodeMap.containsKey(key)) {
                remove(key);
            } else {
                if (list.getSize() >= capacity) {
                    Node last = list.removeLast();
                    nodeMap.remove(last.key);
                }
            }
            list.addFirst(node);
            nodeMap.put(key, node);
        }

        //删除缓存
        public void remove(int key) {
            Node node = nodeMap.get(key);
            if (node != null) {
                list.remove(node);
                nodeMap.remove(key);
            }
        }

        //获取缓存
        public int get(int key) {
            Node node = nodeMap.get(key);
            if (node == null) {
                return -1;
            }
            put(node.key, node.val);
            return node.val;
        }

        class Node {
            Node pre;
            Node next;
            int val;
            int key;
        }

        class DoubleLinkedList {

            private int size;
            private Node head = new Node();
            private Node tail = new Node();

            public DoubleLinkedList() {
                head.pre = tail;
                head.next = tail;
                tail.pre = head;
                tail.next = head;
                this.size = 0;
            }

            //添加新节点
            public void addFirst(Node node) {
                node.next = head.next;
                head.next.pre = node;
                head.next = node;
                node.pre = head;
                ++size;
            }

            //移除节点
            public void remove(Node node) {
                if (node != null) {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                    --size;
                }
            }

            //移除最后一个数据节点
            public Node removeLast() {
                if (tail.pre != head) {
                    Node last = tail.pre;
                    remove(last);
                    return last;
                }
                return null;
            }

            //获取当前缓存size
            public int getSize() {
                return this.size;
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
