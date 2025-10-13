# Problem Restate
Reorder a linked list so nodes follow the pattern:
`[0, n-1, 1, n-2, 2, n-3, ...]`
You can't change node values - only **relink** pointers

# Core Strategy
1. **Split** the list in half (find mid using slow/fast)
2. **Reverse** the second half in-place
3. **Weave** the two halves alternatively
> Split -> Reverse -> Weave - each step is O(n), and we only relink pointers

# Why It Works
- Step 1 isolates the two halves cleanly (`slow.next = null`)
- Step 2 reverses the second half so nodes appear in descending index order
- Step 3 alternatively connects `left` and `right` lists to form the desired pattern

# Complexities
- **Time**: O(n) - single traversal per phase
- **Space**: O(1) - in-place pointer updates

# Step Summary
1. Split
```java
while (fast != null && fast.next != null) {
  slow = slow.next;
  fast = fast.next.next;
}
ListNode second = slow.next;
slow.next = null;
```

2. Reverse second half
```java
ListNode rev = null;
ListNode cur = second;
while (cur != null) {
  ListNode nxt = cur.next;
  cur.next = rev;
  rev = cur;
  cur = nxt;
}
```

3. Weave
```java
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
```

# Common Pitfalls
- Forgetting `slow.next == null` -> infinite loop / cycle
- Forgetting to save `next` before rewiring
- Using recursion (extra space)
- Handling odd length: left half one node longer - still fine

# What I Learned
- A list variable represents its **head**; all linking happens through `.next`
- Always **save** `.next` **before rewiring** to avoid losing nodes
- This problem combines multiple linked list techniques:
  • find middle
  • reverse list
  • merge lists
