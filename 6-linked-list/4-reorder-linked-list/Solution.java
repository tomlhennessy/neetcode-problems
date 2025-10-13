import java.util.List;

public class Solution {
  public void reorderList(ListNode head) {
    if (head == null || head.next = null) {
      return;
    }

    // 1) split: find end of first half (slow)
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode second = slow.next;
    slow.next = null; // cut

    // 2) reverse second half
    ListNode rev  = null;
    ListNode cur = second;
    while (cur != null) {
      ListNode nxt = cur.next;
      cur.next = rev;
      rev = cur;
      cur = nxt;
    }

    // 3) weave: first, rev
    ListNode first = head;
    ListNode right = rev;
    while (right != null) {
      ListNode t1 = first.next;
      ListNode t2 = right.next;
      first.next = right;
      right.next = t1;
      first = t1;
      right = t2;
    }
  }
}
