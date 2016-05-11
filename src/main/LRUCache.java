package main;

import java.util.HashMap;

/**
 * Double LinkedList : remove/insert : O(1)
 * HashMap : search : O(1)
 *
 * Head : Most Recently Used
 * Tail : Least Recently Used
 *
 * 每次访问linkedlist上的点，必然进行list的序列更新：
 * —— remove被访问的点，将其重置为head
 *
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
    private int length;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = null;
        tail = null;
        length = 0;
        map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            remove(map.get(key));
            setHead(map.get(key));
            return map.get(key).val;
        }
    }

    public void set(int key, int value) {
        if (!map.containsKey(key)) {
            Node current = new Node(key, value);
            if (length < capacity) {
                setHead(current);
                map.put(key, current);
                length++;
            } else {
                map.remove(tail);
                // don't forget to set up new tail
                tail = tail.prev;
                if (tail != null) {
                    tail.next = null;
                }

                setHead(current);
                map.put(key, current);
            }
        } else {
            Node oldNode = map.get(key);
            Node newNode = new Node(key, value);
            remove(oldNode);
            map.put(key, newNode);
            setHead(newNode);
        }
    }

    public void remove(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            // @.@
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    public void setHead(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }

        head = node;
        if (tail == null) {
            tail = head;
        }
    }
}
