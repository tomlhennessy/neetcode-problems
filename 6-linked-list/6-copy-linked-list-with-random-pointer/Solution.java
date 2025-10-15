import java.util.HashMap;
import java.util.Map;

public class Solution {
  public Node copyRandomList(Node head) {
    if (head == null) { return null; }

    Map<Node, Node> map = new HashMap<>();

    // Pass 1: map original node to new node
    Node curr = head;
    while (curr != null) {
      map.put(curr, new Node(curr.val));
      curr = curr.next;
    }

    // Pass 2: wire up "next" and "random" pointers
    Node curr = head;
    while (curr != null) {
      Node clone = map.get(curr);
      clone.next = map.get(curr.next);
      clone.random = map.get(curr.random);
      curr = curr.next;
    }

    return map.get(head);
  }
}
