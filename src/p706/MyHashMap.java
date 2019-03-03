package p706;

/*
 https://leetcode.com/problems/design-hashmap/
*/

class MyHashMap {

    class Node {
        private Node() {
        }
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public int key;
        public int value;
        Node next;
    }

    private Node [] table = new Node[10000];

    /** Initialize your data structure here. */
    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashCode = hash(key);
        Node root = table[hashCode];
        while (root != null) {
            if (root.key == key) {
                root.value = value;
                return;
            } else {
                root = root.next;
            }
        }
        Node newNode = new Node(key, value);
        newNode.next = table[hashCode];
        table[hashCode] = newNode;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashCode = hash(key);
        Node root = table[hashCode];
        while (root != null) {
            if (root.key == key) {
                return root.value;
            } else {
                root = root.next;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashCode = hash(key);
        Node current = table[hashCode];
        if (current == null) {
            return;
        }
        if (current.key == key) {
            table[hashCode] = table[hashCode].next;
            return;
        }
        Node prev = current;
        current = current.next;
        while (current != null) {
            if (current.key == key) {
                prev.next = current.next;
                return;
            } else {
                current = current.next;
            }
        }
    }

    private int hash(int key) {
        return key % 10000;
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(10001, 2);
        hashMap.remove(1);          // remove the mapping for 2

    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */