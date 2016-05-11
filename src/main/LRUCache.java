package main;

import java.util.HashMap;

/**
 * Double LinkedList : remove/insert : O(1)
 * HashMap : search : O(1)
 *
 * Head.next -- least recently visit
 * Tail.prev -- recently visit
 *
 * 每次访问linkedlist上的点，必然进行list的序列更新：
 * —— remove被访问的点，将其重置为head
 *
 * 参考自 九章算法
 *
 */
public class LRUCache {

    class Node {
        Node prev;
        Node next;
        int key;
        int val;

        public Node(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        this.map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node current = map.get(key);
            current.prev.next = current.next;
            current.next.prev = current.prev;

            saveToTail(current);
            return map.get(key).val;
        }
    }

    public void set(int key, int value) {
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }

        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node insert = new Node(key, value);
        map.put(key, insert);
        saveToTail(insert);
    }

    public void saveToTail(Node node) {
        node.prev = tail.prev;
        tail.prev = node;
        node.prev.next = node;
        node.next = tail;
    }

}
