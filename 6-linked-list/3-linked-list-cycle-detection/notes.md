# Problem Restate
Detect if a singly linked list has a **cycle** (a node is revisited by following `next` pointers)

# Core Idea (Floyd's)
Use two pointers:
- `slow` moves **1 step**
- `fast` moves **2 steps**
If there's a cycle, they'll **eventually meet**. If no cycle, `fast` hits `null`

# Loop and Invariant
- Loop while `fast != null && fast.next != null`
- Each iteration: `slow = slow.next; fast = fast.next.next;`
- Invariant: if a cycle exists, `fast` laps `slow` by 1 step per iteration in the cycle region

# Why It Works
In a cycle, the distance between `fast` and `slow` decreases mod cycle length; they must collide. With no cycle, `fast` reaches `null`.

# Complexities
- Time: O(n)
- Space: O(1)

# Edge Cases
- `head == null` or single node with `next == null` -> false
- Cycle at head or tiny cycles (length 1/2) still detected

# Common Mistakes
- Missing `fast != null && fast.next != null` guard -> NPE
- Advancing `slow`/`fast` in wrong order of increments
- Usinf values equality instead of **node reference** equality
