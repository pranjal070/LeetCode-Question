class Node {
    int key;
    int value;
    Node prev;
    Node next;
    int freq;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

class DoublyLinkedlist {
    Node head;
    Node tail;
    int size;

    DoublyLinkedlist() {
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;

        size++;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        size--;
    }

    public Node removeLast() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }
}

class LFUCache {

    Map<Integer, Node> map;
    Map<Integer, DoublyLinkedlist> freqMap;

    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        freqMap = new HashMap<>();
        minFreq = 0;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        increaseFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        // Key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.value = value;

            increaseFrequency(node);

            return;
        }

        // Cache is full
        if (map.size() == capacity) {

            DoublyLinkedlist dll = freqMap.get(minFreq);

            Node nodeToRemove = dll.removeLast();

            map.remove(nodeToRemove.key);
        }

        // Create new node
        Node node = new Node(key, value);

        map.put(key, node);

        minFreq = 1;

        DoublyLinkedlist dll = freqMap.getOrDefault(
            1,
            new DoublyLinkedlist()
        );

        dll.addFirst(node);

        freqMap.put(1, dll);
    }

    public void increaseFrequency(Node node) {

        int oldFreq = node.freq;

        DoublyLinkedlist dll = freqMap.get(oldFreq);

        dll.removeNode(node);

        if (dll.size == 0 && minFreq == oldFreq) {
            minFreq++;
        }

        node.freq++;
        DoublyLinkedlist newDll = freqMap.getOrDefault(
            node.freq,
            new DoublyLinkedlist()
        );

        newDll.addFirst(node);

        freqMap.put(node.freq, newDll);
    }
}