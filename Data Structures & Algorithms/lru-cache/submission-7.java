class LRUCache {
    private Map<Integer, Node> map;
    private int capacity;
    // Dummy nodes to simplify boundary logic
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        
        // Initialize dummy head and tail
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node currNode = map.get(key);
        remove(currNode);
        insertAtTail(currNode); // Move to most recently used position
        return currNode.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        
        // Fix 1: Create exactly ONE node reference
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertAtTail(newNode);
        
        // Handle eviction cleanly
        if (map.size() > capacity) {
            Node lruNode = head.next; // First real node after dummy head
            remove(lruNode);
            map.remove(lruNode.key);
        }
    }

    // Simplifies remove: No more null checks needed
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Simplifies insert: Always inserts right before dummy tail
    private void insertAtTail(Node node) {
        Node lastRealNode = tail.prev;
        
        lastRealNode.next = node;
        node.prev = lastRealNode;
        node.next = tail;
        tail.prev = node;
    }
}

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}
