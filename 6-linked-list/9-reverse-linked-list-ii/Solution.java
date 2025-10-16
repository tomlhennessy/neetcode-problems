

public class Solution {
  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null || left == right) { return head; }

    ListNode dummy = new ListNode(0, head);
    ListNode prev = dummy;

    for (int i = 1; i < left; i++) {
      prev = prev.next;
    }

    ListNode curr = prev.next;

    for (int i = 0; i < right - left; i++) {
      ListNode move = curr.next;      // node to extract
      curr.next = move.next;          // unlink move from after curr
      move.next = prev.next;          // insert move right after prev
      prev.next = move;               // finish insertion
    }

    return dummy.next;
  }
}
