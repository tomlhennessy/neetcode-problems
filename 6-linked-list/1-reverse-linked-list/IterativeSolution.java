

public class IterativeSolution {
  public ListNode reverseList(ListNode head) {
    ListNode curr = head;
    ListNode prev = null;

    while (curr != null) {
      ListNode nxt = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nxt;
    }
    return prev;
  }
}
