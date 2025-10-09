

public class RecursiveSolution {
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;        // base : single or empty node is already reversed
    }

    ListNode newHead = reverseList(head.next);    // reverse the rest

    head.next.next = head;    // flip: next node points back to head
    head.next = null;         // detach: head becomes tail of reversed suffix

    return newHead;           // new head bubbles up
  }
}
