

public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;

    int carry = 0;

    ListNode p = l1;
    ListNode q = l2;
    while (p != null || q != null || carry > 0) {
      int x = (p != null) ? p.val : 0;
      int y = (q != null) ? q.val : 0;

      int total = x + y + carry;
      int digit = total % 10;
      carry = total / 10;

      ListNode res = new ListNode(digit);
      tail.next = res;
      tail = tail.next;

      if (p != null) { p = p.next; }
      if (q != null) { q = q.next; }

    }
    return dummy.next;
  }
}
