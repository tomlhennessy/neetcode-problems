

public class Solution {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null) { return list2; }
    if (list2 == null) { return list1; }

    ListNode dummy = new ListNode(-101);
    ListNode tail = dummy;

    while (list1 != null && list2 != null) {
      if (list1.val <= list2.val) {
        tail.next = list1;          // attach the node
        tail = tail.next;           // advance tail
        list1 = list1.next;         // advance the list you took from
      } else {
        tail.next = list2;
        tail = tail.next;
        list2 = list2.next;
      }
    }

    tail.next = (list1 != null) ? list1 : list2;
    return dummy.next;
  }
}
