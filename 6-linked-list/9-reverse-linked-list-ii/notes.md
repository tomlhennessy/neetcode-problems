# Problem Restate
Reverse the sublist of a singly linked list from position `left` to `right` (1-indexed), and return the head.
Do it in one pass.

# Key Design Question
How do we reverse only a middle segment without breaking links?
-> Use a **dummy** to handle `left=1`, find the node **before** `left` (`prev`), then perform **head-insertion** to build the reversed block in place.

# Why It Works
- Keeping `prev` fixed (node before the segment) and `curr.prev = next` (head of the segment) allows us to repeatedly:
  • extract `move = curr.next`
  • splice it **after** `prev`
- After `right - left` iterations, the sublist `[left..right]` is reversed:
  • `prev.next` points to a new head of the reversed block
  • `curr` becomes the tail and already points to `afterRight`

# Core Pattern (Head-Insertion)
```java
class Solution {
  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null || left == right) { return head; }

    ListNode dummy = new ListNode(0, head);
    ListNode prev = dummy;
    for (int i = 1; i < left; i++) {
      prev = prev.next;               // prev: node before left
    }

    ListNode curr = prev.next;        // curr: first node in segment
    for (int i = 0; i < right - left; i++) {
      ListNode move = curr.next;      // extract next node
      curr.next = move.next;          // unlink from after curr
      move.next = prev.next;          // insert after prev
      prev.next = move;
    }

    return dummy.next;
  }
}
```

# Complexities
• Time: O(n) single pass
• Space: O(1) extra

# What I Learned
- Use a dummy to normalize edge cases (`left=1`)
- Keep `prev` fixed; `curr` becomes the tail of the reversed window
- Repeat `right - left` head-insertions to reverse in-place

# Mistakes to Avoid
- Moving `prev` during reversal (it must stay fixed)
- Forgetting to use a dummy when `left=1`
- Using a full-list reverse pattern; Here we only reverse a window via splicing.
