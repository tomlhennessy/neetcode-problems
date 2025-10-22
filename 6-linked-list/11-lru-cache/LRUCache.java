import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  private static class Node {
    int key;
    int value;
    Node prev;
    Node next;
    Node(int k, int v) { this.key = k; this.value = v; }
  }

  private final int cap;
  private final Map<Integer, Node> map;
  private final Node head;      // dummy head (MRU side)
  private final Node tail;      // dummy tail (LRU side)

  public LRUCache(int capacity) {
    this.cap = capacity;
    this.map = new HashMap<>();
    this.head = new Node(-1, -1);
    this.tail = new Node(-1, -1);
    // link sentinels
    head.next = tail;
    tail.prev = head;
  }

  private void addFirst(Node x) {
    // insert x right after head
    x.prev = head;
    x.next = head.next;
    head.next.prev = x;
    head.next = x;
  }

  private void remove(Node x) {
    // unlink x from its neighbours
    x.prev.next = x.next;
    x.next.prev = x.prev;
    x.prev = null;
    x.next = null;
  }

  private void moveToFront(Node x) {
    remove(x);
    addFirst(x);
  }

  public int get(int key) {
    Node x = map.get(key);
    if (x == null) {
      return -1;
    }

    moveToFront(x);
    return x.value;
  }

  public void put(int key, int value) {
    Node x = map.get(key);
    if (x != null) {
      x.value = value;
      moveToFront(x);
      return;
    }

    if (map.size() == cap) {
      Node lru = tail.prev;     // least recently used
      remove(lru);              // unlink from list
      map.remove(lru.key);      // remove from map
    }

    Node y = new Node(key, value);
    addFirst(y);                // insert as MRU
    map.put(key, y);            // store the node
  }
}
